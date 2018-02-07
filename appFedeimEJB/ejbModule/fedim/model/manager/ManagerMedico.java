package fedim.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fedim.model.entities.ConsultaMedica;
import fedim.model.entities.Deportista;
import fedim.model.manager.ManagerDAO;

@Stateless
@LocalBean
public class ManagerMedico {
	@EJB
	private ManagerDAO managerDAO;
	@EJB
	private ManagerAdmin managerAdmin;
	public ManagerMedico() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> findAllModfinConsultaMedica(){
		return managerDAO.findAll(ConsultaMedica.class,"o.estado");
	}
	public ConsultaMedica findConsultaMedicaById(String codConsulta)throws Exception{
		return (ConsultaMedica) managerDAO.findById(ConsultaMedica.class, codConsulta);
	}
	public void insertarTipoConsultaMedica(ConsultaMedica p) throws Exception{
		//ModadDeportista d=findDeportista(cedulaDep);
		//p.setModadDeportista(d);
		managerDAO.insertar(p);
	}
	public void eliminarCitaMedica(String codConsulta) throws Exception{
		managerDAO.eliminar(ConsultaMedica.class,codConsulta );
	}
	public void actualizarCitaMedico(ConsultaMedica citaM)throws Exception{
		ConsultaMedica p = null;
		try {
			//buscamos el test a modificar desde la bdd:
			p=findConsultaMedicaById(citaM.getCodConsulta());
			//actualizamos las propiedades:
			p.setEstado(citaM.getEstado());
			p.setNotaMedica(citaM.getNotaMedica());
			p.setDiagnostico(citaM.getDiagnostico());
			p.setDiasrepos(citaM.getDiasrepos());
			p.setFechaSolicutudConsula(citaM.getFechaSolicutudConsula());
			p.setFechaRealizaConsulata(citaM.getFechaRealizaConsulata());
			managerDAO.actualizar(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
