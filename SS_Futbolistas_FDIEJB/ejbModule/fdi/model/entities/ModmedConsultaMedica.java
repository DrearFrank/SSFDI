package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modmed_consulta_medica database table.
 * 
 */
@Entity
@Table(name="modmed_consulta_medica")
@NamedQuery(name="ModmedConsultaMedica.findAll", query="SELECT m FROM ModmedConsultaMedica m")
public class ModmedConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_consulta", unique=true, nullable=false, precision=10)
	private long codConsulta;

	@Column(length=500)
	private String diagnostico;

	@Column(length=5)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_consulata")
	private Date fechaConsulata;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicutud")
	private Date fechaSolicutud;

	@Column(name="nota_medica", length=500)
	private String notaMedica;

	@Column(length=2)
	private String resposp;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_dep", referencedColumnName="cedula_dep"),
		@JoinColumn(name="contrasena_dep", referencedColumnName="contrasena_dep")
		})
	private ModadDeportista modadDeportista;

	//bi-directional many-to-one association to ModadUsuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_us", referencedColumnName="cedula_us"),
		@JoinColumn(name="contrasena_us", referencedColumnName="contrasena_us")
		})
	private ModadUsuario modadUsuario;

	public ModmedConsultaMedica() {
	}

	public long getCodConsulta() {
		return this.codConsulta;
	}

	public void setCodConsulta(long codConsulta) {
		this.codConsulta = codConsulta;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaConsulata() {
		return this.fechaConsulata;
	}

	public void setFechaConsulata(Date fechaConsulata) {
		this.fechaConsulata = fechaConsulata;
	}

	public Date getFechaSolicutud() {
		return this.fechaSolicutud;
	}

	public void setFechaSolicutud(Date fechaSolicutud) {
		this.fechaSolicutud = fechaSolicutud;
	}

	public String getNotaMedica() {
		return this.notaMedica;
	}

	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}

	public String getResposp() {
		return this.resposp;
	}

	public void setResposp(String resposp) {
		this.resposp = resposp;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

	public ModadUsuario getModadUsuario() {
		return this.modadUsuario;
	}

	public void setModadUsuario(ModadUsuario modadUsuario) {
		this.modadUsuario = modadUsuario;
	}

}