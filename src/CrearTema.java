import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CrearTema extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public CrearTema(JFrame Frame) {

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

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre;
				String descripcion;
				String palabraClave;
				String dia;
				String mes;
				String año;

				nombre = textField.getText();
				palabraClave = textField_1.getText();
				descripcion = textField_2.getText();
				dia = textField_3.getText();
				mes = textField_4.getText();
				año = textField_5.getText();
				
				save(nombre, palabraClave, descripcion, dia, mes, año);
				
				PanelPrincipal crearTema = new PanelPrincipal(Frame);

				Frame.setContentPane(crearTema);
				Frame.validate();

			}
		});
		btnCrear.setBounds(209, 255, 212, 23);
		add(btnCrear);

	}
	
	public void save(String nombre, String palabraClave, String descripcion, String dia, String mes, String año){
		Tema r = new Tema (0, nombre, palabraClave, descripcion, new Integer(dia), new Integer (mes), new Integer (año));
		TemaDAO tDAO = new TemaDAO();
		tDAO.guardar(r);
		
	}
}
