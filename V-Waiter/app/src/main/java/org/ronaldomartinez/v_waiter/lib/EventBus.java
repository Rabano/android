package org.ronaldomartinez.v_waiter.lib;

/**
 * Created by Ronaldo on 03/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);

    void unregister(Object subscriber);

    void post(Object event);
}
