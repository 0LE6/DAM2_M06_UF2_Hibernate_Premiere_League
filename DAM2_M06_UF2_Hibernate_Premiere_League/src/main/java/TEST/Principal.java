package TEST;

import DAO.DAOManager;
import DAO.DAOManagerFactory;
import MODEL.Team;

public class Principal {

	public static void main(String[] args) {

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
			System.out.println(dao.getTeamByAbbr("MNC"));
			
			// getTeamByName
			System.out.println(dao.getTeamByName("Man City"));
			
			// getAllTeams
			for (Team t : dao.getAllTeams()) {
				System.out.println(t);
			}
			
		} catch (Exception e) { e.printStackTrace(); }
	}

}
