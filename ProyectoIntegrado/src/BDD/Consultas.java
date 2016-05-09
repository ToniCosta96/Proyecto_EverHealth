package BDD;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class Consultas{
	Connection con;
	ArrayList<String> select;
	DefaultTableModel dtmBBDD;
	Object valores[];
	String busqueda;
	
	public Consultas(Conexio conexio){
		con= conexio.getConexio();
	}
	
	public void consultarAlimentos(){
		select=new ArrayList<String>();
		select.add("SELECT Nombre,Kcal FROM alimentos");
		select.add("Nombre");
		select.add("Kcal");
		
		
	}
	
	public void consultarDades(String busq,DefaultTableModel dtm2){
		//strings pasados por la clase consultas.
				valores=new Object[select.size()-1];
				dtmBBDD=dtm2;
				busqueda=busq;

		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery(select.get(0)+" WHERE "+select.get(1)+" LIKE "+"'%"+busqueda+"%'");
			
			while (rs.next()) {
				for(int i=0;i<valores.length;i++){
					valores[i]=rs.getString(select.get(i+1));
				}
				
				dtmBBDD.addRow(valores);
				

				}

				rs.close();
		}catch(Exception e){
		}
	}
}