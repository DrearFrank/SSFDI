package fedim.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fedim.model.entities.Deportista;
import fedim.model.entities.DetallePagoUsuario;
import fedim.model.entities.LugarEntrenamientoDepor;
import fedim.model.entities.Usuario;
import sun.launcher.resources.launcher;

/**
 * Session Bean implementation class ManagerSeguimiento
 */
@Stateless
@LocalBean
public class ManagerAdmin {

	/**
	 * Default constructor.
	 */
	@EJB
	private ManagerDAO managerDAO;

	public ManagerAdmin() {
		// TODO Auto-generated constructor stub
	}

	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// ::::::MANEJO DE
	////////////////////////////////////////////////////////////////////////////////////// DEPORTISTAS:::::::://////////////////////////
	///////////////////// /////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public List<Deportista> findAllDeportista() {
		return managerDAO.findAll(Deportista.class, "o.nombres");
	}

	public Deportista findDeportitaById(final String cedula) throws Exception {
		Deportista deportista = null;
		try {
			deportista = (Deportista) managerDAO.findById(Deportista.class, cedula);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar deportista: " + e.getMessage());
		}
		return deportista;
	}

	// :instar deportista://
	public void insertarDeportista(String ceduladep, String nombres, String apellidos, String direccion,
			String categoria, String posision, boolean estado, String clave, String correoelec, String sexo,
			String lugarnac) throws Exception {
		Deportista c = new Deportista();
		c.setCedulaDeportista(ceduladep);
		c.setNombres(nombres);
		c.setApellidos(apellidos);
		c.setDireccion(direccion);
		c.setCategoria(categoria);
		c.setPosisionjug(posision);
		c.setEstadojug(estado);
		c.setClave(clave);
		c.setCorreoelec(correoelec);
		c.setSexo(sexo);
		c.setLugarnac(lugarnac);

		managerDAO.insertar(c);
	}

	public void insertarDepb(final Deportista p) throws Exception {
		managerDAO.insertar(p);
	}

	public void eliminarDeportista(final String ceduladep) throws Exception {
		managerDAO.eliminar(Deportista.class, ceduladep);
	}

	public void actualizarDeportista(final Deportista dep) throws Exception {
		Deportista p = null;
		try {
			// buscamos el test a modificar desde la bdd:
			p = findDeportitaById(dep.getCedulaDeportista());
			// actualizamos las propiedades:
			p.setNombres(dep.getNombres());
			p.setApellidos(dep.getApellidos());
			p.setDireccion(dep.getDireccion());
			p.setCategoria(dep.getCategoria());
			p.setPosisionjug(dep.getPosisionjug());
			p.setEstadojug(dep.getEstadojug());
			p.setCorreoelec(dep.getCorreoelec());
			p.setLugarnac(dep.getLugarnac());
			p.setCorreoelec(dep.getCorreoelec());
			p.setClave(dep.getClave());
			// actualizamos:
			managerDAO.actualizar(p);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// :::::::MANEJO DE USUARIOS
	////////////////////////////////////////////////////////////////////////////////////// :::::::://///////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuario() {
		return managerDAO.findAll(Usuario.class, "o.nombresUsuario");
	}

	public Usuario findUsuarioById(final String codigo_usuario) throws Exception {
		Usuario usuario = null;
		try {
			usuario = (Usuario) managerDAO.findById(Usuario.class, codigo_usuario);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar Usuario: " + e.getMessage());
		}
		return usuario;
	}

	// :instar usuario://
	public void insertarusuario(String codigoUsuario, String apellidoUsuario, String clave, String nombresUsuario,
			String tipoUsuario, String ucorreo, String udireccion, String ufechaNac, String ulugaNac, String usexo,
			String utelefono, boolean estado) throws Exception {
		final Usuario c = new Usuario();
		c.setCodigoUsuario(codigoUsuario);
		;
		c.setNombresUsuario(nombresUsuario);
		c.setApellidoUsuario(apellidoUsuario);
		c.setUsexo(usexo);
		c.setUlugaNac(ulugaNac);
		c.setUfechaNac(ufechaNac);
		c.setUdireccion(udireccion);
		c.setUcorreo(ucorreo);
		c.setTipoUsuario(tipoUsuario);
		c.setUtelefono(utelefono);
		c.setClave(clave);
		managerDAO.insertar(c);
	}

	public void insertarUsua(final Usuario p) throws Exception {
		managerDAO.insertar(p);
	}

	public void eliminarUsuario(final String codigoUsuario) throws Exception {
		managerDAO.eliminar(Usuario.class, codigoUsuario);
	}

	public void actualizarUsuario(final Usuario dep) throws Exception {
		Usuario p = null;
		try {
			// buscamos el test a modificar desde la bdd:
			p = findUsuarioById(dep.getCodigoUsuario());
			// actualizamos las propiedades:
			p.setNombresUsuario(dep.getNombresUsuario());
			p.setApellidoUsuario(dep.getApellidoUsuario());
			p.setUlugaNac(dep.getUlugaNac());
			p.setUfechaNac(dep.getUfechaNac());
			p.setUdireccion(dep.getUdireccion());
			p.setUcorreo(dep.getUcorreo());
			p.setTipoUsuario(dep.getTipoUsuario());
			p.setUtelefono(dep.getUtelefono());
			p.setClave(dep.getClave());
			// actualizamos:
			managerDAO.actualizar(p);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// ::::::MANEJO DE lugares  :::::::://////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////// /////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public List<LugarEntrenamientoDepor> findAllLugar() {
		return managerDAO.findAll(LugarEntrenamientoDepor.class, "o.nombre");
	}

	public LugarEntrenamientoDepor findLugarById(final String codigo) throws Exception {
		LugarEntrenamientoDepor lugarEntrenamientoDepor = null;
		try {
			lugarEntrenamientoDepor = (LugarEntrenamientoDepor) 
					managerDAO.findById(LugarEntrenamientoDepor.class, codigo);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar lugar: " + e.getMessage());
		}
		return lugarEntrenamientoDepor;
	}

	// :instar deportista://
	public void insertarLugar(String codLugar, String descripcion, String direccion, String nombre) throws Exception {
		LugarEntrenamientoDepor c = new LugarEntrenamientoDepor();
		c.setCodLugar(codLugar);
		c.setNombre(nombre);
		c.setDireccion(direccion);
		c.setDescripcion(descripcion);

		managerDAO.insertar(c);
	}

	public void insertarlug(final LugarEntrenamientoDepor p) throws Exception {
		managerDAO.insertar(p);
	}

	public void eliminarluagr(final String codLugar) throws Exception {
		managerDAO.eliminar(LugarEntrenamientoDepor.class, codLugar);
	}

	public void actualizarLugar(final LugarEntrenamientoDepor dep) throws Exception {
		LugarEntrenamientoDepor p = null;
		try {
			// buscamos el test a modificar desde la bdd:
			p = findLugarById(dep.getCodLugar());
			// actualizamos las propiedades:
			p.setNombre(dep.getNombre());
			p.setDireccion(dep.getDireccion());
			p.setDescripcion(dep.getDescripcion());
			
			// actualizamos:
			managerDAO.actualizar(p);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
