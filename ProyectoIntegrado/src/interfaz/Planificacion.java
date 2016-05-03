package interfaz;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Planificacion extends JPanel implements ActionListener{

	Ventanas ventanaPrincipal;
	private CardLayout cl;
	private JPanel panelCard;
	private JTextField textFieldCalRecomendadas;
	private JTextField textFieldCalRestantes;
	private JTextField textFieldDia;
	
	private DiaPlanificacion dia1;
	private DiaPlanificacion dia2;
	private DiaPlanificacion dia3;
	private DiaPlanificacion dia4;
	private DiaPlanificacion dia5;
	private DiaPlanificacion dia6;
	private DiaPlanificacion dia7;
	private DiaPlanificacion dia[];
	private int numeroDia=0;
	
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
		
		JLabel lblCalorasRecomendadas = new JLabel("Calorías recomendadas:");
		panelCaloriasGrid.add(lblCalorasRecomendadas);
		
		textFieldCalRecomendadas = new JTextField();
		textFieldCalRecomendadas.setEditable(false);
		panelCaloriasGrid.add(textFieldCalRecomendadas);
		textFieldCalRecomendadas.setColumns(10);
		
		JLabel lblCalorasRestantes = new JLabel("Calorías restantes:");
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
		textFieldDia.setText("Lunes");
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
		
		panelCentral.add(panelCard, BorderLayout.CENTER);
		
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
		btnAtras.setActionCommand("btnAtras");
		btnAtras.addActionListener(this);
		panelAtras.add(btnAtras);
		
		JPanel panelGuardar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelGuardar.getLayout();
		flowLayout_1.setVgap(30);
		flowLayout_1.setHgap(50);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelInferior.add(panelGuardar);
		
		JButton btnGuardar = new JButton("Guardar planificación");
		btnGuardar.setActionCommand("btnGuardar");
		btnGuardar.addActionListener(this);
		panelGuardar.add(btnGuardar);
	}
	
	private void crearCardLayout(JPanel panelCard){
		cl=new CardLayout();
		dia= new DiaPlanificacion[7];
		dia[0]=new DiaPlanificacion("Lunes");
		dia[1]=new DiaPlanificacion("Martes");
		dia[2]=new DiaPlanificacion("Miércoles");
		dia[3]=new DiaPlanificacion("Jueves");
		dia[4]=new DiaPlanificacion("Viernes");
		dia[5]=new DiaPlanificacion("Sábado");
		dia[6]=new DiaPlanificacion("Domingo");
		
		cl.addLayoutComponent(dia[0], "1");
		cl.addLayoutComponent(dia[1], "2");
		cl.addLayoutComponent(dia[2], "3");
		cl.addLayoutComponent(dia[3], "4");
		cl.addLayoutComponent(dia[4], "5");
		cl.addLayoutComponent(dia[5], "6");
		cl.addLayoutComponent(dia[6], "7");
		
		panelCard.add(dia[0]);
		panelCard.add(dia[1]);
		panelCard.add(dia[2]);
		panelCard.add(dia[3]);
		panelCard.add(dia[4]);
		panelCard.add(dia[5]);
		panelCard.add(dia[6]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accio=e.getActionCommand();
		if(accio.compareTo("btnAtras")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("btnGuardar")==0){
			ventanaPrincipal.cambiapanel("Menu");
		}else if(accio.compareTo("siguiente")==0){
			cl.next(panelCard);
			numeroDia+=1;
			if(numeroDia>=7){
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
