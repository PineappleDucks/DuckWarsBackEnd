package de.fh.dortmund.pineappleducks.loginEJB;

public class Login implements java.io.Serializable{
    String Password;
    String Name;

    public Login(String name, String password){
        this.Password = password;
        this.Name = name;
    }

    public boolean checkLogin(){
        return true;
    }
    public boolean checkName(){
        return true;
    }
    public void register(){

    }
    public void getSave(){

    }
}