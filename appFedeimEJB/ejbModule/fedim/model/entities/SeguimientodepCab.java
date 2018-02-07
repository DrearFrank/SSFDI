package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the seguimientodep_cab database table.
 * 
 */
@Entity
@Table(name="seguimientodep_cab")
@NamedQuery(name="SeguimientodepCab.findAll", query="SELECT s FROM SeguimientodepCab s")
public class SeguimientodepCab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_segui")
	private String numeroSegui;

	@Column(name="base_cero")
	private BigDecimal baseCero;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_emision")
	private Date fechaEmision;

	private BigDecimal subtotalporcentaje;

	private BigDecimal totalporcentaje;

	//bi-directional many-to-one association to Deportista
	@ManyToOne
	@JoinColumn(name="cedula_deportista")
	private Deportista deportista;

	//bi-directional many-to-one association to TestDet
	@OneToMany(mappedBy="seguimientodepCab")
	private List<TestDet> testDets;

	public SeguimientodepCab() {
	}

	public String getNumeroSegui() {
		return this.numeroSegui;
	}

	public void setNumeroSegui(String numeroSegui) {
		this.numeroSegui = numeroSegui;
	}

	public BigDecimal getBaseCero() {
		return this.baseCero;
	}

	public void setBaseCero(BigDecimal baseCero) {
		this.baseCero = baseCero;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public BigDecimal getSubtotalporcentaje() {
		return this.subtotalporcentaje;
	}

	public void setSubtotalporcentaje(BigDecimal subtotalporcentaje) {
		this.subtotalporcentaje = subtotalporcentaje;
	}

	public BigDecimal getTotalporcentaje() {
		return this.totalporcentaje;
	}

	public void setTotalporcentaje(BigDecimal totalporcentaje) {
		this.totalporcentaje = totalporcentaje;
	}

	public Deportista getDeportista() {
		return this.deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

	public List<TestDet> getTestDets() {
		return this.testDets;
	}

	public void setTestDets(List<TestDet> testDets) {
		this.testDets = testDets;
	}

	public TestDet addTestDet(TestDet testDet) {
		getTestDets().add(testDet);
		testDet.setSeguimientodepCab(this);

		return testDet;
	}

	public TestDet removeTestDet(TestDet testDet) {
		getTestDets().remove(testDet);
		testDet.setSeguimientodepCab(null);

		return testDet;
	}

}