package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BDD.Conexio;

public class EmailVentana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCorreo;
	private Conexio c;

	/**
	 * Create the dialog.
	 */
	public EmailVentana(Conexio con) {
		c = con;
		setBounds(400, 200, 300, 180);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle("Confirmar correo electrónico");
		getContentPane().setLayout(new BorderLayout());
		{
			JLabel lblPregunta = new JLabel("\u00BFDeseas enviar la planificaci\u00F3n al siguiente correo?");
			getContentPane().add(lblPregunta, BorderLayout.NORTH);
		}
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setHgap(10);
		fl_contentPanel.setVgap(45);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCorreo = new JLabel("Correo:");
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
				JButton okButton = new JButton("Enviar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*
						 * String[] adjunto = new String[7];

						try {
							ResultSet rs = null;
							Statement cmd = null;
							rs = cmd.executeQuery(
									"SELECT Nombre, Email, Contrasenya, Genero, Altura, Peso, Objetivo, Actividad FROM Usuario"
											+ "  WHERE Nombre like " + c.getUsuario());

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

							
							File f;
							FileWriter fw = new FileReader(f);
							BufferedReader bw = new BufferedReader(fw) 
							
							
							bw.write 
							
							
							
							
							

						} catch (Exception e) {
							e.getMessage();
						}
	*/
						//Aquí se llama a Email con el archivo adjunto

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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

}
