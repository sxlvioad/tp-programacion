import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EditarTema extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public EditarTema (JFrame frame, Tema tema){
		
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 26, 51, 20);
		add(lblNombre);

		textField = new JTextField();
		textField.setBounds(24, 49, 397, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(26, 75, 145, 14);
		add(lblPalabraClave);

		textField_1 = new JTextField();
		textField_1.setBounds(26, 94, 125, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(209, 75, 125, 14);
		add(lblDescripcion);

		textField_2 = new JTextField();
		textField_2.setBounds(209, 94, 212, 137);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblFeca = new JLabel("Fecha");
		lblFeca.setBounds(26, 125, 66, 14);
		add(lblFeca);

		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(122, 141, 46, 14);
		add(lblDia);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(122, 169, 46, 14);
		add(lblMes);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(122, 194, 46, 14);
		add(lblAo);

		textField_3 = new JTextField();
		textField_3.setBounds(26, 138, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(26, 166, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(26, 191, 86, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		 textField.setText(tema.getNombre());
		 textField_1.setText(tema.getPalabraClave());
		 textField_2.setText(tema.getDescripcion());
		 Integer dia = new Integer(tema.getDia());
		 textField_3.setText(dia.toString());
		 Integer mes = new Integer(tema.getMes());
		 textField_4.setText(mes.toString());
		 Integer año = new Integer(tema.getAño());
		 textField_5.setText(año.toString());	
		
		JButton btnNewButton = new JButton("Editar Tema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				TemaDAO tDAO = new TemaDAO();
				Tema t = new Tema(tema.getIdTema(), textField.getText(), textField_1.getText(), textField_2.getText(), Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()));
				tDAO.editarTema(t);
				
				PanelPrincipal temaEdit = new PanelPrincipal(frame);

				frame.setContentPane(temaEdit);
				frame.validate();

				
			}
		});
		btnNewButton.setBounds(209, 242, 212, 23);
		add(btnNewButton);

		
		
		
		
	}
	
	
	
	

}
