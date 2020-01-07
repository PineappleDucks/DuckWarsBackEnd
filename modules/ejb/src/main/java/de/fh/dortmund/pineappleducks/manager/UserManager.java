package de.fh.dortmund.pineappleducks.manager;

import de.fh.dortmund.pineappleducks.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserManager {

    public User getUserByName(String username) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);

        User user = (User) query.getSingleResult();
        return user;
    }

    public User getUserByNameAndPassword(String username, String password) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        User user = (User) query.getSingleResult();
        return user;
    }

    public void registerUser(String username, String password) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        EntityManager man = factory.createEntityManager();

        Query query = man.createQuery(
                "INSERT INTO User u (u.sername, u.password) VALUES (:username, :password)", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
    }
}
