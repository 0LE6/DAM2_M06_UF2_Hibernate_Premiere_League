package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public int importPlayers(String playersFileName, String teamName) {

		/* NOTE : PROJECT S-NK */
	    int count = 0;
	    int playerId = 1;
	    boolean past = false;

	    try (FileReader fR = new FileReader(playersFileName);
	         BufferedReader bR = new BufferedReader(fR);
	    ) {
	        String line = bR.readLine(); // Avoiding the 1st line
	        line = bR.readLine();

	        while (line != null && !past) {

	            String[] fields = line.split(";");
	            
	            // Crazy Switch 
	            String correctTeamName;
                switch (fields[1]) {
                    case "Arsenal FC":
                        correctTeamName = "Arsenal"; 
                        break;
                    case "Aston Villa":
                        correctTeamName = "Aston Villa";
                        break;
                    case "AFC Bournemouth":
                        correctTeamName = "Bournemouth";
                        break; 
                    case "Brentford FC":
                        correctTeamName = "Brentford";
                        break;
                    case "Brighton & Hove Albion":
                        correctTeamName = "Brighton";
                        break;    
                    case "Chelsea FC":
                        correctTeamName = "Chelsea";
                        break;     
                    case "Crystal Palace":
                        correctTeamName = "Crystal Palace";
                        break;
                    case "Everton FC":
                        correctTeamName = "Everton";
                        break;   
                    case "Fulham FC":
                        correctTeamName = "Fulham";
                        break;    
                    case "Leeds United":
                        correctTeamName = "Leeds";
                        break;     
                    case "Leicester City":
                        correctTeamName = "Leicester";
                        break;     
                    case "Liverpool FC":
                        correctTeamName = "Liverpool";
                        break; 
                    case "Manchester City":
                        correctTeamName = "Man City";
                        break;     
                    case "Manchester United":
                        correctTeamName = "Man United";
                        break; 
                    case "Newcastle United":
                        correctTeamName = "Newcastle";
                        break;
                    case "Nottingham Forest":
                        correctTeamName = "Nottingham";
                        break;    
                    case "Southampton FC":
                        correctTeamName = "Southampton";
                        break;     
                    case "Tottenham Hotspur":
                        correctTeamName = "Tottenham";
                        break;     
                    case "West Ham United":
                        correctTeamName = "West Ham";
                        break; 
                    case "Wolverhampton Wanderers":
                        correctTeamName = "Wolves";
                        break;
                    default:
                        correctTeamName = fields[1]; 
                        break;
                }	            
                
                if (fields[5].compareTo("2022-2023") > 0) {
	            	past = true;
	            }
	            else {
	            	
	            	if (fields[5].equals("2022-2023") && correctTeamName.equals(teamName)){
	            	
		            	Player newPlayer = new Player();
	
		                /* NOTE : important, using the team name to get the abbreviation 
		                 * through the method getTeamByName and then the getter of abbreviation */
		                newPlayer.setTeamAbv(getTeamByName(correctTeamName).getAbv());
		                newPlayer.setPlayerId(playerId++); 
		                newPlayer.setName(fields[0]);
		                
		                /* NOTE : taking the first 3 numbers of this field, 
		                 * corresponding to the height without the " cm" */
		                newPlayer.setHeight(Integer.parseInt(fields[3].substring(0, 3)));
		                newPlayer.setPosition(fields[4]);
	
		                if (addPlayer(newPlayer)) count++;
	            	}
	            } 
                line = bR.readLine();
	        }
	    } catch (IOException ex) { ex.printStackTrace(); }

	    return count;
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
