package calculos;

import interfaz.DatosDeUsuario;

public class CalcularCalorias {
	private String caloriasRecomendadas;

	public CalcularCalorias(DatosDeUsuario ddu){
		float kiloCal;
		if(ddu.getGenero()==0){
			//Hombre
			kiloCal=(66.473f+(13.7516f*ddu.getPeso())+(5.0033f*ddu.getAltura())-(6.755f*ddu.getEdad()));
		}else{
			//Mujer
			
		}
	}
	
	public String getCalorias(){
		return caloriasRecomendadas;
	}
}
