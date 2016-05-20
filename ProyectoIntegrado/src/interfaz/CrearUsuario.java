package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import BDD.CargarIdioma;
import BDD.Conexio;
import BDD.Consultas;
import BDD.Email;
import calculos.CalcularCalorias;

public class CrearUsuario extends JPanel implements ActionListener{
	private Conexio conexio;
	private ArrayList<String>arrayIdioma;
	private Ventanas ventanaPrincipal;
	private char modoVentana='c';
	private DatosDeUsuario ddu;
	
	private JLabel lblNombre;
	private JLabel lblCorreoElectrnico;
	private JLabel lblPass;
	private JLabel lblConfirmarPass;
	private JLabel lblEdad;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblGnero;
	private JLabel lblObjetivo;
	private JLabel lblActividadFsica;
	private JLabel lblEligeIdioma;
	private JLabel lblCalorasRecomendadas;
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
	private JTextField textFieldEdad;
	private JComboBox<String> comboBoxIdioma;
	private JButton btnAtras;
	private JButton btnGuardar;

	/**
	 * Create the frame.
	 */
	public CrearUsuario(Ventanas v, Conexio conexio, ArrayList<String>arrayIdioma) {
		final int tamanyoLetraLabels= 20;
		final int tamanyoLetraFieldsTexts= 16;
		this.conexio=conexio;
		ventanaPrincipal=v;
		this.arrayIdioma=arrayIdioma;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDatos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDatos.getLayout();
		flowLayout.setVgap(50);
		
		
		JPanel panelDatos2 = new JPanel();
		panelDatos.add(panelDatos2);
		panelDatos2.setLayout(new GridLayout(11, 2, 75, 10));
		
		//ScrollPane
		JScrollPane panelScroll= new JScrollPane(panelDatos);
		panelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelScroll.getVerticalScrollBar().setUnitIncrement(10);
		add(panelScroll);
		
		lblNombre=new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblNombre, BorderLayout.CENTER);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblCorreoElectrnico=new JLabel("");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblCorreoElectrnico);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		lblPass=new JLabel("");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(passwordField);
		
		lblConfirmarPass=new JLabel("");
		lblConfirmarPass.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblConfirmarPass);
		
		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(passwordFieldConfirmar);
		
		lblEdad=new JLabel("");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		lblAltura=new JLabel("");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		textFieldAltura.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(comprobarCampos()){
					new CalcularCalorias(textFieldCaloriasRecomendadas,guardarDatosUsuario());
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		lblPeso=new JLabel("");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblPeso);
		
		textFieldPeso=new JTextField();
		textFieldPeso.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		panelDatos2.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		textFieldPeso.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(comprobarCampos()){
					new CalcularCalorias(textFieldCaloriasRecomendadas,guardarDatosUsuario());
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		//Seleccionar género.
		lblGnero=new JLabel("");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblGnero);
		seleccionarGenero(panelDatos2);
		
		//Seleccionar actividad.
		lblActividadFsica=new JLabel("");
		lblActividadFsica.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblActividadFsica);
		seleccionarActividad(panelDatos2);
		
		//Seleccionar objetivo.
		lblObjetivo=new JLabel("");
		lblObjetivo.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelDatos2.add(lblObjetivo);
		seleccionarObjetivo(panelDatos2);
		
		JPanel panelIdioma = new JPanel();
		panelDatos2.add(panelIdioma);
		panelIdioma.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblEligeIdioma = new JLabel("");
		lblEligeIdioma.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraLabels));
		panelIdioma.add(lblEligeIdioma);
		
		comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.addItem("Castellano");
		comboBoxIdioma.addItem("Ingles");
		//CargarIdioma->Se selecciona el idioma según el archivo Config.properties
		new CargarIdioma(comboBoxIdioma);
		comboBoxIdioma.setActionCommand("comboBoxIdioma");
		comboBoxIdioma.addActionListener(this);
		panelIdioma.add(comboBoxIdioma);
		
		JPanel panelCaloriasRecomendadas = new JPanel();
		panelCaloriasRecomendadas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDatos2.add(panelCaloriasRecomendadas);
		panelCaloriasRecomendadas.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblCalorasRecomendadas = new JLabel();
		lblCalorasRecomendadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelCaloriasRecomendadas.add(lblCalorasRecomendadas);
		
		textFieldCaloriasRecomendadas = new JTextField();
		textFieldCaloriasRecomendadas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCaloriasRecomendadas.setFont(new Font("Tahoma", Font.PLAIN, tamanyoLetraFieldsTexts));
		textFieldCaloriasRecomendadas.setEditable(false);
		panelCaloriasRecomendadas.add(textFieldCaloriasRecomendadas);
		textFieldCaloriasRecomendadas.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		JPanel panelBotonesAtras = new JPanel();
		FlowLayout fl_panelBotonesAtras = (FlowLayout) panelBotonesAtras.getLayout();
		fl_panelBotonesAtras.setVgap(20);
		fl_panelBotonesAtras.setHgap(20);
		fl_panelBotonesAtras.setAlignment(FlowLayout.LEFT);
		panelBotones.add(panelBotonesAtras);
		
		btnAtras = new JButton();
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
		
		btnGuardar = new JButton("");
		panelBoxBotonesGuardar.add(btnGuardar);
		btnGuardar.setActionCommand("CrearUsuarioBtnGuardar");
		btnGuardar.addActionListener(this);
		
		/*Se cargan los textos de la aplicación*/
		cargarNombresLabels();
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
				/*Recargar labels Menu*/
				ventanaPrincipal.menu.cargarNombresLabels();
				ventanaPrincipal.menu.recargarTabla();
				/*Cargar ventana Menu*/
				ventanaPrincipal.cambiapanel("Menu");
				ventanaPrincipal.setTitle("Ever Health- Menu Principal");
				/*Quitar mensaje de error*/
				lblError.setText("");
			}
		}
		if(accio.compareTo("CrearUsuarioBtnGuardar")==0){
			//Comprovem que les dades son correctes
			if(comprobarCampos()){
				if(modoVentana=='c'){
					//Crear usuario
					if(new Consultas(conexio).registrarUsuario(guardarDatosUsuario())){
						/*Se guarda el nombre del usuario dentro de "conexion"*/
						conexio.setUsuario(textFieldNombre.getText());
						/*Recargar labels Menu*/
						ventanaPrincipal.menu.cargarNombresLabels();
						/*Abrir la ventana Menu*/
						ventanaPrincipal.cambiapanel("Menu");
						ventanaPrincipal.setTitle("Ever Health- Menu Principal");
						/*Enviar correo electrónico de bienvenida.*/
						new Email(textFieldCorreo.getText());
					}
				}else{
					//Actualizar usuario
					if(new Consultas(conexio).actualizarUsuario(guardarDatosUsuario())){
						//Abrir la ventana Menu.
						ventanaPrincipal.cambiapanel("Menu");
						ventanaPrincipal.setTitle("Ever Health- Menu Principal");
					}
				}
			}
		}
		if(accio.compareTo("rdbtnMasculino")==0 || accio.compareTo("rdbtnFemenino")==0 || accio.compareTo("rdbtnSedentario")==0 ||
				accio.compareTo("rdbtnLigeramenteActivo")==0 || accio.compareTo("rdbtnActivo")==0 ||
				accio.compareTo("rdbtnAdelgazar")==0 || accio.compareTo("rdbtnMantenerse")==0 || accio.compareTo("rdbtnEngordar")==0){
			if(comprobarCampos()){
				new CalcularCalorias(textFieldCaloriasRecomendadas,guardarDatosUsuario());
			}
		}
		if(accio.compareTo("comboBoxIdioma")==0){
			new CargarIdioma(conexio, comboBoxIdioma.getSelectedItem().toString(), arrayIdioma);
			cargarNombresLabels();
		}
	}
	
	private void seleccionarGenero(JPanel panelDatos2){
		//Grupo de botones para seleccionar el género.
		JPanel panelGenero = new JPanel();
		panelGenero.setBorder(UIManager.getBorder("TextField.border"));
		panelDatos2.add(panelGenero);
		
		rdbtnMasculino = new JRadioButton();
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setActionCommand("rdbtnMasculino");
		rdbtnMasculino.addActionListener(this);
		panelGenero.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton();
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemenino.setActionCommand("rdbtnFemenino");
		rdbtnFemenino.addActionListener(this);
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
		
		rdbtnSedentario = new JRadioButton();
		rdbtnSedentario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnSedentario.setSelected(true);
		rdbtnSedentario.setActionCommand("rdbtnSedentario");
		rdbtnSedentario.addActionListener(this);
		panelActividadFisica.add(rdbtnSedentario);
		
		rdbtnLigeramenteActivo = new JRadioButton();
		rdbtnLigeramenteActivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnLigeramenteActivo.setActionCommand("rdbtnLigeramenteActivo");
		rdbtnLigeramenteActivo.addActionListener(this);
		panelActividadFisica.add(rdbtnLigeramenteActivo);
		
		rdbtnActivo = new JRadioButton();
		rdbtnActivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnActivo.setActionCommand("rdbtnActivo");
		rdbtnActivo.addActionListener(this);
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
		
		rdbtnAdelgazar = new JRadioButton();
		rdbtnAdelgazar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdelgazar.setSelected(true);
		rdbtnAdelgazar.setActionCommand("rdbtnAdelgazar");
		rdbtnAdelgazar.addActionListener(this);
		panelObjetivo.add(rdbtnAdelgazar);
		
		rdbtnMantenerse = new JRadioButton();
		rdbtnMantenerse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMantenerse.setActionCommand("rdbtnMantenerse");
		rdbtnMantenerse.addActionListener(this);
		panelObjetivo.add(rdbtnMantenerse);
		
		rdbtnEngordar = new JRadioButton();
		rdbtnEngordar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnEngordar.setActionCommand("rdbtnEngordar");
		rdbtnEngordar.addActionListener(this);
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
		datosDeUsuario.setEdad(Integer.parseInt(textFieldEdad.getText()));
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
						//Contraseña introducida.
						if(!textFieldEdad.getText().isEmpty() && !textFieldAltura.getText().isEmpty() && !textFieldPeso.getText().isEmpty()){
							if(comprobarNumero(textFieldEdad.getText()) && comprobarNumero(textFieldAltura.getText()) && comprobarNumero(textFieldPeso.getText())){
								//Correcto.
								mensajeError="";
								lblError.setText("");
							}else{
								mensajeError="La edad, el peso o la altura no se han introducido correctamente.";
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
			//Comprobar correo electrónico
			if(textFieldCorreo.getText().isEmpty()){
				mensajeError+=" No se ha introducido ningún correo electrónico.";
			}else{
				if(comprobarCorreo(textFieldCorreo.getText())==false){
					mensajeError+=" El correo electrónico no se ha introducido correctamente.";
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
	private void cargarNombresLabels(){
		lblNombre.setText(arrayIdioma.get(43));
		lblCorreoElectrnico.setText(arrayIdioma.get(44));
		lblPass.setText(arrayIdioma.get(45));
		lblConfirmarPass.setText(arrayIdioma.get(46));
		lblEdad.setText(arrayIdioma.get(47));
		lblAltura.setText(arrayIdioma.get(48));
		lblPeso.setText(arrayIdioma.get(49));
		lblGnero.setText(arrayIdioma.get(50));
		lblActividadFsica.setText(arrayIdioma.get(52));
		lblObjetivo.setText(arrayIdioma.get(51));
		lblEligeIdioma.setText(arrayIdioma.get(62));
		lblCalorasRecomendadas.setText(arrayIdioma.get(61));
		rdbtnMasculino.setText(arrayIdioma.get(53));
		rdbtnFemenino.setText(arrayIdioma.get(54));
		rdbtnSedentario.setText(arrayIdioma.get(58));
		rdbtnLigeramenteActivo.setText(arrayIdioma.get(59));
		rdbtnActivo.setText(arrayIdioma.get(60));
		rdbtnAdelgazar.setText(arrayIdioma.get(55));
		rdbtnMantenerse.setText(arrayIdioma.get(56));
		rdbtnEngordar.setText(arrayIdioma.get(57));
		btnAtras.setText(arrayIdioma.get(63));
		btnGuardar.setText(arrayIdioma.get(64));
	}
	public void cambiarModoVentana(char modoVentana){
		this.modoVentana=modoVentana;
		textFieldNombre.setEditable(false);
		
		//Se cargan los datos desde la base de datos
		ddu=new Consultas(conexio).datosUsuario(conexio.getUsuario());
		textFieldNombre.setText(ddu.getNombre());
		textFieldCorreo.setText(ddu.getEmail());
		passwordField.setText(ddu.getContrasenya());
		passwordFieldConfirmar.setText(ddu.getContrasenya());
		textFieldEdad.setText(String.valueOf(ddu.getEdad()));
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
		}else if(ddu.getObjetivo()==1){
			rdbtnMantenerse.setSelected(true);
		}else{
			rdbtnEngordar.setSelected(true);
		}
		
		//Se calculan las calorias
		new CalcularCalorias(textFieldCaloriasRecomendadas,guardarDatosUsuario());
	}
}
