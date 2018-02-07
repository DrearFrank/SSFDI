package fedim.controadmin;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.model.entities.Deportista;
import fedim.model.entities.Test;
import fedim.model.manager.ManagerAdmin;

@ManagedBean
@SessionScoped
public class beanDeportista {
	private List<Deportista> listadep;
	@EJB
	private ManagerAdmin manageradmin;

	private String ceduladeportista;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String categoria;
	private String posisionjugador;
	private String clave;
	private Boolean estado;
	private String correoelec;
	private String sexo;
	private String Lugarnac;

	public beanDeportista() {

	}

	public String actionInsertarDeportista() {
		Deportista p = new Deportista();
		p.setCedulaDeportista(ceduladeportista);
		p.setNombres(nombres);
		p.setApellidos(apellidos);
		p.setLugarnac(Lugarnac);
		p.setSexo(sexo);
		p.setDireccion(direccion);
		p.setCorreoelec(correoelec);
		p.setCategoria(categoria);
		p.setPosisionjug(posisionjugador);

		try {
			manageradmin.insertarDepb(p);
			;
			ceduladeportista = "";
			nombres = "";
			apellidos = "";
			direccion = "";
			categoria = "";
			posisionjugador = "";
			estado = true;
			clave = "";
			correoelec = "";
			sexo = "";
			Lugarnac = "";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";

	}

	public String actionEliminarDeportista(Deportista dep) {
		try {
			manageradmin.eliminarDeportista(dep.getCedulaDeportista());
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public String actionCargarDeportista(Deportista dep) {
		ceduladeportista = dep.getCedulaDeportista();
		nombres = dep.getNombres();
		apellidos = dep.getApellidos();
		direccion = dep.getDireccion();
		categoria = dep.getCategoria();
		posisionjugador = dep.getPosisionjug();
		estado = dep.getEstadojug();
		correoelec = dep.getCorreoelec();
		clave = dep.getClave();

		return "jugador_update";
	}

	public String actionActualizarDeportista() {
		Deportista p = new Deportista();
		p.setCedulaDeportista(ceduladeportista);

		p.setNombres(nombres);
		p.setApellidos(apellidos);
		p.setDireccion(direccion);
		p.setCategoria(categoria);
		p.setPosisionjug(posisionjugador);
		p.setCorreoelec(correoelec);
		p.setClave(clave);
		try {
			manageradmin.actualizarDeportista(p);
			// limpiamos las variables del formulario:
			ceduladeportista = "";
			nombres = "";
			apellidos = "";
			direccion = "";
			categoria = "";
			posisionjugador = "";
			estado = true;
			clave = "";
			correoelec = "";

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "registrojugador";
	}

	public String getCorreoelec() {
		return correoelec;
	}

	public void setCorreoelec(String correoelec) {
		this.correoelec = correoelec;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLugarnac() {
		return Lugarnac;
	}

	public void setLugarnac(String lugarnac) {
		Lugarnac = lugarnac;
	}

	public List<Deportista> getListadep() {
		listadep = manageradmin.findAllDeportista();
		return listadep;
	}

	public String getCeduladeportista() {
		return ceduladeportista;
	}

	public void setCeduladeportista(String ceduladeportista) {
		this.ceduladeportista = ceduladeportista;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPosisionjugador() {
		return posisionjugador;
	}

	public void setPosisionjugador(String posisionjugador) {
		this.posisionjugador = posisionjugador;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
