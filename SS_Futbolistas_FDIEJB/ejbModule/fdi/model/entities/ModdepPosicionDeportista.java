package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the moddep_posicion_deportista database table.
 * 
 */
@Entity
@Table(name="moddep_posicion_deportista")
@NamedQuery(name="ModdepPosicionDeportista.findAll", query="SELECT m FROM ModdepPosicionDeportista m")
public class ModdepPosicionDeportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_posicion", unique=true, nullable=false, precision=131089)
	private long codPosicion;

	@Column(length=500)
	private String descripcion;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-one association to ModdepTest
	@ManyToOne
	@JoinColumn(name="cod_test")
	private ModdepTest moddepTest;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="moddepPosicionDeportista")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	public ModdepPosicionDeportista() {
	}

	public long getCodPosicion() {
		return this.codPosicion;
	}

	public void setCodPosicion(long codPosicion) {
		this.codPosicion = codPosicion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ModdepTest getModdepTest() {
		return this.moddepTest;
	}

	public void setModdepTest(ModdepTest moddepTest) {
		this.moddepTest = moddepTest;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepPosicionDeportista(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepPosicionDeportista(null);

		return moddepRegistroRendimiento;
	}

}