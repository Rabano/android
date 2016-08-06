package org.ronaldomartinez.v_waiter.solicitud;

import org.ronaldomartinez.v_waiter.lib.GreenRobotEventBus;
import org.ronaldomartinez.v_waiter.solicitud.ui.SolicitarView;

/**
 * Created by Ronaldo on 07/07/2016.
 */
public class ChatPresenterImpl implements ChatPresenter {
    private org.ronaldomartinez.v_waiter.lib.EventBus eventBus;
    private ChatInteractor chatInteractor;

    public ChatPresenterImpl(SolicitarView view) {
        eventBus = GreenRobotEventBus.getInstance();
        this.chatInteractor = new ChatInteractorImpl();
    }

    @Override
        public void setChatRecipient(String recipient) {
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

}
