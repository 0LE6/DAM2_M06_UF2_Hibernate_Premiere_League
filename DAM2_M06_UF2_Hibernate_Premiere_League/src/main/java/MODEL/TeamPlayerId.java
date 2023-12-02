package MODEL;

import java.io.Serializable;
import java.util.Objects;

public class TeamPlayerId implements Serializable{

	private static final long serialVersionUID = 2L;
	
	private String teamAbv;
	private int playerId;
	
	public TeamPlayerId() { }

	@Override
	public int hashCode() {
		return Objects.hash(playerId, teamAbv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamPlayerId other = (TeamPlayerId) obj;
		return playerId == other.playerId && Objects.equals(teamAbv, other.teamAbv);
	}
	
	
	
}
