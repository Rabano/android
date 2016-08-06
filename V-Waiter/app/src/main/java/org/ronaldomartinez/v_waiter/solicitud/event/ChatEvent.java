package org.ronaldomartinez.v_waiter.solicitud.event;
import org.ronaldomartinez.v_waiter.entities.ChatMessage;

/**
 * Created by Ronaldo on 07/07/2016.
 */
public class ChatEvent {
    ChatMessage message;

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
