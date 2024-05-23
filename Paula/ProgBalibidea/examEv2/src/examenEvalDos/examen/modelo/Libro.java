package examenEvalDos.examen.modelo;


import java.util.Date;
import java.util.Objects;

/**
 * OBJETO de la tabla t_libro
 */
public class Libro {

	private int id = 0;
	private String titulo = null;
	private String autor = null;
	private String editorial = null;
	private Date fechaPublicacion = null;
	
	public Libro(int id, String titulo, String autor, String editorial, Date fechaPublicacion) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Libro() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, editorial, fechaPublicacion, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(editorial, other.editorial)
				&& Objects.equals(fechaPublicacion, other.fechaPublicacion) && id == other.id
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", fechaPublicacion=" + fechaPublicacion + "]";
	}
}
