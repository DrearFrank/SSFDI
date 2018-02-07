package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the detalle_ingresos database table.
 * 
 */
@Entity
@Table(name="detalle_ingresos")
@NamedQuery(name="DetalleIngreso.findAll", query="SELECT d FROM DetalleIngreso d")
public class DetalleIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_deta_ingreso")
	private String codDetaIngreso;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="imes_ingreso")
	private Date imesIngreso;

	private String nombre;

	//bi-directional many-to-one association to LugarEntrenamientoDepor
	@ManyToOne
	@JoinColumn(name="cod_lugar")
	private LugarEntrenamientoDepor lugarEntrenamientoDepor;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="detalleIngreso")
	private List<Ingreso> ingresos;

	public DetalleIngreso() {
	}

	public String getCodDetaIngreso() {
		return this.codDetaIngreso;
	}

	public void setCodDetaIngreso(String codDetaIngreso) {
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

	public LugarEntrenamientoDepor getLugarEntrenamientoDepor() {
		return this.lugarEntrenamientoDepor;
	}

	public void setLugarEntrenamientoDepor(LugarEntrenamientoDepor lugarEntrenamientoDepor) {
		this.lugarEntrenamientoDepor = lugarEntrenamientoDepor;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setDetalleIngreso(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setDetalleIngreso(null);

		return ingreso;
	}

}