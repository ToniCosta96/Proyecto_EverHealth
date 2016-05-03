package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


public class conexio {
	
	Connection con = null;
	Object[] dadesBBDD;
	DefaultTableModel dtmBBDD;
	public conexio(DefaultTableModel dtm2){
		dtmBBDD=dtm2;
		registraDriver();
		
		//...
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost/everhealth?user=root&password=");
		// Otros y operaciones sobre la base de datos...
		} catch (SQLException ex) {
		// Mantener el control sobre el tipo de error
		System.out.println("SQLException: " + ex.getMessage());
		}
		consultarDades();
	}

	public void registraDriver(){
		//Registrar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Registro exitoso");
		} catch (Exception e) {
			System.out.println(e.toString());
		}					
	}
	
	public void consultarDades(){
			

		try {
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs = cmd.executeQuery("SELECT Nombre,Kcal FROM alimentos");
			
			//dadesBBDD=new Object[]{"Nombre","Kcal"};
			//System.out.println(dadesBBDD);
			System.out.println("Nombre --> Kcal");
			while (rs.next()) {
				
				String Nombre = rs.getString("Nombre");
				String Kcal = rs.getString("Kcal");
				dadesBBDD=new Object[]{Nombre,Kcal}; 
				dtmBBDD.addRow(dadesBBDD);
				//System.out.println(dadesBBDD);
				System.out.println(Nombre + " --> " + Kcal);

				}

				rs.close();
		}catch(Exception e){
		}
	}
	
}
