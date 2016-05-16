package BDD;

import com.mysql.jdbc.Connection;

public class CargarIdioma {
	public CargarIdioma(Conexio conexio, String arrayIdioma[]){
		/*Se obtiene el idioma del properties y se carga el idioma de la base de datos.*/
		Connection con=conexio.getConexio();
		System.out.println("");
	}
	public CargarIdioma(Conexio conexio, String idioma, String arrayIdioma[]){
		/*Se carga de la base de datos el idioma seleccionado y se guarda en el properties.*/
		Connection con=conexio.getConexio();
	}
}
