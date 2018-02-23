import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel {

	private JTable table;
	private static DefaultTableModel model;
	private ArrayList<Tema> temas;
	private JTextField busquedaTxtFld;  
	public PanelPrincipal(JFrame frame) {
		setLayout(null);

		JButton btnNewButton = new JButton("Nuevo Tema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CrearTema crearTema = new CrearTema(frame);

				frame.setContentPane(crearTema);
				frame.validate();

			}
		});
		btnNewButton.setBounds(10, 82, 116, 23);
		add(btnNewButton);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int columnn) {
				return false;
			}
		};

		table = new JTable(model);
		table.getTableHeader().setBackground(new Color(252, 252, 252));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		model.addColumn("Codigo Tema");
		model.addColumn("Nombre");
		model.addColumn("Palabra Clave");
		model.addColumn("Dia");
		model.addColumn("Mes");
		model.addColumn("Año");

		temas = TemaDAO.obtenerTemas();
		agregarTemas(temas);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(165, 37, 275, 239);
		add(scroll);

		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Tema tema = temas.get(table.getSelectedRow());

				EditarTema temaEdit = new EditarTema(frame, tema);

				frame.setContentPane(temaEdit);
				frame.validate();

			}
		});
		btnNewButton_1.setBounds(10, 131, 116, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tema tema = temas.get(table.getSelectedRow());
				TemaDAO tDAO = new TemaDAO();
				tDAO.eliminarTema(tema);
				model.removeRow(table.getSelectedRow());
				
				
			}
		});
		btnNewButton_2.setBounds(10, 181, 116, 23);
		add(btnNewButton_2);
		
		busquedaTxtFld = new JTextField();
		busquedaTxtFld.setBounds(165, 6, 275, 20);
		busquedaTxtFld.setColumns(10);
		busquedaTxtFld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				TemaDAO temaDAO = new TemaDAO();
				ArrayList<Tema> resultado = new ArrayList<Tema>();
					resultado.addAll(temaDAO.buscarTema(busquedaTxtFld.getText()));
					agregarTemas(resultado);
			}
		});
		add(busquedaTxtFld);

	}

	public static void agregarTemas(ArrayList<Tema> temas) {
		model.setRowCount(0);
		for (int i = 0; i < temas.size(); i++) {

			Object[] v = { temas.get(i).getIdTema(), temas.get(i).getNombre(), temas.get(i).getPalabraClave(),
					temas.get(i).getDia(), temas.get(i).getMes(), temas.get(i).getAño() };

			model.addRow(v);

		}

	}
}
