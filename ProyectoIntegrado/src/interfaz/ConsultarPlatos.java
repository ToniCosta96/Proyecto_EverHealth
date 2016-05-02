package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ConsultarPlatos extends JPanel {
	
	Ventanas ventanaPrincipal;
	private JTextField textField;
	private JTable table;

	public ConsultarPlatos(Ventanas v) {
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 153));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelBusqueda.add(panel_2);
		
		JLabel label = new JLabel("Busqueda Platos:");
		panel_2.add(label);
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelBusqueda.add(panel_1);
		
		JButton button = new JButton("Atras");
		panel_1.add(button);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setForeground(new Color(255, 153, 51));
		button.setBackground(new Color(255, 204, 51));
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
		ventanaPrincipal=v;
	}
}
