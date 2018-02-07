package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_pago_deportista database table.
 * 
 */
@Entity
@Table(name="detalle_pago_deportista")
@NamedQuery(name="DetallePagoDeportista.findAll", query="SELECT d FROM DetallePagoDeportista d")
public class DetallePagoDeportista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_detaller_deportista")
	private String codDetallerDeportista;

	@Column(name="codigo_usuario")
	private String codigoUsuario;

	private String descuentos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="mes_pago")
	private Date mesPago;

	private String observacion;

	@Column(name="pago_total")
	private String pagoTotal;

	//bi-directional many-to-one association to Deportista
	@ManyToOne
	@JoinColumn(name="cedula_deportista")
	private Deportista deportista;

	public DetallePagoDeportista() {
	}

	public String getCodDetallerDeportista() {
		return this.codDetallerDeportista;
	}

	public void setCodDetallerDeportista(String codDetallerDeportista) {
		this.codDetallerDeportista = codDetallerDeportista;
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getMesPago() {
		return this.mesPago;
	}

	public void setMesPago(Date mesPago) {
		this.mesPago = mesPago;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPagoTotal() {
		return this.pagoTotal;
	}

	public void setPagoTotal(String pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public Deportista getDeportista() {
		return this.deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

}