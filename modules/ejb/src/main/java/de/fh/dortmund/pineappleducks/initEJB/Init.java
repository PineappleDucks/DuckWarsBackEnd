package de.fh.dortmund.pineappleducks.initEJB;

import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;

import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Init implements java.io.Serializable{
private User user;

public Init (LinkedHashMap map) throws ConstructException {


    if (map.containsKey("username")) {
        String username = map.get("username").toString();
        try {
            this.user = new UserManager().getUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else throw new ConstructException("Es wurde keine username uebermittelt! Key muss 'username' lauten! uebermittelte Daten:" + map.toString());
    if(user==null) throw new ConstructException("User ist null!");
}

    public Init(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
