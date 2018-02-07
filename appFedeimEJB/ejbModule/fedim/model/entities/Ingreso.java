package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ingreso database table.
 * 
 */
@Entity
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_ingresos")
	private String codIngresos;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String valor;

	//bi-directional many-to-one association to DetalleIngreso
	@ManyToOne
	@JoinColumn(name="cod_deta_ingreso")
	private DetalleIngreso detalleIngreso;

	public Ingreso() {
	}

	public String getCodIngresos() {
		return this.codIngresos;
	}

	public void setCodIngresos(String codIngresos) {
		this.codIngresos = codIngresos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public DetalleIngreso getDetalleIngreso() {
		return this.detalleIngreso;
	}

	public void setDetalleIngreso(DetalleIngreso detalleIngreso) {
		this.detalleIngreso = detalleIngreso;
	}

}