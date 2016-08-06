package org.ronaldomartinez.androidchat.contactlist;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class ContactListSessionInteractorImpl implements org.ronaldomartinez.androidchat.contactlist.ContactListSessionInteractor {
    ContactListRepository repository;

    public ContactListSessionInteractorImpl() {
        repository = new org.ronaldomartinez.androidchat.contactlist.ContactListRepositoryImpl();
    }

    @Override
    public void signOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);
    }
}
