package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface ContactListRepository {

    void signOff();

    String getCurrentEmail();

    void removeContact(String email);

    void destroyListener();

    void subscribeToContactListEvents();

    void unSubscribeToContactListEvents();

    void changeConnectionStatus(boolean online);
}
