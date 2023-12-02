package TEST;

import DAO.DAOManager;
import DAO.DAOManagerFactory;
import MODEL.Team;

public class Principal {

	public static void main(String[] args) {

		// Using try-w-resources to implements the AutoCloseable
		try (DAOManager dao = DAOManagerFactory.createDAOManager()){
			
			// addTeam
			Team oleg = new Team(
					"Oleg FC", "OLG", "#FFFFFF", "fakelink.lol" );
			if (dao.AddTeam(oleg)) {
				System.out.println("Team ADDED SUCCESFULLY!");
			} else { System.out.println("TEAM NOT ADDED!"); }
			
			// updateTeam
			
			
			// deleteTeam
			
			
			// getTeamByAbbr
			
			
			// getTeamByName
			
			
			// getAllTeams
			
		} catch (Exception e) { e.printStackTrace(); }
	}

}
