package org.ronaldomartinez.v_waiter.main;

import org.ronaldomartinez.v_waiter.entities.User;
import org.ronaldomartinez.v_waiter.lib.GreenRobotEventBus;
import org.ronaldomartinez.v_waiter.main.ui.MainView;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class MainListPresenterImpl implements MainListPresenter {
    private org.ronaldomartinez.v_waiter.lib.EventBus eventBus;
    private MainView view;
    private MainListInteractor listInteractor;
    private MainListSessionInteractor sessionInteractor;

    public MainListPresenterImpl(MainView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.listInteractor = new MainListInteractorImpl();
        this.sessionInteractor = new MainListSessionInteractorImpl();
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



}