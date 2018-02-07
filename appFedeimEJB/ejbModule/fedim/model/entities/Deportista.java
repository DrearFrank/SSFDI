package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the deportista database table.
 * 
 */
@Entity
@NamedQuery(name="Deportista.findAll", query="SELECT d FROM Deportista d")
public class Deportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula_deportista")
	private String cedulaDeportista;

	private String apellidos;

	private String categoria;

	private String clave;

	private String correoelec;

	private String direccion;

	private Boolean estadojug;

	private String lugarnac;

	private String nombres;

	private String posisionjug;

	private String sexo;

	//bi-directional many-to-one association to ConsultaMedica
	@OneToMany(mappedBy="deportista")
	private List<ConsultaMedica> consultaMedicas;

	//bi-directional many-to-one association to DetallePagoDeportista
	@OneToMany(mappedBy="deportista")
	private List<DetallePagoDeportista> detallePagoDeportistas;

	//bi-directional many-to-one association to SeguimientodepCab
	@OneToMany(mappedBy="deportista")
	private List<SeguimientodepCab> seguimientodepCabs;

	public Deportista() {
	}

	public String getCedulaDeportista() {
		return this.cedulaDeportista;
	}

	public void setCedulaDeportista(String cedulaDeportista) {
		this.cedulaDeportista = cedulaDeportista;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreoelec() {
		return this.correoelec;
	}

	public void setCorreoelec(String correoelec) {
		this.correoelec = correoelec;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstadojug() {
		return this.estadojug;
	}

	public void setEstadojug(Boolean estadojug) {
		this.estadojug = estadojug;
	}

	public String getLugarnac() {
		return this.lugarnac;
	}

	public void setLugarnac(String lugarnac) {
		this.lugarnac = lugarnac;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPosisionjug() {
		return this.posisionjug;
	}

	public void setPosisionjug(String posisionjug) {
		this.posisionjug = posisionjug;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<ConsultaMedica> getConsultaMedicas() {
		return this.consultaMedicas;
	}

	public void setConsultaMedicas(List<ConsultaMedica> consultaMedicas) {
		this.consultaMedicas = consultaMedicas;
	}

	public ConsultaMedica addConsultaMedica(ConsultaMedica consultaMedica) {
		getConsultaMedicas().add(consultaMedica);
		consultaMedica.setDeportista(this);

		return consultaMedica;
	}

	public ConsultaMedica removeConsultaMedica(ConsultaMedica consultaMedica) {
		getConsultaMedicas().remove(consultaMedica);
		consultaMedica.setDeportista(null);

		return consultaMedica;
	}

	public List<DetallePagoDeportista> getDetallePagoDeportistas() {
		return this.detallePagoDeportistas;
	}

	public void setDetallePagoDeportistas(List<DetallePagoDeportista> detallePagoDeportistas) {
		this.detallePagoDeportistas = detallePagoDeportistas;
	}

	public DetallePagoDeportista addDetallePagoDeportista(DetallePagoDeportista detallePagoDeportista) {
		getDetallePagoDeportistas().add(detallePagoDeportista);
		detallePagoDeportista.setDeportista(this);

		return detallePagoDeportista;
	}

	public DetallePagoDeportista removeDetallePagoDeportista(DetallePagoDeportista detallePagoDeportista) {
		getDetallePagoDeportistas().remove(detallePagoDeportista);
		detallePagoDeportista.setDeportista(null);

		return detallePagoDeportista;
	}

	public List<SeguimientodepCab> getSeguimientodepCabs() {
		return this.seguimientodepCabs;
	}

	public void setSeguimientodepCabs(List<SeguimientodepCab> seguimientodepCabs) {
		this.seguimientodepCabs = seguimientodepCabs;
	}

	public SeguimientodepCab addSeguimientodepCab(SeguimientodepCab seguimientodepCab) {
		getSeguimientodepCabs().add(seguimientodepCab);
		seguimientodepCab.setDeportista(this);

		return seguimientodepCab;
	}

	public SeguimientodepCab removeSeguimientodepCab(SeguimientodepCab seguimientodepCab) {
		getSeguimientodepCabs().remove(seguimientodepCab);
		seguimientodepCab.setDeportista(null);

		return seguimientodepCab;
	}

}