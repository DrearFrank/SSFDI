package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the moddep_test database table.
 * 
 */
@Entity
@Table(name="moddep_test")
@NamedQuery(name="ModdepTest.findAll", query="SELECT m FROM ModdepTest m")
public class ModdepTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_test")
	private long codTest;

	@Column(name="abdominales_min_test")
	private BigDecimal abdominalesMinTest;

	@Column(name="altura_test")
	private BigDecimal alturaTest;

	@Column(name="cardio_min_test")
	private BigDecimal cardioMinTest;

	@Column(name="fecha_test_test")
	private BigDecimal fechaTestTest;

	@Column(name="peso_test")
	private BigDecimal pesoTest;

	@Column(name="rendimiento_fisico_test")
	private BigDecimal rendimientoFisicoTest;

	@Column(name="velocidad_test")
	private BigDecimal velocidadTest;

	//bi-directional many-to-one association to ModdepPosicionDeportista
	@OneToMany(mappedBy="moddepTest")
	private List<ModdepPosicionDeportista> moddepPosicionDeportistas;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="moddepTest")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	public ModdepTest() {
	}

	public long getCodTest() {
		return this.codTest;
	}

	public void setCodTest(long codTest) {
		this.codTest = codTest;
	}

	public BigDecimal getAbdominalesMinTest() {
		return this.abdominalesMinTest;
	}

	public void setAbdominalesMinTest(BigDecimal abdominalesMinTest) {
		this.abdominalesMinTest = abdominalesMinTest;
	}

	public BigDecimal getAlturaTest() {
		return this.alturaTest;
	}

	public void setAlturaTest(BigDecimal alturaTest) {
		this.alturaTest = alturaTest;
	}

	public BigDecimal getCardioMinTest() {
		return this.cardioMinTest;
	}

	public void setCardioMinTest(BigDecimal cardioMinTest) {
		this.cardioMinTest = cardioMinTest;
	}

	public BigDecimal getFechaTestTest() {
		return this.fechaTestTest;
	}

	public void setFechaTestTest(BigDecimal fechaTestTest) {
		this.fechaTestTest = fechaTestTest;
	}

	public BigDecimal getPesoTest() {
		return this.pesoTest;
	}

	public void setPesoTest(BigDecimal pesoTest) {
		this.pesoTest = pesoTest;
	}

	public BigDecimal getRendimientoFisicoTest() {
		return this.rendimientoFisicoTest;
	}

	public void setRendimientoFisicoTest(BigDecimal rendimientoFisicoTest) {
		this.rendimientoFisicoTest = rendimientoFisicoTest;
	}

	public BigDecimal getVelocidadTest() {
		return this.velocidadTest;
	}

	public void setVelocidadTest(BigDecimal velocidadTest) {
		this.velocidadTest = velocidadTest;
	}

	public List<ModdepPosicionDeportista> getModdepPosicionDeportistas() {
		return this.moddepPosicionDeportistas;
	}

	public void setModdepPosicionDeportistas(List<ModdepPosicionDeportista> moddepPosicionDeportistas) {
		this.moddepPosicionDeportistas = moddepPosicionDeportistas;
	}

	public ModdepPosicionDeportista addModdepPosicionDeportista(ModdepPosicionDeportista moddepPosicionDeportista) {
		getModdepPosicionDeportistas().add(moddepPosicionDeportista);
		moddepPosicionDeportista.setModdepTest(this);

		return moddepPosicionDeportista;
	}

	public ModdepPosicionDeportista removeModdepPosicionDeportista(ModdepPosicionDeportista moddepPosicionDeportista) {
		getModdepPosicionDeportistas().remove(moddepPosicionDeportista);
		moddepPosicionDeportista.setModdepTest(null);

		return moddepPosicionDeportista;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepTest(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModdepTest(null);

		return moddepRegistroRendimiento;
	}

}