package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modad_usuario database table.
 * 
 */
@Entity
@Table(name="modad_usuario")
@NamedQuery(name="ModadUsuario.findAll", query="SELECT m FROM ModadUsuario m")
public class ModadUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ModadUsuarioPK id;

	@Column(name="apellidos_us")
	private String apellidosUs;

	@Column(name="correo_elec_us")
	private String correoElecUs;

	@Column(name="direccion_us")
	private String direccionUs;

	@Column(name="fecha_nac_us")
	private String fechaNacUs;

	@Column(name="lugar_nac_us")
	private String lugarNacUs;

	@Column(name="nombres_us")
	private String nombresUs;

	@Column(name="sexo_us")
	private String sexoUs;

	@Column(name="telefono_us")
	private String telefonoUs;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="modadUsuario")
	private List<Login> logins;

	//bi-directional many-to-one association to ModadRole
	@ManyToOne
	@JoinColumn(name="cod_roles")
	private ModadRole modadRole;

	//bi-directional many-to-one association to ModdepRegistroRendimiento
	@OneToMany(mappedBy="modadUsuario")
	private List<ModdepRegistroRendimiento> moddepRegistroRendimientos;

	//bi-directional many-to-one association to ModmedConsultaMedica
	@OneToMany(mappedBy="modadUsuario")
	private List<ModmedConsultaMedica> modmedConsultaMedicas;

	public ModadUsuario() {
	}

	public ModadUsuarioPK getId() {
		return this.id;
	}

	public void setId(ModadUsuarioPK id) {
		this.id = id;
	}

	public String getApellidosUs() {
		return this.apellidosUs;
	}

	public void setApellidosUs(String apellidosUs) {
		this.apellidosUs = apellidosUs;
	}

	public String getCorreoElecUs() {
		return this.correoElecUs;
	}

	public void setCorreoElecUs(String correoElecUs) {
		this.correoElecUs = correoElecUs;
	}

	public String getDireccionUs() {
		return this.direccionUs;
	}

	public void setDireccionUs(String direccionUs) {
		this.direccionUs = direccionUs;
	}

	public String getFechaNacUs() {
		return this.fechaNacUs;
	}

	public void setFechaNacUs(String fechaNacUs) {
		this.fechaNacUs = fechaNacUs;
	}

	public String getLugarNacUs() {
		return this.lugarNacUs;
	}

	public void setLugarNacUs(String lugarNacUs) {
		this.lugarNacUs = lugarNacUs;
	}

	public String getNombresUs() {
		return this.nombresUs;
	}

	public void setNombresUs(String nombresUs) {
		this.nombresUs = nombresUs;
	}

	public String getSexoUs() {
		return this.sexoUs;
	}

	public void setSexoUs(String sexoUs) {
		this.sexoUs = sexoUs;
	}

	public String getTelefonoUs() {
		return this.telefonoUs;
	}

	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setModadUsuario(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setModadUsuario(null);

		return login;
	}

	public ModadRole getModadRole() {
		return this.modadRole;
	}

	public void setModadRole(ModadRole modadRole) {
		this.modadRole = modadRole;
	}

	public List<ModdepRegistroRendimiento> getModdepRegistroRendimientos() {
		return this.moddepRegistroRendimientos;
	}

	public void setModdepRegistroRendimientos(List<ModdepRegistroRendimiento> moddepRegistroRendimientos) {
		this.moddepRegistroRendimientos = moddepRegistroRendimientos;
	}

	public ModdepRegistroRendimiento addModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().add(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadUsuario(this);

		return moddepRegistroRendimiento;
	}

	public ModdepRegistroRendimiento removeModdepRegistroRendimiento(ModdepRegistroRendimiento moddepRegistroRendimiento) {
		getModdepRegistroRendimientos().remove(moddepRegistroRendimiento);
		moddepRegistroRendimiento.setModadUsuario(null);

		return moddepRegistroRendimiento;
	}

	public List<ModmedConsultaMedica> getModmedConsultaMedicas() {
		return this.modmedConsultaMedicas;
	}

	public void setModmedConsultaMedicas(List<ModmedConsultaMedica> modmedConsultaMedicas) {
		this.modmedConsultaMedicas = modmedConsultaMedicas;
	}

	public ModmedConsultaMedica addModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().add(modmedConsultaMedica);
		modmedConsultaMedica.setModadUsuario(this);

		return modmedConsultaMedica;
	}

	public ModmedConsultaMedica removeModmedConsultaMedica(ModmedConsultaMedica modmedConsultaMedica) {
		getModmedConsultaMedicas().remove(modmedConsultaMedica);
		modmedConsultaMedica.setModadUsuario(null);

		return modmedConsultaMedica;
	}

}