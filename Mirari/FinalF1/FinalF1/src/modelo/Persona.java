package modelo;

import excepciones.ExcepcionPropia;

public abstract class Persona {
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws ExcepcionPropia {

		if (dni.length() == 9) {
			String num = dni.substring(0, 8);
			try {
				Integer.valueOf(num);
				this.dni = dni;
			} catch (Exception ex) {
				throw new ExcepcionPropia("El dni no es número");
			}
		}
		else
			throw new ExcepcionPropia("El dni no tiene 9 carácteres");

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws ExcepcionPropia {
		boolean correcto = true;
		switch (this.mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			if (dia < 0 || dia > 31)
				correcto = false;
			break;
		case 2:
			if (dia < 0 || dia > 29)
				correcto = false;
			break;
		case 4: case 6: case 9: case 11:
			if (dia < 0 || dia > 30)
				correcto = false;
			break;	
		}
		if(correcto)
		this.dia = dia;
		else
			throw new ExcepcionPropia("El mes no está correcto");
	}

	public Persona(String dni, String nombre, int dia, int mes) throws ExcepcionPropia {
		super();
		setDni(dni);
		this.nombre = nombre;
		setDia(dia);
		setMes(mes);
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws ExcepcionPropia {
		if (mes < 0 || mes > 12)
			throw new ExcepcionPropia("El mes no es válido");
		else
			this.mes = mes;
	}

	public Persona()
	{
		
	}
	
	protected String dni;
	protected String nombre;
	protected int dia;
	protected int mes;
}
