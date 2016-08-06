package org.ronaldomartinez.androidchat.contactlist.ui;

import org.ronaldomartinez.androidchat.entities.User;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public interface ContactListView {

    void onContactAdded(User user);

    void onContactChanged(User user);

    void onContactRemoved(User user);
}
