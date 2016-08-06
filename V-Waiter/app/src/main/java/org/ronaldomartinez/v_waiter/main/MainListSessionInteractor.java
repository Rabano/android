package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface MainListSessionInteractor {

    void signOff();

    String getCurrentUserEmail();

    void changeConnectionStatus(boolean online);
}
