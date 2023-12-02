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
	public int ImportPlayers(String playersFileName, String teamName) {

	    int count = 0;

	    try (FileReader fR = new FileReader(playersFileName);
	         BufferedReader bR = new BufferedReader(fR);
	    ) {
	        String line = bR.readLine(); // Avoiding the 1st line
	        line = bR.readLine();

	        while (line != null) {

	            String[] fields = line.split(";");
	            // Asegúrate de tener suficientes campos y verifica si el equipo y la temporada son correctos
	            if (fields.length >= 6 && "2022-2023".equals(fields[5])) {

	                Player newPlayer = new Player();
	                
	                // Switch para mapear el nombre del equipo a la abreviatura
	                String teamAbv;
	                switch (fields[1]) {
	                    case "Arsenal FC":
	                        teamAbv = "Arsenal";
	                        break;
	                    case "Aston Villa":
	                        teamAbv = "Aston Villa";
	                        break;
	                    case "AFC Bournemouth":
	                        teamAbv = "Bournemouth";
	                        break; 
	                    case "Brentford FC":
	                        teamAbv = "Brentford";
	                        break;
	                    case "Brighton & Hove Albion":
	                        teamAbv = "Brighton";
	                        break;    
	                    case "Chelsea FC":
	                        teamAbv = "Chelsea";
	                        break;     
	                    case "Crystal Palace":
	                        teamAbv = "Crystal Palace";
	                        break;
	                    case "Everton FC":
	                        teamAbv = "Everton";
	                        break;   
	                    case "Fulham FC":
	                        teamAbv = "Fulham";
	                        break;    
	                    case "Leeds United":
	                        teamAbv = "Leeds";
	                        break;     
	                    case "Leicester City":
	                        teamAbv = "Leicester";
	                        break;     
	                    case "Liverpool FC":
	                        teamAbv = "Liverpool";
	                        break; 
	                    case "Manchester City":
	                        teamAbv = "Man City";
	                        break;     
	                    case "Manchester United":
	                        teamAbv = "Man United";
	                        break; 
	                    case "Newcastle United":
	                        teamAbv = "Newcastle";
	                        break;
	                    case "Nottingham Forest":
	                        teamAbv = "Nottingham";
	                        break;    
	                    case "Southampton FC":
	                        teamAbv = "Southampton";
	                        break;     
	                    case "Tottenham Hotspur":
	                        teamAbv = "Tottenham";
	                        break;     
	                    case "West Ham United":
	                        teamAbv = "West Ham";
	                        break; 
	                    case "Wolverhampton Wanderers":
	                        teamAbv = "Wolves";
	                        break;
	                    default:
	                        teamAbv = fields[1]; // Si no hay coincidencia, usa el nombre original
	                        break;
	                }

	                // Configura los atributos del jugador según el orden en el archivo CSV
	                newPlayer.setTeamAbv(teamAbv);
	                newPlayer.setPlayerId(Integer.parseInt(fields[2]));
	                newPlayer.setName(fields[0]);
	                newPlayer.setHeight(Integer.parseInt(fields[3]));
	                newPlayer.setPosition(fields[4]);

	                // Llama al método addPlayer que deberías haber implementado anteriormente
	                if (addPlayer(newPlayer)) {
	                    count++;
	                }
	            }

	            line = bR.readLine();
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }

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
