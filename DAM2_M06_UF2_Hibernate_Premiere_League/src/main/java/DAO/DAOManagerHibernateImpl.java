package DAO;

import java.util.ArrayList;

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
    public boolean AddTeam(Team oneTeam) {
    	
        EntityTransaction transaction = eMan.getTransaction();
        boolean isAdded = false;

        try {
        	
            transaction.begin();
            eMan.persist(oneTeam);
            transaction.commit();
            isAdded = true;
            
        } catch (Exception ex) { ex.printStackTrace(); }
        
        return isAdded;
    }

	@Override
	public boolean DeleteTeam(String teamAbbr) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Team updateTeam(Team oneTeam) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Team getTeamByAbbr(String teamAbbr) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Team getTeamByName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
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
