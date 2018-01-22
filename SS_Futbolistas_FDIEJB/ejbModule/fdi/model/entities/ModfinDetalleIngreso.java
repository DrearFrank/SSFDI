package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the modfin_detalle_ingresos database table.
 * 
 */
@Entity
@Table(name="modfin_detalle_ingresos")
@NamedQuery(name="ModfinDetalleIngreso.findAll", query="SELECT m FROM ModfinDetalleIngreso m")
public class ModfinDetalleIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_deta_ingreso", unique=true, nullable=false, precision=131089)
	private long codDetaIngreso;

	@Column(length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="imes_ingreso")
	private Date imesIngreso;

	@Column(length=30)
	private String nombre;

	//bi-directional many-to-one association to ModadLugarEntrenamientoDepor
	@ManyToOne
	@JoinColumn(name="cod_lugar")
	private ModadLugarEntrenamientoDepor modadLugarEntrenamientoDepor;

	//bi-directional many-to-one association to ModfinIngreso
	@OneToMany(mappedBy="modfinDetalleIngreso")
	private List<ModfinIngreso> modfinIngresos;

	public ModfinDetalleIngreso() {
	}

	public long getCodDetaIngreso() {
		return this.codDetaIngreso;
	}

	public void setCodDetaIngreso(long codDetaIngreso) {
		this.codDetaIngreso = codDetaIngreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getImesIngreso() {
		return this.imesIngreso;
	}

	public void setImesIngreso(Date imesIngreso) {
		this.imesIngreso = imesIngreso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ModadLugarEntrenamientoDepor getModadLugarEntrenamientoDepor() {
		return this.modadLugarEntrenamientoDepor;
	}

	public void setModadLugarEntrenamientoDepor(ModadLugarEntrenamientoDepor modadLugarEntrenamientoDepor) {
		this.modadLugarEntrenamientoDepor = modadLugarEntrenamientoDepor;
	}

	public List<ModfinIngreso> getModfinIngresos() {
		return this.modfinIngresos;
	}

	public void setModfinIngresos(List<ModfinIngreso> modfinIngresos) {
		this.modfinIngresos = modfinIngresos;
	}

	public ModfinIngreso addModfinIngreso(ModfinIngreso modfinIngreso) {
		getModfinIngresos().add(modfinIngreso);
		modfinIngreso.setModfinDetalleIngreso(this);

		return modfinIngreso;
	}

	public ModfinIngreso removeModfinIngreso(ModfinIngreso modfinIngreso) {
		getModfinIngresos().remove(modfinIngreso);
		modfinIngreso.setModfinDetalleIngreso(null);

		return modfinIngreso;
	}

}