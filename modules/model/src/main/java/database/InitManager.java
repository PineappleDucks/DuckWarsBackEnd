package database;

import entity.chat.DialogOption;
import entity.chat.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InitManager {
    public void saveDialogOption(DialogOption option) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        man.getTransaction().begin();
        man.persist(option);
        man.getTransaction().commit();
    }

    public void saveMessage(Message message) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        man.getTransaction().begin();
        man.persist(message);
        man.getTransaction().commit();
    }
}