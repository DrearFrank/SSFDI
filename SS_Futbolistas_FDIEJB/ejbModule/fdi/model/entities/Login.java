package fdi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_login")
	private long idLogin;

	//bi-directional many-to-one association to ModadDeportista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_us", referencedColumnName="cedula_dep"),
		@JoinColumn(name="contrasena_us", referencedColumnName="contrasena_dep")
		})
	private ModadDeportista modadDeportista;

	//bi-directional many-to-one association to ModadUsuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cedula_us", referencedColumnName="cedula_us"),
		@JoinColumn(name="contrasena_us", referencedColumnName="contrasena_us")
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