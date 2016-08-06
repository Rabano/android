package org.ronaldomartinez.androidchat.contactlist.events.adapters;

import org.ronaldomartinez.androidchat.entities.User;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user);

    void onItemLongClick(User user);
}
