package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Katua;
import modelo.Maskota;
import modelo.Katua.ileLuzea;
import modelo.Txakurra;

public class FitxeroFuntzioak {

	private final String path = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\RepasoExamenes\\REPASO\\BigarrenAriketaErrepasoa\\MaskotaDatuak.txt";

	public void fitxeroaIrakurri(ArrayList<Maskota> maskotak, ArrayList<Integer> idGuztiak) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String lerroa;

			while ((lerroa = br.readLine()) != null) {
				if (lerroa.isEmpty()) {
					continue;
				}

				String[] lerroBakoitza = lerroa.split(",");
				char mota = lerroBakoitza[0].trim().charAt(0);
				// String mota = lerroBakoitza[0].trim();
				int id = Integer.parseInt(lerroBakoitza[1].trim());
				idGuztiak.add(id);
				String izena = lerroBakoitza[2].trim();
				int adina = Integer.parseInt(lerroBakoitza[3].trim());
				String jabearenNan = lerroBakoitza[6].trim();
				String razaEdokolorea = lerroBakoitza[4].trim();

				if (mota == 'P') {
					boolean arkakusoak = Boolean.parseBoolean(lerroBakoitza[5].trim());
					Txakurra txakurra = new Txakurra(id, izena, adina, jabearenNan, razaEdokolorea, arkakusoak);
					maskotak.add(txakurra);
				} else if (mota == 'G') {
					Katua katua = new Katua(id, izena, adina, jabearenNan, razaEdokolorea);
					ileLuzea ileLuzeaEnum = ileLuzea.valueOf(lerroBakoitza[5].trim());
					katua.setIleLuzea(ileLuzeaEnum);
					maskotak.add(katua);
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fitxeroaIdatzi(ArrayList<Maskota> maskotak) {
		berridatziFitxategi(path);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			for (Maskota maskota : maskotak) {
				String nombreClase = maskota.getClass().getSimpleName();
				String mota;

				if (nombreClase.equals("Katua")) {
					mota = "G"; 
				} else {
					mota = "P"; 
				}

				writer.write(mota);
				writer.write(", "); 
				
				writer.write(maskota.getId() + ", " + maskota.getIzena() + ", " + maskota.getAdina() + ", ");

				if (mota.equals("P")) {
					Txakurra txakurra = (Txakurra) maskota; 
					writer.write(txakurra.getArraza() + ", " + txakurra.isArkakusoak() + " ," + maskota.getJabearenNan());
				} else { 
					Katua katua = (Katua) maskota; 
					writer.write(katua.getKolorea() + ", " + katua.getIleLuzea() + " ," + maskota.getJabearenNan());
				}

				writer.newLine(); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void berridatziFitxategi(String path) {
	    File fitxategi = new File(path);
	    if (fitxategi.exists()) {
	    	fitxategi.delete();
	    }
	}

}
