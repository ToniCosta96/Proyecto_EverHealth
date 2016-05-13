package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BDD.Conexio;
import BDD.Consultas;

public class CrearPlato extends JPanel {
	private Ventanas ventanaPrincipal;
	Conexio conexio;
	private JTextField txtCaloriasRestantes;
	private DefaultTableModel dtm;
	private JTable tablaAlimentos;
	private JTextField textFieldBusqueda;
	private JTextField txtNombreDelPlato;
	private JTable table;

	public CrearPlato(Ventanas v, Conexio conexio) {
		this.conexio=conexio;
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
		
		JPanel A�adir_Ingrediente = new JPanel();
		A�adir_Ingrediente.setBackground(new Color(255, 140, 0));
		add(A�adir_Ingrediente, BorderLayout.CENTER);
		GridBagLayout gbl_A�adir_Ingrediente = new GridBagLayout();
		gbl_A�adir_Ingrediente.columnWidths = new int[]{0, 0, 0, 0};
		gbl_A�adir_Ingrediente.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_A�adir_Ingrediente.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_A�adir_Ingrediente.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		A�adir_Ingrediente.setLayout(gbl_A�adir_Ingrediente);
		
		JLabel Cantidad = new JLabel("Buscador");
		Cantidad.setForeground(new Color(255, 255, 0));
		GridBagConstraints BuscadorPanel = new GridBagConstraints();
		BuscadorPanel.insets = new Insets(0, 0, 5, 5);
		BuscadorPanel.anchor = GridBagConstraints.EAST;
		BuscadorPanel.gridx = 0;
		BuscadorPanel.gridy = 1;
		A�adir_Ingrediente.add(Cantidad, BuscadorPanel);
		
		textFieldBusqueda = new JTextField();
		GridBagConstraints BuscadorTxt = new GridBagConstraints();
		BuscadorTxt.fill = GridBagConstraints.HORIZONTAL;
		BuscadorTxt.insets = new Insets(0, 0, 5, 5);
		BuscadorTxt.gridx = 1;
		BuscadorTxt.gridy = 1;
		A�adir_Ingrediente.add(textFieldBusqueda, BuscadorTxt);
		textFieldBusqueda.setColumns(10);
		
		JLabel lblAadir = new JLabel("+ A\u00F1adir");
		lblAadir.setForeground(Color.BLUE);
		GridBagConstraints AnadirTxt = new GridBagConstraints();
		AnadirTxt.anchor = GridBagConstraints.WEST;
		AnadirTxt.insets = new Insets(0, 0, 5, 0);
		AnadirTxt.gridx = 2;
		AnadirTxt.gridy = 2;
		A�adir_Ingrediente.add(lblAadir, AnadirTxt);
		
		dtm= new DefaultTableModel();
		//Tabla y ScrollPane
		tablaAlimentos= new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(tablaAlimentos);
		GridBagConstraints ScrollBuscador = new GridBagConstraints();
		ScrollBuscador.gridheight = 8;
		ScrollBuscador.insets = new Insets(0, 0, 5, 5);
		ScrollBuscador.fill = GridBagConstraints.BOTH;
		ScrollBuscador.gridx = 1;
		ScrollBuscador.gridy = 2;
		A�adir_Ingrediente.add(scrollPane, ScrollBuscador);
		A�adir_Ingrediente.updateUI();
		
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
		A�adir_Ingrediente.add(lblBorrar, BorrarTxt);
		A�adir_Ingrediente.add(BotonAtras, gbc_BotonAtras);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints ScrollAnadir = new GridBagConstraints();
		ScrollAnadir.insets = new Insets(0, 0, 5, 5);
		ScrollAnadir.fill = GridBagConstraints.BOTH;
		ScrollAnadir.gridx = 1;
		ScrollAnadir.gridy = 10;
		A�adir_Ingrediente.add(scrollPane_1, ScrollAnadir);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 10;
		A�adir_Ingrediente.add(btnGuardar, gbc_btnGuardar);
		ventanaPrincipal=v;
		
		cargarAlimentos(A�adir_Ingrediente);
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