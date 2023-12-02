package MODEL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="player")
@IdClass(TeamPlayerId.class)
public class Player implements Serializable {

	private static final long serialVersionUID = 3L;
	
	@Id
	@Column(name="team_abv")
	private String teamAbv;
	
	@Id
	@Column(name="player_id")
	private int playerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="height")
	private int height;
	
	@Column(name="position")
	private String position;
	
	
	public Player() { }

	public Player(String teamAbv, int playerId, String name, int height, String position) {
		super();
		this.teamAbv = teamAbv;
		this.playerId = playerId;
		this.name = name;
		this.height = height;
		this.position = position;
	}

	public String getTeamAbv() {
		return teamAbv;
	}

	public void setTeamAbv(String teamAbv) {
		this.teamAbv = teamAbv;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [teamAbv=" + teamAbv + ", playerId=" + playerId + ", name=" + name + ", height=" + height
				+ ", position=" + position + "]";
	}
	
	
	
	
	
}
