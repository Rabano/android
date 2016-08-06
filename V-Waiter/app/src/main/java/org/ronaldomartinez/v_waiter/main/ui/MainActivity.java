package org.ronaldomartinez.v_waiter.main.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.ronaldomartinez.v_waiter.AndroidChatApplication;
import org.ronaldomartinez.v_waiter.R;
import org.ronaldomartinez.v_waiter.entities.Productos;
import org.ronaldomartinez.v_waiter.login.ui.LMesaActivity;
import org.ronaldomartinez.v_waiter.main.MainListPresenter;
import org.ronaldomartinez.v_waiter.main.MainListPresenterImpl;
import org.ronaldomartinez.v_waiter.main.productos.adapter.Adapter;
import org.ronaldomartinez.v_waiter.solicitud.ui.SolicitudActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.txtUser)
    TextView txtUser;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private MainListPresenter presenter;
    private RecyclerView rvi;
    List<Productos> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvi=(RecyclerView)findViewById(R.id.rv);
        presenter = new MainListPresenterImpl(this);
        setupToolbar();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvi.setLayoutManager(llm);
        rvi.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            presenter.signOff();
            Intent intent = new Intent(this, LMesaActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.itemsK) {
            AndroidChatApplication app = (AndroidChatApplication) getApplication();
            String strUrl = app.getAboutUrl();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(strUrl));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupToolbar() {
        toolbar.setTitle("");
        String userEmail = presenter.getCurrentUserEmail();
        switch (  userEmail  ) {
            case "ms_1@res.com":
                userEmail = "1";
                txtUser.setText("Mesa # "+userEmail);
                setSupportActionBar(toolbar);
            break;
            case "ms_2@res.com":
                userEmail = "2";
                txtUser.setText("Mesa # "+userEmail);
                setSupportActionBar(toolbar);
                break;
            case "ms_3@res.com":
                userEmail = "3";
                txtUser.setText("Mesa # "+userEmail);
                setSupportActionBar(toolbar);
                break;
            case "ms_4@res.com":
                userEmail = "4";
                txtUser.setText("Mesa # "+userEmail);
                setSupportActionBar(toolbar);
                break;
        }

    }


    @OnClick(R.id.fab)
    @Override
    public void addSolicitud() {
        Intent intent = new Intent(this, SolicitudActivity.class);
        startActivity(intent);
    }

    public String getMesa(){
        String userEmail = presenter.getCurrentUserEmail();
        return userEmail;
    }

    private void initializeAdapter(){
        Adapter adapter = new Adapter(persons);
        rvi.setAdapter(adapter);
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Productos("Restaurante Gurmet",R.drawable.cubiertos));
        persons.add(new Productos("Helado de Chocolate", R.drawable.heladochocolate));
        persons.add(new Productos("Helado de Fresa", R.drawable.heladofresa));
        persons.add(new Productos("Jugos", R.drawable.jugosnaturales));
        persons.add(new Productos("Pastel de chocolate", R.drawable.pastelchoco));
        persons.add(new Productos("Pastel de Fresa", R.drawable.pastelfresa));
        persons.add(new Productos("Pie de Manzana", R.drawable.piedemanzana));
        persons.add(new Productos("Bebidas Refrescantes", R.drawable.vasohielo));
        persons.add(new Productos("Vinos", R.drawable.vino));
        persons.add(new Productos("Whisky", R.drawable.whisky));
        persons.add(new Productos("Gaseosas", R.drawable.coca));
    }

}
