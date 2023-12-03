package DAO;
import java.util.ArrayList;
import java.util.List;

import MODEL.Player;
import MODEL.Team;

public interface DAOManager extends AutoCloseable{

	/* Methods of A3.2 */
	public boolean addTeam(Team oneTeam);
	public boolean deleteTeam(String teamAbbr);
	public Team updateTeam(Team oneTeam);
	public Team getTeamByAbbr(String teamAbbr);
	public Team getTeamByName(String teamName);
	public ArrayList<Team> getAllTeams();
	
	/* Methods of A3.3 */
	public boolean addPlayer(Player onePlayer);
	public int importPlayers(String playersFileName, String teamName);
	
	/* Method of A3.4 */
	public boolean addTeam(Team oneTeam, List<Player> plantilla);
}