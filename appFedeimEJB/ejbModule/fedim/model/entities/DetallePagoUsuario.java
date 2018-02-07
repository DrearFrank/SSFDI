package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_pago_usuarios database table.
 * 
 */
@Entity
@Table(name="detalle_pago_usuarios")
@NamedQuery(name="DetallePagoUsuario.findAll", query="SELECT d FROM DetallePagoUsuario d")
public class DetallePagoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_detaller_usuario")
	private String codDetallerUsuario;

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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;

	public DetallePagoUsuario() {
	}

	public String getCodDetallerUsuario() {
		return this.codDetallerUsuario;
	}

	public void setCodDetallerUsuario(String codDetallerUsuario) {
		this.codDetallerUsuario = codDetallerUsuario;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}