package fedim.controadmin;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import fedim.model.entities.DetallePagoUsuario;
import fedim.model.entities.Test;
import fedim.model.entities.Usuario;
import fedim.model.manager.ManagerAdmin;

@ManagedBean
@SessionScoped
public class beanUsuario {
	private List<Usuario> listaus;
	@EJB
	private ManagerAdmin manageradmin;

	private String codigoUsuario;
	private String apellidousuario;
	private String clave;
	private String nombresusuario;
	private String tipousuario;
	private String ucorreo;
	private String udireccion;
	private String ufechanac;
	private String ulugaNac;
	private String usexo;
	private String utelefono;


	public beanUsuario() {

	}

	public String actionInsertarUsuario() {
		Usuario p = new Usuario();
		p.setCodigoUsuario(codigoUsuario);;
		p.setNombresUsuario(nombresusuario);
		p.setApellidoUsuario(apellidousuario);
		p.setUsexo(usexo);
		p.setUlugaNac(ulugaNac);
		p.setUfechaNac(ufechanac);
		p.setUdireccion(udireccion);
		p.setUcorreo(ucorreo);
		p.setTipoUsuario(tipousuario);
		p.setUtelefono(utelefono);
		p.setClave(clave);

		try {
			manageradmin.insertarUsua(p);
			
			codigoUsuario="";
			nombresusuario="";
			apellidousuario="";
			usexo="";
			ulugaNac="";
			ufechanac="";
			udireccion="";
			ucorreo="";
			tipousuario="";
			utelefono="";
			clave="";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";

	}

	public String actionEliminarUsuario(Usuario dep) {
		try {
			manageradmin.eliminarUsuario(dep.getCodigoUsuario());
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public String actionCargarUsuario(Usuario dep) {
		codigoUsuario=dep.getCodigoUsuario();
		nombresusuario=dep.getNombresUsuario();
		apellidousuario=dep.getApellidoUsuario();
		usexo=dep.getUsexo();
		ulugaNac=dep.getUlugaNac();
		ufechanac=dep.getUfechaNac();
		udireccion=dep.getUdireccion();
		ucorreo=dep.getUcorreo();
		tipousuario=dep.getTipoUsuario();
		utelefono=dep.getUtelefono();
		clave=dep.getClave();


		return "usuario_update";
	}

	public String actionActualizarUsuario() {
		Usuario p = new Usuario();
		p.setCodigoUsuario(codigoUsuario);;
		p.setNombresUsuario(nombresusuario);
		p.setApellidoUsuario(apellidousuario);
		p.setUsexo(usexo);
		p.setUlugaNac(ulugaNac);
		p.setUfechaNac(ufechanac);
		p.setUdireccion(udireccion);
		p.setUcorreo(ucorreo);
		p.setTipoUsuario(tipousuario);
		p.setUtelefono(utelefono);
		p.setClave(clave);

		try {
			manageradmin.actualizarUsuario(p);
			// limpiamos las variables del formulario:
			codigoUsuario="";
			nombresusuario="";
			apellidousuario="";
			usexo="";
			ulugaNac="";
			ufechanac="";
			udireccion="";
			ucorreo="";
			tipousuario="";
			utelefono="";
			clave="";


		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "registrousuario";
	}

	public List<Usuario> getListaus() {
		listaus = manageradmin.findAllUsuario();
		return listaus;
	}



	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getApellidousuario() {
		return apellidousuario;
	}

	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombresusuario() {
		return nombresusuario;
	}

	public void setNombresusuario(String nombresusuario) {
		this.nombresusuario = nombresusuario;
	}

	public String getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

	public String getUcorreo() {
		return ucorreo;
	}

	public void setUcorreo(String ucorreo) {
		this.ucorreo = ucorreo;
	}

	public String getUdireccion() {
		return udireccion;
	}

	public void setUdireccion(String udireccion) {
		this.udireccion = udireccion;
	}

	public String getUfechanac() {
		return ufechanac;
	}

	public void setUfechanac(String ufechanac) {
		this.ufechanac = ufechanac;
	}

	public String getUlugaNac() {
		return ulugaNac;
	}

	public void setUlugaNac(String ulugaNac) {
		this.ulugaNac = ulugaNac;
	}

	public String getUsexo() {
		return usexo;
	}

	public void setUsexo(String usexo) {
		this.usexo = usexo;
	}

	public String getUtelefono() {
		return utelefono;
	}

	public void setUtelefono(String utelefono) {
		this.utelefono = utelefono;
	}



}
