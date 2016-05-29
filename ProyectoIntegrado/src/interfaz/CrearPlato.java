package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BDD.Conexio;
import BDD.Consultas;

public class CrearPlato extends JPanel implements ActionListener{
	
	private Conexio conexio;
	private ArrayList<String> arrayIdioma;
	private Ventanas ventanaPrincipal;
	private JTextField textFieldBusqueda;
	private DiaPlanificacion dia[];
	public DefaultTableModel dtm;
	public DefaultTableModel dtm2;
	public JTable tablaAlimentos;
	private JPanel panelScroll;
	private JPanel panelAlimentos;
	private JTextField textFieldTituloCrearPlato;
	private JTable tablaIngredientes;
	private JTextField textFieldCantidad;
	private JTextField textFieldCaloriasTotales;
	private JComboBox<String> comboBoxTipo;
	private JLabel lblTituloCrearPlato;
	private JLabel labelTipo;
	private JLabel lblBusquedaAlimentos;
	private JButton btnAnyadir;
	private JButton btnBusqueda;
	private JLabel lblCaloriasTotales;
	private JLabel lblIngredientes;
	private JButton btnEliminar;
	private JButton buttonAtras;
	private JButton buttonGuardar;
	
	private String textoAnterior;

	public CrearPlato(Ventanas v, Conexio conexio, ArrayList<String> arrayIdioma, DiaPlanificacion dia[]) {
		ventanaPrincipal=v;
		this.conexio=conexio;
		this.arrayIdioma=arrayIdioma;
		this.dia=dia;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTituloCrearPlato = new JPanel();
		panelTituloCrearPlato.setBackground(new Color(255, 255, 102));
		add(panelTituloCrearPlato, BorderLayout.NORTH);
		
		lblTituloCrearPlato = new JLabel();
		lblTituloCrearPlato.setForeground(new Color(255, 160, 122));
		lblTituloCrearPlato.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(lblTituloCrearPlato);
		
		textFieldTituloCrearPlato = new JTextField();
		textFieldTituloCrearPlato.setBackground(new Color(255, 255, 153));
		textFieldTituloCrearPlato.setSelectedTextColor(new Color(255, 255, 51));
		textFieldTituloCrearPlato.setForeground(new Color(255, 153, 102));
		textFieldTituloCrearPlato.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(textFieldTituloCrearPlato);
		textFieldTituloCrearPlato.setColumns(15);
		
		labelTipo = new JLabel();
		labelTipo.setForeground(new Color(255, 160, 122));
		labelTipo.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(labelTipo);
		
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBackground(new Color(255, 255, 153));
		comboBoxTipo.addItem("Desayuno");
		comboBoxTipo.addItem("Almuerzo");
		comboBoxTipo.addItem("Comida");
		comboBoxTipo.addItem("Merienda");
		comboBoxTipo.addItem("Cena");
		
		panelTituloCrearPlato.add(comboBoxTipo);
		
		JPanel panelCentroCrearPlato = new JPanel();
		panelCentroCrearPlato.setBackground(new Color(255, 255, 153));
		add(panelCentroCrearPlato, BorderLayout.CENTER);
		panelCentroCrearPlato.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setOpaque(false);
		panelCentroCrearPlato.add(panelBusqueda, BorderLayout.NORTH);
		
		
		panelScroll = new JPanel();
		panelScroll.setBackground(new Color(255, 255, 153));
		panelCentroCrearPlato.add(panelScroll, BorderLayout.CENTER);
		
		JLabel lblBordeIzquierdo = new JLabel("                ");
		lblBordeIzquierdo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCentroCrearPlato.add(lblBordeIzquierdo, BorderLayout.WEST);
		
		JPanel panelBordeDerecho = new JPanel();
		panelBordeDerecho.setOpaque(false);
		panelCentroCrearPlato.add(panelBordeDerecho, BorderLayout.EAST);
		panelBordeDerecho.setLayout(new BoxLayout(panelBordeDerecho, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panelBordeDerecho.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 20));
		
		btnAnyadir = new JButton();
		
		panel_3.add(btnAnyadir);
		
		btnEliminar = new JButton();
		panel_3.add(btnEliminar);
		
		JLabel lblBordeDerecho = new JLabel("   ");
		panelBordeDerecho.add(lblBordeDerecho);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
		
		panelAlimentos = new JPanel();
		panelScroll.add(panelAlimentos);
		panelAlimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneAlimentos = new JScrollPane(tablaAlimentos);
		panelAlimentos.add(scrollPaneAlimentos);
		scrollPaneAlimentos.setBackground(new Color(255, 255, 220));
		
		lblIngredientes = new JLabel();
		lblIngredientes.setFont(new Font("SimSun", Font.ITALIC, 18));
		lblIngredientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIngredientes.setHorizontalAlignment(SwingConstants.LEFT);
		panelScroll.add(lblIngredientes);
		dtm2=new DefaultTableModel();
		dtm2.addColumn(arrayIdioma.get(75));
		dtm2.addColumn(arrayIdioma.get(76));
		dtm2.addColumn(arrayIdioma.get(77));
		
		
		panelBusqueda.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		JLabel labelEspacio = new JLabel("          ");
		panelBusqueda.add(labelEspacio);
		
		lblBusquedaAlimentos = new JLabel();
		panelBusqueda.add(lblBusquedaAlimentos);
		lblBusquedaAlimentos.setHorizontalTextPosition(SwingConstants.LEFT);
		lblBusquedaAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFieldBusqueda = new JTextField();
		panelBusqueda.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		textFieldBusqueda.setAlignmentX(0.0f);
		
		JPanel panelIngredientes = new JPanel();
		panelScroll.add(panelIngredientes);
		panelIngredientes.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JScrollPane scrollPaneIngredientes = new JScrollPane();
		panelIngredientes.add(scrollPaneIngredientes);
		tablaIngredientes = new JTable(dtm2);
		tablaIngredientes.setBackground(new Color(255, 255, 153));
		scrollPaneIngredientes.setViewportView(tablaIngredientes);
		
		btnBusqueda = new JButton();
		panelBusqueda.add(btnBusqueda);
		
		JLabel lblCantidadgramos = new JLabel("Cantidad(gramos):");
		panelBusqueda.add(lblCantidadgramos);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setText("100");
		panelBusqueda.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		textoAnterior=textFieldCantidad.getText();
		textFieldCantidad.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldCantidad.getText().isEmpty() || !comprovarFloat(textFieldCantidad.getText())){
					textFieldCantidad.setText(textoAnterior);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(comprovarFloat(textFieldCantidad.getText())){
					textoAnterior=textFieldCantidad.getText();
				}
			}
		});
		
		JPanel panelCaloriasTotales = new JPanel();
		panelCaloriasTotales.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panelCaloriasTotales.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelScroll.add(panelCaloriasTotales);
		
		lblCaloriasTotales = new JLabel();
		panelCaloriasTotales.add(lblCaloriasTotales);
		
		textFieldCaloriasTotales = new JTextField();
		textFieldCaloriasTotales.setEditable(false);
		panelCaloriasTotales.add(textFieldCaloriasTotales);
		textFieldCaloriasTotales.setColumns(10);
		
		btnBusqueda.addActionListener(this);
		btnBusqueda.setActionCommand("btnBusqueda");
		
		btnAnyadir.addActionListener(this);
		btnAnyadir.setActionCommand("btnAnyadir");
		
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("btnEliminar");
		
		JPanel panelBordeInferior = new JPanel();
		panelBordeInferior.setBackground(new Color(255, 255, 153));
		panelCentroCrearPlato.add(panelBordeInferior, BorderLayout.SOUTH);
		panelBordeInferior.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelAtras = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAtras.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelAtras.setOpaque(false);
		panelBordeInferior.add(panelAtras);
		
		buttonAtras = new JButton();
		panelAtras.add(buttonAtras);
		buttonAtras.setHorizontalAlignment(SwingConstants.LEFT);
		buttonAtras.setForeground(new Color(255, 153, 51));
		buttonAtras.setBackground(new Color(255, 204, 51));
		buttonAtras.setAlignmentX(1.0f);
		buttonAtras.addActionListener(this);
		buttonAtras.setActionCommand("buttonAtras");
		
		JPanel panelGuardar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelGuardar.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelGuardar.setOpaque(false);
		panelBordeInferior.add(panelGuardar);
		
		buttonGuardar = new JButton();
		buttonGuardar.setForeground(new Color(255, 153, 51));
		buttonGuardar.setBackground(new Color(255, 204, 51));
		buttonGuardar.setAlignmentX(1.0f);
		buttonGuardar.addActionListener(this);
		buttonGuardar.setActionCommand("buttonGuardar");
		panelGuardar.add(buttonGuardar);
		
		
		/*Cargar labels y cargar los alimentos*/
		cargarLabels();
		cargarAlimentos();

	}
	private void cargarAlimentos(){
		panelAlimentos.removeAll();
		dtm=new DefaultTableModel();
		dtm.addColumn(arrayIdioma.get(73));
		dtm.addColumn(arrayIdioma.get(74));
		
		
		Consultas cons=new Consultas(conexio);
		cons.consultarAlimentos();
		cons.consultarDades(textFieldBusqueda.getText(),dtm);
		
		tablaAlimentos=new JTable(dtm);	
		tablaAlimentos.setBackground(new Color(255, 255, 200));
		
		JScrollPane scrollPaneAlimentos = new JScrollPane(tablaAlimentos);
		scrollPaneAlimentos.setBackground(new Color(255, 255, 220));
		panelAlimentos.add(scrollPaneAlimentos, 0);
		panelScroll.updateUI();
	}
	private void recargarPanel(){
		textFieldTituloCrearPlato.setText("");
		comboBoxTipo.setSelectedIndex(0);
		textFieldBusqueda.setText("");
		cargarAlimentos();
		textFieldCantidad.setText("100");
		int CantidadFilas=tablaIngredientes.getRowCount();
		for(int i=0;i<CantidadFilas;i++){
			dtm2.removeRow(0);
		}
		textFieldCaloriasTotales.setText("");
	}
	public void cargarLabels(){
		lblTituloCrearPlato.setText(arrayIdioma.get(68));
		labelTipo.setText(arrayIdioma.get(69));
		lblBusquedaAlimentos.setText(arrayIdioma.get(70));
		btnBusqueda.setText(arrayIdioma.get(71));
		btnAnyadir.setText(arrayIdioma.get(78));
		btnEliminar.setText(arrayIdioma.get(79));
		lblIngredientes.setText(arrayIdioma.get(75));
		lblCaloriasTotales.setText(arrayIdioma.get(80));
		buttonAtras.setText(arrayIdioma.get(81));
		buttonGuardar.setText(arrayIdioma.get(82));
		/*Se cambia el nombre de las columnas*/
		try{
			int numeroColumnas=tablaIngredientes.getColumnCount();
			for(int i=0;i<numeroColumnas;i++){
				tablaIngredientes.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(arrayIdioma.get(75+i));
			}
			numeroColumnas=tablaAlimentos.getColumnCount();
			for(int i=0;i<numeroColumnas;i++){
				tablaAlimentos.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(arrayIdioma.get(73+i));
			}
		}catch(NullPointerException npe){
		}
	}
	private boolean comprovarFloat(String numero){
		try{
			Float.parseFloat(numero);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String accio= e.getActionCommand();
		if(accio.compareTo("btnBusqueda")==0){
			cargarAlimentos();
		}else if(accio.compareTo("btnAnyadir")==0){
			if(tablaAlimentos.getSelectedRowCount()==1){
				//System.out.println(dtm.getValueAt(tablaAlimentos.getSelectedRow(),0));
				Object [] ingrediente=new Object[]{dtm.getValueAt(tablaAlimentos.getSelectedRow(), 0),textFieldCantidad.getText(),(float)(Integer.parseInt(String.valueOf(dtm.getValueAt(tablaAlimentos.getSelectedRow(), 1)))* Integer.parseInt(textFieldCantidad.getText())/100f)};
				dtm2.addRow(ingrediente);
				float caloriasTotales=0;
				for(int i=0;i<tablaIngredientes.getRowCount();i++){
					caloriasTotales+=Float.parseFloat(String.valueOf(tablaIngredientes.getValueAt(i, 2)));
				}
				textFieldCaloriasTotales.setText(String.valueOf(caloriasTotales));
			}
		}else if(accio.compareTo("btnEliminar")==0){
			if(tablaIngredientes.getSelectedRowCount()==1){
				//System.out.println(dtm.getValueAt(tablaAlimentos.getSelectedRow(),0));
				;
				dtm2.removeRow(tablaIngredientes.getSelectedRow());
				float caloriasTotales=0;
				for(int i=0;i<tablaIngredientes.getRowCount();i++){
					caloriasTotales+=Float.parseFloat(String.valueOf(tablaIngredientes.getValueAt(i, 2)));
				}
				textFieldCaloriasTotales.setText(String.valueOf(caloriasTotales));
			}
		}else if(accio.compareTo("buttonAtras")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("buttonGuardar")==0){
			String [] ingredientes=new String[tablaIngredientes.getRowCount()];
			for(int i=0;i<tablaIngredientes.getRowCount();i++){
				ingredientes[i]=(String) tablaIngredientes.getValueAt(i, 0);
				System.out.println(ingredientes[i]);
			}
			
			int [] cantidades=new int[tablaIngredientes.getRowCount()];
			for(int i=0;i<tablaIngredientes.getRowCount();i++){
				cantidades[i]=Integer.parseInt((String)tablaIngredientes.getValueAt(i, 1));
				System.out.println(cantidades[i]);
			}
			Consultas cons=new Consultas(conexio);
			cons.registrarPlato(textFieldTituloCrearPlato.getText(), String.valueOf(comboBoxTipo.getSelectedItem()),ingredientes,cantidades);
			//Carrega el plat en Planificación
			new Consultas(conexio).rellenarComboBox(dia, null);
			//Cambia al Menu.
			ventanaPrincipal.cambiapanel("Menu");
			//Resetea la informacion del panel.
			recargarPanel();
		}
	}

}