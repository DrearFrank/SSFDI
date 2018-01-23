package bean;

import java.util.List;
import java.util.ArrayList;
import model.disciplina;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class disciplina2bean {
	
	private List<disciplina> lista = new ArrayList<disciplina>();



	public List<disciplina> getLista() {
		return lista;
	}



	public void setLista(List<disciplina> lista) {
		this.lista = lista;
	}



	public void listar() {
		disciplina dis= new disciplina();
		dis.setId("1");
		dis.setDisciplina("Futbol");
		lista.add(dis);
		
		dis = new disciplina();
		dis.setId("2");
		dis.setDisciplina("Voley");
		lista.add(dis);
		
		dis = new disciplina();
		dis.setId("3");
		dis.setDisciplina("Basquet");
		lista.add(dis);
		
		
	}
}
