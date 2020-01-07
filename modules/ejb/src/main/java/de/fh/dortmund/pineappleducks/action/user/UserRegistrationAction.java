package de.fh.dortmund.pineappleducks.action.user;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.entity.User;

public class UserRegistrationAction implements Action {

    private final User user;

    public UserRegistrationAction(User user){
        this.user = user;
    }

    @Override
    public void run() {
        //TODO Registration
    }
}