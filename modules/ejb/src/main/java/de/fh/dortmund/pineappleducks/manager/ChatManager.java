package de.fh.dortmund.pineappleducks.manager;

import de.fh.dortmund.pineappleducks.shared.Chat;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ChatManager {

    public Chat getChatByID(int chatID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT c FROM Chat c WHERE c.chatId = :chatID", Chat.class);
        query.setParameter("chatID", chatID);

        Chat cat = (Chat) query.getSingleResult();
        return cat;
    }

    public ServerMessage getAntwort(int messageID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT m FROM Message m WHERE m.messageId = :messageID", ServerMessage.class);
        query.setParameter("messageID", messageID);

        ServerMessage antwort = (ServerMessage) query.getSingleResult();
        return antwort;
    }

    public ServerMessage getServerMessageByID(int messageID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT m FROM ServerMessage m WHERE m.messageId = :messageID", ServerMessage.class);
        query.setParameter("messageID", messageID);

        ServerMessage message = (ServerMessage) query.getSingleResult();
        return message;
    }
}
