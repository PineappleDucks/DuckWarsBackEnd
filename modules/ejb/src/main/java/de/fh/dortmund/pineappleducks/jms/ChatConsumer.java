package de.fh.dortmund.pineappleducks.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ChatQueue")
        },
        mappedName = "java:/jms/queue/ChatQueue")
public class ChatConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {

    }
}
