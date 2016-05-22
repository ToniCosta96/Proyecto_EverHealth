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
	String nombreUsuario;
	
	public Consultas(Conexio conexio){
		con= conexio.getConexio();
		nombreUsuario = conexio.getUsuario();
	}
	
	public void consultarAlimentos(){
		select=new ArrayList<String>();
		select.add("SELECT Nombre,Kcal FROM alimentos");
		select.add("Nombre");
		select.add("Kcal");
		
		
	}
	public void consultarPlatos(){
		select=new ArrayList<String>();
		select.add("SELECT Nombre,Tipo FROM alimentos");
		select.add("Nombre");
		select.add("Tipo");
		
		
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
				
				psInsertar=(PreparedStatement) con.prepareStatement("INSERT INTO Usuario (Nombre,Email,Contrasenya,Genero,Altura_cm,Peso_kg,Objetivo,Actividad,Edad) VALUES (?,?,?,?,?,?,?,?,?)");
				
				psInsertar.setString(1, ddu.getNombre());
				psInsertar.setString(2, ddu.getEmail());
				psInsertar.setString(3, ddu.getContrasenya());
				psInsertar.setInt(4,ddu.getGenero());
				psInsertar.setInt(5,ddu.getAltura());
				psInsertar.setInt(6,ddu.getPeso());
				psInsertar.setInt(7,ddu.getObjetivo());
				psInsertar.setInt(8,ddu.getActividad());
				psInsertar.setInt(9, ddu.getEdad());
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
		
		try {		
				psInsertar=(PreparedStatement) con.prepareStatement("UPDATE Usuario SET Email=?,Contrasenya=?,Genero=?,Altura_cm=?,Peso_kg=?,Objetivo=?,Actividad=?,Edad=? WHERE Nombre LIKE ?");
				//System.out.println(ddu.getEmail());
				psInsertar.setString(1, ddu.getEmail());
				//System.out.println(psInsertar);
				psInsertar.setString(2, ddu.getContrasenya());
				//System.out.println(psInsertar);
				psInsertar.setInt(3,ddu.getGenero());
				//System.out.println(psInsertar);
				psInsertar.setInt(4,ddu.getAltura());
				//System.out.println(psInsertar);
				psInsertar.setInt(5,ddu.getPeso());
				//System.out.println(psInsertar);
				psInsertar.setInt(6,ddu.getObjetivo());
				//System.out.println(psInsertar);
				psInsertar.setInt(7,ddu.getActividad());
				//System.out.println(psInsertar);
				psInsertar.setInt(8, ddu.getEdad());
				psInsertar.setString(9, ddu.getNombre());
				//System.out.println(psInsertar);
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
					rs = cmd.executeQuery("SELECT contrasenya FROM Usuario WHERE Nombre LIKE "+"'"+nom+"'");
					
					while (rs.next()) {
						if(pass.equals(rs.getString("Contrasenya"))){
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
			rs = cmd.executeQuery("SELECT Nombre,Email,Contrasenya FROM Usuario WHERE Nombre LIKE "+"'"+nombre+"'");
			
			while (rs.next()) {
				stringUsuario[0]=rs.getString("Nombre");
				stringUsuario[1]=rs.getString("Email");
				stringUsuario[2]=rs.getString("Contrasenya");
				
				

				}

				rs.close();
		}catch(Exception e){
		}
		return stringUsuario;
	}
	
	public int[] consultarIntUsuario(String nombre){	
		int [] intUsuario=new int[6];
		
		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Genero,Altura_cm,Peso_kg,Objetivo,Actividad,Edad FROM Usuario WHERE Nombre LIKE "+"'"+nombre+"'");
			
			while (rs.next()) {
				intUsuario[0]=rs.getInt("Genero");
				intUsuario[1]=rs.getInt("Altura_cm");
				intUsuario[2]=rs.getInt("Peso_kg");
				intUsuario[3]=rs.getInt("Objetivo");
				intUsuario[4]=rs.getInt("Actividad");
				intUsuario[5]=rs.getInt("Edad");
				
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
		ddu.setEdad(iU[5]);
		return ddu;
	}
	
	public void registrarPlato(String nombre,String tipo,String [] ingredientes,int [] cantidades){
		int id_Usuario=consultarIdUsuario();
		try {		
			psInsertar=(PreparedStatement) con.prepareStatement("INSERT INTO Plato (Nombre,Tipo,Fid_Usuario) VALUES(?,?,?)");
			
			psInsertar.setString(1, nombre);
			psInsertar.setString(2, tipo);
			psInsertar.setInt(3, id_Usuario);

			psInsertar.execute();
			
			ResultSet rs = null;
			Statement cmd = null;
			int id_plato=-1;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT id_plato FROM Plato");
			
			while (rs.next()) {
				id_plato=rs.getInt("id_plato");
				System.out.println("id plato: "+id_plato);
			}
			
			int id_alimento=0;
			
			for(int i=0;i<ingredientes.length;i++){
				rs = cmd.executeQuery("SELECT id_alimento FROM alimentos WHERE Nombre ='"+ingredientes[i]+"'");
				while (rs.next()) {
					id_alimento=rs.getInt("id_alimento");
					System.out.println("id alimento: "+id_alimento);
				}
				psInsertar=(PreparedStatement) con.prepareStatement("INSERT INTO alimentos_plato(Fid_Alimentos,Fid_Plato,cantidad) VALUES(?,?,?)");
				
				psInsertar.setInt(1, id_alimento);
				psInsertar.setInt(2, id_plato);
				psInsertar.setInt(3, cantidades[i]);
				
				psInsertar.execute();
			}
			
			
			rs.close();
			
		}catch(Exception e){
			System.out.println("Ha habido algun problema con el registro de plato");
			System.out.println(e);
		}
	}
	
	public int consultarIdUsuario(){
		int id_Usuario=-1;
		try{
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			
			rs = cmd.executeQuery("SELECT id_usuario FROM Usuario WHERE Nombre='"+nombreUsuario+"'");
			
			
			while (rs.next()) {
				id_Usuario=rs.getInt("id_Usuario");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return id_Usuario;
	}
	
			
}
	
			
