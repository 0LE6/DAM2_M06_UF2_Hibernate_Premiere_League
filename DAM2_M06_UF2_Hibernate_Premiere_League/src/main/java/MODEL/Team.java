package MODEL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	
    // Constructors
	public Team() { } /* Very important, if there's no one the update method breaks */
	
    public Team(String clubName, String abv, String hexCode, String logoLink) {
        this.clubName = clubName;
        this.abv = abv;
        this.hexCode = hexCode;
        this.logoLink = logoLink;
    }

    /* Getters & Setters */
	public static long getSerialversionuid() { return serialVersionUID;}
	
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
