package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the modfin_egresos database table.
 * 
 */
@Entity
@Table(name="modfin_egresos")
@NamedQuery(name="ModfinEgreso.findAll", query="SELECT m FROM ModfinEgreso m")
public class ModfinEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_egresos")
	private long codEgresos;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double valor;

	//bi-directional many-to-one association to ModfinDetallePagoUsuario
	@OneToMany(mappedBy="modfinEgreso")
	private List<ModfinDetallePagoUsuario> modfinDetallePagoUsuarios;

	//bi-directional many-to-one association to ModfinTipoEgreso
	@ManyToOne
	@JoinColumn(name="cod_tipo_egreso")
	private ModfinTipoEgreso modfinTipoEgreso;

	public ModfinEgreso() {
	}

	public long getCodEgresos() {
		return this.codEgresos;
	}

	public void setCodEgresos(long codEgresos) {
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

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<ModfinDetallePagoUsuario> getModfinDetallePagoUsuarios() {
		return this.modfinDetallePagoUsuarios;
	}

	public void setModfinDetallePagoUsuarios(List<ModfinDetallePagoUsuario> modfinDetallePagoUsuarios) {
		this.modfinDetallePagoUsuarios = modfinDetallePagoUsuarios;
	}

	public ModfinDetallePagoUsuario addModfinDetallePagoUsuario(ModfinDetallePagoUsuario modfinDetallePagoUsuario) {
		getModfinDetallePagoUsuarios().add(modfinDetallePagoUsuario);
		modfinDetallePagoUsuario.setModfinEgreso(this);

		return modfinDetallePagoUsuario;
	}

	public ModfinDetallePagoUsuario removeModfinDetallePagoUsuario(ModfinDetallePagoUsuario modfinDetallePagoUsuario) {
		getModfinDetallePagoUsuarios().remove(modfinDetallePagoUsuario);
		modfinDetallePagoUsuario.setModfinEgreso(null);

		return modfinDetallePagoUsuario;
	}

	public ModfinTipoEgreso getModfinTipoEgreso() {
		return this.modfinTipoEgreso;
	}

	public void setModfinTipoEgreso(ModfinTipoEgreso modfinTipoEgreso) {
		this.modfinTipoEgreso = modfinTipoEgreso;
	}

}