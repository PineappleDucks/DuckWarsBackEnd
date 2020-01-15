package de.fh.dortmund.pineappleducks.register;

import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean implements RegisterBeanRemote, RegisterBeanLocal{

    public RegisterBean () { }

    @Override
    public String persist ( String login, String password) {
        UserManager manager = new UserManager();
        manager.registerUser(login, password);
        User savedUser = manager.getUserByName(login);
        if(savedUser.getUsername().equals(login)
        && savedUser.getPassword().equals(password)){
            return "Die Registrierung war erfolgreich!";
        }else {
            throw new RuntimeException("Es ist ein Fehler bei der Persistenz aufgetreten!");
        }
    }
}