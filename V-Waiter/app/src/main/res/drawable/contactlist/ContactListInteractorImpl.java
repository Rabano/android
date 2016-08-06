package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class ContactListInteractorImpl implements ContactListInteractor {

    org.ronaldomartinez.androidchat.contactlist.ContactListRepository repository;

    public ContactListInteractorImpl() {
        repository = new org.ronaldomartinez.androidchat.contactlist.ContactListRepositoryImpl();
    }

    @Override
    public void subscribe() {
        repository.subscribeToContactListEvents();
    }

    @Override
    public void unsubscribe() {
        repository.unSubscribeToContactListEvents();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}
