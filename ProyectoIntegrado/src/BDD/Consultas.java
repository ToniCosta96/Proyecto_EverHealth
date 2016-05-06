package BDD;

import java.util.ArrayList;

public class Consultas {
//	
	ArrayList<String> select;
	public Consultas(){
	
	}
	public ArrayList<String> consultarAlimentos(){
		select=new ArrayList<String>();
		select.add("SELECT Nombre,Kcal FROM alimentos");
		select.add("Nombre");
		select.add("Kcal");
		return select;
		
	}
}
