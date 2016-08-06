package org.ronaldomartinez.androidchat.contactlist;

import org.greenrobot.eventbus.Subscribe;
import org.ronaldomartinez.androidchat.contactlist.ui.ContactListView;
import org.ronaldomartinez.androidchat.entities.User;
import org.ronaldomartinez.androidchat.lib.GreenRobotEventBus;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class ContactListPresenterImpl implements ContactListPresenter {
    private org.ronaldomartinez.androidchat.lib.EventBus eventBus;
    private ContactListView view;
    private ContactListInteractor listInteractor;
    private org.ronaldomartinez.androidchat.contactlist.ContactListSessionInteractor sessionInteractor;

    public ContactListPresenterImpl(ContactListView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.listInteractor = new ContactListInteractorImpl();
        this.sessionInteractor = new org.ronaldomartinez.androidchat.contactlist.ContactListSessionInteractorImpl();
    }

    @Override
    public void onPause() {
        sessionInteractor.changeConnectionStatus(User.OFFLINE);
        listInteractor.unsubscribe();
    }

    @Override
    public void onResume() {
        sessionInteractor.changeConnectionStatus(User.ONLINE);
        listInteractor.subscribe();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        listInteractor.destroyListener();
        view = null;
    }

    @Override
    public void signOff() {
        sessionInteractor.changeConnectionStatus(User.OFFLINE);
        listInteractor.unsubscribe();
        listInteractor.destroyListener();
        sessionInteractor.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return sessionInteractor.getCurrentUserEmail();
    }

    @Override
    public void removeContact(String email) {
        listInteractor.removeContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(org.ronaldomartinez.androidchat.contactlist.events.ContactListEvent event) {
        User user = event.getUser();
        switch (event.getEventType()) {
            case org.ronaldomartinez.androidchat.contactlist.events.ContactListEvent.onContactAdded:
                onContactAdded(user);
                break;
            case org.ronaldomartinez.androidchat.contactlist.events.ContactListEvent.onContactChanged:
                onContactChanged(user);
                break;
            case org.ronaldomartinez.androidchat.contactlist.events.ContactListEvent.onContactRemoved:
                onContactRemoved(user);
                break;
        }
    }

    public void onContactAdded(User user) {
        if (view != null) {
            view.onContactAdded(user);
        }
    }

    public void onContactChanged(User user) {
        if (view != null) {
            view.onContactChanged(user);
        }
    }

    public void onContactRemoved(User user) {
        if (view != null) {
            view.onContactRemoved(user);
        }
    }
}