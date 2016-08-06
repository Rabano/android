package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class MainListSessionInteractorImpl implements MainListSessionInteractor {
    MainListRepository repository;

    public MainListSessionInteractorImpl() {
        repository = new MainListRepositoryImpl();
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
