package fdi.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fdi.model.entities.ModadRole;



/**
 * Session Bean implementation class ManagerAdministrador
 */
@Stateless
@LocalBean
public class ManagerAdministrador {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="fdiDS")
	
	private EntityManager em;
    public ManagerAdministrador() {
        // TODO Auto-generated constructor stub
    }
    
    

    
    
  
    
    
    public ModadRole findRoleById(long codRol){
    	 ModadRole u=em.find( ModadRole.class, codRol);
    	 return u;
    	 }

    
    
	    public List<ModadRole> findAllRoles(){    
	    	Query q;     
	    	List< ModadRole> listado;     
	    	String sentenciaSQL;       
	    	sentenciaSQL = "SELECT o FROM  ModadRole o ORDER BY o.codRoles";  
	    	q = em.createQuery(sentenciaSQL);    
	    	listado = q.getResultList();    
	    	return listado;    }
	    
	    
	    
		public void eliminarRol(long codRoles) throws Exception {
			// buscamos el Usuario:
			 ModadRole a = findRoleById(codRoles);
			if (a == null  ) 
			
				throw new Exception("No existe el usuario.");
				// lo eliminamos:
			//else 
				//if((!(a == null)) && (a.getBlogs().contains(a))) {
					//throw new Exception("Existe el usuario pero contiene blog");
				//}
			//if((!(a == null))||a.getBlogs().contains(a))
				//throw new Exception("No se puede eliminar usuario contiene blogs.");
			//else
				//if((!(a == null)) &&(!a.getBlogs().contains(a))) {
			
					em.remove(a);
			
				//}
		
				}
		

			
			
    	 public void registrarNuevoRol(Long codRoles,String nombrerol,String descripcionrol) {
    	ModadRole u= new  ModadRole();

    	 u.setCodRoles(codRoles);
    	 u.setNombreRoles(nombrerol);
    	 u.setDescripcionRoles(descripcionrol);
    	 
    	 em.persist(u);
    	 }

   		

  

}
