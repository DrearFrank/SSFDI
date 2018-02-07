package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_cate")
	private String nombreCate;

	@Column(name="descripcion_cate")
	private String descripcionCate;

	public Categoria() {
	}

	public String getNombreCate() {
		return this.nombreCate;
	}

	public void setNombreCate(String nombreCate) {
		this.nombreCate = nombreCate;
	}

	public String getDescripcionCate() {
		return this.descripcionCate;
	}

	public void setDescripcionCate(String descripcionCate) {
		this.descripcionCate = descripcionCate;
	}

}