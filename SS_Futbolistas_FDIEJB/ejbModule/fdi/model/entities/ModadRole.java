package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_roles database table.
 * 
 */
@Entity
@Table(name="modad_roles")
@NamedQuery(name="ModadRole.findAll", query="SELECT m FROM ModadRole m")
public class ModadRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_roles", unique=true, nullable=false, precision=131089)
	private long codRoles;

	@Column(name="descripcion_roles", length=100)
	private String descripcionRoles;

	@Column(name="nombre_roles", length=20)
	private String nombreRoles;

	//bi-directional many-to-one association to ModadUsuario
	@OneToMany(mappedBy="modadRole")
	private List<ModadUsuario> modadUsuarios;

	public ModadRole() {
	}

	public long getCodRoles() {
		return this.codRoles;
	}

	public void setCodRoles(long codRoles) {
		this.codRoles = codRoles;
	}

	public String getDescripcionRoles() {
		return this.descripcionRoles;
	}

	public void setDescripcionRoles(String descripcionRoles) {
		this.descripcionRoles = descripcionRoles;
	}

	public String getNombreRoles() {
		return this.nombreRoles;
	}

	public void setNombreRoles(String nombreRoles) {
		this.nombreRoles = nombreRoles;
	}

	public List<ModadUsuario> getModadUsuarios() {
		return this.modadUsuarios;
	}

	public void setModadUsuarios(List<ModadUsuario> modadUsuarios) {
		this.modadUsuarios = modadUsuarios;
	}

	public ModadUsuario addModadUsuario(ModadUsuario modadUsuario) {
		getModadUsuarios().add(modadUsuario);
		modadUsuario.setModadRole(this);

		return modadUsuario;
	}

	public ModadUsuario removeModadUsuario(ModadUsuario modadUsuario) {
		getModadUsuarios().remove(modadUsuario);
		modadUsuario.setModadRole(null);

		return modadUsuario;
	}

}