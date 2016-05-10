package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import BDD.Conexio;
import BDD.Consultas;

import java.awt.Color;

public class CrearUsuario extends JPanel implements ActionListener{
	private Conexio conexio;
	private Ventanas ventanaPrincipal;
	private char modoVentana='c';
	private JTextField textFieldnombre;
	private JTextField textFieldCorreo;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmar;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private JLabel lblError;
	
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnSedentario;
	private JRadioButton rdbtnLigeramenteActivo;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnAdelgazar;
	private JRadioButton rdbtnEngordar;
	private JTextField textFieldCaloriasRecomendadas;

	/**
	 * Create the frame.
	 */
	public CrearUsuario(Ventanas v, Conexio conexio) {
		final int tamanyoLetraLabels= 20;
		final int tamanyoLetraFieldsTexts= 16;
		this.conexio=conexio;
		ventanaPrincipal=v;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDatos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDatos.getLayout();
		flowLayout.setVgap(50);
		add(panelDatos, BorderLayout.CENTER);
		
		JPanel panelDatos2 = new JPanel();
		panelDatos.add(panelDatos2);
		panelDatos2.setLayout(new GridLayout(10, 2, 80, 10));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblNombre);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblCorreoElectrnico);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(passwordField);
		
		JLabel lblConfirmarPass = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblConfirmarPass);
		
		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(passwordFieldConfirmar);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
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
		
		JLabel lblVacio = new JLabel("");
		panelDatos2.add(lblVacio);
		
		JPanel panelCaloriasRecomendadas = new JPanel();
		panelCaloriasRecomendadas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDatos2.add(panelCaloriasRecomendadas);
		panelCaloriasRecomendadas.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblCalorasRecomendadas = new JLabel("Calorías recomendadas:");
		lblCalorasRecomendadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCaloriasRecomendadas.add(lblCalorasRecomendadas);
		
		textFieldCaloriasRecomendadas = new JTextField();
		textFieldCaloriasRecomendadas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCaloriasRecomendadas.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		textFieldCaloriasRecomendadas.setEditable(false);
		panelCaloriasRecomendadas.add(textFieldCaloriasRecomendadas);
		textFieldCaloriasRecomendadas.setColumns(10);
		textFieldCaloriasRecomendadas.setText("Calorias");
		
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
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		panelBotonesGuardar.add(lblError);
		panelBotonesGuardar.add(btnGuardar);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String accio = e.getActionCommand();

		if(accio.compareTo("CrearUsuarioBtnAtras")==0){
			if(modoVentana=='c'){
				InicioDeSesion frame = new InicioDeSesion();
				frame.setVisible(true);
				ventanaPrincipal.dispose();
			}else{
				ventanaPrincipal.cambiapanel("Menu");
				ventanaPrincipal.setTitle("Ever Health- Menu Principal");
			}
		}
		if(accio.compareTo("CrearUsuarioBtnGuardar")==0){
			//Comprovem que les dades son correctes
			
			if(comprobarCampos()){
				String campos[]= new String[3];
				int camposInt[]= new int[5];
				campos[0]=textFieldnombre.getText();
				campos[1]=textFieldCorreo.getText();
				campos[2]=String.valueOf(passwordField.getPassword());
				if(rdbtnMasculino.isSelected()){
					camposInt[0]=0;
				}else{
					camposInt[0]=1;
				}
				camposInt[1]=Integer.parseInt(textFieldAltura.getText());
				camposInt[2]=Integer.parseInt(textFieldPeso.getText());
				if(rdbtnAdelgazar.isSelected()){
					camposInt[3]=0;
				}else{
					camposInt[3]=1;
				}
				if(rdbtnLigeramenteActivo.isSelected()){
					camposInt[4]=0;
				}else if(rdbtnActivo.isSelected()){
					camposInt[4]=1;
				}else{
					camposInt[4]=2;
				}
				new Consultas(conexio).registrarUsuario(campos, camposInt);
				ventanaPrincipal.cambiapanel("Menu");
				ventanaPrincipal.setTitle("Ever Health- Menu Principal");
			}
			//Si tot esta correcte
				//obrir connexio
				//fer un insert
				//si l'insert ha anat bé --> 
			
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
	private boolean comprobarCampos(){
		String mensajeError="";
		if(!textFieldnombre.getText().isEmpty()){
			if(passwordField.getPassword().length>0 && passwordFieldConfirmar.getPassword().length>0){
				if(passwordField.getPassword().length>=4 && passwordFieldConfirmar.getPassword().length>=4){
					if(Arrays.equals(passwordField.getPassword(), passwordFieldConfirmar.getPassword())){
						//Contraseña introducida.
						if(!textFieldAltura.getText().isEmpty() && !textFieldPeso.getText().isEmpty()){
							if(comprobarNumero(textFieldAltura.getText()) && comprobarNumero(textFieldPeso.getText())){
								//Correcto.
								mensajeError="";
								lblError.setText("");
							}else{
								mensajeError="El peso o la altura no se han introducido correctamente.";
							}
						}else{
							mensajeError="Faltan campos por introducir.";
						}
					}else{
						mensajeError="Las contraseñas no coinciden.";
					}
				}else{
					mensajeError="La contraseña tiene que tener al menos una longitud de 4 caracteres.";
				}
			}else{
				mensajeError="No se ha introducido ninguna contraseña.";
			}
		}else{
			mensajeError="No se ha introducido el nombre.";
		}
		if(mensajeError.compareTo("")!=0){
			lblError.setText(mensajeError);
			return false;
		}else{
			return true;
		}
	}
	private boolean comprobarNumero(String numero){
		try{
			Integer.parseInt(numero);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	public void cambiarModoVentana(char modoVentana){
		this.modoVentana=modoVentana;
	}
}
