package de.fh.dortmund.pineappleducks.jms;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.action.user.UserAction;
import de.fh.dortmund.pineappleducks.action.user.UserActionDefinition;
import de.fh.dortmund.pineappleducks.action.user.UserLoginAction;
import de.fh.dortmund.pineappleducks.action.user.UserRegistrationAction;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/UserQueue")
        },
        mappedName = "java:/jms/queue/LoginQueue")
public class UserConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        UserAction userAction = getUserActionFromMessage(message);
        runActionOfUserAction(userAction);
    }

    private UserAction getUserActionFromMessage(Message message) {
        ObjectMessage objectMessage = convertToObjectMessage(message);
        UserAction userAction = extractObjectFromMessage(objectMessage);
        if(userAction != null){
            return userAction;
        }else{
            throw new IllegalArgumentException("Error while deserialize object from message!");
        }
    }

    private ObjectMessage convertToObjectMessage(Message message){
        if(message instanceof ObjectMessage){
            return (ObjectMessage) message;
        }else{
            throw new IllegalArgumentException("Only ObjectMessages can be processed!");
        }
    }

    private UserAction extractObjectFromMessage(ObjectMessage message){
        try{
            Object object = message.getObject();
            if(object instanceof UserAction){
                return (UserAction) object;
            }else{
                throw new IllegalArgumentException("Only objects of type UserAction are allowed!");
            }
        } catch (JMSException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void runActionOfUserAction(UserAction userAction){

        Action action;

        if(userAction.action.equals(UserActionDefinition.REGISTER)){
            action = new UserRegistrationAction(userAction.user);
        }
        else if(userAction.action.equals(UserActionDefinition.LOGIN)){
            action = new UserLoginAction(userAction.user);
        }
        else{
            throw new IllegalArgumentException("provided unknown action!");
        }

        action.run();
    }
}