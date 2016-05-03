package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class DiaPlanificacion extends JPanel {

	private String dia;
	/**
	 * Create the panel.
	 */
	public DiaPlanificacion(String d) {
		dia=d;
		JLabel labelDia = new JLabel(dia);
		add(labelDia);

	}
	public String getNomDia(){
		return dia;
	}

}
