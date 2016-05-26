package BDD;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class Conexio {
	
	Connection con = null;
	String usuario;
	
	public Conexio(){
		registraDriver();
	}

	public void registraDriver(){
		//...
				try {
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/everhealth?user=root&password=");
				// Otros y operaciones sobre la base de datos...
				} catch (SQLException ex) {
				// Mantener el control sobre el tipo de error
				System.out.println("SQLException: " + ex.getMessage());
				}
		//Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Conexión exitosa");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public Connection getConexio(){
		return con;
	}
	
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	public String getUsuario(){
		return usuario;
	}
	
}
	
	
	

