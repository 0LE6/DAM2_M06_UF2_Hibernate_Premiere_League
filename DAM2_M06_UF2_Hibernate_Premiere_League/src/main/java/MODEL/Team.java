package MODEL;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="team")
@Entity /* Inform that needs to be manage w/ persistence */
public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="club_name")
    private String clubName;
	
	@Id
	@Column(name="abv")
    private String abv;
	
	@Column(name="hex_code")
    private String hexCode;
	
	@Column(name="logo_link")
    private String logoLink;
	
	/* NOTE : A3.3 - O2M */
	@OneToMany(targetEntity=Player.class, cascade=CascadeType.ALL)
	@JoinColumn(name="team_abv")
	private List<Player> players;
	

	// NOTE : 3 constructors
	public Team() { } /* Very important, if there's no one the update method breaks */
	
    public Team(String clubName, String abv, String hexCode, String logoLink) {
        this.clubName = clubName;
        this.abv = abv;
        this.hexCode = hexCode;
        this.logoLink = logoLink;
    }
    
    public Team(String clubName, String abv, 
    		String hexCode, String logoLink, List<Player> players) {
        this.clubName = clubName;
        this.abv = abv;
        this.hexCode = hexCode;
        this.logoLink = logoLink;
        this.players = players;
    }

    /* Getters & Setters */
	public static long getSerialversionuid() { return serialVersionUID;}
	

	/* NOTE : the specials for O2M */
    public List<Player> getPlayers() { return players; }
	public void setPlayers(List<Player> players) { this.players = players; }
	
	
	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getLogoLink() {
		return logoLink;
	}

	public void setLogoLink(String logoLink) {
		this.logoLink = logoLink;
	}
	
	// toString to show the information about the Team
    @Override
    public String toString() {
        return "Team{" +
                "clubName='" + clubName + '\'' +
                ", abv='" + abv + '\'' +
                ", hexCode='" + hexCode + '\'' +
                ", logoLink='" + logoLink + '\'' +
                '}';
    }
}
