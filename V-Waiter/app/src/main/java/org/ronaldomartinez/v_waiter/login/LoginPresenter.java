package org.ronaldomartinez.v_waiter.login;

import org.ronaldomartinez.v_waiter.login.events.LoginEvent;

/**
 * Created by pc on 17/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onPause();
    void onResume();
    void checkForAuthenticadedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
