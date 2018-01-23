package bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.ArrayList;


import model.entrenador;

@ManagedBean
@RequestScoped

public class entrenadorbean {
	
	private List<entrenador> lista = new ArrayList<entrenador>();

	public List<entrenador> getLista() {
		return lista;
	}

	public void setLista(List<entrenador> lista) {
		this.lista = lista;
	}
	
	
	
	

	public void listar() {
		entrenador en= new entrenador();
		en.setCedula("1003456544");
		en.setNombres("Carlos");
		en.setApellidos("Perez");
		en.setDireccion("Ibarra");
		en.setTelefono(432423);
		en.setLugarnaciemnto("Ibarra");
		en.setEmail("dsad@hotmail.com");
		en.setSexo("masculino");
		en.setProfesion("lcdo.Culturafiscia");
		
		lista.add(en);
		
	 en= new entrenador();
		en.setCedula("1003456545");
		en.setNombres("karla");
		en.setApellidos("Guerron");
		en.setDireccion("Quito");
		en.setTelefono(234234324);
		en.setLugarnaciemnto("Quito");
		en.setEmail("carlak@hotmail.com");
		en.setSexo("femenino");
		en.setProfesion("lcda.Culturafiscia");
		
		lista.add(en);
		
		
		 en= new entrenador();
		en.setCedula("1003453427");
		en.setNombres("Luis");
		en.setApellidos("Pineda");
		en.setDireccion("Otvalo");
		en.setTelefono(23426263);
		en.setLugarnaciemnto("Imbya");
		en.setEmail("luispda@hotmail.com");
		en.setSexo("masculino");
		en.setProfesion("lcdo.Entrenamiento Futbol");
		
		lista.add(en);
		
		
	 en= new entrenador();
		en.setCedula("1003321352");
		en.setNombres("Paola");
		en.setApellidos("Lema");
		en.setDireccion("urcuqui");
		en.setTelefono(321311510);
		en.setLugarnaciemnto("Urcuqui");
		en.setEmail("Plema@hotmail.com");
		en.setSexo("femenino");
		en.setProfesion("lcdo.Entrenamiento Basquet");
		
		lista.add(en);
		
		
		
		
	}
}
