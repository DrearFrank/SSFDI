package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name="login")
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_login", unique=true, nullable=false, precision=131089)
	private long idLogin;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_us", referencedColumnName="cedula_dep", nullable=false),
		@JoinColumn(name="contrasena_us", referencedColumnName="contrasena_dep", nullable=false)
		})
	private ModadDeportista modadDeportista;

	//bi-directional many-to-one association to ModadUsuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_us", referencedColumnName="cedula_us", nullable=false),
		@JoinColumn(name="contrasena_us", referencedColumnName="contrasena_us", nullable=false)
		})
	private ModadUsuario modadUsuario;

	public Login() {
	}

	public long getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}

	public ModadDeportista getModadDeportista() {
		return this.modadDeportista;
	}

	public void setModadDeportista(ModadDeportista modadDeportista) {
		this.modadDeportista = modadDeportista;
	}

	public ModadUsuario getModadUsuario() {
		return this.modadUsuario;
	}

	public void setModadUsuario(ModadUsuario modadUsuario) {
		this.modadUsuario = modadUsuario;
	}

}