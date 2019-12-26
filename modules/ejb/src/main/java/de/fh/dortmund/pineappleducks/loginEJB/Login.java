package de.fh.dortmund.pineappleducks.loginEJB;
import de.fh.dortmund.pineappleducks.model;
import de.fh.dortmund.pineappleducks.manager;

public class Login implements java.io.Serializable{
    User user = new User();
    UserManager manager = new UserManager();

    public Login(String name, String password){
        user.setPassword(password);
        user.setUsername(name);
    }

    public boolean checkLogin(){
        User test;
        test = manager.getUserByNameAndPassword(user.getUsername(), user.getPassword());
        if(user.getUsername()==test.getUsername()){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean checkName(){
        User test;
        test = manager.getUserByName(user.getUsername());
        if(user.getUsername()==test.getUsername()){
            return true;
        }
        else{
            return false;
        }
    }
    public void register(){
        manager.registerUser(user.getUsername(), user.getPassword());
    }
    public void getSave(){

    }
}