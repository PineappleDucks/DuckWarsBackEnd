package de.fh.dortmund.pineappleducks.action.user;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.entity.User;

public class UserLoginAction implements Action {

    private final User user;

    public UserLoginAction(User user){
        this.user = user;
    }

    @Override
    public void run() {
        //TODO Login
    }
}
