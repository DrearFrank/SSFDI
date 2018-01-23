package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_categoria database table.
 * 
 */
@Entity
@Table(name="modad_categoria")
@NamedQuery(name="ModadCategoria.findAll", query="SELECT m FROM ModadCategoria m")
public class ModadCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_cate")
	private long codCate;

	@Column(name="descripcion_cate")
	private String descripcionCate;

	@Column(name="nombre_cate")
	private String nombreCate;

	//bi-directional many-to-one association to ModadDeportista
	@OneToMany(mappedBy="modadCategoria")
	private List<ModadDeportista> modadDeportistas;

	//bi-directional many-to-one association to ModadHorario
	@OneToMany(mappedBy="modadCategoria")
	private List<ModadHorario> modadHorarios;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="modadCategoria")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	public ModadCategoria() {
	}

	public long getCodCate() {
		return this.codCate;
	}

	public void setCodCate(long codCate) {
		this.codCate = codCate;
	}

	public String getDescripcionCate() {
		return this.descripcionCate;
	}

	public void setDescripcionCate(String descripcionCate) {
		this.descripcionCate = descripcionCate;
	}

	public String getNombreCate() {
		return this.nombreCate;
	}

	public void setNombreCate(String nombreCate) {
		this.nombreCate = nombreCate;
	}

	public List<ModadDeportista> getModadDeportistas() {
		return this.modadDeportistas;
	}

	public void setModadDeportistas(List<ModadDeportista> modadDeportistas) {
		this.modadDeportistas = modadDeportistas;
	}

	public ModadDeportista addModadDeportista(ModadDeportista modadDeportista) {
		getModadDeportistas().add(modadDeportista);
		modadDeportista.setModadCategoria(this);

		return modadDeportista;
	}

	public ModadDeportista removeModadDeportista(ModadDeportista modadDeportista) {
		getModadDeportistas().remove(modadDeportista);
		modadDeportista.setModadCategoria(null);

		return modadDeportista;
	}

	public List<ModadHorario> getModadHorarios() {
		return this.modadHorarios;
	}

	public void setModadHorarios(List<ModadHorario> modadHorarios) {
		this.modadHorarios = modadHorarios;
	}

	public ModadHorario addModadHorario(ModadHorario modadHorario) {
		getModadHorarios().add(modadHorario);
		modadHorario.setModadCategoria(this);

		return modadHorario;
	}

	public ModadHorario removeModadHorario(ModadHorario modadHorario) {
		getModadHorarios().remove(modadHorario);
		modadHorario.setModadCategoria(null);

		return modadHorario;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadCategoria(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadCategoria(null);

		return moddepRegistroRendimiento;
	}

}