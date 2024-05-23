package modelo;

import java.util.ArrayList;

import excepciones.ExcepcionPropia;

public class Profesor extends Persona {
 private 	ArrayList<Materia> materias = new ArrayList<Materia>();
 
 public Profesor()
 {
	 
 }

public Profesor(String dni, String nombre, int dia, int mes, ArrayList<Materia> materias) throws ExcepcionPropia {
	super(dni, nombre, dia, mes);
	this.materias = materias;
}

@Override
public String toString() {
	return "Profesor: " + dni + " " + nombre + ", " + dia + " del " + mes+","+materias;	
	
}

public ArrayList<Materia> getMaterias() {
	return materias;
}

public void setMaterias(ArrayList<Materia> materias) {
	this.materias = materias;
}
}
