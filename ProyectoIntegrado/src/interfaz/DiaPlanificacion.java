package interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class DiaPlanificacion extends JPanel {
	
	private String dia;
	private JTextField textField[];
	private ArrayList<JComboBox<String>> comboBox;
	
	/**
	 * Create the panel.
	 */
	public DiaPlanificacion(String d) {
		comboBox=new ArrayList<JComboBox<String>>();
		textField= new JTextField[5];
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
		
		comboBox.add(new JComboBox<String>());
		panelPlatos.add(comboBox.get(0));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos.add(comboBox.get(1));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos.add(comboBox.get(2));
		
		JLabel lblCaloriasDesayuno = new JLabel("Calorías:");
		panelDesayuno.add(lblCaloriasDesayuno);
		
		textField[0] = new JTextField();
		textField[0].setEditable(false);
		panelDesayuno.add(textField[0]);
		textField[0].setColumns(10);
		
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
		
		comboBox.add(new JComboBox<String>());
		panelPlatos5.add(comboBox.get(3));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos5.add(comboBox.get(4));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos5.add(comboBox.get(5));
		
		JLabel labelCaloriasAlmuerzo = new JLabel("Calorías:");
		panelAlmuerzo.add(labelCaloriasAlmuerzo);
		
		textField[1] = new JTextField();
		textField[1].setEditable(false);
		textField[1].setColumns(10);
		panelAlmuerzo.add(textField[1]);
		
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
		
		comboBox.add(new JComboBox<String>());
		panelPlatos2.add(comboBox.get(6));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos2.add(comboBox.get(7));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos2.add(comboBox.get(8));
		
		JLabel lblCalorias2 = new JLabel("Calor\u00EDas:");
		panelComida.add(lblCalorias2);
		
		textField[2] = new JTextField();
		textField[2].setEditable(false);
		textField[2].setColumns(10);
		panelComida.add(textField[2]);
		
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
		
		comboBox.add(new JComboBox<String>());
		panelPlatos3.add(comboBox.get(9));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos3.add(comboBox.get(10));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos3.add(comboBox.get(11));
		
		JLabel lblCalorias3 = new JLabel("Calor\u00EDas:");
		panelMerienda.add(lblCalorias3);
		
		textField[3] = new JTextField();
		textField[3].setEditable(false);
		textField[3].setColumns(10);
		panelMerienda.add(textField[3]);
		
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
		
		comboBox.add(new JComboBox<String>());
		panelPlatos4.add(comboBox.get(12));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos4.add(comboBox.get(13));
		
		comboBox.add(new JComboBox<String>());
		panelPlatos4.add(comboBox.get(14));
		
		JLabel label_5 = new JLabel("Calor\u00EDas:");
		panelCena.add(label_5);
		
		textField[4] = new JTextField();
		textField[4].setEditable(false);
		textField[4].setColumns(10);
		panelCena.add(textField[4]);
		
		JLabel lblCrearNuevaCena = new JLabel("Crear nueva cena");
		panelCena.add(lblCrearNuevaCena);
		dia=d;
		
	}
	public String getNomDia(){
		return dia;
	}
	public void setNomDia(String dia){
		this.dia=dia;
	}
	public JTextField[] getTextField() {
		return textField;
	}
	public void setTextField(JTextField[] textField) {
		this.textField = textField;
	}
	public ArrayList<JComboBox<String>> getComboBox() {
		return comboBox;
	}
	public void setComboBox(ArrayList<JComboBox<String>> comboBox) {
		this.comboBox = comboBox;
	}
}
