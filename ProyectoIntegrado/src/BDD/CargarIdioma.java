package BDD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class CargarIdioma {
	private static final String archivoConfig="./Config.properties";
	
	public CargarIdioma(JComboBox<String> comboBoxIdioma){
		comboBoxIdioma.setSelectedItem(cargarProperties());
	}
	
	public CargarIdioma(Conexio conexio, ArrayList<String>arrayIdioma){
		/*Se obtiene el idioma del properties y se carga el idioma de la base de datos.*/
		String idioma;
		Connection con=conexio.getConexio();
		/*Cargar properties*/
		idioma=cargarProperties();
		/*Cargar idioma de la base de datos*/
		cargarIdiomaDeLaBDD(con,idioma,arrayIdioma);
	}
	
	public CargarIdioma(Conexio conexio, String idioma, ArrayList<String>arrayIdioma){
		/*Se carga de la base de datos el idioma seleccionado y se guarda en el properties.*/
		Connection con=conexio.getConexio();
		/*Cargar idioma de la base de datos*/
		cargarIdiomaDeLaBDD(con,idioma,arrayIdioma);
		/*Escribir properties*/
		FileOutputStream output= null;
		try{
			Properties prop= new Properties();
			output=new FileOutputStream(archivoConfig);
			prop.setProperty("idioma", idioma);
			prop.store(output,null);
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,
				    ""+ex.getMessage(),
				    "Error al guardar idioma",
				    JOptionPane.ERROR_MESSAGE);
		}finally{
			if(output!=null){
				try{
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	private String cargarProperties(){
		String idioma=null;
		FileInputStream input= null;
		try{
			Properties prop= new Properties();
			input=new FileInputStream(archivoConfig);
			prop.load(input);
			prop.getProperty("idioma");
			idioma=prop.getProperty("idioma");
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,
				    ""+ex.getMessage(),
				    "Error al guardar idioma",
				    JOptionPane.ERROR_MESSAGE);
		}finally{
			if(input!=null){
				try{
					input.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return idioma;
	}
	
	private void cargarIdiomaDeLaBDD(Connection con,String idioma, ArrayList<String> arrayIdioma){
		try{
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			
			String cargarIdioma = "SELECT "+idioma+" FROM idiomas";
			if(arrayIdioma.isEmpty()){
				rs= cmd.executeQuery(cargarIdioma);
				while(rs.next()){
					arrayIdioma.add(rs.getString(1));
				}
			}else{
				rs= cmd.executeQuery(cargarIdioma);
				for(int i=0;i<arrayIdioma.size();i++){
					rs.next();
					arrayIdioma.set(i, rs.getString(1));
				}
			}
			rs.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
