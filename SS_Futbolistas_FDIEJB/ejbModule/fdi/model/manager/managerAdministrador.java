package fdi.model.manager;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fdi.model.entities.ModadUsuario;
import fdi.model.entities.ModadUsuarioPK;
import fdi.model.entities.ModadUsuario;
import fdi.model.entities.ModadCategoria;
import fdi.model.entities.ModadRole;

/**
 * Session Bean implementation class managerAdministrador
 */
@Stateless
@LocalBean
public class managerAdministrador {
	@PersistenceContext(unitName = "fdiDS")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public managerAdministrador() {
        // TODO Auto-generated constructor stub
    }
 
    public void Agregar_deportista(String cedula, String nombre, String apellido, String sexo, String fechanacieminto,
    		String lugarnaciento, String direccion, String correo, String  numerotlf, String roles, String Contraseña) throws Exception {
    	if(cedula==null||cedula.length()==0)
    		throw new Exception("Debe especificar la marca.");
    		ModadUsuario a=new ModadUsuario();
    		ModadUsuarioPK b=new ModadUsuarioPK();
    		ModadRole r = new ModadRole();
    		b.setCedulaUs(cedula);
    		a.setNombresUs(nombre);
    		a.setApellidosUs(apellido);
    		a.setSexoUs(sexo);
    		a.setFechaNacUs(fechanacieminto);
    		a.setLugarNacUs(lugarnaciento);
    		a.setDireccionUs(direccion);
    		a.setCorreoElecUs(correo);
    		a.setTelefonoUs(numerotlf);
    		r.setNombreRoles(Character.toString(a.setModadRole(roles)));
    		
    		
    		
    		
    		
    }
}
