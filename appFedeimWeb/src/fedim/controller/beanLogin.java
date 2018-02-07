package fedim.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fedim.model.manager.ManagerLogin;
import fedim.controller.JSFUtil;


@ManagedBean
@SessionScoped
public class beanLogin {
	private String codigoUsuario;
	private String clave;
	private String tipoUsuario;
	private boolean acceso;
	@EJB
	private ManagerLogin managerLogin;

	public beanLogin() {
		managerLogin=new ManagerLogin();
	}
	/**
	 * Action que permite el acceso al sistema.
	 * @return
	 */
	public String accederSistema(){
		acceso=false;
		try {
			//verificamos el acceso del usuario:
			tipoUsuario=managerLogin.accederSistema(codigoUsuario, clave);
			//por seguridad borramos la clave en la sesion:
			clave="";
			//dependiendo del tipo de usuario, direccionamos:
			if(tipoUsuario.equals("AD")){
				acceso=true;
				return "administrador/index";
			}
			if(tipoUsuario.equals("EN")){
				acceso=true;
				return "entrenador/menu";
			}
			if(tipoUsuario.equals("ME")){
				acceso=true;
				return "medico/index";
			}
			if(tipoUsuario.equals("FI")){
				acceso=true;
				return "financiero/index";
			}
			//caso contrario, ocurrio un error con el tipo de usuario:
			JSFUtil.crearMensajeERROR("Error al acceder (tipo de usuario).");
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeERROR(e.getMessage());
		}
		return "";
	}
	
	/**
	 * Finaliza la sesion web del usuario.
	 * @return
	 */
	public String salirSistema(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/entrenador/menu.xhtml?faces-redirect=true";
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isAcceso() {
		return acceso;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
