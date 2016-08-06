package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface ContactListPresenter {
    void onPause();

    void onResume();

    void onCreate();

    void onDestroy();

    void signOff();

    String getCurrentUserEmail();

    void removeContact(String email);

    void onEventMainThread(org.ronaldomartinez.androidchat.contactlist.events.ContactListEvent event);
}
