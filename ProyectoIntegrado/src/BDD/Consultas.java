package BDD;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import interfaz.DatosDeUsuario;

public class Consultas{
	Connection con;
	ArrayList<String> select;
	Object valores[];
	boolean existe;
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
	
	public void consultarDades(String busqueda,DefaultTableModel dtmBBDD){
		//strings pasados por la clase consultas.
				valores=new Object[select.size()-1];

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
	
	public boolean registrarUsuario(DatosDeUsuario ddu){
		existe=false;
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre FROM Usuario");
			
			while (rs.next()) {
				if(ddu.getNombre().equals(rs.getString("Nombre"))){
					existe=true;
					System.out.println("existe");
				}
				System.out.println("no existe de momento");
				
			}
			
			if(existe==false){
				
				psInsertar=(PreparedStatement) con.prepareStatement("INSERT INTO Usuario (Nombre,Email,Contraseņa,Genero,Altura_cm,Peso_kg,Objetivo,Actividad) VALUES (?,?,?,?,?,?,?,?)");
				
				psInsertar.setString(1, ddu.getNombre());
				psInsertar.setString(2, ddu.getEmail());
				psInsertar.setString(3, ddu.getContrasenya());
				psInsertar.setInt(4,ddu.getGenero());
				psInsertar.setInt(5,ddu.getAltura());
				psInsertar.setInt(6,ddu.getPeso());
				psInsertar.setInt(7,ddu.getObjetivo());
				psInsertar.setInt(8,ddu.getActividad());
				psInsertar.execute();
			
			
			System.out.println("Se ha registrado el usuario");
			return true;
			}else{
				System.out.println("El usuario ya existe");
				JOptionPane.showMessageDialog(null,"El Nombre de Usuario ya existe");
				return false;
			}
			
			
		}catch(Exception e){
			System.out.println("Ha habido algun problema en el registro");
			System.out.println(e);
			return false;
		}
	}
	
	public boolean actualizarUsuario(DatosDeUsuario ddu){
		existe=false;
		
		try {		
				psInsertar=(PreparedStatement) con.prepareStatement("UPDATE Usuario SET Email=?,Contraseņa=?,Genero=?,Altura_cm=?,Peso_kg=?,Objetivo=?,Actividad=? WHERE Nombre LIKE ?");
				System.out.println(ddu.getEmail());
				psInsertar.setString(1, ddu.getEmail());
				System.out.println(psInsertar);
				psInsertar.setString(2, ddu.getContrasenya());
				System.out.println(psInsertar);
				psInsertar.setInt(3,ddu.getGenero());
				System.out.println(psInsertar);
				psInsertar.setInt(4,ddu.getAltura());
				System.out.println(psInsertar);
				psInsertar.setInt(5,ddu.getPeso());
				System.out.println(psInsertar);
				psInsertar.setInt(6,ddu.getObjetivo());
				System.out.println(psInsertar);
				psInsertar.setInt(7,ddu.getActividad());
				System.out.println(psInsertar);
				psInsertar.setString(8, ddu.getNombre());
				System.out.println(psInsertar);
				psInsertar.execute();
			
			
			System.out.println("Se ha actualizado el usuario");
			return true;
			
			
		}catch(Exception e){
			System.out.println("Ha habido algun problema con la actualizacion");
			System.out.println(e);
			return false;
		}
	}
	
	public boolean iniciarSesionUsuario(String nom, String pass){
		boolean correcta=false;
		existe=false;
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre FROM Usuario");
			
			while (rs.next()) {
				
			
				if(nom.equals(rs.getString("Nombre"))){
					existe=true;
				}
				//System.out.println("no existe de momento");
				
			}
			
			if(existe==true){
				
				try {
					
					cmd = (Statement) con.createStatement();
					rs = cmd.executeQuery("SELECT contraseņa FROM Usuario WHERE Nombre LIKE "+"'"+nom+"'");
					
					while (rs.next()) {
						if(pass.equals(rs.getString("Contraseņa"))){
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
	
	public String[] consultarStringUsuario(String nombre){	
		String [] stringUsuario=new String[3];
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre,Email,Contraseņa FROM Usuario WHERE Nombre LIKE "+"'"+nombre+"'");
			
			while (rs.next()) {
				stringUsuario[0]=rs.getString("Nombre");
				stringUsuario[1]=rs.getString("Email");
				stringUsuario[2]=rs.getString("Contraseņa");
				
				

				}

				rs.close();
		}catch(Exception e){
		}
		return stringUsuario;
	}
	
	public int[] consultarIntUsuario(String nombre){	
		int [] intUsuario=new int[5];
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Genero,Altura_cm,Peso_kg,Objetivo,Actividad FROM Usuario WHERE Nombre LIKE "+"'"+nombre+"'");
			
			while (rs.next()) {
				intUsuario[0]=rs.getInt("Genero");
				intUsuario[1]=rs.getInt("Altura_cm");
				intUsuario[2]=rs.getInt("Peso_kg");
				intUsuario[3]=rs.getInt("Objetivo");
				intUsuario[4]=rs.getInt("Actividad");
				}

				rs.close();
		}catch(Exception e){
		}
		return intUsuario;
	}
	
	public DatosDeUsuario datosUsuario(String nom){
		DatosDeUsuario ddu=new DatosDeUsuario();
		String sU[]=consultarStringUsuario(nom);
		int iU[]=consultarIntUsuario(nom);
		ddu.setNombre(sU[0]);
		ddu.setEmail(sU[1]);
		ddu.setContrasenya(sU[2]);
		ddu.setGenero(iU[0]);
		ddu.setAltura(iU[1]);
		ddu.setPeso(iU[2]);
		ddu.setObjetivo(iU[3]);
		ddu.setActividad(iU[4]);
		return ddu;
	}
			
}