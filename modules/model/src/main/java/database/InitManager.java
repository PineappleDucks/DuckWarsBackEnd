package database;

import entity.chat.Chat;
import entity.chat.DialogOption;
import entity.chat.Message;
import entity.user.User;

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

    public DialogOption getDialogOptionByIdAlt(Long id){
        Query query = man.createQuery(
                "SELECT u FROM DialogOption u WHERE u.id = :doId", DialogOption.class);
        query.setParameter("doId", id);

        List<DialogOption> options = (List<DialogOption>) query.getResultList();

        if(options == null){
            return null;
        }

        if(options.size() != 1){
            return null;
        }

        return options.get(0);
    }

    public void saveMessage(Message message) {
        man.getTransaction().begin();
        man.persist(message);
        man.getTransaction().commit();
    }

    public void saveChat(Chat chat){
        man.getTransaction().begin();
        man.persist(chat);
        man.getTransaction().commit();
    }
}