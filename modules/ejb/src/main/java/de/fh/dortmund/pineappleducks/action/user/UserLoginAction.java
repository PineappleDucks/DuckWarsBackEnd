package de.fh.dortmund.pineappleducks.action.user;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;

public class UserLoginAction implements Action {

    private final User user;

    public UserLoginAction(User user){
        this.user = user;
    }

    @Override
    public void run() {
        UserManager userManager = new UserManager();
        User checkUser = userManager.getUserByName(user.getUsername());
        if(!(checkUser.getPassword().equals(user.getPassword()))){
            throw new IllegalArgumentException("Passwort falsch!");
        }
    }
}
