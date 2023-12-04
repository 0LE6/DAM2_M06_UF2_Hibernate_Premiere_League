package MODEL;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nations")
public class Nationality implements Serializable {

	private static final long serialVersionUID = 4L;
	 
	@Id
	@Column(name="abv")
	private String abv;

	@Column(name="description")
	private String description;

	public Nationality(String abv, String description) {
		super();
		this.abv = abv;
		this.description = description;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abv, description);
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nationality other = (Nationality) obj;
		return Objects.equals(abv, other.abv) && Objects.equals(description, other.description);
	}
	
	
}
