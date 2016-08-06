package org.ronaldomartinez.v_waiter.solicitud;

/**
 * Created by Ronaldo on 07/07/2016.
 */
public interface ChatInteractor {
    void sendMessage(String msg);

    void setRecipient(String recipient);

    void destroyListener();

    void subscribe();

    void unSubscribe();
}
