package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CrearUsuario extends JPanel implements ActionListener{
	Ventanas ventanaPrincipal;
	private JTextField textFieldnombre;
	private JTextField textFieldCorreo;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmar;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnSedentario;
	private JRadioButton rdbtnLigeramenteActivo;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnAdelgazar;
	private JRadioButton rdbtnEngordar;


	/**
	 * Create the frame.
	 */
	public CrearUsuario(Ventanas v) {
		final int tamanyoLetraLabels= 20;
		ventanaPrincipal=v;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDatos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDatos.getLayout();
		flowLayout.setVgap(50);
		add(panelDatos, BorderLayout.CENTER);
		
		JPanel panelDatos2 = new JPanel();
		panelDatos.add(panelDatos2);
		panelDatos2.setLayout(new GridLayout(9, 2, 80, 10));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblNombre);
		
		textFieldnombre = new JTextField();
		panelDatos2.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblCorreoElectrnico);
		
		textFieldCorreo = new JTextField();
		panelDatos2.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPass);
		
		passwordField = new JPasswordField();
		panelDatos2.add(passwordField);
		
		JLabel lblConfirmarPass = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblConfirmarPass);
		
		passwordFieldConfirmar = new JPasswordField();
		panelDatos2.add(passwordFieldConfirmar);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblAltura);
		
		textFieldAltura = new JTextField();
		panelDatos2.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPeso);
		
		textFieldPeso = new JTextField();
		panelDatos2.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		//Seleccionar género.
		JLabel lblGnero = new JLabel("Género:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblGnero);
		seleccionarGenero(panelDatos2);
		
		//Seleccionar actividad.
		JLabel lblActividadFsica = new JLabel("Actividad física:");
		lblActividadFsica.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblActividadFsica);
		seleccionarActividad(panelDatos2);
		
		//Seleccionar objetivo.
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblObjetivo);
		seleccionarObjetivo(panelDatos2);
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		JPanel panelBotonesAtras = new JPanel();
		FlowLayout fl_panelBotonesAtras = (FlowLayout) panelBotonesAtras.getLayout();
		fl_panelBotonesAtras.setVgap(20);
		fl_panelBotonesAtras.setHgap(20);
		fl_panelBotonesAtras.setAlignment(FlowLayout.LEFT);
		panelBotones.add(panelBotonesAtras);
		
		JButton btnAtras = new JButton("Atrás");
		panelBotonesAtras.add(btnAtras);
		btnAtras.setActionCommand("CrearUsuarioBtnAtras");
		btnAtras.addActionListener(this);
		
		JPanel panelBotonesGuardar = new JPanel();
		FlowLayout fl_panelBotonesGuardar = (FlowLayout) panelBotonesGuardar.getLayout();
		fl_panelBotonesGuardar.setVgap(20);
		fl_panelBotonesGuardar.setHgap(20);
		fl_panelBotonesGuardar.setAlignment(FlowLayout.RIGHT);
		panelBotones.add(panelBotonesGuardar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("CrearUsuarioBtnGuardar");
		btnGuardar.addActionListener(this);
		panelBotonesGuardar.add(btnGuardar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String accio = e.getActionCommand();

		if(accio.compareTo("CrearUsuarioBtnAtras")==0){
			InicioDeSesion frame = new InicioDeSesion();
			frame.setVisible(true);
			ventanaPrincipal.dispose();
		}
		if(accio.compareTo("CrearUsuarioBtnGuardar")==0){
			
			//Comprovem que les dadesson correctes
			//Si tot esta correcte
				//obrir connexio
				//fer un insert
				//si l'insert ha anat bé --> 
			ventanaPrincipal.cambiapanel("Menu");
			ventanaPrincipal.setTitle("Ever Health- Menu Principal");
			//si l'insert no ha anat bé --> mostrar JOptionPane amb misssatge d'error
		}
	}
	
	private void seleccionarGenero(JPanel panelDatos2){
		//Grupo de botones para seleccionar el género.
		JPanel panelGenero = new JPanel();
		panelGenero.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelGenero);
		
		rdbtnMasculino = new JRadioButton("Masculino.");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelGenero.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino.");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelGenero.add(rdbtnFemenino);
		ButtonGroup grupoRdbtGenero = new ButtonGroup();
		grupoRdbtGenero.add(rdbtnMasculino);
		grupoRdbtGenero.add(rdbtnFemenino);
	}
	private void seleccionarActividad(JPanel panelDatos2){
		//Grupo de botones para seleccionar la actividad física.
		JPanel panelActividadFisica = new JPanel();
		panelActividadFisica.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelActividadFisica);
		
		rdbtnSedentario = new JRadioButton("Sedentario.");
		rdbtnSedentario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelActividadFisica.add(rdbtnSedentario);
		
		rdbtnLigeramenteActivo = new JRadioButton("Ligeramente activo.");
		rdbtnLigeramenteActivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelActividadFisica.add(rdbtnLigeramenteActivo);
		
		rdbtnActivo = new JRadioButton("Activo.");
		rdbtnActivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelActividadFisica.add(rdbtnActivo);
		ButtonGroup grupoRdbtActividad = new ButtonGroup();
		grupoRdbtActividad.add(rdbtnSedentario);
		grupoRdbtActividad.add(rdbtnLigeramenteActivo);
		grupoRdbtActividad.add(rdbtnActivo);
	}
	private void seleccionarObjetivo(JPanel panelDatos2){
		//Grupo de botones para seleccionar el género.
		JPanel panelObjetivo = new JPanel();
		panelObjetivo.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelObjetivo);
		
		rdbtnAdelgazar = new JRadioButton("Adelgazar.");
		rdbtnAdelgazar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelObjetivo.add(rdbtnAdelgazar);
		
		rdbtnEngordar = new JRadioButton("Engordar.");
		rdbtnEngordar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelObjetivo.add(rdbtnEngordar);
		ButtonGroup grupoRdbtObjetivo = new ButtonGroup();
		grupoRdbtObjetivo.add(rdbtnAdelgazar);
		grupoRdbtObjetivo.add(rdbtnEngordar);
	}
}
