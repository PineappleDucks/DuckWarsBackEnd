package de.fh.dortmund.pineappleducks.loginEJB;


import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;

public class Login implements java.io.Serializable{
    User user = new User();
    UserManager manager = new UserManager();

    public Login(String name, String password){
        user.setPassword(password);
        user.setUsername(name);
    }

    public boolean checkLogin(){
        try {
            User found = manager.getUserByNameAndPassword(user.getUsername(), user.getPassword());

            return found.getUsername().equals(user.getUsername());
        } catch(Exception e) {
            return false;
        }
    }

    public boolean checkName(){
        try {
            User found = manager.getUserByName(user.getUsername());

            return found.getUsername().equals(user.getUsername());
        } catch(Exception e) {
            return false;
        }
    }

    public void register(){
        manager.registerUser(user.getUsername(), user.getPassword());
    }

    public void getSave(){

    }
}