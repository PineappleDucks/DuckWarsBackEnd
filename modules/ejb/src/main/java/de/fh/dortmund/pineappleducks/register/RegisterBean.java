package de.fh.dortmund.pineappleducks.register;

import de.fh.dortmund.pineappleducks.manager.UserManager;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean implements RegisterBeanRemote, RegisterBeanLocal{

    public RegisterBean () { }

    @Override
    public String persist ( String login, String password) {
        UserManager manager = new UserManager();
        manager.registerUser(login, password);
        return manager.getUserByName(login).getPassword();
    }
}