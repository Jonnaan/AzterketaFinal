package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import excepciones.ExcepcionPropia;
import modelo.Alumno;
import modelo.Materia;
import modelo.Persona;
import modelo.Profesor;

public class Metodos {

	GestorAlumnos gestorAlumnos = new GestorAlumnos();
	GestorProfesores gestorProfesores = new GestorProfesores();

	public ArrayList<Persona> cargarDatos() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
	

		try {
			 BufferedReader	ficheroAlumnos = new BufferedReader(new FileReader("archivos/Alumnos.txt"));
			 BufferedReader ficheroProfesores = new BufferedReader(new FileReader("archivos/Profesores.txt"));
		
	      
	     
	      String linea; 
	      while((linea = ficheroAlumnos.readLine())!=null) 
	      {
	    	  String sub = linea.split(":")[1];
	    	  String dni = sub.split(" ")[1];
	    	  String nombre = sub.split(" ")[2].split(",")[0];
	    	  String fechas = sub.split(",")[1];
	    	  int dia = Integer.valueOf(fechas.split(" ")[1]);
	    	  int mes = Integer.valueOf(fechas.split(" ")[3]);
	    	  String codigo = sub.split(",")[2].trim();
	    	  String grupo = sub.split(",")[3].trim();
	    	  Alumno al = null;
			try {
				al = new Alumno(dni,nombre,dia,mes,codigo,grupo);
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
					System.out.println("Formato incorrecto del alumno");
			}
	    	  personas.add(al);
	    	  
	    	  int num = Integer.valueOf( codigo.split("M")[1]);
	    	  Alumno.codigo = num+1;

	      }
	      
	      while((linea = ficheroProfesores.readLine())!=null) 
	      {
	    	  String sub = linea.split(":")[1];
	    	  String dni = sub.split(" ")[1];
	    	  String nombre = sub.split(" ")[2].split(",")[0];
	    	  String fechas = sub.split(",")[1];
	    	  int dia = Integer.valueOf(fechas.split(" ")[1]);
	    	  int mes = Integer.valueOf(fechas.split(" ")[3]);
	    	  String asig = sub.split("\\[")[1];
	    	  String asig2 = asig.split("\\]")[0]; 
	    	  String[] asigs = asig2.split(",");
	    	  ArrayList<Materia> materias = new ArrayList<Materia>();
	    	  for (String asignatura : asigs) {
	    		  String nombremat = asignatura.split(" ")[0].trim();
	    		  String grupo = asignatura.split(" ")[1].trim();

				Materia mat = new Materia(nombremat,grupo);
				materias.add(mat);
			}
	    	  

	    	  
	    	  Profesor profe = null;
			try {
				profe = new Profesor(dni,nombre,dia,mes,materias);
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  personas.add(profe);

	      }
	 	ficheroAlumnos.close();
		ficheroProfesores.close();
	      
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} 
		// Carga del txt
		return personas;

	}

	public void mostrarMenu(ArrayList<Persona> personas) {

		Scanner sc = new Scanner(System.in);
		int opc = -1;
		do {
			System.out.println(
					"1. Añadir persona.\r\n" + "2. Mostrar datos\r\n" + "3. Modificar datos de alumno/profesor\r\n"
							+ "4. Eliminar alumno/profesor\r\n" + "5. Felicitar\r\n" + "6. Buscar alumno por grupo\r\n"
							+ "7. Buscar profesores por materia\r\n" + "8. Salir");
			opc = PedirInt(sc, 1, 8, "Elija la opción");

			switch (opc) {
			case 1:
				anyadirPersona(sc, personas);
				break;
			case 2:
				mostrarDatos(personas);
				break;
			case 3:
				modificar(sc, personas);
				break;
			case 4:
				eliminar(sc, personas);
				break;
			case 5:
				felicitar(sc, personas);
				break;
			case 6:
				buscarAlumno(sc, personas);
				break;
			case 7:
				buscarProfe(sc, personas);
				break;
			case 8:
				salir(personas);
				break;
			}
		} while (opc != 8);
	}

	private void salir(ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter ficheroProfes = new BufferedWriter(new FileWriter("archivos/Profesores.txt"));

			BufferedWriter ficheroAlumnos = new BufferedWriter(new FileWriter("archivos/Alumnos.txt"));
			for (Persona persona : personas) {

				if (persona instanceof Profesor) {
					ficheroProfes.write(persona.toString());
					ficheroProfes.newLine();
				} else {
					ficheroAlumnos.write(persona.toString());
					ficheroAlumnos.newLine();
				}

			}

			ficheroProfes.close();
			ficheroAlumnos.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S ");
		}
	}

	private void buscarProfe(Scanner sc, ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca la materia");
		String materia = sc.nextLine();
		int i = 0;
		while (i < personas.size()) {
			if (personas.get(i) instanceof Profesor) {
				Profesor profe = (Profesor) personas.get(i);
				boolean doy = false;
				for (Materia materia2 : profe.getMaterias()) {
					if (materia2.getNombre().equalsIgnoreCase(materia)) {
						doy = true;
					}
				}
				if (doy)
					System.out.println(profe.toString());

			}
			i++;
		}
	}

	private void buscarAlumno(Scanner sc, ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Introduzca un grupo");
		String grupo = sc.nextLine();
		int i = 0;
		while (i < personas.size()) {
			if (personas.get(i) instanceof Alumno) {
				Alumno alum = (Alumno) personas.get(i);

				if (alum.getGrupo().equalsIgnoreCase(grupo)) {
					System.out.println(alum.toString());
				}
			}
			i++;
		}

	}

	private void felicitar(Scanner sc, ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		int mes = PedirInt(sc, 1, 12, "Introduce el mes de cumpleaños (Número)");
		int dia = PedirInt(sc, 1, 31, "Introduce el día de cumpleaños");
		int i = 0;
		while (i < personas.size()) {
			if (personas.get(i).getDia() == dia && personas.get(i).getMes() == mes) {
				System.out.print("Felicidades ");
				if (personas.get(i) instanceof Alumno)
					System.out.print("Alumno: ");
				else
					System.out.print("Profesor: ");
				System.out.println(personas.get(i).getNombre());
			}
			i++;
		}
	}

	private void eliminar(Scanner sc, ArrayList<Persona> personas) {
		String dni = introducirDNI(sc);
		Persona persona = buscarPorDNI(dni, personas);
		if (persona != null)
			personas.remove(persona);
		else
			System.out.println("Persona no encontrada");
	}

	private void modificar(Scanner sc, ArrayList<Persona> personas) {
		String dni = introducirDNI(sc);
		Persona persona = buscarPorDNI(dni, personas);
		if (persona != null) {
			int opc = -1;
			do {
				System.out.print("¿Qué quieres cambiar?\\r\\n\" + \"1. Nombre\\r\\n\"" + "2. Día y Mes\\r\\n\"");
				if (persona instanceof Alumno) {
					System.out.print("3. Grupo\\r\\n\"");

				} else
					System.out.print("3. Cambiar materias\\r\\n\"");
				System.out.println("4. Salir modo cambio");
				opc = PedirInt(sc, 1, 4, "Elija una opción");
				switch (opc) {
				case 1:
					System.out.println("Introduce el nombre");
					String nombre = sc.nextLine();
					persona.setNombre(nombre);
					break;
				case 2:
					boolean error = false;
					do {
						int mes = PedirInt(sc, 1, 12, "Introduce el mes de cumpleaños (Número)");
						try {
							persona.setMes(mes);
							error = false;
						} catch (ExcepcionPropia e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							error = true;
						}
					} while (error);
					error = false;
					do {

						int dia = PedirInt(sc, 1, 31, "Introduce el día de cumpleaños");
						try {
							persona.setDia(dia);
							error = false;
						} catch (ExcepcionPropia e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							error = true;
						}
					} while (error);
					break;

				case 3:
					if (persona instanceof Alumno) {
						Alumno alum = (Alumno) persona;
						System.out.println("Introduce el número de grupo");
						String grupo = sc.nextLine();
						alum.setGrupo(grupo);

					} else {
						ArrayList<Materia> materias = pedirMaterias(sc);
						Profesor prof = (Profesor) persona;
						prof.setMaterias(materias);
					}
					break;
				}
			} while (opc != 4);
		} else
			System.out.println("No encontrado");

	}

	private Persona buscarPorDNI(String dni, ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		Persona persona = null;
		int i = 0;
		do {
			if (dni.equals(personas.get(i).getDni()))
				persona = personas.get(i);
			i++;
		} while (i < personas.size() && !dni.equals(personas.get(i - 1).getDni()));
		return persona;
	}

	private String introducirDNI(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Introduce el DNI");
		return sc.nextLine();
	}

	private void mostrarDatos(ArrayList<Persona> personas) {
		// TODO Auto-generated method stub
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}

	private void anyadirPersona(Scanner sc, ArrayList<Persona> personas) {
		// TODO Auto-generated method stub

		Profesor prof = new Profesor();
		boolean error = false;
		do {
			String dni = introducirDNI(sc);
			try {
				prof.setDni(dni);
				error = false;
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);

		System.out.println("Introduce el nombre");
		String nombre = sc.nextLine();
		prof.setNombre(nombre);

		do {
			int mes = PedirInt(sc, 1, 12, "Introduce el mes de cumpleaños (Número)");
			try {
				prof.setMes(mes);
				error = false;
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);

		do {
			int dia = PedirInt(sc, 1, 31, "Introduce el día de cumpleaños");
			try {
				prof.setDia(dia);
				error = false;
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);

		int tipo = PedirInt(sc, 1, 2, "Quiere añadir profesor (1) , o alumno (2)");
		if (tipo == 2) {
			System.out.println("Introduce el número de grupo");
			String grupo = sc.nextLine();
			Alumno alumno = new Alumno();
			try {
				alumno.setDni(prof.getDni());
				alumno.setNombre(prof.getNombre());
				alumno.setMes(prof.getMes());
				alumno.setDia(prof.getDia());
				alumno.setGrupo(grupo);
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			}
			personas.add(alumno);

		} else {
			ArrayList<Materia> materias = pedirMaterias(sc);
			prof.setMaterias(materias);
			personas.add(prof);
		}

	}

	private ArrayList<Materia> pedirMaterias(Scanner sc) {
		// TODO Auto-generated method stub
		ArrayList<Materia> materias = new ArrayList<Materia>();
		int cont = 0;
		String con = "";
		do {
			System.out.println("Introduce el nombre de la materia");
			String nombre = sc.nextLine();
			System.out.println("Introduce el número de grupo");
			String grupo = sc.nextLine();
			Materia materia = new Materia(nombre, grupo);
			materias.add(materia);
			cont++;
			System.out.println("Quiere introducir más materias (S/N)");
			con = sc.nextLine();
		} while (cont < 5 && (con.charAt(0) == 's' || con.charAt(0) == 'S'));
		return materias;
	}

	private int PedirInt(Scanner sc, int min, int max, String texto) {
		int opc = -1;
		do {
			System.out.println(texto);
			String dato = sc.nextLine();
			try {
				opc = Integer.valueOf(dato);
				if (opc < min || opc > max)
					opc = -1;
			} catch (NumberFormatException e) {
				// No saco mensaje de error
			}
		} while (opc == -1);
		// TODO Auto-generated method stub
		return opc;
	}

}
