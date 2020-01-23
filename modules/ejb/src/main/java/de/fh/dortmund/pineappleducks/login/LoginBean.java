package de.fh.dortmund.pineappleducks.login;

import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;

import javax.ejb.Stateless;

@Stateless
public class LoginBean {

    public LoginBean(){}

    public Boolean checkForValidCredentials(String username, String password){
        if(checkForValidCredentialsInternal(username, password)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean checkForValidCredentialsInternal(String username, String password){
        UserManager manager = new UserManager();
        try{
            User user = manager.getUserByNameAndPassword(username, password);
            if(user != null){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }catch(Exception e){
            return Boolean.FALSE;
        }
    }

}
