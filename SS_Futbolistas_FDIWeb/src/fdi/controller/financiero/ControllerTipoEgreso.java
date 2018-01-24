package fdi.controller.financiero;

import java.awt.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fdi.view.util.JSFUtil;
import fdi.model.manager.financiero.*;
import fdi.model.entities.ModfinTipoEgreso;

@ManagedBean
@SessionScoped
public class ControllerTipoEgreso {
	
	private Integer codTipoEgreso;
	private String nombre;
	private List<ModfinTipoEgreso> lista;
	private String descripcion;
	
	
	public ControllerTipoEgreso() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private ManagerFdiFinanciero managerFdiFinanciero;
	
	@PostConstruct
	public void iniciar() {
		lista=managerFdiFinanciero.findAllModfinTipoEgreso(); 
	}
	
    public void actionListenerAgregar(){   
    	try {         
    
			managerFdiFinanciero.agregartipoegreso(codTipoEgreso, nombre, descripcion); 
    		lista=managerFdiFinanciero.findAllModfinTipoEgreso();  
    		JSFUtil.crearMensajeInfo("Tipo Egreso registrado.");  
    		} catch (Exception e) {         
    			JSFUtil.crearMensajeError(e.getMessage());   
    			e.printStackTrace();      
    			}
		
		codTipoEgreso=null;
    	nombre = "";
		descripcion = "";
		

	}
	
	
}
		
	
	