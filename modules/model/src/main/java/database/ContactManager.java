package database;

import entity.chat.Contact;
import entity.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ContactManager {

    public User getContactByFirstName(String firstname){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT u FROM Contact u WHERE u.firstName = :username", Contact.class);
        query.setParameter("username", firstname);

        List<User> userList = (List<User>) query.getResultList();

        if(userList.isEmpty()){
            return null;
        }else{
            return userList.get(0);
        }
    }

    public  void saveContact(Contact contact){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        man.getTransaction().begin();
        man.persist(contact);
        man.getTransaction().commit();
    }
}
