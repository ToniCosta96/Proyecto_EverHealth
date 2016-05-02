package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultarAlimentos extends JPanel {
	
	Ventanas ventanaPrincipal;
	private JTextField textField;

	public ConsultarAlimentos(Ventanas v) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTituloConsultaAlimentos = new JPanel();
		panelTituloConsultaAlimentos.setBackground(new Color(255, 255, 102));
		add(panelTituloConsultaAlimentos, BorderLayout.NORTH);
		
		JLabel lblConsultaAlimentos = new JLabel("CONSULTA ALIMENTOS");
		lblConsultaAlimentos.setForeground(new Color(255, 160, 122));
		lblConsultaAlimentos.setFont(new Font("SimSun", Font.BOLD, 18));
		panelTituloConsultaAlimentos.add(lblConsultaAlimentos);
		
		JPanel panelCentroConsultaAlimentos = new JPanel();
		panelCentroConsultaAlimentos.setBackground(new Color(255, 255, 153));
		add(panelCentroConsultaAlimentos, BorderLayout.CENTER);
		panelCentroConsultaAlimentos.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentX(0.0f);
		panelCentroConsultaAlimentos.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(new Color(255, 255, 153));
		panel_2.add(panel_3);
		
		JLabel lblBusquedaAlimentos = new JLabel("Busqueda Alimentos:");
		lblBusquedaAlimentos.setHorizontalTextPosition(SwingConstants.LEFT);
		lblBusquedaAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblBusquedaAlimentos);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setAlignmentX(0.0f);
		panel_3.add(textField);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setBackground(new Color(255, 255, 153));
		panel_2.add(panel_4);
		
		JButton button = new JButton("Atras");
		button.setForeground(new Color(255, 153, 51));
		button.setBackground(new Color(255, 204, 51));
		button.setAlignmentX(1.0f);
		panel_4.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 204));
		panelCentroConsultaAlimentos.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 204));
		panel_5.add(scrollPane);
		ventanaPrincipal=v;
	}

}