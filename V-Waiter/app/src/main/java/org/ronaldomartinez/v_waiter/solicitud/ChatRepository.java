package org.ronaldomartinez.v_waiter.solicitud;

/**
 * Created by Ronaldo on 07/07/2016.
 */
public interface ChatRepository {

    void sendMessage(String msg);
    void setRecipient(String recipient);

    void subscribe();
    void unSubscribe();
    void destroyListener();
    void changeConnectionStatus(boolean online);
}
