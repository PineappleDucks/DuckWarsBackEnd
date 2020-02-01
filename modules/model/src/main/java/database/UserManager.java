package database;

import entity.chat.Chat;
import entity.chat.Contact;
import entity.chat.Message;
import entity.user.User;
import entity.user.UserData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        Chat chat = new Chat();
        Contact contact = new ContactManager().getContactByFirstName("Bordcomputer");
        Message message = UserUtil.initialMessage;
        List<Message> messages = new LinkedList<>();
        messages.add(message);
        chat.setMessageList(messages);
        chat.setContact(contact);
        List<Chat> chats = new LinkedList<>();
        chats.add(chat);

        man.getTransaction().begin();
        man.persist(chat);
        man.getTransaction().commit();

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
