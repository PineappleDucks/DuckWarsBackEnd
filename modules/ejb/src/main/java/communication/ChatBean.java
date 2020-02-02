package communication;

import database.InitManager;
import database.UserManager;
import entity.chat.Chat;
import entity.chat.Condition;
import entity.chat.DialogOption;
import entity.chat.Message;
import entity.user.User;
import entity.user.UserData;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ChatBean {

    public Message messageSend(String username, DialogOption sendedMessage){
        InitManager manager = new InitManager();
        UserManager userManager = new UserManager();
        DialogOption option = manager.getDialogOptionByIdAlt(sendedMessage.getId());

        Message answer = option.getAnswer();
        List<DialogOption> options  = answer.getDialogOptions();
        //List<DialogOption> possibleOptions = filterMessages(username, options);

        User user = userManager.getUserByName(username);
        UserData userdata = user.getUserData();

        boolean chatExisting = false;
        for(Chat chat : userdata.getChats()){
            if (chat.getContact().equals(answer.getAuthor())){
                chat.getMessageList().add(answer);

                InitManager man = new InitManager();
                man.saveChat(chat);

                chatExisting = true;
            }
        }

        if(!chatExisting){
            Chat chatToCreate = new Chat();
            List<Message> messages = new LinkedList<>();
            messages.add(answer);
            chatToCreate.setContact(answer.getAuthor());
            chatToCreate.setMessageList(messages);
            InitManager man = new InitManager();
            man.saveChat(chatToCreate);
        }


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
