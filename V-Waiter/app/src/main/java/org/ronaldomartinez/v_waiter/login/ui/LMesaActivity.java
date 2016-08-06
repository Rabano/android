package org.ronaldomartinez.v_waiter.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.ronaldomartinez.v_waiter.R;
import org.ronaldomartinez.v_waiter.login.LoginPresenter;
import org.ronaldomartinez.v_waiter.login.LoginPresenterImpl;
import org.ronaldomartinez.v_waiter.main.ui.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LMesaActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.editTextCodigoMesa)
    EditText editTextCodigoMesa;
    @Bind(R.id.btnSignin)
    Button btnSignin;
    @Bind(R.id.layoutMainContainer)
    RelativeLayout layoutMainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lmesa);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        loginPresenter.onResume();
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticadedUser();
        super.onResume();
    }

    @Override
    protected void onPause() {
        loginPresenter.onPause();
        super.onPause();
    }


    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void handleSignUp() {
    }

    @OnClick(R.id.btnSignin)
    @Override
    public void handleSignIn() {
        String cambio = editTextCodigoMesa.getText().toString();
        String cambio1 = cambio.replace("-", "_");
        String cambio2 = cambio1.replace("#", "@");
        String codigomesa = cambio2.replace("/", ".com");
        String contra = "1234567";
        loginPresenter.validateLogin(codigomesa.toString(), contra);
    }


    @Override
    public void navigateToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void loginError(String error) {
        editTextCodigoMesa.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        editTextCodigoMesa.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(layoutMainContainer, R.string.login_notice_message_signup, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        editTextCodigoMesa.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        editTextCodigoMesa.setError(msgError);
    }

    private void setInputs(boolean enabled) {
        btnSignin.setEnabled(enabled);
        editTextCodigoMesa.setEnabled(enabled);
    }


}
