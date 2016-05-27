package interfaz;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class DiaPlanificacion extends JPanel implements ItemListener{
	
	private String dia;
	private JTextField textField[];
	private ArrayList<JComboBox<String>> comboBox;
	private ArrayList<String> caloriasDesayuno;
	private ArrayList<String> caloriasAlmuerzo;
	private ArrayList<String> caloriasComida;
	private ArrayList<String> caloriasMerienda;
	private ArrayList<String> caloriasCena;
	
	/**
	 * Create the panel.
	 */
	public DiaPlanificacion(String d) {
		dia=d;
		comboBox=new ArrayList<JComboBox<String>>();
		textField= new JTextField[15];
		caloriasDesayuno= new ArrayList<String>();
		caloriasAlmuerzo= new ArrayList<String>();
		caloriasComida= new ArrayList<String>();
		caloriasMerienda= new ArrayList<String>();
		caloriasCena= new ArrayList<String>();
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
		
		JPanel panelDesayunoCalorias = new JPanel();
		panelDesayuno.add(panelDesayunoCalorias);
		panelDesayunoCalorias.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField[0] = new JTextField();
		textField[0].setEditable(false);
		panelDesayunoCalorias.add(textField[0]);
		textField[0].setColumns(10);
		
		textField[1] = new JTextField();
		textField[1].setEditable(false);
		panelDesayunoCalorias.add(textField[1]);
		textField[1].setColumns(10);
		
		textField[2] = new JTextField();
		textField[2].setEditable(false);
		panelDesayunoCalorias.add(textField[2]);
		textField[2].setColumns(10);
		
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
		
		JPanel panelAlmuerzoCalorias = new JPanel();
		panelAlmuerzo.add(panelAlmuerzoCalorias);
		panelAlmuerzoCalorias.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField[3] = new JTextField();
		textField[3].setEditable(false);
		textField[3].setColumns(10);
		panelAlmuerzoCalorias.add(textField[3]);
		
		textField[4] = new JTextField();
		textField[4].setEditable(false);
		textField[4].setColumns(10);
		panelAlmuerzoCalorias.add(textField[4]);
		
		textField[5] = new JTextField();
		textField[5].setEditable(false);
		panelAlmuerzoCalorias.add(textField[5]);
		textField[5].setColumns(10);
		
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
		
		JPanel panelComidaCalorias = new JPanel();
		panelComida.add(panelComidaCalorias);
		panelComidaCalorias.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField[6] = new JTextField();
		textField[6].setEditable(false);
		textField[6].setColumns(10);
		panelComidaCalorias.add(textField[6]);
		
		textField[7] = new JTextField();
		textField[7].setEditable(false);
		textField[7].setColumns(10);
		panelComidaCalorias.add(textField[7]);
		
		textField[8] = new JTextField();
		textField[8].setEditable(false);
		textField[8].setColumns(10);
		panelComidaCalorias.add(textField[8]);
		
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
		
		JPanel panelMeriendaCalorias = new JPanel();
		panelMerienda.add(panelMeriendaCalorias);
		panelMeriendaCalorias.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField[9] = new JTextField();
		textField[9].setEditable(false);
		textField[9].setColumns(10);
		panelMeriendaCalorias.add(textField[9]);
		
		textField[10] = new JTextField();
		textField[10].setEditable(false);
		textField[10].setColumns(10);
		panelMeriendaCalorias.add(textField[10]);
		
		textField[11] = new JTextField();
		textField[11].setEditable(false);
		textField[11].setColumns(11);
		panelMeriendaCalorias.add(textField[11]);
		
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
		
		JPanel panelCenaCalorias = new JPanel();
		panelCena.add(panelCenaCalorias);
		panelCenaCalorias.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField[12] = new JTextField();
		textField[12].setEditable(false);
		textField[12].setColumns(10);
		panelCenaCalorias.add(textField[12]);
		
		textField[13] = new JTextField();
		textField[13].setEditable(false);
		textField[13].setColumns(10);
		panelCenaCalorias.add(textField[13]);
		
		textField[14] = new JTextField();
		textField[14].setEditable(false);
		textField[14].setColumns(10);
		panelCenaCalorias.add(textField[14]);
		
		JLabel lblCrearNuevaCena = new JLabel("Crear nueva cena");
		panelCena.add(lblCrearNuevaCena);
		
		//Se añaden los action listeners a los comboBox.
		for(int i=0;i<comboBox.size();i++){
			comboBox.get(i).addItemListener(this);
		}
	}
	public String getNomDia(){
		return dia;
	}
	public void setNomDia(String dia){
		this.dia=dia;
	}
	public ArrayList<String> getCaloriasDesayuno() {
		return caloriasDesayuno;
	}
	public ArrayList<String> getCaloriasAlmuerzo() {
		return caloriasAlmuerzo;
	}
	public ArrayList<String> getCaloriasComida() {
		return caloriasComida;
	}
	public ArrayList<String> getCaloriasMerienda() {
		return caloriasMerienda;
	}
	public ArrayList<String> getCaloriasCena() {
		return caloriasCena;
	}
	public JTextField[] getTextField() {
		return textField;
	}
	public ArrayList<JComboBox<String>> getComboBox() {
		return comboBox;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		ArrayList<ArrayList<String>> arraysListCalorias= new ArrayList<ArrayList<String>>();
		arraysListCalorias.add(caloriasDesayuno);
		arraysListCalorias.add(caloriasAlmuerzo);
		arraysListCalorias.add(caloriasComida);
		arraysListCalorias.add(caloriasMerienda);
		arraysListCalorias.add(caloriasCena);
		int numTextField=0;
		for(int i=0;i<5;i++){
			textField[(numTextField)].setText(arraysListCalorias.get(i).get(comboBox.get((numTextField)).getSelectedIndex()));
			numTextField++;
			textField[(numTextField)].setText(arraysListCalorias.get(i).get(comboBox.get((numTextField)).getSelectedIndex()));
			numTextField++;
			textField[(numTextField)].setText(arraysListCalorias.get(i).get(comboBox.get((numTextField)).getSelectedIndex()));
		}
	}
	
	
}
