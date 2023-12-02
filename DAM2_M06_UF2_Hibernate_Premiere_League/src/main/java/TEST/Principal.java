package TEST;

import DAO.DAOManager;
import DAO.DAOManagerFactory;
import MODEL.Player;
import MODEL.Team;

public class Principal {

	public static void main(String[] args) {
		
		final String PLAYERS_FILE = "players.csv";

		// Using try-w-resources to implements the AutoCloseable
		try (DAOManager dao = DAOManagerFactory.createDAOManager()){
			
			/* AddTeam */
//			Team olegFC = new Team(
//					"Oleg FC", "OLG", "#FFFFFF", "fakelink.lol");
//			if (dao.addTeam(olegFC)) {
//				System.out.println("Team ADDED SUCCESFULLY!");
//			} else { System.out.println("TEAM NOT ADDED!"); }
			
			/* updateTeam */
//			Team updatedOlegFC = new Team(
//					"Unión Polideportiva Oleg", "OLG", "#FFFFFE", "fakelink2.lol");
//			if (dao.updateTeam(updatedOlegFC) != null) {
//				System.out.println("Team UPDATED SUCCESFULLY!");
//				System.out.println(dao.updateTeam(updatedOlegFC));
//			} else { System.out.println("TEAM NOT UPDATE!"); }
			
			/* deleteTeam */
//			if (dao.deleteTeam("OLG")) {
//				System.out.println("Team DELETED SUCCESFULLY!");
//			} else { System.out.println("TEAM NOT DELETED!"); }
			
			// getTeamByAbbr
//			System.out.println(dao.getTeamByAbbr("MNC"));
			
			// getTeamByName
//			System.out.println(dao.getTeamByName("Man City"));
			
			// getAllTeams
//			for (Team t : dao.getAllTeams()) { System.out.println(t); }
			
			/* NOTE : correct working of A3.2 methods */
			
			
			/* NOTE : tests of A3.3 */
			// addPlayer
//			Player oleg = new Player(
//					"MNC", 1, "Oleg Kharenko", 190, "MF");
//			if(dao.addPlayer(oleg)) {
//				System.out.println("Player ADDED SUCCESFULLY!");
//			} else { System.out.println("Player NOT ADDED!"); }
			
			// NOTE: working!
			
			// addPlayers
//			System.out.println(dao.importPlayers(PLAYERS_FILE, "Man City"));
			
//			System.out.println(dao.importPlayers(PLAYERS_FILE, "Man United"));
			
			System.out.println(dao.importPlayers(PLAYERS_FILE, "Arsenal"));
			
			
		} catch (Exception e) { e.printStackTrace(); }
	}

}
