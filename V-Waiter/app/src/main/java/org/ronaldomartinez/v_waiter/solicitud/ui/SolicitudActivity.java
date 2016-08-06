package org.ronaldomartinez.v_waiter.solicitud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import org.ronaldomartinez.v_waiter.R;
import org.ronaldomartinez.v_waiter.main.ui.MainActivity;
import org.ronaldomartinez.v_waiter.solicitud.ChatPresenter;
import org.ronaldomartinez.v_waiter.solicitud.ChatPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SolicitudActivity extends AppCompatActivity implements SolicitarView {

    @Bind(R.id.btnSolicitar)
    Button btnsolicitar;
    @Bind(R.id.spinnerCubiertos)
    Spinner spinnerCubiertos;
    @Bind(R.id.spinnerPostres)
    Spinner spinnerPostres;
    @Bind(R.id.spinnerBebidas)
    Spinner spinnerBebidas;
    @Bind(R.id.spinnerExtras)
    Spinner spinnerExtras;
    @Bind(R.id.cbxCuenta)
    CheckBox cbxcuenta;

    private ChatPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);
        ButterKnife.bind(this);

        presenter = new ChatPresenterImpl(this);
    }


    @OnClick(R.id.btnSolicitar)
    @Override
    public void handleSolicitar(){
        String spinnerC = spinnerCubiertos.getSelectedItem().toString();
        String spinnerB = spinnerBebidas.getSelectedItem().toString();
        String spinnerE = spinnerExtras.getSelectedItem().toString();
        String spinnerP = spinnerPostres.getSelectedItem().toString();

        String cuenta= "";
        if (cbxcuenta.isChecked()){
            cuenta="La Cuenta";
        }

        String pedir= "/  "+ cuenta + "  /  " + spinnerC  + "  /  " +
                spinnerB + "  /  " + spinnerE + "  /  " + spinnerP;

        ////////////////////////////////////////////////////////////////////
        if(pedir.length() > 0)
            presenter.sendMessage(pedir);

        /////////////////////////////////////////////////////////////////////
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
