package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the modad_deportista database table.
 * 
 */
@Embeddable
public class ModadDeportistaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cedula_dep")
	private String cedulaDep;

	@Column(name="contrasena_dep")
	private String contrasenaDep;

	public ModadDeportistaPK() {
	}
	public String getCedulaDep() {
		return this.cedulaDep;
	}
	public void setCedulaDep(String cedulaDep) {
		this.cedulaDep = cedulaDep;
	}
	public String getContrasenaDep() {
		return this.contrasenaDep;
	}
	public void setContrasenaDep(String contrasenaDep) {
		this.contrasenaDep = contrasenaDep;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ModadDeportistaPK)) {
			return false;
		}
		ModadDeportistaPK castOther = (ModadDeportistaPK)other;
		return 
			this.cedulaDep.equals(castOther.cedulaDep)
			&& this.contrasenaDep.equals(castOther.contrasenaDep);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cedulaDep.hashCode();
		hash = hash * prime + this.contrasenaDep.hashCode();
		
		return hash;
	}
}