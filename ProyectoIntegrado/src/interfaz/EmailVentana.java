package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;

//import org.apache.poi.xwpf.usermodel.XWPFDocument;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import BDD.Conexio;

public class EmailVentana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCorreo;
	private Conexio c;

	/**
	 * Create the dialog.
	 */
	public EmailVentana(Conexio con, ArrayList<String> arrayIdioma) {
		c = con;
		setBounds(400, 200, 300, 180);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle(arrayIdioma.get(106));
		getContentPane().setLayout(new BorderLayout());
		{
			JLabel lblPregunta = new JLabel(arrayIdioma.get(107));
			getContentPane().add(lblPregunta, BorderLayout.NORTH);
		}
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setHgap(10);
		fl_contentPanel.setVgap(45);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCorreo = new JLabel(arrayIdioma.get(108));
			contentPanel.add(lblCorreo);
		}
		{
			textFieldCorreo = new JTextField();
			contentPanel.add(textFieldCorreo);
			textFieldCorreo.setColumns(15);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(arrayIdioma.get(109));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						// Aquí se llama a Email con el archivo adjunto

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton(arrayIdioma.get(110));
				cancelButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}

				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void formarFichero() {
		String[] adjunto = new String[7];

		try {

			ResultSet rs = null;
			Statement cmd = null;
			rs = cmd.executeQuery(
					"SELECT Nombre, Email, Contrasenya, Genero, Altura, Peso, Objetivo, Actividad FROM Usuario"
							+ "  WHERE Nombre = " + c.getUsuario());

			while (rs.next()) {
				adjunto[0] = rs.getString("Nombre");
				adjunto[1] = rs.getString("Email");
				adjunto[2] = rs.getString("Contrasenya");
				adjunto[3] = rs.getString("Genero");
				adjunto[4] = rs.getString("Altura");
				adjunto[5] = rs.getString("Peso");
				adjunto[6] = rs.getString("Objetivo");
				adjunto[7] = rs.getString("Actividad");

			}

		} catch (Exception e) {
			e.getMessage();
		}
		
		try {
			
			FileOutputStream fichero = new FileOutputStream("datos.docx");
			
			
			
			
		}catch(Exception e) {
			e.getMessage();			
			
		}

	}
}
