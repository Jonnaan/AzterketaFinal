package vista;

import java.util.ArrayList;

import controlador.Metodos;
import modelo.Persona;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodos metodos = new Metodos();
		System.out.println("Hola");
		ArrayList<Persona> personas = metodos.cargarDatos();
		metodos.mostrarMenu(personas);
	}

}
