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
import java.awt.Dimension;

public class Menu extends JPanel implements ActionListener{
	private JTextField txtCaloriasRestantes;
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
		btnHazTuPropio.setActionCommand("MenuBtnCrearPlato");
		btnHazTuPropio.addActionListener(this);
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
		String nombresColumnas[]= {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
		String[] datosTabla= new String[8];
		DefaultTableModel dtm= new DefaultTableModel();
		dtm.addColumn("");
		for(int columna=0;columna<nombresColumnas.length;columna++){
			dtm.addColumn(nombresColumnas[columna]);
		}
		for(int fila=0;fila<10;fila++){
			for(int columna=1;columna<datosTabla.length;columna++){
				datosTabla[columna]="Celda "+fila+", "+columna;
			}
			dtm.addRow(datosTabla);
		}
		
		JPanel panelTabla = new JPanel();
		JTable datos= new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (0 == column)
					return false;
				return super.isCellEditable(row, column);
			}
			@Override
			public void changeSelection(int rowIndex, int columnIndex,
					boolean toggle, boolean extend) {
				if (columnIndex == 0)
					// Podemos llamar a changeSelecion() incrementando la columna en 1
		            // o bien podríamos hacer directamente un return.
					super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
				else
					super.changeSelection(rowIndex, columnIndex, toggle, extend);
					}
				};
		datos.getColumnModel().getColumn(0).setCellRenderer(datos.getTableHeader().getDefaultRenderer());
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
		}else if(accio.compareTo("MenuBtnCrearPlato")==0){
			ventanaPrincipal.cambiapanel("CrearPlato");
			ventanaPrincipal.setTitle("Ever Health- Crear plato");
		}
	}
}
