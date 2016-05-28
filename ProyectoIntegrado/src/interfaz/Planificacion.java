package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BDD.Conexio;
import BDD.Consultas;
import calculos.CalcularCalorias;
import javafx.scene.control.ComboBox;

public class Planificacion extends JPanel implements ActionListener{

	private Ventanas ventanaPrincipal;
	private Conexio conexio;
	private ArrayList<String> arrayIdiomas;
	private DefaultTableModel dtm;
	private CardLayout cl;
	private JPanel panelCard;
	private JTextField textFieldCalRecomendadas;
	private JTextField textFieldCalRestantes;
	private JTextField textFieldDia;
	private JLabel lblCalorasRecomendadas;
	private JLabel lblCalorasRestantes;
	private JButton btnAtras;
	private JButton btnGuardar;
	
	private DiaPlanificacion dia[];
	private int numeroDia=0;
	
	public Planificacion(Ventanas v, Conexio conexio, ArrayList<String> arrayIdiomas, DefaultTableModel dtm) {
		ventanaPrincipal=v;
		this.arrayIdiomas=arrayIdiomas;
		this.conexio=conexio;
		this.dtm=dtm;
		
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
		
		lblCalorasRecomendadas = new JLabel();
		panelCaloriasGrid.add(lblCalorasRecomendadas);
		
		textFieldCalRecomendadas = new JTextField();
		textFieldCalRecomendadas.setEditable(false);
		panelCaloriasGrid.add(textFieldCalRecomendadas);
		textFieldCalRecomendadas.setColumns(10);
		
		lblCalorasRestantes = new JLabel();
		panelCaloriasGrid.add(lblCalorasRestantes);
		
		textFieldCalRestantes = new JTextField();
		textFieldCalRestantes.setEditable(false);
		panelCaloriasGrid.add(textFieldCalRestantes);
		textFieldCalRestantes.setColumns(10);
		
		JPanel panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSeleccionDia = new JPanel();
		panelCentral.add(panelSeleccionDia, BorderLayout.NORTH);
		
		JButton btnA = new JButton("<<");
		btnA.setActionCommand("anterior");
		btnA.addActionListener(this);
		panelSeleccionDia.add(btnA);
		
		textFieldDia = new JTextField();
		textFieldDia.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDia.setEditable(false);
		panelSeleccionDia.add(textFieldDia);
		textFieldDia.setColumns(10);
		
		JButton btnB = new JButton(">>");
		btnB.setActionCommand("siguiente");
		btnB.addActionListener(this);
		panelSeleccionDia.add(btnB);
		
		panelCard = new JPanel();
		crearCardLayout(panelCard);
		panelCard.setLayout(cl);
		
		JScrollPane panelScroll= new JScrollPane(panelCard);
		panelScroll.getVerticalScrollBar().setUnitIncrement(10);
		panelScroll.getHorizontalScrollBar().setUnitIncrement(10);
		panelCentral.add(panelScroll, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel();
		add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		JPanel panelAtras = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAtras.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(50);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelInferior.add(panelAtras);
		
		btnAtras = new JButton();
		btnAtras.setActionCommand("btnAtras");
		btnAtras.addActionListener(this);
		panelAtras.add(btnAtras);
		
		JPanel panelGuardar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelGuardar.getLayout();
		flowLayout_1.setVgap(30);
		flowLayout_1.setHgap(50);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelInferior.add(panelGuardar);
		
		btnGuardar = new JButton();
		btnGuardar.setActionCommand("btnGuardar");
		btnGuardar.addActionListener(this);
		panelGuardar.add(btnGuardar);
		
		/*Se cargan los labels*/
		cargarLabels();
		//Cargar calorías totales.
		new CalcularCalorias(textFieldCalRecomendadas, new Consultas(conexio).datosUsuario(conexio.getUsuario()));
		//Carga los combobox de cada dia y los textFields de calorías.
		new Consultas(conexio).rellenarComboBox(dia, dtm);
		for(int i=0;i<dia.length;i++){
			dia[i].rellenarCalorias();
		}
	}
	
	private void crearCardLayout(JPanel panelCard){
		cl=new CardLayout();
		dia= new DiaPlanificacion[7];
		for(int i=0;i<dia.length;i++){
			dia[i]=new DiaPlanificacion(arrayIdiomas.get(24+i), Planificacion.this);
		}
		for(int i=0;i<7;i++){
			cl.addLayoutComponent(dia[i], ""+(i+1));
			panelCard.add(dia[i]);
		}
	}
	
	public void cargarLabels(){
		lblCalorasRecomendadas.setText(arrayIdiomas.get(22));
		lblCalorasRestantes.setText(arrayIdiomas.get(23));
		textFieldDia.setText(arrayIdiomas.get(24));
		btnGuardar.setText(arrayIdiomas.get(36));
		btnAtras.setText(arrayIdiomas.get(37));
		for(int i=0;i<dia.length;i++){
			dia[i].setNomDia(arrayIdiomas.get(24+i));
		}
		
	}
	
	private void guardarPlanificacionMenu(){
		/*Se guarda la planificacion en la tabla de la clase Menu*/
		for(int fila=0;fila<dtm.getRowCount();fila++){
			for(int columna=0;columna<dtm.getColumnCount()-1;columna++){
				dtm.setValueAt(dia[columna].getComboBox().get(fila).getSelectedItem(), fila, columna+1);
			}
		}
	}
	
	protected void calcularCaloriasRestantes(){
		/*Calcular calorías restantes*/
		try{
		int sumaCalorias=0;
		for(int tf=0;tf<dia[0].getComboBox().size();tf++){
			sumaCalorias+=Float.parseFloat(dia[numeroDia].getTextField()[tf].getText());
		}
		textFieldCalRestantes.setText(String.valueOf(Float.parseFloat(textFieldCalRecomendadas.getText())-sumaCalorias));
		}catch(NumberFormatException nfe){
			nfe.printStackTrace();
			JOptionPane.showMessageDialog(null,
				    ""+nfe,
				    "Error numérico",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accio=e.getActionCommand();
		if(accio.compareTo("btnAtras")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("btnGuardar")==0){
			new Consultas(conexio).registrarPlanificacion(dia);
			guardarPlanificacionMenu();
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("siguiente")==0){
			cl.next(panelCard);
			numeroDia+=1;
			if(numeroDia>6){
				numeroDia=0;
			}
			textFieldDia.setText(dia[numeroDia].getNomDia());
			calcularCaloriasRestantes();
		}else if(accio.compareTo("anterior")==0){
			cl.previous(panelCard);
			numeroDia-=1;
			if(numeroDia<0){
				numeroDia=6;
			}
			textFieldDia.setText(dia[numeroDia].getNomDia());
			calcularCaloriasRestantes();
		}
	}
}
