package interfaz;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventanas extends JFrame{

	private JPanel contentPane;
	private CardLayout cl;
	private Menu menu;
	private Planificacion planificacion;
	private CrearPlato crearPlato;
	/**
	 * Create the frame.
	 */
	public Ventanas(char ventanaDeInicio) {
		cl=new CardLayout();
		
		setTitle("Ever Health- Crear usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane=new JPanel();
		
		//Crear paneles del cardLayout
		CrearUsuario crearUsuario= new CrearUsuario(Ventanas.this);
		menu = new Menu(Ventanas.this);
		planificacion= new Planificacion(Ventanas.this);
		crearPlato= new CrearPlato(Ventanas.this);
		
		//Preparar paneles del cardLayout
		cl.addLayoutComponent(crearUsuario, "Crear Usuario");
		cl.addLayoutComponent(menu, "Menu");
		cl.addLayoutComponent(planificacion, "Planificacion");
		cl.addLayoutComponent(crearPlato, "CrearPlato");
		//Añadir al contentPane
		contentPane.add(crearUsuario);
		contentPane.add(menu);
		contentPane.add(crearPlato);
		contentPane.add(planificacion);
		
		contentPane.setLayout(cl);
		setContentPane(contentPane);
		
		if(ventanaDeInicio=='m'){
			cl.next(contentPane);
		}
	}
	
	public void cambiapanel(String nombre){
		if(nombre.equals("Menu")){
			cl.show(contentPane, "Menu");
		}else if(nombre.equals("CrearUsuario")){
			cl.show(contentPane, "CrearUsuario");
		}else if(nombre.equals("Planificacion")){
			cl.show(contentPane, "Planificacion");
		}else if(nombre.equals("CrearPlato")){
			cl.show(contentPane, "CrearPlato");
		}else if(nombre.equals("ConsultarPlatos")){
			ConsultarPlatos consultarPlatos=new ConsultarPlatos(Ventanas.this);
			cl.addLayoutComponent(consultarPlatos, "ConsultarPlatos");
			contentPane.add(consultarPlatos);
			cl.show(contentPane, "ConsultarPlatos");
		}else if(nombre.equals("ConsultarAlimentos")){
			ConsultarAlimentos consultarAlimentos=new ConsultarAlimentos(Ventanas.this);
			cl.addLayoutComponent(consultarAlimentos, "ConsultarAlimentos");
			contentPane.add(consultarAlimentos);
			cl.show(contentPane, "ConsultarAlimentos");
		}else if(nombre.equals("PerfilDeUsuario")){
			PerfilDeUsuario perfilDeUsuario=new PerfilDeUsuario(Ventanas.this);
			cl.addLayoutComponent(perfilDeUsuario, "PerfilDeUsuario");
			contentPane.add(perfilDeUsuario);
			cl.show(contentPane, "PerfilDeUsuario");
		}
	}
}
