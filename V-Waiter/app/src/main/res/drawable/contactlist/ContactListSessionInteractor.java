package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface ContactListSessionInteractor {

    void signOff();

    String getCurrentUserEmail();

    void changeConnectionStatus(boolean online);
}
