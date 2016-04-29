package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Menu extends JPanel implements ActionListener{
	private JTextField txtCaloriasRestantes;
	private JTable table;
	Ventanas ventanaPrincipal;

	/**
	 * Create the frame.
	 */
	public Menu(Ventanas v) {
		ventanaPrincipal=v;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabezera = new JPanel();
		add(panelCabezera, BorderLayout.NORTH);
		panelCabezera.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelCalorias = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCalorias.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(25);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCabezera.add(panelCalorias);
		
		JLabel lblNewLabelCalorias = new JLabel("Calorías restantes:");
		panelCalorias.add(lblNewLabelCalorias);
		
		txtCaloriasRestantes = new JTextField();
		panelCalorias.add(txtCaloriasRestantes);
		txtCaloriasRestantes.setText("Calorias Restantes");
		txtCaloriasRestantes.setColumns(12);
		txtCaloriasRestantes.setEditable(false);
		
		JPanel panelIrAlPerfil = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelIrAlPerfil.getLayout();
		flowLayout_1.setHgap(25);
		flowLayout_1.setVgap(15);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelCabezera.add(panelIrAlPerfil);
		
		JLabel lblIrAlPerfil = new JLabel("Ir al perfil de usuario.");
		lblIrAlPerfil.setForeground(Color.BLUE);
		lblIrAlPerfil.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblIrAlPerfil.setText("Ir al perfil de usuario.");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIrAlPerfil.setText("<html><u>Ir al perfil de usuario.</html></u>");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaPrincipal.cambiapanel("PerfilDeUsuario");
				ventanaPrincipal.setTitle("Ever Health- Perfil de usuario");
			}
		});
		panelIrAlPerfil.add(lblIrAlPerfil);
		
		JPanel panelDivisor = new JPanel();
		add(panelDivisor, BorderLayout.CENTER);
		panelDivisor.setLayout(new BoxLayout(panelDivisor, BoxLayout.X_AXIS));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4, 1, 0, 0));
		panelDivisor.add(panelBotones);
		
		JButton btnPlanificacion = new JButton("Panificación");
		btnPlanificacion.setActionCommand("MenuBtnPlanificacion");
		btnPlanificacion.addActionListener(this);
		panelBotones.add(btnPlanificacion);
		
		JButton btnHazTuPropio = new JButton("Haz tu propio plato");
		panelBotones.add(btnHazTuPropio);
		
		JButton btnConsultarPlatos = new JButton("Consultar platos");
		btnConsultarPlatos.setActionCommand("MenuBtnConsultarPlatos");
		btnConsultarPlatos.addActionListener(this);
		panelBotones.add(btnConsultarPlatos);
		
		JButton btnConsultarAlimentos = new JButton("Consultar alimentos");
		btnConsultarAlimentos.setActionCommand("MenuBtnConsultarAlimentos");
		btnConsultarAlimentos.addActionListener(this);
		panelBotones.add(btnConsultarAlimentos);
		
		//Crear y mostrar la tabla de la planificación
		table = new JTable();
		String[] datosTabla= new String[5];
		DefaultTableModel dtm= new DefaultTableModel();
		for(int columna=0;columna<datosTabla.length;columna++){
			dtm.addColumn("columna "+columna);
		}
		for(int fila=0;fila<10;fila++){
			for(int columna=0;columna<datosTabla.length;columna++){
				datosTabla[columna]="Celda "+fila+", "+columna;
			}
			dtm.addRow(datosTabla);
		}
		
		JPanel panelTabla = new JPanel();
		JTable datos= new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(datos);
		panelTabla.add(scrollPane);
		panelDivisor.add(panelTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accio=e.getActionCommand();
		if(accio.compareTo("MenuBtnPlanificacion")==0){
			ventanaPrincipal.cambiapanel("Planificacion");
			ventanaPrincipal.setTitle("Ever Health- Planificación");
		}else if(accio.compareTo("MenuBtnConsultarPlatos")==0){
			ventanaPrincipal.cambiapanel("ConsultarPlatos");
			ventanaPrincipal.setTitle("Ever Health- Consultar platos");
		}else if(accio.compareTo("MenuBtnConsultarAlimentos")==0){
			ventanaPrincipal.cambiapanel("ConsultarAlimentos");
			ventanaPrincipal.setTitle("Ever Health- Consultar alimentos");
		}
	}
}
