package database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManager manager;

    public static EntityManager getManager(){
        if(manager == null){
            javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
            EntityManager man = factory.createEntityManager();
            manager = man;
        }
        return manager;
    }
}
