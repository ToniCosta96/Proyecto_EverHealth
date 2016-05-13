package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BDD.Consultas;
import BDD.Conexio;
import javax.swing.BoxLayout;

public class CrearPlato extends JPanel {
	
	private Conexio conexio;
	private Ventanas ventanaPrincipal;
	private JTextField textFieldBusqueda;
	public DefaultTableModel dtm;
	public JTable tablaAlimentos;
	private JTextField textFieldTituloCrearPlato;

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
		textFieldTituloCrearPlato.setSelectedTextColor(new Color(255, 255, 51));
		textFieldTituloCrearPlato.setForeground(new Color(255, 153, 102));
		textFieldTituloCrearPlato.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloCrearPlato.add(textFieldTituloCrearPlato);
		textFieldTituloCrearPlato.setColumns(10);
		
		JPanel panelCentroCrearPlato = new JPanel();
		panelCentroCrearPlato.setBackground(new Color(255, 255, 153));
		add(panelCentroCrearPlato, BorderLayout.CENTER);
		panelCentroCrearPlato.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setAlignmentX(0.0f);
		panelCentroCrearPlato.add(panelBusqueda, BorderLayout.NORTH);
		panelBusqueda.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout fl_panel_1 = (FlowLayout) panel_1.getLayout();
		fl_panel_1.setVgap(10);
		fl_panel_1.setHgap(50);
		fl_panel_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(new Color(255, 255, 153));
		panelBusqueda.add(panel_1);
		
		JLabel lblBusquedaAlimentos = new JLabel("Busqueda Alimentos:");
		lblBusquedaAlimentos.setHorizontalTextPosition(SwingConstants.LEFT);
		lblBusquedaAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblBusquedaAlimentos);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setColumns(10);
		textFieldBusqueda.setAlignmentX(0.0f);
		panel_1.add(textFieldBusqueda);
		
		JPanel panel_2 = new JPanel();
		FlowLayout fl_panel_2 = (FlowLayout) panel_2.getLayout();
		fl_panel_2.setVgap(10);
		fl_panel_2.setHgap(50);
		fl_panel_2.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(new Color(255, 255, 153));
		panelBusqueda.add(panel_2);
		
		JPanel panelScroll = new JPanel();
		panelScroll.setBackground(new Color(255, 255, 204));
		panelCentroCrearPlato.add(panelScroll, BorderLayout.CENTER);
		panelScroll.setLayout(new GridLayout(2, 1, 10, 5));
		
		
		
		JButton btnBusqueda = new JButton("Buscar");
		btnBusqueda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				cargarAlimentos(panelScroll);
		        
				
				
				
			}
		});
		panel_2.add(btnBusqueda);
		
		JButton buttonAtras = new JButton("Atras");
		buttonAtras.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.cambiapanel("Menu");				
			}
		});
		
		buttonAtras.setForeground(new Color(255, 153, 51));
		buttonAtras.setBackground(new Color(255, 204, 51));
		buttonAtras.setAlignmentX(1.0f);
		panel_2.add(buttonAtras);
		
		ventanaPrincipal=v;
		cargarAlimentos(panelScroll);
		
		JPanel panel = new JPanel();
		panelScroll.add(panel);
		
		JLabel lblBordeIzquierdo = new JLabel("                          ");
		panelCentroCrearPlato.add(lblBordeIzquierdo, BorderLayout.WEST);
		
		JPanel panelBordeDerecho = new JPanel();
		panelBordeDerecho.setOpaque(false);
		panelCentroCrearPlato.add(panelBordeDerecho, BorderLayout.EAST);
		panelBordeDerecho.setLayout(new BoxLayout(panelBordeDerecho, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panelBordeDerecho.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 5));
		
		JButton btnAnyadir = new JButton("A\u00F1adir");
		panel_3.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		
		JLabel lblBordeDerecho = new JLabel("   ");
		panelBordeDerecho.add(lblBordeDerecho);
		
	}
	private void cargarAlimentos(JPanel panelScroll){
		panelScroll.removeAll();
		dtm=new DefaultTableModel();
		dtm.addColumn("Alimento");
		dtm.addColumn("Kcal");
		
		
		Consultas cons=new Consultas(conexio);
		cons.consultarAlimentos();
		cons.consultarDades(textFieldBusqueda.getText(),dtm);
		
		tablaAlimentos=new JTable(dtm);	
		tablaAlimentos.setBackground(new Color(255, 255, 200));
		
		JScrollPane scrollPaneAlimentos = new JScrollPane(tablaAlimentos);
		scrollPaneAlimentos.setBackground(new Color(255, 255, 220));
		panelScroll.add(scrollPaneAlimentos);
		panelScroll.updateUI();
	}

}