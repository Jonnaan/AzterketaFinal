package control.metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.interfaces.I_MaskotaFitxaKude;
import modelo.objetos.Gato;
import modelo.objetos.Mascota;
import modelo.objetos.Perro;

public class MascotaFitxaKude extends MaskotaFitxaKudeAbstract implements I_MaskotaFitxaKude{

	@Override
	public ArrayList<Mascota> leerEnTXT() throws IOException {
		ArrayList<Mascota> maskotaList = new ArrayList<Mascota>();
		try {
			BufferedReader bR = new BufferedReader(new FileReader(path+filename));
			String linea;
			while ((linea = bR.readLine()) != null) {
				String[] palabras = linea.split(" ; ");
				
					if(palabras[0].equals("P")) {
						boolean pulgas ;
						if(palabras[6].equals("S")){
							pulgas = true;
						}else {
							pulgas = false;
						}
						Perro per = new Perro(Integer.parseInt(palabras[1]), palabras[2], Integer.parseInt(palabras[3]),palabras[4], palabras[5], pulgas);
						maskotaList.add(per);	

					}else {
						Gato katu = new Gato(Integer.parseInt(palabras[1]), palabras[2], Integer.parseInt(palabras[3]),palabras[4],palabras[5],palabras[6]);
						maskotaList.add(katu);	
					}	
			}			
			bR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return maskotaList;
	}

	
	
	
		@Override
		public void escribirEnTXT(ArrayList<Mascota> list) {
			try {
				BufferedWriter escritor = new BufferedWriter(new FileWriter("MaskotakDatuak.txt"));
	            for (Mascota m1 : list) {
	                escritor.write(m1.toString());
	                escritor.newLine();
	            }
	            System.out.println("Mascotas escritas en el archivo MaskotakDatuak.txt con éxito.");
	            escritor.close();
	        } catch (IOException e) {
	            System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        }
		}

}
