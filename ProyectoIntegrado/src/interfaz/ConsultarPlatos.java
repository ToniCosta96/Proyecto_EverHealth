package interfaz;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ConsultarPlatos extends JPanel {
	
	Ventanas ventanaPrincipal;
	private JTextField textField;

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
		
		JLabel label = new JLabel("Busqueda Platos:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button = new JButton("Atras");
		button.setForeground(new Color(255, 153, 51));
		button.setBackground(new Color(255, 204, 51));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelCentroConsultaPlatos = new GroupLayout(panelCentroConsultaPlatos);
		gl_panelCentroConsultaPlatos.setHorizontalGroup(
			gl_panelCentroConsultaPlatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentroConsultaPlatos.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelCentroConsultaPlatos.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCentroConsultaPlatos.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panelCentroConsultaPlatos.setVerticalGroup(
			gl_panelCentroConsultaPlatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentroConsultaPlatos.createSequentialGroup()
					.addGroup(gl_panelCentroConsultaPlatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelCentroConsultaPlatos.setLayout(gl_panelCentroConsultaPlatos);
		ventanaPrincipal=v;
	}
}
