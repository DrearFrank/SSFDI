package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the egresos database table.
 * 
 */
@Entity
@Table(name="egresos")
@NamedQuery(name="Egreso.findAll", query="SELECT e FROM Egreso e")
public class Egreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_egresos")
	private String codEgresos;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String valor;

	//bi-directional many-to-one association to TipoEgreso
	@ManyToOne
	@JoinColumn(name="cod_tipo_egreso")
	private TipoEgreso tipoEgreso;

	public Egreso() {
	}

	public String getCodEgresos() {
		return this.codEgresos;
	}

	public void setCodEgresos(String codEgresos) {
		this.codEgresos = codEgresos;
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

	public TipoEgreso getTipoEgreso() {
		return this.tipoEgreso;
	}

	public void setTipoEgreso(TipoEgreso tipoEgreso) {
		this.tipoEgreso = tipoEgreso;
	}

}