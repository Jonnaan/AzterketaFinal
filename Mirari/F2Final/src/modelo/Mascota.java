package modelo;



public class Mascota {
	
	public static int idG = 1;
	
	protected int id;
	protected String nombre;
	protected int edad;
	protected String dni;
	
	public Mascota()
	{
	}
	
	
	public Mascota(int q)
	{
		id = idG;
		idG++;
	}

	public int getId() {
		return id;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		try {
			Integer.valueOf(edad);
			this.edad = edad;
		} catch (Exception ex) {
			throw new Exception("La edad no es un número");
		}

	}

	public Mascota(int id, String nombre, int edad, String dni) throws Exception {
		this.id = id;
		this.nombre = nombre;
		setEdad(edad);
		setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws Exception {
		if (dni.length() == 9) {
			String num = dni.substring(0, 8);
			try {
				Integer.valueOf(num);
				this.dni = dni;
			} catch (Exception ex) {
				throw new Exception("El dni no es número");
			}
		}
		else
			throw new Exception("El dni no tiene 9 carácteres");

	}
}
