package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BDD.Conexio;


public class ConsultarPlatos extends JPanel {
	
	private Ventanas ventanaPrincipal;
	private Conexio conexio;
	private JTextField textFieldBusqueda;
	private JTable table;

	public ConsultarPlatos(Ventanas v,Conexio conexio) {
		ventanaPrincipal=v;
		this.conexio=conexio;
		
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
		panelBusqueda.setLayout(new GridLayout(0, 2, 0, 0));
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		FlowLayout fl_panel_2 = (FlowLayout) panel_2.getLayout();
		fl_panel_2.setAlignment(FlowLayout.RIGHT);
		panelBusqueda.add(panel_2);
		
		JButton buttonAtras = new JButton("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.cambiapanel("Menu");
				
			}
		});
		panel_2.add(buttonAtras);
		buttonAtras.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buttonAtras.setForeground(new Color(255, 153, 51));
		buttonAtras.setBackground(new Color(255, 204, 51));
		panelCentroConsultaPlatos.setLayout(new BorderLayout(0, 0));
		panelScroll.setLayout(new GridLayout(0, 1, 0, 0));
		panelCentroConsultaPlatos.add(panelScroll, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 204));
		panelScroll.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(table);
		panelCentroConsultaPlatos.add(panelBusqueda, BorderLayout.NORTH);
	}
}
