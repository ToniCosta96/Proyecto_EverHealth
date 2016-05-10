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
import javax.swing.JTable;
import java.awt.Component;

public class CrearPlato extends JPanel {
	private JTextField txtCaloriasRestantes;
	Ventanas ventanaPrincipal;
	private JTextField textField;
	private JTextField txtNombreDelPlato;
	private JTable table;

	public CrearPlato(Ventanas v) {
		setForeground(Color.ORANGE);
		setLayout(new BorderLayout(0, 0));
		
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
		gbl_Añadir_Ingrediente.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Añadir_Ingrediente.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Añadir_Ingrediente.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Añadir_Ingrediente.setLayout(gbl_Añadir_Ingrediente);
		
		JLabel Cantidad = new JLabel("Buscador");
		Cantidad.setForeground(new Color(255, 255, 0));
		GridBagConstraints BuscadorPanel = new GridBagConstraints();
		BuscadorPanel.insets = new Insets(0, 0, 5, 5);
		BuscadorPanel.anchor = GridBagConstraints.EAST;
		BuscadorPanel.gridx = 0;
		BuscadorPanel.gridy = 1;
		Añadir_Ingrediente.add(Cantidad, BuscadorPanel);
		
		textField = new JTextField();
		GridBagConstraints BuscadorTxt = new GridBagConstraints();
		BuscadorTxt.fill = GridBagConstraints.HORIZONTAL;
		BuscadorTxt.insets = new Insets(0, 0, 5, 5);
		BuscadorTxt.gridx = 1;
		BuscadorTxt.gridy = 1;
		Añadir_Ingrediente.add(textField, BuscadorTxt);
		textField.setColumns(10);
		
		JLabel lblAadir = new JLabel("+ A\u00F1adir");
		lblAadir.setForeground(Color.BLUE);
		GridBagConstraints AnadirTxt = new GridBagConstraints();
		AnadirTxt.anchor = GridBagConstraints.WEST;
		AnadirTxt.insets = new Insets(0, 0, 5, 0);
		AnadirTxt.gridx = 2;
		AnadirTxt.gridy = 2;
		Añadir_Ingrediente.add(lblAadir, AnadirTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints ScrollBuscador = new GridBagConstraints();
		ScrollBuscador.gridheight = 8;
		ScrollBuscador.insets = new Insets(0, 0, 5, 5);
		ScrollBuscador.fill = GridBagConstraints.BOTH;
		ScrollBuscador.gridx = 1;
		ScrollBuscador.gridy = 2;
		Añadir_Ingrediente.add(scrollPane, ScrollBuscador);
		
		JButton BotonAtras = new JButton("Atras");
		GridBagConstraints gbc_BotonAtras = new GridBagConstraints();
		gbc_BotonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_BotonAtras.gridx = 0;
		gbc_BotonAtras.gridy = 10;
		BotonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		
		JLabel lblBorrar = new JLabel("- Borrar");
		lblBorrar.setForeground(Color.RED);
		GridBagConstraints BorrarTxt = new GridBagConstraints();
		BorrarTxt.anchor = GridBagConstraints.WEST;
		BorrarTxt.insets = new Insets(0, 0, 5, 0);
		BorrarTxt.gridx = 2;
		BorrarTxt.gridy = 9;
		Añadir_Ingrediente.add(lblBorrar, BorrarTxt);
		Añadir_Ingrediente.add(BotonAtras, gbc_BotonAtras);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints ScrollAnadir = new GridBagConstraints();
		ScrollAnadir.insets = new Insets(0, 0, 5, 5);
		ScrollAnadir.fill = GridBagConstraints.BOTH;
		ScrollAnadir.gridx = 1;
		ScrollAnadir.gridy = 10;
		Añadir_Ingrediente.add(scrollPane_1, ScrollAnadir);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 10;
		Añadir_Ingrediente.add(btnGuardar, gbc_btnGuardar);
		ventanaPrincipal=v;
		
	
		
		
	}
	
	

}