package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import MODEL.Team;

public class DAOManagerHibernateImpl implements DAOManager {
    
    
	private EntityManagerFactory eManFact;
    private EntityManager eMan;
    
    public DAOManagerHibernateImpl() {
        try {

            eManFact = Persistence.createEntityManagerFactory("ORMEmployee");
            eMan = eManFact.createEntityManager();
            
        } catch (Exception e) { e.printStackTrace(); }
    }

	
    
	@Override
    public void close() {
        // Closing the EntityManager y el EntityManagerFactory 
        if (eMan != null && eMan.isOpen()) {
            eMan.close();
        }
        if (eManFact != null && eManFact.isOpen()) {
            eManFact.close();
        }
    }

}
