package calculos;

import javax.swing.JTextField;

import interfaz.DatosDeUsuario;

public class CalcularCalorias {

	public CalcularCalorias(JTextField textFieldCaloriasRecomendadas,DatosDeUsuario ddu){
		float kiloCal;
		if(ddu.getGenero()==0){
			//Hombre
			kiloCal=(66.473f+(13.7516f*ddu.getPeso())+(5.0033f*ddu.getAltura())-(6.755f*ddu.getEdad()));
			kiloCal=calcularSugunActividad(kiloCal,ddu.getActividad());
			if(ddu.getObjetivo()==0){
				kiloCal-=500;
			}else if (ddu.getObjetivo()==2){
				kiloCal+=600;
			}
		}else{
			//Mujer
			kiloCal=(655.0955f+(9.5634f*ddu.getPeso())+(1.8496f*ddu.getAltura())-(4.6756f*ddu.getEdad()));
			kiloCal=calcularSugunActividad(kiloCal,ddu.getActividad());
			if(ddu.getObjetivo()==0){
				kiloCal-=400;
			}else if (ddu.getObjetivo()==2){
				kiloCal+=500;
			}
		}
		//Se cambia el texto del textField de calorias
		textFieldCaloriasRecomendadas.setText(String.valueOf((int)kiloCal));
	}
	
	private float calcularSugunActividad(float kiloCal,int actividad){
		if(actividad==0){
			kiloCal*=1.2f;
		}else if(actividad==1){
			kiloCal*=1.55f;
		}else{
			kiloCal*=1.8f;
		}
		return kiloCal;
	}
}
