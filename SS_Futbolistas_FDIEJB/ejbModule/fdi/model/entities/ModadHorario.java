package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modad_horarios database table.
 * 
 */
@Entity
@Table(name="modad_horarios")
@NamedQuery(name="ModadHorario.findAll", query="SELECT m FROM ModadHorario m")
public class ModadHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_horario", unique=true, nullable=false, precision=131089)
	private long codHorario;

	@Column(length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entre")
	private Date fechaEntre;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_entrenamiento")
	private Date horaEntrenamiento;

	//bi-directional many-to-one association to ModadCategoria
	@ManyToOne
	@JoinColumn(name="cod_cate")
	private ModadCategoria modadCategoria;

	//bi-directional many-to-one association to ModadLugarEntrenamientoDepor
	@ManyToOne
	@JoinColumn(name="cod_lugar")
	private ModadLugarEntrenamientoDepor modadLugarEntrenamientoDepor;

	public ModadHorario() {
	}

	public long getCodHorario() {
		return this.codHorario;
	}

	public void setCodHorario(long codHorario) {
		this.codHorario = codHorario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEntre() {
		return this.fechaEntre;
	}

	public void setFechaEntre(Date fechaEntre) {
		this.fechaEntre = fechaEntre;
	}

	public Date getHoraEntrenamiento() {
		return this.horaEntrenamiento;
	}

	public void setHoraEntrenamiento(Date horaEntrenamiento) {
		this.horaEntrenamiento = horaEntrenamiento;
	}

	public ModadCategoria getModadCategoria() {
		return this.modadCategoria;
	}

	public void setModadCategoria(ModadCategoria modadCategoria) {
		this.modadCategoria = modadCategoria;
	}

	public ModadLugarEntrenamientoDepor getModadLugarEntrenamientoDepor() {
		return this.modadLugarEntrenamientoDepor;
	}

	public void setModadLugarEntrenamientoDepor(ModadLugarEntrenamientoDepor modadLugarEntrenamientoDepor) {
		this.modadLugarEntrenamientoDepor = modadLugarEntrenamientoDepor;
	}

}