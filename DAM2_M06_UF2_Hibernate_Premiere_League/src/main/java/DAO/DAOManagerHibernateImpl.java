package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import MODEL.Player;
import MODEL.Team;

public class DAOManagerHibernateImpl implements DAOManager {
    
    
	private EntityManagerFactory eManFact;
    private EntityManager eMan;
    
    public DAOManagerHibernateImpl() {
        try {

            eManFact = Persistence.createEntityManagerFactory("ORMTeam");
            eMan = eManFact.createEntityManager();
            
        } catch (Exception e) { e.printStackTrace(); }
    }

	
    @Override 
    public boolean addTeam(Team oneTeam) {
    	
        EntityTransaction transaction = eMan.getTransaction();
        boolean isAdded = false;

        try {
        	
            transaction.begin();
            eMan.persist(oneTeam);
            transaction.commit();
            isAdded = true;
            
        } catch (Exception e) { e.printStackTrace(); }
        
        return isAdded;
    }

    @Override
    public boolean deleteTeam(String teamAbbr) {
    	
        EntityTransaction transaction = eMan.getTransaction();
        boolean isDeleated = false;

        try {

            transaction.begin();
            // Checking if there's any team w/ that abbreviation.
            Team team = eMan.find(Team.class, teamAbbr);

            // If there's one,  then we'll delete it
            if (team != null) {
                eMan.remove(team);
                transaction.commit();
                isDeleated = true;
            } 
        } catch (Exception e) { e.printStackTrace(); }
        
        return isDeleated;
    }



    @Override
    public Team updateTeam(Team oneTeam) {
    	
        EntityTransaction transaction = eMan.getTransaction();
        Team teamAfterUpdate = null;

        try {
        	
            transaction.begin();
            teamAfterUpdate = eMan.find(Team.class, oneTeam.getAbv());

            // If the parameter team exists...
            if (teamAfterUpdate != null) { 
                // Update all fields except abbreviation
            	teamAfterUpdate.setClubName(oneTeam.getClubName());
            	teamAfterUpdate.setHexCode(oneTeam.getHexCode());
            	teamAfterUpdate.setLogoLink(oneTeam.getLogoLink());
            	transaction.commit();
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return teamAfterUpdate;
    }



    @Override
    public Team getTeamByAbbr(String teamAbbr) {
    	
    	Team teamByAbbr = null;
    	
    	try { teamByAbbr = eMan.find(Team.class, teamAbbr); }
    	catch (Exception ex) { ex.printStackTrace(); }
    	
        return teamByAbbr;
    }
    
    @Override
    public Team getTeamByName(String teamName) {
    	
    	Team teamByName = null;
    	
    	try {
    		// Using parameters to avoid SQL Injections
    		Query query = eMan.createQuery(
    				"SELECT t FROM Team t WHERE t.clubName = :name");
    		query.setParameter("name", teamName);
    		teamByName= (Team) query.getSingleResult();
    		
    	} catch (Exception e) { e.printStackTrace(); }
    	
    	return teamByName;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Team> getAllTeams() {

		ArrayList<Team> listOfTeams = null;
		
		try { 
			
			Query query = eMan.createQuery("SELECT t FROM Team t");
			listOfTeams = (ArrayList<Team>) query.getResultList();
			
		} catch (Exception e) { e.printStackTrace(); }		
		
		return listOfTeams;
	}
	
	/* NOTE : Methods of A3.3 */
	@Override
	public boolean addPlayer(Player onePlayer) {

		EntityTransaction transaction = eMan.getTransaction();
	    boolean isAdded = false;

	    try {
	        transaction.begin();
	        eMan.persist(onePlayer);
	        transaction.commit();
	        isAdded = true;
	    } catch (Exception e) { e.printStackTrace(); }

	    return isAdded;
	}


	@Override
	public int ImportPlayers(String playersFileName, String teamName) {
		// TODO Auto-generated method stub
		return 0;
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
