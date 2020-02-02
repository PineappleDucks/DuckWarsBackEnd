package communication;

import database.EntityManagerUtil;
import database.UserManager;
import entity.chat.Chat;
import entity.chat.DialogOption;
import entity.chat.Message;
import entity.user.User;
import entity.user.UserData;

import javax.ejb.Stateless;

@Stateless
public class InitBean {

    public UserData getUserData(String username){
        UserManager manager = new UserManager();
        User user = manager.getUserByName(username);
        if(user != null){
            UserData userdata = user.getUserData();
            for(Chat chat : userdata.getChats()){
                for(Message message : chat.getMessageList()){
                    for(DialogOption option : message.getDialogOptions()){
                        EntityManagerUtil.getManager().detach(option);
                        option.setAnswer(null);
                    }
                }
            }
            return user.getUserData();
        }else{
            return null;
        }
    }
}
