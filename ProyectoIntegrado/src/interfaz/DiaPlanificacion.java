package interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class DiaPlanificacion extends JPanel {
//
	private String dia;
	private JTextField textFieldCaloriasDesayuno;
	private JTextField textFieldCaloriasComida;
	private JTextField textFieldCaloriasMerienda;
	private JTextField textFieldCaloriasCena;
	private JTextField textFieldCaloriasAlmuerzo;
	/**
	 * Create the panel.
	 */
	public DiaPlanificacion(String d) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panelDesayuno = new JPanel();
		panelDesayuno.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelDesayuno);
		
		JLabel lblDesayuno = new JLabel("Desayuno");
		panelDesayuno.add(lblDesayuno);
		
		JPanel panelPlatos = new JPanel();
		panelDesayuno.add(panelPlatos);
		panelPlatos.setLayout(new GridLayout(3, 1, 0, 0));
		
		JComboBox<String> comboBoxDesayuno1 = new JComboBox<String>();
		comboBoxDesayuno1.addItem("Plato1");
		panelPlatos.add(comboBoxDesayuno1);
		
		JComboBox<String> comboBoxDesayuno2 = new JComboBox<String>();
		comboBoxDesayuno2.addItem("Plato2");
		panelPlatos.add(comboBoxDesayuno2);
		
		JComboBox<String> comboBoxDesayuno3 = new JComboBox<String>();
		comboBoxDesayuno3.addItem("Plato3");
		panelPlatos.add(comboBoxDesayuno3);
		
		JLabel lblCaloriasDesayuno = new JLabel("Calorías:");
		panelDesayuno.add(lblCaloriasDesayuno);
		
		textFieldCaloriasDesayuno = new JTextField();
		textFieldCaloriasDesayuno.setEditable(false);
		panelDesayuno.add(textFieldCaloriasDesayuno);
		textFieldCaloriasDesayuno.setColumns(10);
		
		JLabel lblCrearNuevoDesayuno = new JLabel("Crear nuevo desayuno");
		panelDesayuno.add(lblCrearNuevoDesayuno);
		
		JPanel panelAlmuerzo = new JPanel();
		panelAlmuerzo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelAlmuerzo);
		
		JLabel labelAlmuerzo = new JLabel("Almuerzo");
		panelAlmuerzo.add(labelAlmuerzo);
		
		JPanel panelPlatos5 = new JPanel();
		panelAlmuerzo.add(panelPlatos5);
		panelPlatos5.setLayout(new GridLayout(3, 1, 0, 0));
		
		JComboBox<String> comboBoxAlmuerzo1 = new JComboBox<String>();
		panelPlatos5.add(comboBoxAlmuerzo1);
		
		JComboBox<String> comboBoxAlmuerzo2 = new JComboBox<String>();
		panelPlatos5.add(comboBoxAlmuerzo2);
		
		JComboBox<String> comboBoxAlmuerzo3 = new JComboBox<String>();
		panelPlatos5.add(comboBoxAlmuerzo3);
		
		JLabel labelCaloriasAlmuerzo = new JLabel("Calorías:");
		panelAlmuerzo.add(labelCaloriasAlmuerzo);
		
		textFieldCaloriasAlmuerzo = new JTextField();
		textFieldCaloriasAlmuerzo.setEditable(false);
		textFieldCaloriasAlmuerzo.setColumns(10);
		panelAlmuerzo.add(textFieldCaloriasAlmuerzo);
		
		JLabel labelCrearAlmuerzo = new JLabel("Crear nuevo almuerzo");
		panelAlmuerzo.add(labelCrearAlmuerzo);
		
		JPanel panelComida = new JPanel();
		panelComida.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelComida);
		
		JLabel labelComida = new JLabel("Comida");
		panelComida.add(labelComida);
		
		JPanel panelPlatos2 = new JPanel();
		panelComida.add(panelPlatos2);
		panelPlatos2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JComboBox<String> comboBoxComida1 = new JComboBox<String>();
		panelPlatos2.add(comboBoxComida1);
		
		JComboBox<String> comboBoxComida2 = new JComboBox<String>();
		panelPlatos2.add(comboBoxComida2);
		
		JComboBox<String> comboBoxComida3 = new JComboBox<String>();
		panelPlatos2.add(comboBoxComida3);
		
		JLabel lblCalorias2 = new JLabel("Calor\u00EDas:");
		panelComida.add(lblCalorias2);
		
		textFieldCaloriasComida = new JTextField();
		textFieldCaloriasComida.setEditable(false);
		textFieldCaloriasComida.setColumns(10);
		panelComida.add(textFieldCaloriasComida);
		
		JLabel lblCrearNuevaComida = new JLabel("Crear nueva comida");
		panelComida.add(lblCrearNuevaComida);
		
		JPanel panelMerienda = new JPanel();
		panelMerienda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelMerienda);
		
		JLabel lblMerienda = new JLabel("Merienda");
		panelMerienda.add(lblMerienda);
		
		JPanel panelPlatos3 = new JPanel();
		panelMerienda.add(panelPlatos3);
		panelPlatos3.setLayout(new GridLayout(3, 1, 0, 0));
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		panelPlatos3.add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		panelPlatos3.add(comboBox_4);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		panelPlatos3.add(comboBox_5);
		
		JLabel lblCalorias3 = new JLabel("Calor\u00EDas:");
		panelMerienda.add(lblCalorias3);
		
		textFieldCaloriasMerienda = new JTextField();
		textFieldCaloriasMerienda.setEditable(false);
		textFieldCaloriasMerienda.setColumns(10);
		panelMerienda.add(textFieldCaloriasMerienda);
		
		JLabel labelCrearNuevaMerienda = new JLabel("Crear nuevo desayuno");
		panelMerienda.add(labelCrearNuevaMerienda);
		
		JPanel panelCena = new JPanel();
		panelCena.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panelCena);
		
		JLabel labelCena = new JLabel("Cena");
		panelCena.add(labelCena);
		
		JPanel panelPlatos4 = new JPanel();
		panelCena.add(panelPlatos4);
		panelPlatos4.setLayout(new GridLayout(3, 1, 0, 0));
		
		JComboBox<String> comboBoxCena1 = new JComboBox<String>();
		panelPlatos4.add(comboBoxCena1);
		
		JComboBox<String> comboBoxCena2 = new JComboBox<String>();
		panelPlatos4.add(comboBoxCena2);
		
		JComboBox<String> comboBoxCena3 = new JComboBox<String>();
		panelPlatos4.add(comboBoxCena3);
		
		JLabel label_5 = new JLabel("Calor\u00EDas:");
		panelCena.add(label_5);
		
		textFieldCaloriasCena = new JTextField();
		textFieldCaloriasCena.setEditable(false);
		textFieldCaloriasCena.setColumns(10);
		panelCena.add(textFieldCaloriasCena);
		
		JLabel lblCrearNuevaCena = new JLabel("Crear nueva cena");
		panelCena.add(lblCrearNuevaCena);
		dia=d;
		
		

	}
	public String getNomDia(){
		return dia;
	}

}
