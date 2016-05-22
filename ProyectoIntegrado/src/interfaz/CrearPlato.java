package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BDD.Conexio;
import BDD.Consultas;
import javax.swing.JComboBox;

public class CrearPlato extends JPanel {
	
	private Conexio conexio;
	private Ventanas ventanaPrincipal;
	private JTextField textFieldBusqueda;
	public DefaultTableModel dtm;
	public DefaultTableModel dtm2;
	public JTable tablaAlimentos;
	private JTextField textFieldTituloCrearPlato;
	private JTable tablaIngredientes;
	private JTextField textFieldCantidad;
	private JTextField textFieldCaloriasTotales;

	public CrearPlato(Ventanas v, Conexio conexio) {
		this.conexio=conexio;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTituloCrearPlato = new JPanel();
		panelTituloCrearPlato.setBackground(new Color(255, 255, 102));
		add(panelTituloCrearPlato, BorderLayout.NORTH);
		
		JLabel lblTituloCrearPlato = new JLabel("PLATO:");
		lblTituloCrearPlato.setForeground(new Color(255, 160, 122));
		lblTituloCrearPlato.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(lblTituloCrearPlato);
		
		textFieldTituloCrearPlato = new JTextField();
		textFieldTituloCrearPlato.setBackground(new Color(255, 255, 153));
		textFieldTituloCrearPlato.setSelectedTextColor(new Color(255, 255, 51));
		textFieldTituloCrearPlato.setForeground(new Color(255, 153, 102));
		textFieldTituloCrearPlato.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(textFieldTituloCrearPlato);
		textFieldTituloCrearPlato.setColumns(10);
		
		JLabel labelTipo = new JLabel("TIPO:");
		labelTipo.setForeground(new Color(255, 160, 122));
		labelTipo.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(labelTipo);
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
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
		
		
		JPanel panelScroll = new JPanel();
		panelScroll.setBackground(new Color(255, 255, 153));
		panelCentroCrearPlato.add(panelScroll, BorderLayout.CENTER);
		
		ventanaPrincipal=v;
		
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
		
		JButton btnAnyadir = new JButton("A\u00F1adir");
		
		panel_3.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		
		JLabel lblBordeDerecho = new JLabel("   ");
		panelBordeDerecho.add(lblBordeDerecho);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
		
		JPanel panelAlimentos = new JPanel();
		panelScroll.add(panelAlimentos);
		panelAlimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneAlimentos = new JScrollPane(tablaAlimentos);
		panelAlimentos.add(scrollPaneAlimentos);
		scrollPaneAlimentos.setBackground(new Color(255, 255, 220));
		
		JLabel lblIngredientes = new JLabel("Ingredientes del plato:");
		lblIngredientes.setFont(new Font("SimSun", Font.ITALIC, 18));
		lblIngredientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIngredientes.setHorizontalAlignment(SwingConstants.LEFT);
		panelScroll.add(lblIngredientes);
		dtm2=new DefaultTableModel();
		dtm2.addColumn("Alimento");
		dtm2.addColumn("Cantidad(g)");
		dtm2.addColumn("Kcal");
		
		
		panelBusqueda.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		JLabel labelEspacio = new JLabel("          ");
		panelBusqueda.add(labelEspacio);
		
		JLabel lblBusquedaAlimentos = new JLabel("Busqueda Alimentos:");
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
		
		JButton btnBusqueda = new JButton("Buscar");
		panelBusqueda.add(btnBusqueda);
		
		JLabel lblCantidadgramos = new JLabel("Cantidad(gramos):");
		panelBusqueda.add(lblCantidadgramos);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setText("100");
		panelBusqueda.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JPanel panelCaloriasTotales = new JPanel();
		panelCaloriasTotales.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panelCaloriasTotales.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelScroll.add(panelCaloriasTotales);
		
		JLabel lblCaloriasTotales = new JLabel("Calorias Totales:");
		panelCaloriasTotales.add(lblCaloriasTotales);
		
		textFieldCaloriasTotales = new JTextField();
		textFieldCaloriasTotales.setEditable(false);
		panelCaloriasTotales.add(textFieldCaloriasTotales);
		textFieldCaloriasTotales.setColumns(10);
		
		btnBusqueda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				cargarAlimentos(panelScroll,panelAlimentos);
				
				
				
			}
		});
		
		btnAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tablaAlimentos.getSelectedRowCount()==1){
					//System.out.println(dtm.getValueAt(tablaAlimentos.getSelectedRow(),0));
					Object [] ingrediente=new Object[]{dtm.getValueAt(tablaAlimentos.getSelectedRow(), 0),textFieldCantidad.getText(),(float)(Integer.parseInt(String.valueOf(dtm.getValueAt(tablaAlimentos.getSelectedRow(), 1)))* Integer.parseInt(textFieldCantidad.getText())/100f)};
					dtm2.addRow(ingrediente);
					float caloriasTotales=0;
					for(int i=0;i<tablaIngredientes.getRowCount();i++){
						caloriasTotales+=Float.parseFloat(String.valueOf(tablaIngredientes.getValueAt(i, 2)));
					}
					textFieldCaloriasTotales.setText(String.valueOf(caloriasTotales));
					panelIngredientes.updateUI();
				}
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tablaIngredientes.getSelectedRowCount()==1){
					//System.out.println(dtm.getValueAt(tablaAlimentos.getSelectedRow(),0));
					;
					dtm2.removeRow(tablaIngredientes.getSelectedRow());
					float caloriasTotales=0;
					for(int i=0;i<tablaIngredientes.getRowCount();i++){
						caloriasTotales+=Float.parseFloat(String.valueOf(tablaIngredientes.getValueAt(i, 2)));
					}
					textFieldCaloriasTotales.setText(String.valueOf(caloriasTotales));
					panelIngredientes.updateUI();
				}
			}
		});
		
		JPanel panelBordeInferior = new JPanel();
		panelBordeInferior.setBackground(new Color(255, 255, 153));
		panelCentroCrearPlato.add(panelBordeInferior, BorderLayout.SOUTH);
		panelBordeInferior.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelAtras = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAtras.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelAtras.setOpaque(false);
		panelBordeInferior.add(panelAtras);
		
		JButton buttonAtras = new JButton("Atras");
		panelAtras.add(buttonAtras);
		buttonAtras.setHorizontalAlignment(SwingConstants.LEFT);
		buttonAtras.setForeground(new Color(255, 153, 51));
		buttonAtras.setBackground(new Color(255, 204, 51));
		buttonAtras.setAlignmentX(1.0f);
		buttonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		
		JPanel panelGuardar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelGuardar.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelGuardar.setOpaque(false);
		panelBordeInferior.add(panelGuardar);
		
		JButton buttonGuardar = new JButton("Guardar");
		buttonGuardar.setForeground(new Color(255, 153, 51));
		buttonGuardar.setBackground(new Color(255, 204, 51));
		buttonGuardar.setAlignmentX(1.0f);
		buttonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
			}
		});
		panelGuardar.add(buttonGuardar);
		
		
		
		
		cargarAlimentos(panelScroll,panelAlimentos);

	}
	private void cargarAlimentos(JPanel panelScroll,JPanel panelAlimentos){
		panelAlimentos.removeAll();
		dtm=new DefaultTableModel();
		dtm.addColumn("Alimento");
		dtm.addColumn("Kcal (100g)");
		
		
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

}