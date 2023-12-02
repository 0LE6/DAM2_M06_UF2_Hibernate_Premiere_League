package DAO;
import java.util.ArrayList;

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
	public int ImportPlayers(String playersFileName, String teamName);
}