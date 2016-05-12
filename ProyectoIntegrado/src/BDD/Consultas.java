package BDD;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Consultas{
	Connection con;
	ArrayList<String> select;
	DefaultTableModel dtmBBDD;
	Object valores[];
	String busqueda;
	String[] dat;
	int[] datint;
	char existe;
	PreparedStatement psInsertar;
	
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
	
	public void registrarUsuario(String[] datos,int[] datosint){
		dat=datos;
		datint=datosint;
		existe='n';
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre FROM Usuario");
			
			while (rs.next()) {
				if(dat[0].equals(rs.getString("Nombre"))){
					existe='s';
				}
				System.out.println("no existe de momento");
				
			}
			
			if(existe=='n'){
				
				psInsertar=(PreparedStatement) con.prepareStatement("INSERT INTO Usuario (Nombre,Email,Contraseña,Genero,Altura_cm,Peso_kg,Objetivo,Actividad) VALUES (?,?,?,?,?,?,?,?)");
				
				psInsertar.setString(1, dat[0]);
				psInsertar.setString(2, dat[1]);
				psInsertar.setString(3, dat[2]);
				psInsertar.setInt(4,datint[0]);
				psInsertar.setInt(5,datint[1]);
				psInsertar.setInt(6,datint[2]);
				psInsertar.setInt(7,datint[3]);
				psInsertar.setInt(8,datint[4]);
				psInsertar.execute();
			
			
			System.out.println("Se ha registrado el usuario");
			}else{
				System.out.println("El usuario ya existe");
			}
			
			
		}catch(Exception e){
			System.out.println("Ha habido algun problema en el registro");
			System.out.println(e);
		}
	}
	
	public boolean iniciarSesionUsuario(String nombre, String contrasenya){
		String nom=nombre;
		String pass=contrasenya;
		boolean correcta=false;
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre FROM Usuario");
			
			while (rs.next()) {
				
			
				if(nom.equals(rs.getString("Nombre"))){
					existe='s';
				}
				//System.out.println("no existe de momento");
				
			}
			
			if(existe=='s'){
				
				try {
					
					cmd = (Statement) con.createStatement();
					rs = cmd.executeQuery("SELECT contraseña FROM Usuario WHERE Nombre LIKE "+nom);
					
					while (rs.next()) {
						if(pass.equals(rs.getString("Contraseña"))){
							correcta=true;
						}					
						
					}			
				}catch(Exception e){
					System.out.println(e);
				}
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
				return correcta;
	}
			
}