package fedim.model.manager;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Date;
import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;


import fedim.model.entities.SeguimientodepCab;
import fedim.model.entities.TestDet;

import fedim.model.entities.Deportista;
import fedim.model.entities.Parametro;
import fedim.model.entities.Test;
import fedim.model.entities.*;
import fedim.model.manager.ManagerDAO;
/**
 * Session Bean implementation class ManagerSeguimiento
 */
@Stateless
@LocalBean
public class ManagerSeguimiento {

    /**
     * Default constructor. 
     */
	@EJB
	private ManagerDAO managerDAO;
    public ManagerSeguimiento() {
        // TODO Auto-generated constructor stub
    }
    
    
	//MANEJO DE TEST:
	
	@SuppressWarnings("unchecked")
	public List<Test> findAllTest(){
		return managerDAO.findAll(Test.class, "o.nombretest");
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	public Test findTestById(Integer codigotest) throws Exception{
		return (Test) managerDAO.findById(Test.class, codigotest);
	}
	
	public void insertarTest(Test p) throws Exception{
		managerDAO.insertar(p);
	}
	public void eliminarTest(Integer codigoTest) throws Exception{
		managerDAO.eliminar(Test.class, codigoTest);
	}
	
	public void actualizarTest(Test test) throws Exception{
		Test p=null;
		try {
			//buscamos el test a modificar desde la bdd:
			p=findTestById(test.getCodigoTest());
			//actualizamos las propiedades:
			p.setNombretest(test.getNombretest());
			p.setDescripcion(test.getDescripcion()); 
			p.setIndiceValor(test.getIndiceValor());
			//actualizamos:
			managerDAO.actualizar(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	//Manejor del parametro para contrar el numero de segumiento
	@SuppressWarnings("unchecked")
	public List<Parametro> findAllParametros(){
		return managerDAO.findAll(Parametro.class);
	}
///:....///
	private int getContSeguimiento() throws Exception{
		int contFacturas=0;
		Parametro parametro=null;
		try {
			parametro=(Parametro)managerDAO.findById(Parametro.class, "cont_segui");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Revise el parametro 'cont_segui': "+e.getMessage());
		}
		contFacturas=Integer.parseInt(parametro.getValorParametro());
		return contFacturas;
	}
	
	//:.://
	private int getContSeguimietoDet() throws Exception{
		int contseguiDet=0;
		Parametro parametro=null;
		try {
			parametro=(Parametro)managerDAO.findById(Parametro.class, "cont_segui_det");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Revise el parametro 'cont_segui_det': "+e.getMessage());
		}
		contseguiDet=Integer.parseInt(parametro.getValorParametro());
		return contseguiDet;
	}
	
	
	private void actualizarContSeguimiento(int nuevoContadorSeguimiento) throws Exception{
		Parametro parametro=null;
		try {
			parametro=(Parametro)managerDAO.findById(Parametro.class, "cont_segui");
			parametro.setValorParametro(Integer.toString(nuevoContadorSeguimiento));
			managerDAO.actualizar(parametro);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al actualizar el parametro 'cont_segui': "+e.getMessage());
		}
	}
	
	/**
	 * Actualiza el contador del detalle de facturas.
	 * @param nuevoContadorFacturasDet nuevo valor del contador.
	 * @throws Exception
	 */
	private void actualizarContSeguiminetoDet(int nuevoContadorSeguimeintoDet) throws Exception{
		Parametro parametro=null;
		try {
			parametro=(Parametro)managerDAO.findById(Parametro.class, "cont_segui_det");
			parametro.setValorParametro(Integer.toString(nuevoContadorSeguimeintoDet));
			managerDAO.actualizar(parametro);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al actualizar el parametro 'cont_seguis_det': "+e.getMessage());
		}
	}
	
	
	/////:::::::MANEJO DE DEPORTISTAS::::::::////////////
	
	@SuppressWarnings("unchecked")
	public List<Deportista> findAllDeportista(){
		return managerDAO.findAll(Deportista.class, "o.nombres");
	}
	
	
	
	public Deportista findDeportitaById(String cedula) throws Exception{
		Deportista deportista=null;
		try {
			deportista=(Deportista)managerDAO.findById(Deportista.class, cedula);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar deportista: "+e.getMessage());
		}
		return deportista;
	}
	
	//:instar deportista://
	public void insertarDeportista(String ceduladep,String nombres,
			String apellidos,String direccion,String categoria,String posision,boolean estado, String clave) throws Exception{
		Deportista c=new Deportista();
		c.setCedulaDeportista(ceduladep);
		c.setNombres(nombres);
		c.setApellidos(apellidos);
		c.setDireccion(direccion);
		c.setCategoria(categoria);
		c.setPosisionjug(posision);
		c.setEstadojug(estado);
		c.setClave(clave);
		managerDAO.insertar(c);
	}
	
	
	
	
	public void insertarDepb(Deportista p) throws Exception{
		managerDAO.insertar(p);
	}
	public void eliminarDeportista(String ceduladep) throws Exception{
		managerDAO.eliminar(Deportista.class,ceduladep );
	}
	
	public void actualizarDeportista(Deportista dep) throws Exception{
		Deportista p=null;
		try {
			//buscamos el test a modificar desde la bdd:
			p=findDeportitaById(dep.getCedulaDeportista());
			//actualizamos las propiedades:
			p.setNombres(dep.getNombres()); 
			p.setApellidos(dep.getApellidos()); 
			p.setDireccion(dep.getDireccion()); 
			p.setCategoria(dep.getCategoria());
			p.setPosisionjug(dep.getPosisionjug());
			p.setEstadojug(dep.getEstadojug());
			
			
			//actualizamos:
			managerDAO.actualizar(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	//MANEJO SEGIIMIENTO JUGADOR MAEDTRO DETALLE
	
	@SuppressWarnings("unchecked")
	public List<SeguimientodepCab> findAllSeguimientoCab(){
		List<SeguimientodepCab> listado= managerDAO.findAll(SeguimientodepCab.class, "o.fechaEmision desc,o.numeroSegui desc");
		//recorremos las facturas cabecera para extraer los datos de los detalles:
		for(SeguimientodepCab sc:listado){
			for(TestDet td:sc.getTestDets()){
				td.getCantidad();
			}
		}
		return listado;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<SeguimientodepCab> findSegimientoCabByFechas(Date fechaInicio,Date fechaFinal) throws Exception{
		List<SeguimientodepCab> listado=null;
		if(fechaInicio==null||fechaFinal==null)
			return findAllSeguimientoCab();
		try{
			//Debido a que son insuficientes los metodos genericos de ManagerDAO,
			//creamos un nuevo Query:
			EntityManager em=managerDAO.getEntityManager();
			String sql="SELECT p FROM SeguimientodepCab p WHERE p.fechaEmision between :fechaInicio and :fechaFinal order by p.numeroSegui asc";
			Query query=em.createQuery(sql);
			//pasamos los parametros a la consulta:
			query.setParameter("fechaInicio",fechaInicio,TemporalType.DATE);
			query.setParameter("fechaFinal",fechaFinal,TemporalType.DATE);
			//ejecutamos la consulta:
			listado=query.getResultList();
			//recorremos los pedidos para extraer los datos de los detalles:
			for(SeguimientodepCab pc:listado){
				for(TestDet pd:pc.getTestDets()){
					pd.getCantidad();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return listado;
	}
	
	
	
	
	
	
	
	
	/**
	 * Crea una nueva cabecera de factura temporal, para que desde el programa
	 * cliente pueda manipularla y llenarle con la informacion respectiva.
	 * Esta informacion solo se mantiene en memoria.
	 * @return la nueva factura temporal.
	 */
	public SeguimientodepCab crearSeguimientoTmp(){
		SeguimientodepCab seguiCabTmp=new SeguimientodepCab();
		seguiCabTmp.setFechaEmision(new Date());
		seguiCabTmp.setTestDets(new  ArrayList<TestDet>());
		return seguiCabTmp;
	}
	
	/**
	 * Asigna un cliente a una factura temporal.
	 * @param facturaCabTmp Factura temporal creada en memoria.
	 * @param cedulaCliente codigo del cliente.
	 * @throws Exception
	 */
	public void asignarDeportistaSeguimientoTmp(SeguimientodepCab seguiCabTmp,String cedulaDeportista) throws Exception{
		
		Deportista deportista=null;
		if(cedulaDeportista==null||cedulaDeportista.length()==0)
			throw new Exception("Error debe especificar la cedula del Deportista.");
		try {
			deportista=findDeportitaById(cedulaDeportista);
			if(deportista==null)
				throw new Exception("Error al asignar deportista.");
			seguiCabTmp.setDeportista(deportista);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al asignar deportista: "+e.getMessage());
		}
	}
	
	/**
	 * Realiza los calculos de subtotales, impuestos y totales.
	 * @param facturaCabTmp Factura temporal creada en memoria.
	 */
	private void calcularSeguiTmp(SeguimientodepCab seguiCabTmp){
		double sumaSubtotales;
		double cont=0;
		double promedio=0;
		//verificamos los campos calculados:
		sumaSubtotales=0;
		for(TestDet det:seguiCabTmp.getTestDets()){
			sumaSubtotales+= ((det.getCantidad().intValue()*100) / det.getIndiceValorTest().doubleValue());
		cont=cont+1;
		}
		
	promedio=sumaSubtotales/cont;
		seguiCabTmp.setSubtotalporcentaje(new BigDecimal(sumaSubtotales)); 
		seguiCabTmp.setBaseCero(new BigDecimal(0));
	seguiCabTmp.setTotalporcentaje( new BigDecimal(promedio));
	}
	
	/**
	 * Adiciona un item detalle a una factura temporal. Estos valores permanecen
	 * en memoria. 
	 * @param codigoProducto codigo del producto.
	 * @param cantidad cantidad del producto.
	 * @throws Exception problemas ocurridos al momento de insertar el item detalle.
	 */
	public void agregarDetalleSeguimientoTmp(SeguimientodepCab seguiCabTmp,Integer codigotest,Integer cantidad) throws Exception{
		Test p;
		TestDet td;	
		
		if(seguiCabTmp==null)
			throw new Exception("Error primero debe crear un nuevo reguistro seguimeinto.");
		if(codigotest==null||codigotest.intValue()<0)
			throw new Exception("Error debe especificar el codigo del Test.");
		if(cantidad==null||cantidad.intValue()<=0)
			throw new Exception("Error debe especificar  el valor  del test realizado.");
		
		//buscamos el Test:
		p=findTestById(codigotest);
		//creamos un nuevo detalle y llenamos sus propiedades:
		td=new TestDet();
		td.setCantidad(cantidad);
		td.setIndiceValorTest(p.getIndiceValor());
		td.setTest(p);
		seguiCabTmp.getTestDets().add(td);
		
		//verificamos los campos calculados:
		calcularSeguiTmp(seguiCabTmp);
	}
	
	/**
	 * Guarda en la base de datos una factura.
	 * @param facturaCabTmp factura temporal creada en memoria.
	 * @throws Exception problemas ocurridos en la insercion.
	 */
	public void guardarSeguimientoTemporal(SeguimientodepCab seguiCabTmp) throws Exception{
		
		if(seguiCabTmp==null)
			throw new Exception("Debe crear una reguistro seguimiento primero.");
		if(seguiCabTmp.getTestDets()==null || seguiCabTmp.getTestDets().size()==0)
			throw new Exception("Debe ingresar los test realizado  en el seguimiento.");
		if(seguiCabTmp.getDeportista()==null)
			throw new Exception("Debe registrar el deportista.");

		seguiCabTmp.setFechaEmision(new Date());
		
		//obtenemos el numero de la nueva factura:
		int contSegui;
		contSegui=getContSeguimiento();
		contSegui++;
		seguiCabTmp.setNumeroSegui(Integer.toString(contSegui));
		
		//verificamos los campos calculados:
		calcularSeguiTmp(seguiCabTmp);
		
		//asignamos la clave primaria a los detalles:
		int contseguiDet;
		contseguiDet=getContSeguimietoDet();
		
		for(TestDet det:seguiCabTmp.getTestDets()){
			contseguiDet++;
			det.setNumeroTestDet(new Integer(contseguiDet));
			//vinculamos el detalle a la cabecera (relacion bidireccional):
			det.setSeguimientodepCab(seguiCabTmp);
		}
		
		//guardamos la factura completa en la bdd:
		managerDAO.insertar(seguiCabTmp);
		
		//actualizamos los parametros contadores de facturas:
		actualizarContSeguimiento(contSegui); 
		actualizarContSeguiminetoDet(contseguiDet); 
		
		
		seguiCabTmp=null;		
		
	}
	
	
	
	/**
	 * Permite generar una factura a partir de un pedido de compra
	 * de un cliente. Este metodo reutiliza toda la logica de negocio
	 * que previamente fue implementada en ManagerFacturacion.
	 * @param pedidoCab El pedido del cliente.
	 * @throws Exception
	 */
/*	public void crearFacturaConPedido(PedidoCab pedidoCab) throws Exception{
		if(pedidoCab==null)
			throw new Exception("Debe crear un pedido primero.");

		//Creamos una factura temporal:
		FacturaCab facturaCabTmp=crearFacturaTmp();
		//Asignamos la informacion de cliente:
		asignarClienteFacturaTmp(facturaCabTmp, pedidoCab.getCliente().getCedulaCliente());
		//Agregamos los productos:
		for(PedidoDet pd:pedidoCab.getPedidoDets()){
			agregarDetalleFacturaTmp(facturaCabTmp, pd.getProducto().getCodigoProducto(), pd.getCantidad());
		}
		//Finalmente guardamos la nueva factura:
		guardarFacturaTemporal(facturaCabTmp);
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
