package de.fh.dortmund.pineappleducks.register;

import de.fh.dortmund.pineappleducks.entity.User;
import de.fh.dortmund.pineappleducks.manager.UserManager;
import de.fh.dortmund.pineappleducks.shared;
import de.fh.dortmund.pineappleducks.manager;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean {

    public RegisterBean () { }

    public String persist ( String login, String password, boolean helleseite) {
        UserManager manager = new UserManager();
        ChatManager cmanager = new ChatManager();
        Chat chat;
        if(helleseite == true){
            chat = New Chat(cmanager.getServerMessageByID(1000);)
        }
        else {
            chat = New Chat(cmanager.getServerMessageByID(2000);)
        }

        List<Chat> chats = new List<Chat>();
        chats.add(chat);
        savedUser.setChats(chats);
        cmanager.newChat(Chat chat);
        manager.registerUser(login, password, chat);
        User savedUser = manager.getUserByName(login);
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