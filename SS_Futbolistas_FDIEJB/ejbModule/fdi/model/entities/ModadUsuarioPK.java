package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the modad_usuario database table.
 * 
 */
@Embeddable
public class ModadUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cedula_us", unique=true, nullable=false, length=10)
	private String cedulaUs;

	@Column(name="contrasena_us", unique=true, nullable=false, length=50)
	private String contrasenaUs;

	public ModadUsuarioPK() {
	}
	public String getCedulaUs() {
		return this.cedulaUs;
	}
	public void setCedulaUs(String cedulaUs) {
		this.cedulaUs = cedulaUs;
	}
	public String getContrasenaUs() {
		return this.contrasenaUs;
	}
	public void setContrasenaUs(String contrasenaUs) {
		this.contrasenaUs = contrasenaUs;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ModadUsuarioPK)) {
			return false;
		}
		ModadUsuarioPK castOther = (ModadUsuarioPK)other;
		return 
			this.cedulaUs.equals(castOther.cedulaUs)
			&& this.contrasenaUs.equals(castOther.contrasenaUs);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cedulaUs.hashCode();
		hash = hash * prime + this.contrasenaUs.hashCode();
		
		return hash;
	}
}