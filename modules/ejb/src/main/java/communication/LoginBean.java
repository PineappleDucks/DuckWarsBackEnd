package communication;

import database.UserManager;
import entity.user.Credential;
import entity.user.User;

import javax.ejb.Stateless;

@Stateless
public class LoginBean {

    public Boolean checkForValidCredentials(Credential credential){

        String username = credential.getUsername();
        String password = credential.getPassword();

        UserManager userManager = new UserManager();
        User user =userManager.getUserByNameAndPassword(username, password);

        if(user != null){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
