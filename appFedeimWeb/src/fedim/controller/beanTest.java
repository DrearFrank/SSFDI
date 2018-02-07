package fedim.controller;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fedim.controller.JSFUtil;
import fedim.model.entities.Test;
import fedim.model.manager.ManagerSeguimiento;

@ManagedBean
@SessionScoped
public class beanTest {
private List<Test> listatest;
@EJB
private ManagerSeguimiento managersegui;

private Integer codigoTest;
private String descripciontest;
private String nombretest;
private BigDecimal inidcevalor;

public beanTest() {
	
}



public String actionInsertarTest(){
	Test p= new Test();
	p.setCodigoTest(codigoTest); 
	p.setNombretest(nombretest);
	p.setDescripcion(descripciontest);


	p.setIndiceValor(inidcevalor); 

	try {
		managersegui.insertarTest(p);
		codigoTest=null;
		descripciontest="";
		nombretest="";
		inidcevalor=null;
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
	
}
public String actionEliminarTest(Test test){
	try {
	managersegui.eliminarTest(test.getCodigoTest());	
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "";
}
public String actionCargarTest(Test test){
	codigoTest=test.getCodigoTest();
	descripciontest=test.getDescripcion();
	nombretest= test.getNombretest();
	inidcevalor= test.getIndiceValor();
	
	return "test_update";
}
public String actionActualizarTest(){
	Test p=new Test();
	p.setCodigoTest(codigoTest);
	p.setNombretest(nombretest);
	p.setDescripcion(descripciontest);
	p.setIndiceValor(inidcevalor);

	try {
	managersegui.actualizarTest(p);
		//limpiamos las variables del formulario:
		codigoTest=null;
		descripciontest="";
	
		nombretest="";
		inidcevalor=null;
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}
	return "test";
}










public List<Test> getListatest() {
	listatest=managersegui.findAllTest();
	return listatest;
}


public Integer getCodigoTest() {
	return codigoTest;
}
public void setCodigoTest(Integer codigoTest) {
	this.codigoTest = codigoTest;
}
public String getDescripciontest() {
	return descripciontest;
}
public void setDescripciontest(String descripciontest) {
	this.descripciontest = descripciontest;
}
public String getNombretest() {
	return nombretest;
}
public void setNombretest(String nombretest) {
	this.nombretest = nombretest;
}
public BigDecimal getInidcevalor() {
	return inidcevalor;
}
public void setInidcevalor(BigDecimal inidcevalor) {
	this.inidcevalor = inidcevalor;
}


}
