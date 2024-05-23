package controlador;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class Metodos {
	GestorFichMascotas gestor = new 		GestorFichMascotas();
	

	public void Menu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		GestorFichMascotas gestor = new 		GestorFichMascotas();
		try {
			mascotas = gestor.leer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar: "+e.getMessage());
		}
		int opc = -1;
		do {
		System.out.println("1. Añadir mascota.\r\n"
				+ "2. Mostrar datos\r\n"
				+ "3. Modificar mascota.\r\n"
				+ "4. Eliminar mascota.\r\n"
				+ "5. Eliminar mascota por DNI del dueño.\r\n"
				+ "6. Buscar mascota por nombre\r\n"
				+ "7. Salir");
		opc = PedirInt(sc,1,7,"Introduce una opción");
		switch(opc)
		{
		case 1: anyadirMascota(sc,mascotas);
		break;
		case 2: imprimir(mascotas);
		break;
		case 3: modificar(sc, mascotas);
		break;
		case 4: eliminar(sc, mascotas);
		break;
		case 5: eliminarDNI(sc, mascotas);
		break;
		case 6: buscar(sc, mascotas);
		break;
		case 7: guardar(mascotas);
		break;
		}
		}
		while(opc != 7);
		
	}
	

	private void buscar(Scanner sc, ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		String dni = introducirDNI(sc);
		Mascota mas = busquedaDNI(mascotas, dni);
		if(mas != null)
		{
			System.out.println(mas);
		}
		else
			System.out.println("No encuentro");
	}


	private Mascota busquedaDNI(ArrayList<Mascota> mascotas, String dni) {
		// TODO Auto-generated method stub
		Mascota mascota = null;
		
		int i = 0;
		do {
			if (dni.equals(mascotas.get(i).getDni()))
				mascota = mascotas.get(i);
			i++;
		} while (i < mascotas.size() && !dni.equals(mascotas.get(i).getDni()));
	
		return mascota;
	}


	private void eliminarDNI(Scanner sc, ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		
			String dni = introducirDNI(sc);
			EliminarPorDNI(mascotas, dni);
		
		
		
	}


	private void EliminarPorDNI(ArrayList<Mascota> mascotas, String dni) {
		// TODO Auto-generated method stub

		int i = 0;
		do {
			if (dni.equals(mascotas.get(i).getDni()))
				mascotas.remove(i);
			else
			i++;
		} while (i < mascotas.size());
	
	}


	private void eliminar(Scanner sc, ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		int id =	PedirInt(sc, 1, "Introduce un id");
		Mascota mas = busqueda(mascotas, id);
		if(mas != null)
		{
			mascotas.remove(mas);
		}
	}


	private void modificar(Scanner sc, ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		int id =	PedirInt(sc, 1, "Introduce un id");
		Mascota mas = busqueda(mascotas, id);
		if(mas != null)
		{
			System.out.println("Introduce un nombre");
			String nombre =sc.nextLine();
			mas.setNombre(nombre);
			try  {
				int edad =	PedirInt(sc, 1, 150, "Introduce edad");
				mas.setEdad(edad);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				
				}
		
		}
		else
			System.out.println("No encuentro");
	}


	private Mascota busqueda(ArrayList<Mascota> mascotas, int id) {
		// TODO Auto-generated method stub
		Mascota mascota = null;
	
		int i = 0;
		do {
			if (id == mascotas.get(i).getId())
				mascota = mascotas.get(i);
			i++;
		} while (i < mascotas.size() && id != mascotas.get(i - 1).getId());
	
		return mascota;
	}


	private void anyadirMascota(Scanner sc, ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
	
		int opc =	PedirInt(sc, 1, 2, "¿Qué mascota quiere? 1 Gato, 2 Pero");
		System.out.println("Introduce un nombre");
		String nombre =sc.nextLine();
		Mascota mascota = new Mascota(1);
		int edad =	PedirInt(sc, 1, 150, "Introduce edad");

	
		boolean error = false;
		do {
		
			String dni = introducirDNI(sc);
			try {
				mascota.setDni(dni);
				error = false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);
		
		if(opc == 1)
		{
			Gato gato = new Gato();
			try {
				gato.setDni(mascota.getDni());
				gato.setEdad(edad);
				gato.setNombre(nombre);
				gato.setId(mascota.getId());
				System.out.println("Introduce un color");
				String color =sc.nextLine();
				gato.setColor(color);
		
				error = false;
				do {
				
					try {
						System.out.println("Introduce largura");
						char largura =sc.nextLine().charAt(0);
						gato.setPelo(largura);
						error = false;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						error = true;
					}
				} while (error);
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error dni");
			}
			mascotas.add(gato);
			
		}
		else
		{
			Perro perro = new Perro();
			try {
				perro.setDni(mascota.getDni());
				perro.setEdad(edad);
				perro.setNombre(nombre);
				perro.setId(mascota.getId());
				System.out.println("Introduce una raza");
				String raza =sc.nextLine();
				perro.setRaza(raza);
				
			
				
				String  respuesta;
				do {
				
						System.out.println("¿Tiene pulgas? S o N");
						respuesta  =sc.nextLine();
						
					
				} while (!respuesta.equals("S") && !respuesta.equals("N"));
				if(respuesta.equals("S"))
					perro.setPulgas(true);
				else
					perro.setPulgas(false);

				mascotas.add(perro);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error dni");
			}
		}
		
		
	

	}


	private String introducirDNI(Scanner sc) {
		System.out.println("Introduce el DNI");
		return sc.nextLine();
	}


	private void guardar(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		try {
			gestor.guardar(mascotas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar: "+e.getMessage());
		}
	}


	private void imprimir(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		for (Mascota mascota : mascotas) {
			System.out.println(mascota.toString());
		}
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
	private int PedirInt(Scanner sc, int min, String texto) {
		int opc = -1;
		do {
			System.out.println(texto);
			String dato = sc.nextLine();
			try {
				opc = Integer.valueOf(dato);
				if (opc < min )
					opc = -1;
			} catch (NumberFormatException e) {
				// No saco mensaje de error
			}
		} while (opc == -1);
		// TODO Auto-generated method stub
		return opc;
	}

}
