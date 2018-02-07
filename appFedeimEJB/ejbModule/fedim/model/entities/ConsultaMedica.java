package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consulta_medica database table.
 * 
 */
@Entity
@Table(name="consulta_medica")
@NamedQuery(name="ConsultaMedica.findAll", query="SELECT c FROM ConsultaMedica c")
public class ConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_consulta")
	private String codConsulta;

	private String diagnostico;

	private String diasrepos;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_realiza_consulata")
	private Date fechaRealizaConsulata;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicutud_consula")
	private Date fechaSolicutudConsula;

	@Column(name="nota_medica")
	private String notaMedica;

	//bi-directional many-to-one association to Deportista
	@ManyToOne
	@JoinColumn(name="cedula_deportista")
	private Deportista deportista;

	public ConsultaMedica() {
	}

	public String getCodConsulta() {
		return this.codConsulta;
	}

	public void setCodConsulta(String codConsulta) {
		this.codConsulta = codConsulta;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getDiasrepos() {
		return this.diasrepos;
	}

	public void setDiasrepos(String diasrepos) {
		this.diasrepos = diasrepos;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRealizaConsulata() {
		return this.fechaRealizaConsulata;
	}

	public void setFechaRealizaConsulata(Date fechaRealizaConsulata) {
		this.fechaRealizaConsulata = fechaRealizaConsulata;
	}

	public Date getFechaSolicutudConsula() {
		return this.fechaSolicutudConsula;
	}

	public void setFechaSolicutudConsula(Date fechaSolicutudConsula) {
		this.fechaSolicutudConsula = fechaSolicutudConsula;
	}

	public String getNotaMedica() {
		return this.notaMedica;
	}

	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}

	public Deportista getDeportista() {
		return this.deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

}