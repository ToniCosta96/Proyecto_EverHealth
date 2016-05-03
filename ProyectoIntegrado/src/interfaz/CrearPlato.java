package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CrearPlato extends JPanel {
	private JTextField txtCaloriasRestantes;
	Ventanas ventanaPrincipal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNombreDelPlato;

	public CrearPlato(Ventanas v) {
		setForeground(Color.ORANGE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(255, 228, 181));
		panelSuperior.setForeground(Color.BLACK);
		add(panelSuperior, BorderLayout.NORTH);
		
		txtNombreDelPlato = new JTextField();
		txtNombreDelPlato.setForeground(new Color(255, 69, 0));
		txtNombreDelPlato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreDelPlato.setBackground(new Color(245, 222, 179));
		txtNombreDelPlato.setText("Nombre del plato");
		panelSuperior.add(txtNombreDelPlato);
		txtNombreDelPlato.setColumns(10);
		
		JLabel CaloriasTotales = new JLabel("Total Calorias");
		CaloriasTotales.setForeground(new Color(139, 0, 0));
		panelSuperior.add(CaloriasTotales);
		
		JPanel Añadir_Ingrediente = new JPanel();
		Añadir_Ingrediente.setBackground(new Color(255, 140, 0));
		add(Añadir_Ingrediente, BorderLayout.CENTER);
		GridBagLayout gbl_Añadir_Ingrediente = new GridBagLayout();
		gbl_Añadir_Ingrediente.columnWidths = new int[]{0, 0, 0, 0};
		gbl_Añadir_Ingrediente.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Añadir_Ingrediente.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Añadir_Ingrediente.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Añadir_Ingrediente.setLayout(gbl_Añadir_Ingrediente);
		
		JLabel Cantidad = new JLabel("Cantidad");
		Cantidad.setForeground(new Color(255, 255, 0));
		GridBagConstraints gbc_Cantidad = new GridBagConstraints();
		gbc_Cantidad.insets = new Insets(0, 0, 5, 5);
		gbc_Cantidad.anchor = GridBagConstraints.WEST;
		gbc_Cantidad.gridx = 0;
		gbc_Cantidad.gridy = 1;
		Añadir_Ingrediente.add(Cantidad, gbc_Cantidad);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		Añadir_Ingrediente.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrediente");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		Añadir_Ingrediente.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		Añadir_Ingrediente.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAadir = new JLabel("+ A\u00F1adir");
		lblAadir.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblAadir = new GridBagConstraints();
		gbc_lblAadir.anchor = GridBagConstraints.WEST;
		gbc_lblAadir.insets = new Insets(0, 0, 5, 5);
		gbc_lblAadir.gridx = 1;
		gbc_lblAadir.gridy = 3;
		Añadir_Ingrediente.add(lblAadir, gbc_lblAadir);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		Añadir_Ingrediente.add(scrollPane, gbc_scrollPane);
		
		JButton BotonAtras = new JButton("Atras");
		GridBagConstraints gbc_BotonAtras = new GridBagConstraints();
		gbc_BotonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_BotonAtras.gridx = 0;
		gbc_BotonAtras.gridy = 8;
		BotonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		Añadir_Ingrediente.add(BotonAtras, gbc_BotonAtras);
		
		JButton Guardar = new JButton("Guardar");
		GridBagConstraints gbc_Guardar = new GridBagConstraints();
		gbc_Guardar.insets = new Insets(0, 0, 5, 5);
		gbc_Guardar.gridx = 1;
		gbc_Guardar.gridy = 8;
		Añadir_Ingrediente.add(Guardar, gbc_Guardar);
		ventanaPrincipal=v;
		
		
	}

}