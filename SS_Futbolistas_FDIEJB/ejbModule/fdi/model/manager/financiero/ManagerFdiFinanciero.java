package fdi.model.manager.financiero;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fdi.model.entities.ModfinTipoEgreso;


/**
 * Session Bean implementation class ManagerFdiFinanciero
 */
@Stateless
@LocalBean
public class ManagerFdiFinanciero {
	@PersistenceContext(unitName="fdiDS")
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerFdiFinanciero() {
        // TODO Auto-generated constructor stub
    }
    
    public void agregartipoegreso(Integer codTipoEgreso, String nombre, String descripcion) throws Exception{   
    	if (nombre == null || nombre.length() == 0)
			throw new Exception("Debe especificar su nombre.");
    	ModfinTipoEgreso a=new ModfinTipoEgreso();  
    	a.setCodTipoEgreso(codTipoEgreso);;    
    	a.setNombre(nombre);       
    	a.setDescripcion(descripcion);
    	em.persist(a);    
    	}
    
    public ModfinTipoEgreso findModfinTipoEgreso(String nombre) throws Exception{
        
        ModfinTipoEgreso a=em.find(ModfinTipoEgreso.class, nombre);   
        return a;
    }
    
    
    public List<ModfinTipoEgreso> findAllModfinTipoEgreso(){    
    	Query q;     
    	List<ModfinTipoEgreso> listado;     
    	String sentenciaSQL;       
    	sentenciaSQL = "SELECT o FROM ModfinTipoEgreso o ORDER BY o.nombre";  
    	q = em.createQuery(sentenciaSQL);    
    	listado = q.getResultList();    
    	return listado;    
    	}
}