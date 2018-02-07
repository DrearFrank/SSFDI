package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_egreso database table.
 * 
 */
@Entity
@Table(name="tipo_egreso")
@NamedQuery(name="TipoEgreso.findAll", query="SELECT t FROM TipoEgreso t")
public class TipoEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_tipo_egreso")
	private String codTipoEgreso;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Egreso
	@OneToMany(mappedBy="tipoEgreso")
	private List<Egreso> egresos;

	public TipoEgreso() {
	}

	public String getCodTipoEgreso() {
		return this.codTipoEgreso;
	}

	public void setCodTipoEgreso(String codTipoEgreso) {
		this.codTipoEgreso = codTipoEgreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public Egreso addEgreso(Egreso egreso) {
		getEgresos().add(egreso);
		egreso.setTipoEgreso(this);

		return egreso;
	}

	public Egreso removeEgreso(Egreso egreso) {
		getEgresos().remove(egreso);
		egreso.setTipoEgreso(null);

		return egreso;
	}

}