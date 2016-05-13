package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;

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

public class CrearUsuario extends JPanel implements ActionListener{
	private Conexio conexio;
	private Ventanas ventanaPrincipal;
	private char modoVentana='c';
	private DatosDeUsuario ddu;
	private JTextField textFieldNombre;
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
	private JRadioButton rdbtnMantenerse;
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
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr�nico:");
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
		
		//Seleccionar g�nero.
		JLabel lblGnero = new JLabel("G�nero:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblGnero);
		seleccionarGenero(panelDatos2);
		
		//Seleccionar actividad.
		JLabel lblActividadFsica = new JLabel("Actividad f�sica:");
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
		
		JLabel lblCalorasRecomendadas = new JLabel("Calor�as recomendadas:");
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
		
		JButton btnAtras = new JButton("Atr�s");
		panelBotonesAtras.add(btnAtras);
		btnAtras.setActionCommand("CrearUsuarioBtnAtras");
		btnAtras.addActionListener(this);
		
		JPanel panelBotonesGuardar = new JPanel();
		FlowLayout fl_panelBotonesGuardar = (FlowLayout) panelBotonesGuardar.getLayout();
		fl_panelBotonesGuardar.setVgap(20);
		fl_panelBotonesGuardar.setHgap(20);
		fl_panelBotonesGuardar.setAlignment(FlowLayout.RIGHT);
		panelBotones.add(panelBotonesGuardar);
		
		JPanel panelBoxBotonesGuardar = new JPanel();
		panelBotonesGuardar.add(panelBoxBotonesGuardar);
		panelBoxBotonesGuardar.setLayout(new BoxLayout(panelBoxBotonesGuardar, BoxLayout.X_AXIS));
		
		lblError = new JLabel("");
		panelBoxBotonesGuardar.add(lblError);
		lblError.setForeground(Color.RED);
		
		JButton btnGuardar = new JButton("Guardar");
		panelBoxBotonesGuardar.add(btnGuardar);
		btnGuardar.setActionCommand("CrearUsuarioBtnGuardar");
		btnGuardar.addActionListener(this);
		
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
				//Quitar mensaje de error.
				lblError.setText("");
			}
		}
		if(accio.compareTo("CrearUsuarioBtnGuardar")==0){
			//Comprovem que les dades son correctes
			if(comprobarCampos()){
				if(modoVentana=='c'){
					//Crear usuario
					if(new Consultas(conexio).registrarUsuario(guardarDatosUsuario())){
						//Se guarda el nombre del usuario dentro de "conexion".
						conexio.setUsuario(textFieldNombre.getText());
						//Abrir la ventana Menu.
						ventanaPrincipal.cambiapanel("Menu");
						ventanaPrincipal.setTitle("Ever Health- Menu Principal");
					}
				}else{
					//Actualizar usuario
					////////////////////////////////new Consultas(conexio).actualizarUsuario(guardarDatosUsuario());
					ventanaPrincipal.cambiapanel("Menu");
					ventanaPrincipal.setTitle("Ever Health- Menu Principal");
				}
				
			}
			//Si tot esta correcte
				//obrir connexio
				//fer un insert
				//si l'insert ha anat b� --> 
			
			//si l'insert no ha anat b� --> mostrar JOptionPane amb misssatge d'error
		}
	}
	
	private void seleccionarGenero(JPanel panelDatos2){
		//Grupo de botones para seleccionar el g�nero.
		JPanel panelGenero = new JPanel();
		panelGenero.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelGenero);
		
		rdbtnMasculino = new JRadioButton("Masculino.");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setSelected(true);
		panelGenero.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino.");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelGenero.add(rdbtnFemenino);
		ButtonGroup grupoRdbtGenero = new ButtonGroup();
		grupoRdbtGenero.add(rdbtnMasculino);
		grupoRdbtGenero.add(rdbtnFemenino);
	}
	private void seleccionarActividad(JPanel panelDatos2){
		//Grupo de botones para seleccionar la actividad f�sica.
		JPanel panelActividadFisica = new JPanel();
		panelActividadFisica.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelActividadFisica);
		
		rdbtnSedentario = new JRadioButton("Sedentario.");
		rdbtnSedentario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnSedentario.setSelected(true);
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
		//Grupo de botones para seleccionar el g�nero.
		JPanel panelObjetivo = new JPanel();
		panelObjetivo.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelObjetivo);
		
		rdbtnAdelgazar = new JRadioButton("Adelgazar.");
		rdbtnAdelgazar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdelgazar.setSelected(true);
		panelObjetivo.add(rdbtnAdelgazar);
		
		rdbtnMantenerse = new JRadioButton("Mantenerse.");
		rdbtnMantenerse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelObjetivo.add(rdbtnMantenerse);
		
		rdbtnEngordar = new JRadioButton("Engordar.");
		rdbtnEngordar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelObjetivo.add(rdbtnEngordar);
		ButtonGroup grupoRdbtObjetivo = new ButtonGroup();
		grupoRdbtObjetivo.add(rdbtnAdelgazar);
		grupoRdbtObjetivo.add(rdbtnMantenerse);
		grupoRdbtObjetivo.add(rdbtnEngordar);
	}
	private DatosDeUsuario guardarDatosUsuario(){
		DatosDeUsuario datosDeUsuario=new DatosDeUsuario();
		datosDeUsuario.setNombre(textFieldNombre.getText());
		datosDeUsuario.setEmail(textFieldCorreo.getText());
		datosDeUsuario.setContrasenya(String.valueOf(passwordField.getPassword()));
		if(rdbtnMasculino.isSelected()){
			datosDeUsuario.setGenero(0);
		}else{
			datosDeUsuario.setGenero(1);
		}
		datosDeUsuario.setAltura(Integer.parseInt(textFieldAltura.getText()));
		datosDeUsuario.setPeso(Integer.parseInt(textFieldPeso.getText()));
		if(rdbtnAdelgazar.isSelected()){
			datosDeUsuario.setObjetivo(0);
		}else if(rdbtnMantenerse.isSelected()){
			datosDeUsuario.setObjetivo(1);
		}else{
			datosDeUsuario.setObjetivo(2);
		}
		if(rdbtnSedentario.isSelected()){
			datosDeUsuario.setActividad(0);
		}else if(rdbtnLigeramenteActivo.isSelected()){
			datosDeUsuario.setActividad(1);
		}else{
			datosDeUsuario.setActividad(2);
		}
		return datosDeUsuario;
	}
	private boolean comprobarCampos(){
		String mensajeError="";
		if(!textFieldNombre.getText().trim().isEmpty()){
			if(passwordField.getPassword().length>0 && passwordFieldConfirmar.getPassword().length>0){
				if(passwordField.getPassword().length>=4 && passwordFieldConfirmar.getPassword().length>=4){
					if(Arrays.equals(passwordField.getPassword(), passwordFieldConfirmar.getPassword())){
						//Contrase�a introducida.
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
						mensajeError="Las contrase�as no coinciden.";
					}
				}else{
					mensajeError="La contrase�a tiene que tener al menos una longitud de 4 caracteres.";
				}
			}else{
				mensajeError="No se ha introducido ninguna contrase�a.";
			}
			//Comprobar correo electr�nico
			if(textFieldCorreo.getText().isEmpty()){
				mensajeError+=" No se ha introducido ning�n correo electr�nico.";
			}else{
				if(comprobarCorreo(textFieldCorreo.getText())==false){
					mensajeError+=" El correo electr�nico no se ha introducido correctamente.";
				}
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
	private boolean comprobarCorreo(String correo){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (p.matcher(correo).find())
		    return true;
		else
		    return false;
	}
	public void cambiarModoVentana(char modoVentana){
		this.modoVentana=modoVentana;
		textFieldNombre.setEditable(false);
		
		ddu=new Consultas(conexio).datosUsuario(conexio.getUsuario());
		textFieldNombre.setText(ddu.getNombre());
		textFieldCorreo.setText(ddu.getEmail());
		passwordField.setText(ddu.getContrasenya());
		passwordFieldConfirmar.setText(ddu.getContrasenya());
		textFieldAltura.setText(String.valueOf(ddu.getAltura()));
		textFieldPeso.setText(String.valueOf(ddu.getPeso()));
		if(ddu.getGenero()==0){
			rdbtnMasculino.isSelected();
		}else{
			rdbtnFemenino.isSelected();
		}
		if(ddu.getActividad()==0){
			rdbtnSedentario.setSelected(true);
		}else if(ddu.getActividad()==1){
			rdbtnLigeramenteActivo.setSelected(true);
		}else{
			rdbtnActivo.setSelected(true);
		}
		if(ddu.getObjetivo()==0){
			rdbtnAdelgazar.setSelected(true);
		}else if(ddu.getActividad()==1){
			rdbtnMantenerse.setSelected(true);
		}else{
			rdbtnEngordar.setSelected(true);
		}
	}
}
