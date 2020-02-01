package communication;

import database.InitManager;
import database.UserManager;
import entity.chat.Condition;
import entity.chat.DialogOption;
import entity.chat.Message;
import entity.user.User;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ChatBean {

    public Message messageSend(String username, DialogOption sendedMessage){
        InitManager manager = new InitManager();
        DialogOption option = manager.getDialogOptionById(sendedMessage.getId());

        Message answer = option.getAnswer();
        List<DialogOption> options  = answer.getDialogOptions();
        //List<DialogOption> possibleOptions = filterMessages(username, options);
        answer.setDialogOptions(options);
        return answer;
    }

    private List<DialogOption> filterMessages(String username, List<DialogOption> options){
        List<DialogOption> ret;
        List<Condition> conditions = getUserConditions(username);
        ret = filterMessagesWithConditions(conditions, options);
        return ret;
    }

    private List<Condition> getUserConditions(String username){
        UserManager manager = new UserManager();
        User user = manager.getUserByName(username);
        return user.getUserData().getConditions();
    }

    private List<DialogOption> filterMessagesWithConditions(List<Condition> conditions, List<DialogOption> options){
        List<DialogOption> filtered = new LinkedList<>();

        for(DialogOption option : options){
            if(checkForValidConditionsForMessage(conditions, option)){
                filtered.add(option);
            }
        }
        return filtered;
    }

    private Boolean checkForValidConditionsForMessage(List<Condition> condtions, DialogOption option){
           for(Condition conditionFromUser : condtions){
               for(Condition conditionFromMessage : option.getConditions()){
                   if(conditionFromUser.getConditionDescriptor().equals(conditionFromMessage.getConditionDescriptor())){
                       if(!conditionFromUser.getConditionStatus().equals(conditionFromMessage.getConditionStatus())){
                           return Boolean.FALSE;
                       }
                   }
               }
           }
           return Boolean.TRUE;
    }

}
