package de.fh.dortmund.pineappleducks.register;

import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.ChatManager;
import de.fh.dortmund.pineappleducks.manager.UserManager;
import de.fh.dortmund.pineappleducks.shared;
import de.fh.dortmund.pineappleducks.manager;
import de.fh.dortmund.pineappleducks.entity.Chat;
import de.fh.dortmund.pineappleducks.entity.Message;
import java.util.ArrayList;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class RegisterBean {

    public RegisterBean () { }

    public String persist ( String login, String password, boolean helleseite) {
        UserManager manager = new UserManager();
        manager.registerUser(login, password, null);
        User savedUser = manager.getUserByName(login);
        ChatManager cmanager = new ChatManager();
        Chat chat = new Chat();
        List<Message> messageList = new ArrayList<Message>();
        if(helleseite == true){
            messageList.add(cmanager.getServerMessageByID(1000));
        }
        else {
            messageList.add(cmanager.getServerMessageByID(2000));
        }
        chat.setMessageList(messageList);
        List<Chat> chats = new ArrayList<Chat>();
        chats.add(chat);
        savedUser.setChats(chats);

        if(savedUser.getUsername().equals(login)
        && savedUser.getPassword().equals(password)){
            return "Die Registrierung war erfolgreich!";
        }else {
            throw new RuntimeException("Es ist ein Fehler bei der Persistenz aufgetreten!");
        }
    }

    public Boolean checkForExistingUserName(String username){
        UserManager manager = new UserManager();
        User user = manager.getUserByName(username);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }
}