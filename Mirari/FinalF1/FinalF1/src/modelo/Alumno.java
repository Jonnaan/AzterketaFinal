package modelo;

import java.util.ArrayList;

import excepciones.ExcepcionPropia;

public class Alumno extends Persona {
	
	public static int codigo = 1;
	
	public Alumno(ArrayList<Persona> per)
	{
		Alumno ultimoA = null;
		for (Persona persona : per) {
			if(persona instanceof Alumno)
			{
				ultimoA = (Alumno) persona;
			}
		}
		int num = 0;
		if( ultimoA != null)
			num = Integer.valueOf(ultimoA.getnMatricula().split("M")[1]);
		nMatricula = "M"+(num+1);
	}
	
	
	public Alumno()
	{
		nMatricula = "M"+codigo;
		codigo++;
	}

	public Alumno(String dni, String nombre, int dia, int mes, String nMatricula, String grupo) throws ExcepcionPropia {
		super(dni, nombre, dia, mes);
		this.nMatricula = nMatricula;
		this.grupo = grupo;
	}


	@Override
	public String toString() {
		return "Alumno: "+dni + " " + nombre + ", " + dia + " del " + mes+", "+ nMatricula+ ", "+grupo;
	}

	public String getnMatricula() {
		return nMatricula;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	private String nMatricula;
	private String grupo;
}
