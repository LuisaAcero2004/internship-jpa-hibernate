package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaManager {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManager manager;
    private static EntityManagerFactory managerFactory;

    public EntityManager getManager(){
        //Create new Entity Manager
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = managerFactory.createEntityManager();
        return manager;
    }


}
