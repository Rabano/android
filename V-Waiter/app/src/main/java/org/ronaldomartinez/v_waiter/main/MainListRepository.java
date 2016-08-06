package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface MainListRepository {

    void signOff();

    String getCurrentEmail();

    void removeContact(String email);

    void destroyListener();

    void subscribeToContactListEvents();

    void unSubscribeToContactListEvents();

    void changeConnectionStatus(boolean online);
}
