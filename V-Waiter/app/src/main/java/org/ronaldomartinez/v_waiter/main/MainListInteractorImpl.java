package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class MainListInteractorImpl implements MainListInteractor {

    MainListRepository repository;

    public MainListInteractorImpl() {
        repository = new MainListRepositoryImpl();
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
