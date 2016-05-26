package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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


public class ConsultarPlatos extends JPanel {
	
	private Ventanas ventanaPrincipal;
	private Conexio conexio;
	private JTextField textFieldBusqueda;
	private JTable tablePlatos;
	private JTable tableIngredientes;
	DefaultTableModel dtmPla;
	DefaultTableModel dtmIng;
	Consultas cons;
	JPanel panelScrollPlatos;
	public ConsultarPlatos(Ventanas v,Conexio conexio) {
		ventanaPrincipal=v;
		this.conexio=conexio;
		cons=new Consultas(conexio);
		
		setBackground(new Color(255, 255, 153));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTituloConsultaPlatos = new JPanel();
		panelTituloConsultaPlatos.setBackground(new Color(255, 255, 102));
		add(panelTituloConsultaPlatos, BorderLayout.NORTH);
		
		JLabel lblConsultaPlatos = new JLabel("CONSULTA PLATOS");
		lblConsultaPlatos.setForeground(new Color(255, 160, 122));
		lblConsultaPlatos.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloConsultaPlatos.add(lblConsultaPlatos);
		
		JPanel panelCentroConsultaPlatos = new JPanel();
		panelCentroConsultaPlatos.setBackground(new Color(255, 255, 153));
		add(panelCentroConsultaPlatos, BorderLayout.CENTER);
		
		JPanel panelScroll = new JPanel();
		panelScroll.setBackground(new Color(255, 255, 204));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelBusqueda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		FlowLayout fl_panel_1 = (FlowLayout) panel_1.getLayout();
		fl_panel_1.setAlignment(FlowLayout.LEFT);
		panelBusqueda.add(panel_1);
		
		JLabel labelBusqueda = new JLabel("Busqueda Platos:");
		labelBusqueda.setFont(new Font("SimSun", Font.PLAIN, 11));
		panel_1.add(labelBusqueda);
		labelBusqueda.setHorizontalTextPosition(SwingConstants.LEFT);
		labelBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFieldBusqueda = new JTextField();
		panel_1.add(textFieldBusqueda);
		textFieldBusqueda.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldBusqueda.setColumns(10);
		
		JButton buttonBuscar = new JButton("Buscar");
		panel_1.add(buttonBuscar);
		buttonBuscar.setForeground(new Color(255, 153, 51));
		buttonBuscar.setBackground(new Color(255, 204, 51));
		buttonBuscar.setAlignmentX(1.0f);
		panelCentroConsultaPlatos.setLayout(new BorderLayout(0, 0));
		panelScroll.setLayout(new GridLayout(0, 2, 0, 0));
		panelCentroConsultaPlatos.add(panelScroll, BorderLayout.CENTER);
		
		panelScrollPlatos = new JPanel();
		panelScroll.add(panelScrollPlatos);
		panelScrollPlatos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPanePlatos = new JScrollPane();
		panelScrollPlatos.add(scrollPanePlatos);
		scrollPanePlatos.setBackground(new Color(255, 255, 204));
		
		dtmPla = new DefaultTableModel();
		dtmPla.addColumn("Plato");
		dtmPla.addColumn("Calorias del plato");
		dtmPla.addColumn("Propietario");
		tablePlatos = new JTable(dtmPla);
		tablePlatos.setBackground(new Color(255, 255, 204));
		scrollPanePlatos.setViewportView(tablePlatos);
		
		JPanel panelScrollIngredientes = new JPanel();
		panelScroll.add(panelScrollIngredientes);
		panelScrollIngredientes.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneIngredientes = new JScrollPane();
		scrollPaneIngredientes.setBackground(new Color(255, 255, 204));
		panelScrollIngredientes.add(scrollPaneIngredientes);
		
		dtmIng = new DefaultTableModel();
		dtmIng.addColumn("Ingrediente");
		dtmIng.addColumn("Cantidad(g)");
		dtmIng.addColumn("Kcal");
		tableIngredientes = new JTable(dtmIng);
		tableIngredientes.setBackground(new Color(255, 255, 204));
		scrollPaneIngredientes.setViewportView(tableIngredientes);
		panelCentroConsultaPlatos.add(panelBusqueda, BorderLayout.NORTH);
		
		JPanel panelAtras = new JPanel();
		FlowLayout fl_panelAtras = (FlowLayout) panelAtras.getLayout();
		fl_panelAtras.setVgap(20);
		fl_panelAtras.setHgap(20);
		fl_panelAtras.setAlignment(FlowLayout.LEFT);
		panelAtras.setBackground(new Color(255, 255, 153));
		add(panelAtras, BorderLayout.SOUTH);
		
		JButton buttonAtras = new JButton("Atras");
		buttonAtras.setForeground(new Color(255, 153, 51));
		buttonAtras.setBackground(new Color(255, 204, 51));
		buttonAtras.setAlignmentX(1.0f);
		panelAtras.add(buttonAtras);
		
		buttonAtras.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		
		JLabel lblBordeIzquierda = new JLabel("          ");
		add(lblBordeIzquierda, BorderLayout.WEST);
		
		JLabel lblBordeDerecha = new JLabel("          ");
		add(lblBordeDerecha, BorderLayout.EAST);
		
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int numFilas=dtmPla.getRowCount();
				for(int i=0;i<numFilas;i++){
					dtmPla.removeRow(0);
				}
				cargarPlatos();
			}
		});
		tablePlatos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int numFilas=dtmIng.getRowCount();
				for(int i=0;i<numFilas;i++){
					dtmIng.removeRow(0);
				}
				cargarIngredientes();
			}
		});
		cargarPlatos();
	}
	
	public void cargarPlatos(){
		cons.consultarPlatos(textFieldBusqueda.getText(),dtmPla);
		//panelScrollPlatos.updateUI();
	}
	public void cargarIngredientes(){
		cons.consultarIngredientes(tablePlatos.getValueAt(tablePlatos.getSelectedRow(), 0).toString(),dtmIng);
	}
}
