package BDD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class CargarIdioma {
	private static final String archivoConfig="./Config.properties";
	private String arrayIdioma[];
	
	public CargarIdioma(Conexio conexio){
		/*Se carga el array con el idioma de la base de datos*/
		String idioma;
		Connection con=conexio.getConexio();
		idioma=cargarProperties();
		this.arrayIdioma=cargarIdiomaDeLaBDD(con, idioma, arrayIdioma);
	}
	
	public CargarIdioma(JComboBox<String> comboBoxIdioma){
		comboBoxIdioma.setSelectedItem(cargarProperties());
	}
	
	public CargarIdioma(Conexio conexio, String arrayIdioma[]){
		/*Se obtiene el idioma del properties y se carga el idioma de la base de datos.*/
		String idioma;
		Connection con=conexio.getConexio();
		/*Cargar properties*/
		idioma=cargarProperties();
		/*Cargar idioma de la base de datos*/
		arrayIdioma=cargarIdiomaDeLaBDD(con,idioma,arrayIdioma);
	}
	
	public CargarIdioma(Conexio conexio, String idioma, String arrayIdioma[]){
		/*Se carga de la base de datos el idioma seleccionado y se guarda en el properties.*/
		Connection con=conexio.getConexio();
		/*Cargar idioma de la base de datos*/
		arrayIdioma=cargarIdiomaDeLaBDD(con,idioma,arrayIdioma);
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
	
	private String[] cargarIdiomaDeLaBDD(Connection con,String idioma, String arrayIdioma[]){
		try{
			ResultSet rs = null;
			Statement cmd = null;
			cmd = (Statement) con.createStatement();
			rs=cmd.executeQuery("SELECT COUNT(id) FROM idiomas");
			rs.next();
			arrayIdioma=new String[rs.getInt(1)];
			String cargarIdioma = "SELECT "+idioma+" FROM idiomas";
			rs= cmd.executeQuery(cargarIdioma);
				for(int i=0;i<arrayIdioma.length;i++){
					rs.next();
					arrayIdioma[i]=rs.getString(1);
				}
				rs.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return arrayIdioma;
	}
	
	public String[] getArrayIdioma(){
		return arrayIdioma;
	}
}
