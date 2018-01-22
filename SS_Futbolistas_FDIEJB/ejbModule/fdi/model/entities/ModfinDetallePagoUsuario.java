package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the modfin_detalle_pago_usuarios database table.
 * 
 */
@Entity
@Table(name="modfin_detalle_pago_usuarios")
@NamedQuery(name="ModfinDetallePagoUsuario.findAll", query="SELECT m FROM ModfinDetallePagoUsuario m")
public class ModfinDetallePagoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_detaller_egreso", unique=true, nullable=false, precision=131089)
	private long codDetallerEgreso;

	private Object descuentos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="mes_pago")
	private Date mesPago;

	@Column(length=100)
	private String observacion;

	@Column(name="pago_total")
	private double pagoTotal;

	//bi-directional many-to-one association to ModfinEgreso
	@ManyToOne
	@JoinColumn(name="cod_egresos")
	private ModfinEgreso modfinEgreso;

	public ModfinDetallePagoUsuario() {
	}

	public long getCodDetallerEgreso() {
		return this.codDetallerEgreso;
	}

	public void setCodDetallerEgreso(long codDetallerEgreso) {
		this.codDetallerEgreso = codDetallerEgreso;
	}

	public Object getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(Object descuentos) {
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

	public double getPagoTotal() {
		return this.pagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public ModfinEgreso getModfinEgreso() {
		return this.modfinEgreso;
	}

	public void setModfinEgreso(ModfinEgreso modfinEgreso) {
		this.modfinEgreso = modfinEgreso;
	}

}