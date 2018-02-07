package fedim.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_usuario")
	private String codigoUsuario;

	@Column(name="apellido_usuario")
	private String apellidoUsuario;

	private String clave;

	@Column(name="nombres_usuario")
	private String nombresUsuario;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

	private String ucorreo;

	private String udireccion;

	@Column(name="ufecha_nac")
	private String ufechaNac;

	@Column(name="uluga_nac")
	private String ulugaNac;

	private String usexo;

	private String utelefono;

	//bi-directional many-to-one association to DetallePagoUsuario
	@OneToMany(mappedBy="usuario")
	private List<DetallePagoUsuario> detallePagoUsuarios;

	public Usuario() {
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombresUsuario() {
		return this.nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUcorreo() {
		return this.ucorreo;
	}

	public void setUcorreo(String ucorreo) {
		this.ucorreo = ucorreo;
	}

	public String getUdireccion() {
		return this.udireccion;
	}

	public void setUdireccion(String udireccion) {
		this.udireccion = udireccion;
	}

	public String getUfechaNac() {
		return this.ufechaNac;
	}

	public void setUfechaNac(String ufechaNac) {
		this.ufechaNac = ufechaNac;
	}

	public String getUlugaNac() {
		return this.ulugaNac;
	}

	public void setUlugaNac(String ulugaNac) {
		this.ulugaNac = ulugaNac;
	}

	public String getUsexo() {
		return this.usexo;
	}

	public void setUsexo(String usexo) {
		this.usexo = usexo;
	}

	public String getUtelefono() {
		return this.utelefono;
	}

	public void setUtelefono(String utelefono) {
		this.utelefono = utelefono;
	}

	public List<DetallePagoUsuario> getDetallePagoUsuarios() {
		return this.detallePagoUsuarios;
	}

	public void setDetallePagoUsuarios(List<DetallePagoUsuario> detallePagoUsuarios) {
		this.detallePagoUsuarios = detallePagoUsuarios;
	}

	public DetallePagoUsuario addDetallePagoUsuario(DetallePagoUsuario detallePagoUsuario) {
		getDetallePagoUsuarios().add(detallePagoUsuario);
		detallePagoUsuario.setUsuario(this);

		return detallePagoUsuario;
	}

	public DetallePagoUsuario removeDetallePagoUsuario(DetallePagoUsuario detallePagoUsuario) {
		getDetallePagoUsuarios().remove(detallePagoUsuario);
		detallePagoUsuario.setUsuario(null);

		return detallePagoUsuario;
	}


	

}