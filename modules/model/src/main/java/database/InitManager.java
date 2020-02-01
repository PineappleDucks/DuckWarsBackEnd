package database;

import entity.chat.DialogOption;
import entity.chat.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InitManager {

    private EntityManager man = EntityManagerUtil.getManager();

    public void saveDialogOption(DialogOption option) {
        man.getTransaction().begin();
        man.persist(option);
        man.getTransaction().commit();
    }

    public DialogOption getDialogOptionById(Long id){
        return man.find(DialogOption.class, id);
    }

    public void saveMessage(Message message) {
        man.getTransaction().begin();
        man.persist(message);
        man.getTransaction().commit();
    }
}