package TEST;

import java.util.ArrayList;
import java.util.List;

import DAO.DAOManager;
import DAO.DAOManagerFactory;
import MODEL.Player;
import MODEL.Team;

public class Principal {

	public static void main(String[] args) {
		
		final String PLAYERS_FILE = "players.csv";

		// Using try-w-resources to implements the AutoCloseable
		try (DAOManager dao = DAOManagerFactory.createDAOManager()){
			
			/* AddTeam version A3.2 */
//			Team olegFC = new Team(
//					"Oleg FC", "OLG", "#FFFFFF", "fakelink.lol");
//			if (dao.addTeam(olegFC)) {
//				System.out.println("Team ADDED SUCCESFULLY!");
//			} else { System.out.println("TEAM NOT ADDED!"); }
			
			/* updateTeam */
//			Team updatedOlegFC = new Team(
//					"Unión Polideportiva Oleg", "OLG", "", "fakelink2.lol");
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
			/* addPlayer */
//			Player oleg = new Player(
//					"MNC", 1, "Oleg Kharenko", 190, "MF");
//			if(dao.addPlayer(oleg)) {
//				System.out.println("Player ADDED SUCCESFULLY!");
//			} else { System.out.println("Player NOT ADDED!"); }
			
			// NOTE: working!
			
			/* addPlayers */
//			System.out.println(dao.importPlayers(PLAYERS_FILE, "Man City"));
			
//			System.out.println(dao.importPlayers(PLAYERS_FILE, "Man United"));
			
//			System.out.println(dao.importPlayers(PLAYERS_FILE, "Arsenal"));
			
			/* addTeam version A3.4*/
			Team testTeam = new Team(
					"Test A34", "A34", "#FFFFFE", "fakelink4testa34.lol");
			Player player1 = new Player("A34",1,"Player 1", 200, "GK");
			Player player2 = new Player("A34",2,"Player 2", 200, "FW");
			Player player3 = new Player("A34",3,"Player 3", 200, "MF");
			
			List<Player> players = new ArrayList<Player>();
			players.add(player1);
			players.add(player2);
			players.add(player3);
			
			if (dao.addTeam(testTeam, players)) {
				System.out.println("Team with Players ADDED SUCCESFULLY!");
			} else { System.out.println("TEAM with Players NOT ADDED!"); }
			
			
		} catch (Exception e) { e.printStackTrace(); }
	}

}
