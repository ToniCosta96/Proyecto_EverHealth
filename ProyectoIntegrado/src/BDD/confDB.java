package BDD;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class confDB {
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
		
		//DATOS DE LA BBDD
		private String host;
		private String bbdd;
		private String user;
		private String pass;
		private String url;
		
		//Conexion
		private Connection conexion = null;// maneja la conexió
		
		//Instancia unica
		private static confDB instance = null;
		
		private confDB(String HOST,String BBDD,String USER,String PASS) {
			this.host=HOST;
			this.bbdd=BBDD;
			this.user=USER;
			this.pass=PASS;
			this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		}
		
		//Implementar SingleTon
		public static confDB getInstance(String HOST,String BBDD,String USER,String PASS) {
		      if(instance == null) {
		         instance = new confDB(HOST,BBDD,USER,PASS);
		      }
		      return instance;
		   }
		
		public boolean connectDB(){
			try{
				//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
				Class.forName(CONTROLADOR_MYSQL);
				//Conectarnos a la BBDD
				conexion = DriverManager.getConnection(this.url,this.user,this.pass);
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
				return false;
			}
			catch( ClassNotFoundException noEncontroClase)
			{
				noEncontroClase.printStackTrace();
				return false;
			}
			return true;
		}
		
		public Connection getConexion(){
			return this.conexion;
		}

	}
