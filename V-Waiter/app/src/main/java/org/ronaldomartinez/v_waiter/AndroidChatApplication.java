package org.ronaldomartinez.v_waiter;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by Ronaldo on 03/07/2016.
 */
public class AndroidChatApplication extends Application {

    private final String ABOUT_URL = "http://www.kinal.org.gt/";

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public String getAboutUrl() {
        return ABOUT_URL;
    }


}
