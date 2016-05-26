package interfaz;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BDD.Conexio;

public class Ventanas extends JFrame{

	private Conexio conexio;
	private ArrayList<String> arrayIdioma;
	private JPanel contentPane;
	private CardLayout cl;
	private Menu menu;
	private Planificacion planificacion;
	private CrearPlato crearPlato;
	private CrearUsuario crearUsuario;
	private ConsultarPlatos consultarPlatos;
	/**
	 * Create the frame.
	 */
	public Ventanas(char ventanaDeInicio, Conexio conexio, ArrayList<String>arrayIdioma) {
		this.conexio= conexio;
		this.arrayIdioma=arrayIdioma;
		cl=new CardLayout();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(".\\img\\logoEverHealth1.png").getImage());
		contentPane=new JPanel();
		
		//Crear paneles del cardLayout
		menu = new Menu(Ventanas.this, conexio, arrayIdioma);
		planificacion= new Planificacion(Ventanas.this, conexio, arrayIdioma);
		crearPlato= new CrearPlato(Ventanas.this, conexio, arrayIdioma);
		crearUsuario= new CrearUsuario(Ventanas.this, conexio, arrayIdioma, menu, crearPlato);
		
		//Preparar paneles del cardLayout
		if(ventanaDeInicio=='c'){
			setTitle(arrayIdioma.get(41));
			cl.addLayoutComponent(crearUsuario, "CrearUsuario");
			cl.addLayoutComponent(menu, "Menu");
		}else if(ventanaDeInicio=='m'){
			setTitle(arrayIdioma.get(5));
			cl.addLayoutComponent(menu, "Menu");
			cl.addLayoutComponent(crearUsuario, "CrearUsuario");
		}
		cl.addLayoutComponent(planificacion, "Planificacion");
		cl.addLayoutComponent(crearPlato, "CrearPlato");
		//Añadir al contentPane
		contentPane.add(crearUsuario);
		contentPane.add(menu);
		contentPane.add(crearPlato);
		contentPane.add(planificacion);
		
		contentPane.setLayout(cl);
		setContentPane(contentPane);
	}
	
	public void cambiapanel(String nombre){
		if(nombre.equals("Menu")){
			cl.show(contentPane, "Menu");
		}else if(nombre.equals("CrearUsuario")){
			crearUsuario.cambiarModoVentana('p');
			cl.show(contentPane, "CrearUsuario");
		}else if(nombre.equals("Planificacion")){
			cl.show(contentPane, "Planificacion");
		}else if(nombre.equals("CrearPlato")){
			cl.show(contentPane, "CrearPlato");
		}else if(nombre.equals("ConsultarPlatos")){
			consultarPlatos=new ConsultarPlatos(Ventanas.this,conexio, arrayIdioma);
			cl.addLayoutComponent(consultarPlatos, "ConsultarPlatos");
			contentPane.add(consultarPlatos);
			cl.show(contentPane, "ConsultarPlatos");
		}else if(nombre.equals("ConsultarAlimentos")){
			ConsultarAlimentos consultarAlimentos=new ConsultarAlimentos(Ventanas.this,conexio, arrayIdioma);
			cl.addLayoutComponent(consultarAlimentos, "ConsultarAlimentos");
			contentPane.add(consultarAlimentos);
			cl.show(contentPane, "ConsultarAlimentos");
		}
	}
}
