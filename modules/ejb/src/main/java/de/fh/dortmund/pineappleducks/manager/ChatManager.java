package de.fh.dortmund.pineappleducks.manager;

import de.fh.dortmund.pineappleducks.shared.Chat;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ChatManager {

    public Chat getChatByID(Long chatID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT c FROM Chat c WHERE c.chatId = :chatID", de.fh.dortmund.pineappleducks.entity.Chat.class);
        query.setParameter("chatID", chatID);

        Chat cat = (Chat) query.getSingleResult();
        return cat;
    }

    public ServerMessage getAntwort(int messageID) { // get Antwort des Servers auf die Message, die der Nutzer gewählt hat.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();
        Query query = man.createQuery(
                "SELECT m FROM Message m WHERE m.messageId = :messageID", de.fh.dortmund.pineappleducks.entity.ServerMessage.class);
        query.setParameter("messageID", messageID);

        ServerMessage temp = (ServerMessage) query.getSingleResult();
        ServerMessage antwort = getServerMessageByID((int) temp.getNext());
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
