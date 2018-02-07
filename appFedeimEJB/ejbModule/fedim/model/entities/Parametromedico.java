package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametromedico database table.
 * 
 */
@Entity
@NamedQuery(name="Parametromedico.findAll", query="SELECT p FROM Parametromedico p")
public class Parametromedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_parametro")
	private String nombreParametro;

	@Column(name="valor_parametro")
	private String valorParametro;

	public Parametromedico() {
	}

	public String getNombreParametro() {
		return this.nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public String getValorParametro() {
		return this.valorParametro;
	}

	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}

}