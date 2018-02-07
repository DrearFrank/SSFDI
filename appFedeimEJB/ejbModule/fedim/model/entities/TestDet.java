package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the test_det database table.
 * 
 */
@Entity
@Table(name="test_det")
@NamedQuery(name="TestDet.findAll", query="SELECT t FROM TestDet t")
public class TestDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_test_det")
	private Integer numeroTestDet;

	private Integer cantidad;

	@Column(name="indice_valor_test")
	private BigDecimal indiceValorTest;

	//bi-directional many-to-one association to SeguimientodepCab
	@ManyToOne
	@JoinColumn(name="numero_segui")
	private SeguimientodepCab seguimientodepCab;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="codigo_test")
	private Test test;

	public TestDet() {
	}

	public Integer getNumeroTestDet() {
		return this.numeroTestDet;
	}

	public void setNumeroTestDet(Integer numeroTestDet) {
		this.numeroTestDet = numeroTestDet;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getIndiceValorTest() {
		return this.indiceValorTest;
	}

	public void setIndiceValorTest(BigDecimal indiceValorTest) {
		this.indiceValorTest = indiceValorTest;
	}

	public SeguimientodepCab getSeguimientodepCab() {
		return this.seguimientodepCab;
	}

	public void setSeguimientodepCab(SeguimientodepCab seguimientodepCab) {
		this.seguimientodepCab = seguimientodepCab;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}