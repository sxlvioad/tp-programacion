
public class Tema {

	private int idTema;
	private String nombre;
	private String palabraClave;
	private String descripcion;
	private int dia;
	private int mes;
	private int a�o;

	public Tema(int idTema, String nombre, String palabraClave, String descripcion, int dia, int mes, int a�o) {

		this.idTema=idTema;
		this.nombre = nombre;
		this.palabraClave = palabraClave;
		this.descripcion = descripcion;
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;

	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
}
