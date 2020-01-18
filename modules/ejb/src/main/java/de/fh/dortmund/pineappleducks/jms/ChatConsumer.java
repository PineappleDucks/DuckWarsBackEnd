package de.fh.dortmund.pineappleducks.jms;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.action.chat.ChatAction;
import de.fh.dortmund.pineappleducks.action.chat.ChatActionDefinition;
import de.fh.dortmund.pineappleducks.chatEJB.ChatOptionsAction;
import de.fh.dortmund.pineappleducks.chatEJB.ChatSendenAction;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ChatQueue")
        },
        mappedName = "java:/jms/queue/ChatQueue")
public class ChatConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ChatAction chatAction = getChatActionFromMessage(message);
        runActionOfUserAction(chatAction);
    }

    private ChatAction getChatActionFromMessage(Message message) {
        ObjectMessage objectMessage = convertToObjectMessage(message);
        ChatAction chatAction = extractObjectFromMessage(objectMessage);
        if (chatAction != null) {
            return chatAction;
        } else {
            throw new IllegalArgumentException("Error while deserialize object from message!");
        }
    }

    private ObjectMessage convertToObjectMessage(Message message) {
        if (message instanceof ObjectMessage) {
            return (ObjectMessage) message;
        } else {
            throw new IllegalArgumentException("Only ObjectMessages can be processed!");
        }
    }

    private ChatAction extractObjectFromMessage(ObjectMessage message) {
        try {
            Object object = message.getObject();
            if (object instanceof ChatAction) {
                return (ChatAction) object;
            } else {
                throw new IllegalArgumentException("Only objects of type UserAction are allowed!");
            }
        } catch (JMSException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void runActionOfUserAction(ChatAction chatAction) {

        Action action;

        if (chatAction.action.equals(ChatActionDefinition.GETOPTIONS)) {
            action = new ChatOptionsAction(chatAction.chat);
        } else if (chatAction.action.equals(ChatActionDefinition.NACHRICHTSENDEN)) {
            action = new ChatSendenAction(chatAction.chat);
        } else {
            throw new IllegalArgumentException("provided unknown action!");
        }

        action.run();
    }
}
