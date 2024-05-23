package modelo;

public class Materia {
	private String nombre;
	private String grupo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Materia(String nombre, String grupo) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return  nombre + " " + grupo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
