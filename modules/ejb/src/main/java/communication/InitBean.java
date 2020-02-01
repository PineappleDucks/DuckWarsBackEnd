package communication;

import database.UserManager;
import entity.user.User;
import entity.user.UserData;

import javax.ejb.Stateless;

@Stateless
public class InitBean {

    public UserData getUserData(String username){
        UserManager manager = new UserManager();
        User user = manager.getUserByName(username);
        if(user != null){
            return user.getUserData();
        }else{
            return null;
        }
    }
}
