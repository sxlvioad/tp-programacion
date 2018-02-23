import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TemaDAO {
	public void guardar(Tema t) {

		String url = "jdbc:mysql://localhost:3306/recuperatorio";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(url, "root", "admin");
			Statement st = (Statement) users.createStatement();
			PreparedStatement query = (PreparedStatement) users
					.prepareStatement("INSERT INTO temas  (nombre_tema, palabra_clave, descripcion, dia, mes, año)"
							+ "values (?,?,?,?,?,?)");
			query.setString(1, t.getNombre());
			query.setString(2, t.getPalabraClave());
			query.setString(3, t.getDescripcion());
			query.setInt(4, t.getDia());
			query.setInt(5, t.getMes());
			query.setInt(6, t.getAño());
			query.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Tema> obtenerTemas() {
		ArrayList<Tema> temas = new ArrayList<Tema>();
		String url = "jdbc:mysql://localhost:3306/recuperatorio";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(url, "root", "admin");
			Statement st = (Statement) users.createStatement();
			ResultSet rs;
			rs = st.executeQuery("SELECT * FROM temas");
			while (rs.next()) {
				Tema tema = new Tema(rs.getInt("id_tema"), rs.getString("nombre_tema"), rs.getString("palabra_clave"),
						rs.getString("descripcion"), rs.getInt("dia"), rs.getInt("mes"), rs.getInt("año"));
				temas.add(tema);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return temas;
	}

	public void editarTema(Tema tema) {
		String url = "jdbc:mysql://localhost:3306/recuperatorio";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(url, "root", "admin");
			Statement st = (Statement) users.createStatement();
			PreparedStatement query = (PreparedStatement) users
					.prepareStatement("UPDATE temas SET nombre_tema=?, palabra_clave=?, descripcion=?, dia=?, mes=?, año=? WHERE id_tema=?");
			

			query.setString(1, tema.getNombre());
			query.setString(2, tema.getPalabraClave());
			query.setString(3, tema.getDescripcion());
			query.setInt(4, tema.getDia());
			query.setInt(5, tema.getMes());
			query.setInt(6, tema.getAño());
			query.setInt(7, tema.getIdTema());
			query.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void eliminarTema(Tema tema) {
		String url = "jdbc:mysql://localhost:3306/recuperatorio";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(url, "root", "admin");
			Statement st = (Statement) users.createStatement();
			PreparedStatement query = (PreparedStatement) users
					.prepareStatement("DELETE FROM temas WHERE id_tema = ?");
			
			query.setInt(1, tema.getIdTema());
			query.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Tema> buscarTema (String texto) {
		
		String url = "jdbc:mysql://localhost:3306/recuperatorio";
		
		
		ArrayList<Tema> temas = new ArrayList<Tema>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection users = DriverManager.getConnection(url, "root", "admin");
			Statement st = (Statement) users.createStatement();

			ResultSet rs;
			rs = st.executeQuery("SELECT * FROM temas WHERE palabra_clave like'" + texto + "%'");
			while (rs.next()) {
				Tema tema = new Tema(rs.getInt("id_tema"), rs.getString("nombre_tema"), rs.getString("palabra_clave"),
						rs.getString("descripcion"), rs.getInt("dia"), rs.getInt("mes"), rs.getInt("año"));
				temas.add(tema);
			}
			users.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return temas;
	}

}
