package BDD;

import com.mysql.jdbc.Connection;

public class CargarIdioma {
	public CargarIdioma(Conexio conexio, String arrayIdioma[]){
		Connection con=conexio.getConexio();
		
	}
	public CargarIdioma(Conexio conexio, String idioma, String arrayIdioma[]){
		Connection con=conexio.getConexio();
	}
}
