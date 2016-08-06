package org.ronaldomartinez.v_waiter.main;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface MainListPresenter {
    void onPause();

    void onResume();

    void onCreate();

    void onDestroy();

    void signOff();

    String getCurrentUserEmail();
}
