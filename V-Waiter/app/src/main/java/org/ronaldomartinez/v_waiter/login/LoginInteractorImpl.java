package org.ronaldomartinez.v_waiter.login;

/**
 * Created by pc on 19/06/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRespository;

    public LoginInteractorImpl() {
        loginRespository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRespository.checkSession();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRespository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRespository.signIn(email, password);
    }

}
