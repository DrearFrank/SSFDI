package fedim.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fedim.model.entities.ConsultaMedica;

@Stateless
@LocalBean
public class ManagerMedico {

	@EJB
	private ManagerDAO managerDAO;
	public ManagerMedico() {
		
	}
	
	///Manejo Medico
	@SuppressWarnings("unchecked")
	public List<ConsultaMedica>findAllMedico(){
		return managerDAO.findAll(ConsultaMedica.class, "o.estado");
	}
	public ConsultaMedica findTestById(String codConsulta)throws Exception{
		return (ConsultaMedica) managerDAO.findById(ConsultaMedica.class, codConsulta);
	}
	//insertar Consulta medica
	public void insertarConsultMedica(ConsultaMedica p) throws Exception{
		managerDAO.insertar(p);
	}
	//ELEIMINAR CONSULTA MEDICA
	public void eliminarConsultaMedica(String codConsulta) throws Exception{
		managerDAO.eliminar(ConsultaMedica.class, codConsulta);
	}
	//ACTUALIZAR CONSULTA MEDICA
	public void actualizarConsultaMedica(ConsultaMedica consulta )throws Exception{
		ConsultaMedica p=null;
		try {
			//buscamos la consulta a modificar desd la bdd
			p=findTestById(consulta.getCodConsulta());
			//actualizamos las propiedades
			p.setDeportista(consulta.getDeportista());
			p.setDiagnostico(consulta.getDiagnostico());
			p.setDiasrepos(consulta.getDiasrepos());
			p.setEstado(consulta.getEstado());
			p.setFechaSolicutudConsula(consulta.getFechaSolicutudConsula());
			p.setFechaRealizaConsulata(consulta.getFechaRealizaConsulata());
			p.setNotaMedica(consulta.getNotaMedica());
			//actualizamos
			managerDAO.actualizar(p);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
