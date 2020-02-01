package database;

import entity.chat.Chat;
import entity.chat.Contact;
import entity.chat.Message;
import entity.user.User;
import entity.user.UserData;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class UserManager {

    private EntityManager man = EntityManagerUtil.getManager();

    public User getUserByName(String username){
        Query query = man.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);

        List<User> userList = (List<User>) query.getResultList();

        if(userList.isEmpty()){
            return null;
        }else{
            System.out.println(userList.toString());
            return userList.get(0);
        }
    }

    public User getUserByNameAndPassword(String username, String password){
        Query query = man.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        List<User> users = (List<User>) query.getResultList();

        if(users == null){
            return null;
        }

        System.out.println(users.toString());

        if(users.size() != 1){
            return null;
        }

        return users.get(0);
    }

    public  void registerUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserData userData = new UserData();
        Chat chatSith = new Chat();
        chatSith.setJediSide(false);
        Contact contactSith = new ContactManager().getContactByFirstName("Bordcomputer");
        Message messageSith = UserUtil.initialSithMessage;
        List<Message> messagesSith = new LinkedList<>();
        messagesSith.add(messageSith);
        chatSith.setMessageList(messagesSith);
        chatSith.setContact(contactSith);

        man.getTransaction().begin();
        man.persist(chatSith);
        man.getTransaction().commit();

        Chat chatJedi = new Chat();
        chatJedi.setJediSide(true);
        Contact contactJedi = new ContactManager().getContactByFirstName("D2R2");
        Message messageJedi = UserUtil.initialJediMessage;
        List<Message> messagesJedi = new LinkedList<>();
        messagesJedi.add(messageJedi);
        chatJedi.setMessageList(messagesJedi);
        chatJedi.setContact(contactJedi);

        man.getTransaction().begin();
        man.persist(chatJedi);
        man.getTransaction().commit();

        List<Chat> chats = new LinkedList<>();
        chats.add(chatSith);
        chats.add(chatJedi);

        userData.setChats(chats);

        man.getTransaction().begin();
        man.persist(userData);
        man.getTransaction().commit();
        user.setUserData(userData);

        man.getTransaction().begin();
        man.persist(user);
        man.getTransaction().commit();
    }
}
