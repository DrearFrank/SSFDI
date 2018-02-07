package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lugar_entrenamiento_depor database table.
 * 
 */
@Entity
@Table(name="lugar_entrenamiento_depor")
@NamedQuery(name="LugarEntrenamientoDepor.findAll", query="SELECT l FROM LugarEntrenamientoDepor l")
public class LugarEntrenamientoDepor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_lugar")
	private String codLugar;

	private String descripcion;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to DetalleIngreso
	@OneToMany(mappedBy="lugarEntrenamientoDepor")
	private List<DetalleIngreso> detalleIngresos;

	public LugarEntrenamientoDepor() {
	}

	public String getCodLugar() {
		return this.codLugar;
	}

	public void setCodLugar(String codLugar) {
		this.codLugar = codLugar;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetalleIngreso> getDetalleIngresos() {
		return this.detalleIngresos;
	}

	public void setDetalleIngresos(List<DetalleIngreso> detalleIngresos) {
		this.detalleIngresos = detalleIngresos;
	}

	public DetalleIngreso addDetalleIngreso(DetalleIngreso detalleIngreso) {
		getDetalleIngresos().add(detalleIngreso);
		detalleIngreso.setLugarEntrenamientoDepor(this);

		return detalleIngreso;
	}

	public DetalleIngreso removeDetalleIngreso(DetalleIngreso detalleIngreso) {
		getDetalleIngresos().remove(detalleIngreso);
		detalleIngreso.setLugarEntrenamientoDepor(null);

		return detalleIngreso;
	}

}