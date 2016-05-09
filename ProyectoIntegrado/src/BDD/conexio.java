package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexio {
	
	Connection con = null;
	
	
	public conexio(){
		registraDriver();
	}

	public void registraDriver(){
		//...
				try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/everhealth?user=root&password=");
				// Otros y operaciones sobre la base de datos...
				} catch (SQLException ex) {
				// Mantener el control sobre el tipo de error
				System.out.println("SQLException: " + ex.getMessage());
				}
		//Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Registro exitoso");
		} catch (Exception e) {
			System.out.println(e.toString());
		}					
	}
	
	
}
	
	
	

