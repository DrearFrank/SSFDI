package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_lugar_entrenamiento_depor database table.
 * 
 */
@Entity
@Table(name="modad_lugar_entrenamiento_depor")
@NamedQuery(name="ModadLugarEntrenamientoDepor.findAll", query="SELECT m FROM ModadLugarEntrenamientoDepor m")
public class ModadLugarEntrenamientoDepor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_lugar", unique=true, nullable=false, precision=131089)
	private long codLugar;

	@Column(length=100)
	private String descripcion;

	@Column(length=100)
	private String direccion;

	@Column(length=20)
	private String nombre;

	//bi-directional many-to-one association to ModadHorario
	@OneToMany(mappedBy="modadLugarEntrenamientoDepor")
	private List<ModadHorario> modadHorarios;

	//bi-directional many-to-one association to ModfinDetalleIngreso
	@OneToMany(mappedBy="modadLugarEntrenamientoDepor")
	private List<ModfinDetalleIngreso> modfinDetalleIngresos;

	public ModadLugarEntrenamientoDepor() {
	}

	public long getCodLugar() {
		return this.codLugar;
	}

	public void setCodLugar(long codLugar) {
		this.codLugar = codLugar;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ModadHorario> getModadHorarios() {
		return this.modadHorarios;
	}

	public void setModadHorarios(List<ModadHorario> modadHorarios) {
		this.modadHorarios = modadHorarios;
	}

	public ModadHorario addModadHorario(ModadHorario modadHorario) {
		getModadHorarios().add(modadHorario);
		modadHorario.setModadLugarEntrenamientoDepor(this);

		return modadHorario;
	}

	public ModadHorario removeModadHorario(ModadHorario modadHorario) {
		getModadHorarios().remove(modadHorario);
		modadHorario.setModadLugarEntrenamientoDepor(null);

		return modadHorario;
	}

	public List<ModfinDetalleIngreso> getModfinDetalleIngresos() {
		return this.modfinDetalleIngresos;
	}

	public void setModfinDetalleIngresos(List<ModfinDetalleIngreso> modfinDetalleIngresos) {
		this.modfinDetalleIngresos = modfinDetalleIngresos;
	}

	public ModfinDetalleIngreso addModfinDetalleIngreso(ModfinDetalleIngreso modfinDetalleIngreso) {
		getModfinDetalleIngresos().add(modfinDetalleIngreso);
		modfinDetalleIngreso.setModadLugarEntrenamientoDepor(this);

		return modfinDetalleIngreso;
	}

	public ModfinDetalleIngreso removeModfinDetalleIngreso(ModfinDetalleIngreso modfinDetalleIngreso) {
		getModfinDetalleIngresos().remove(modfinDetalleIngreso);
		modfinDetalleIngreso.setModadLugarEntrenamientoDepor(null);

		return modfinDetalleIngreso;
	}

}