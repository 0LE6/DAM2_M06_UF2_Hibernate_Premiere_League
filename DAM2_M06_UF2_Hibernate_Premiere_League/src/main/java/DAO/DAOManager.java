package DAO;
import java.util.ArrayList;

import MODEL.Team;

public interface DAOManager extends AutoCloseable{

	public boolean AddTeam(Team oneTeam);
	public boolean DeleteTeam(String teamAbbr);
	public Team updateTeam(Team oneTeam);
	public Team getTeamByAbbr(String teamAbbr);
	public Team getTeamByName(String teamName);
	public ArrayList<Team> getAllTeams();
}