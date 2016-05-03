package interfaz;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Planificacion extends JPanel {

	Ventanas ventanaPrincipal;
	private JTextField textFieldCalRecomendadas;
	private JTextField textFieldCalRestantes;

	public Planificacion(Ventanas v) {
		ventanaPrincipal=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabezera = new JPanel();
		add(panelCabezera, BorderLayout.NORTH);
		FlowLayout fl_panelCabezera = (FlowLayout) panelCabezera.getLayout();
		fl_panelCabezera.setVgap(20);
		fl_panelCabezera.setHgap(30);
		fl_panelCabezera.setAlignment(FlowLayout.LEFT);
		
		JPanel panelCaloriasGrid = new JPanel();
		panelCabezera.add(panelCaloriasGrid);
		panelCaloriasGrid.setLayout(new GridLayout(2, 2, 10, 5));
		
		JLabel lblCalorasRecomendadas = new JLabel("Calor\u00EDas recomendadas:");
		panelCaloriasGrid.add(lblCalorasRecomendadas);
		
		textFieldCalRecomendadas = new JTextField();
		panelCaloriasGrid.add(textFieldCalRecomendadas);
		textFieldCalRecomendadas.setColumns(10);
		
		JLabel lblCalorasRestantes = new JLabel("Calor\u00EDas restantes:");
		panelCaloriasGrid.add(lblCalorasRestantes);
		
		textFieldCalRestantes = new JTextField();
		panelCaloriasGrid.add(textFieldCalRestantes);
		textFieldCalRestantes.setColumns(10);
		
		JPanel panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel();
		add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelAtras = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAtras.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(50);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelInferior.add(panelAtras);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		panelAtras.add(btnAtras);
		
		JPanel panelGuardar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelGuardar.getLayout();
		flowLayout_1.setVgap(30);
		flowLayout_1.setHgap(50);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelInferior.add(panelGuardar);
		
		JButton btnGuardar = new JButton("Guardar planificación");
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Consultar base de datos antes de ir a menú.
				ventanaPrincipal.cambiapanel("Menu");
			}
		});
		panelGuardar.add(btnGuardar);
	}

}
