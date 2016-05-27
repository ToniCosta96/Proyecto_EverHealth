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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BDD.Conexio;
import BDD.Consultas;

public class Planificacion extends JPanel implements ActionListener{

	private Ventanas ventanaPrincipal;
	private Conexio conexio;
	private ArrayList<String> arrayIdiomas;
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
	
	public Planificacion(Ventanas v, Conexio conexio, ArrayList<String> arrayIdiomas) {
		ventanaPrincipal=v;
		this.arrayIdiomas=arrayIdiomas;
		this.conexio=conexio;
		
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
		new Consultas(conexio).consultarPlatoTipo(dia);
		
	}
	
	private void crearCardLayout(JPanel panelCard){
		cl=new CardLayout();
		dia= new DiaPlanificacion[7];
		for(int i=0;i<dia.length;i++){
			dia[i]=new DiaPlanificacion(arrayIdiomas.get(24+i));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String accio=e.getActionCommand();
		if(accio.compareTo("btnAtras")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("btnGuardar")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("siguiente")==0){
			cl.next(panelCard);
			numeroDia+=1;
			if(numeroDia>6){
				numeroDia=0;
			}
			textFieldDia.setText(dia[numeroDia].getNomDia());
		}else if(accio.compareTo("anterior")==0){
			cl.previous(panelCard);
			numeroDia-=1;
			if(numeroDia<0){
				numeroDia=6;
			}
			textFieldDia.setText(dia[numeroDia].getNomDia());
		}
	}
}
