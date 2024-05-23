package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class GestorFichMascotas extends GestorFichMascotasAbstract implements GestorFichMascotasI {

	public ArrayList<Mascota> leer() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

		BufferedReader fichero = new BufferedReader(new FileReader(path + "/" + fileName));

		String linea;
		while ((linea = fichero.readLine()) != null) {
			String[] datos = linea.split(",");
			int id = Integer.valueOf(datos[1]);
			Mascota.idG = id + 1;
			String nombre = datos[2];
			int edad = Integer.valueOf(datos[3]);
			String dni = datos[6];
			if (datos[0].equals("P")) {
				String raza = datos[4];
				String pulgas = datos[5];
				boolean pul = false;
				if (pulgas.equals("S"))
					pul = true;
				try {
					Perro perro = new Perro(id, nombre, edad, dni, raza, pul);
					mascotas.add(perro);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Formato incorrecto del archivo");
				}

			} else {
				String color = datos[4];
				char pelo = datos[5].charAt(0);
				try {
					Gato gato = new Gato(id, nombre, edad, dni, color, pelo);
					mascotas.add(gato);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Formato incorrecto del archivo");
				}
			}

		}
		fichero.close();
		return mascotas;
	}

	public void guardar(ArrayList<Mascota> mascotas) throws IOException {
		// TODO Auto-generated method stub

		BufferedWriter fichero = new BufferedWriter(new FileWriter(path + "/" + fileName));

		for (Mascota mascota : mascotas) {

			fichero.write(mascota.toString());
			fichero.newLine();
		}

		fichero.close();

	}

}
