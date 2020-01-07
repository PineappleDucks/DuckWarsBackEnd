package de.fh.dortmund.pineappleducks.manager;

import de.fh.dortmund.pineappleducks.shared.Chat;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ChatManager {
    //TODO könnt ihr euch das angucken? Ich hab mich am anderen Manager orientiert, aber ich habe das gefühl, dass das so nicht ganz stimmt?
    public Chat getChatByID(int chatID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Chat");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT c FROM Chat c WHERE c.ID = :chatID", Chat.class);
        query.setParameter("chatID", chatID);

        Chat cat = (Chat) query.getSingleResult();
        return cat;
    }

    public ServerMessage getAntwort(int messageID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerAntwort");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT m FROM Message m WHERE m.ID = :messageID", ServerMessage.class);
        query.setParameter("messageID", messageID);

        ServerMessage antwort = (ServerMessage) query.getSingleResult();
        return antwort;
    }

    public ServerMessage getServerMessageByID(int messageID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerMessage");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT m FROM ServerMessage m WHERE m.ID = :messageID", ServerMessage.class);
        query.setParameter("messageID", messageID);

        ServerMessage message = (ServerMessage) query.getSingleResult();
        return message;
    }
}
