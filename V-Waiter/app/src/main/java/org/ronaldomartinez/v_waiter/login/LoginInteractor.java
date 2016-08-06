package org.ronaldomartinez.v_waiter.login;

/**
 * Created by pc on 17/06/2016.
 */
public interface LoginInteractor {
    void checkSession();

    void doSignUp(String email, String password);

    void doSignIn(String email, String password);
}


