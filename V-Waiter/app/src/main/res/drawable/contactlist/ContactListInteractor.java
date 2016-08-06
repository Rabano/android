package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
