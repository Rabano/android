package org.ronaldomartinez.v_waiter.main.event;


import org.ronaldomartinez.v_waiter.entities.User;

/**
 * Created by Ronaldo on 04/07/2016.
 */
public class MesaListEvent {
    public final static int onContactAdded = 0;
    public final static int onContactChanged = 1;
    public final static int onContactRemoved = 2;

    private User user;
    private int eventType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

}
