package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface MainListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
