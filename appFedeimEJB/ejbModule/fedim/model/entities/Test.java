package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_test")
	private Integer codigoTest;

	private String descripcion;

	@Column(name="indice_valor")
	private BigDecimal indiceValor;

	private String nombretest;

	//bi-directional many-to-one association to TestDet
	@OneToMany(mappedBy="test")
	private List<TestDet> testDets;

	public Test() {
	}

	public Integer getCodigoTest() {
		return this.codigoTest;
	}

	public void setCodigoTest(Integer codigoTest) {
		this.codigoTest = codigoTest;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getIndiceValor() {
		return this.indiceValor;
	}

	public void setIndiceValor(BigDecimal indiceValor) {
		this.indiceValor = indiceValor;
	}

	public String getNombretest() {
		return this.nombretest;
	}

	public void setNombretest(String nombretest) {
		this.nombretest = nombretest;
	}

	public List<TestDet> getTestDets() {
		return this.testDets;
	}

	public void setTestDets(List<TestDet> testDets) {
		this.testDets = testDets;
	}

	public TestDet addTestDet(TestDet testDet) {
		getTestDets().add(testDet);
		testDet.setTest(this);

		return testDet;
	}

	public TestDet removeTestDet(TestDet testDet) {
		getTestDets().remove(testDet);
		testDet.setTest(null);

		return testDet;
	}

}