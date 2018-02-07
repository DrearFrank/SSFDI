package fedim.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.model.entities.ConsultaMedica;
import fedim.model.manager.ManagerMedico;

@ManagedBean
@SessionScoped
public class ControllerMedico {
private List<ConsultaMedica> listadoMe;
@EJB
private ManagerMedico managerMedico;

private String codConsulta;
private String diagnostico;
private String diasrepos;
private String estado;
private Date fechaRealizaConsulata;
private Date fechaSolicutudConsula;
private String notaMedica;
private String deportista;

public String getDeportista() {
	return deportista;
}

public void setDeportista(String deportista) {
	this.deportista = deportista;
}

public ControllerMedico() {
	
}

public String actionInsertarConsultaMedica() {
	ConsultaMedica p = new ConsultaMedica();
	p.setCodConsulta(codConsulta);
	//p.setDeportista(deportista);
	p.setDiagnostico(diagnostico);
	p.setDiasrepos(diasrepos);
	p.setEstado(estado);
	p.setFechaRealizaConsulata(fechaRealizaConsulata);
	p.setFechaSolicutudConsula(fechaSolicutudConsula);
	p.setNotaMedica(notaMedica);
	try {
		managerMedico.insertarConsultMedica(p);
		codConsulta="";
		diagnostico="";
		estado="";
		fechaSolicutudConsula =  new Date();
		fechaRealizaConsulata = new Date();
		notaMedica ="";
	}catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
}

//eleiminar mconsulta medica
public String actionEliminarCOnsultaMedica(ConsultaMedica con) {
	try {
		managerMedico.eliminarConsultaMedica(con.getCodConsulta());
	}catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
}
//Actualizar consulta medica

public String actionCargarConsultaMedica(ConsultaMedica con) {
	codConsulta=con.getCodConsulta();
	diagnostico=con.getDiagnostico();
	diasrepos=con.getDiasrepos();
	estado=con.getEstado();
	notaMedica = con.getNotaMedica();
	fechaSolicutudConsula=con.getFechaSolicutudConsula();
	fechaRealizaConsulata=con.getFechaRealizaConsulata();
	return "citaMedica_update";
}
public String acitionActulizarMedico() {
	ConsultaMedica p=new ConsultaMedica();
	p.setCodConsulta(codConsulta);
	//p.setDeportista(deportista);
	p.setDiagnostico(diagnostico);
	p.setDiasrepos(diasrepos);
	p.setEstado(estado);
	p.setFechaRealizaConsulata(fechaRealizaConsulata);
	p.setFechaSolicutudConsula(fechaSolicutudConsula);
	p.setNotaMedica(notaMedica);
	try {
		managerMedico.actualizarConsultaMedica(p);
		//limpiamos las variables del formulario
		codConsulta="";
		diagnostico="";
		diasrepos="";
		estado="";
		fechaRealizaConsulata= new Date();
		fechaSolicutudConsula= new Date();
		notaMedica="";
	}catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "index";
}


//modificar a que inserte en la base de datos
public List<ConsultaMedica> getListadoMe() {
	listadoMe=managerMedico.findAllMedico();
	return listadoMe;

}
public ManagerMedico getManagerMedico() {
	return managerMedico;
}
public void setManagerMedico(ManagerMedico managerMedico) {
	this.managerMedico = managerMedico;
}
public String getCodConsulta() {
	return codConsulta;
}
public void setCodConsulta(String codConsulta) {
	this.codConsulta = codConsulta;
}
public String getDiagnostico() {
	return diagnostico;
}
public void setDiagnostico(String diagnostico) {
	this.diagnostico = diagnostico;
}
public String getDiasrepos() {
	return diasrepos;
}
public void setDiasrepos(String diasrepos) {
	this.diasrepos = diasrepos;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public Date getFechaRealizaConsulata() {
	return fechaRealizaConsulata;
}
public void setFechaRealizaConsulata(Date fechaRealizaConsulata) {
	this.fechaRealizaConsulata = fechaRealizaConsulata;
}
public Date getFechaSolicutudConsula() {
	return fechaSolicutudConsula;
}
public void setFechaSolicutudConsula(Date fechaSolicutudConsula) {
	this.fechaSolicutudConsula = fechaSolicutudConsula;
}
public String getNotaMedica() {
	return notaMedica;
}
public void setNotaMedica(String notaMedica) {
	this.notaMedica = notaMedica;
}


}
