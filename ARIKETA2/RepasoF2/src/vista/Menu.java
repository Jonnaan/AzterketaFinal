package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import control.metodos.*;
import modelo.objetos.Gato;
import modelo.objetos.Mascota;
import modelo.objetos.Perro;

public class Menu {

	public void menuaAtera() throws IOException {
		MascotaFitxaKude fitxaKudeatxailea = new MascotaFitxaKude();
		ArrayList<Mascota> maskotaList = fitxaKudeatxailea.leerEnTXT();
		Scanner sc = new Scanner(System.in);
		int aukera;
		do {

			System.out.println("------------------Sartu zure aukera------------------");
			System.out.println("1. Maskota sartu");
			System.out.println("2. Datuak erakutsi");
			System.out.println("3. Maskota aldatu");
			System.out.println("4. Maskota ezabatu");
			System.out.println("5. Jabearen NAN bidezko maskota kentzea");
			System.out.println("6. Bilatu maskota izenaren arabera");
			System.out.println("7. Irten");
			aukera = balidatuZenbakia(sc);
			switch (aukera) {
			case 1:
				sortuMaskota(maskotaList, sc);
				break;
			case 2:
				datuakAurkeztu(maskotaList);
				// Irakurri
				break;
			case 3:
				Mascota m = bilatuIzena(maskotaList, sc);

				aldatuDatuak(maskotaList, m, sc);
				System.out.println(m.toString());
				break;
			case 4:
				// Maskota ezabatu por nombre
				Mascota m1 = bilatuIzena(maskotaList, sc);
				removeMaskota(maskotaList, m1);

				break;
			case 5:
				Mascota m2 = bilatuNan(maskotaList, sc);
				removeMaskota(maskotaList, m2);
				break;
			case 6:
				bilatuIzena(maskotaList, sc);
				break;
			case 7:
				fitxaKudeatxailea.escribirEnTXT( maskotaList);
				break;
			default:
				System.out.println("Aukera okerra");
				break;
			}
		} while (aukera != 7);
	}

	private static int balidatuZenbakia(Scanner sc) {
		int aukera = -1;
		boolean error = true;
		do {
			System.out.println("Sartu zure aukera");
			String textua = sc.nextLine();
			try {
				aukera = Integer.valueOf(textua);
				if (aukera >= 1 && aukera <= 7)
					error = false;

			} catch (Exception ex) {
				error = true;
				System.err.println("Ez da zenbakia edo tartez lanpo");

			}
		} while (error);
		return aukera;
	}

	public static void datuakAurkeztu(ArrayList<Mascota> maskotaList) {

		for (Mascota mascota : maskotaList) {

			System.out.println(mascota.toString());

		}

	}

	public Mascota bilatuNan(ArrayList<Mascota> maskotaList, Scanner sc) {

		System.out.println("Sartu nahi duzun NAN-a");

		String nana = sc.nextLine();

		for (int i = 0; i < maskotaList.size(); i++) {
			if (maskotaList.get(i).getNAN_Jabe().equals(nana)) {
				return maskotaList.get(i);
			}
		}
		System.out.println("Ez da aurkitu NAN-a");

		return null;

	}

	public Mascota bilatuIzena(ArrayList<Mascota> maskotaList, Scanner sc) {

		System.out.println("Sartu nahi duzun izena");

		String izena = sc.nextLine();

		for (int i = 0; i < maskotaList.size(); i++) {
			if (maskotaList.get(i).getIzena().equals(izena)) {
				return maskotaList.get(i);
			}
		}
		System.out.println("Ez da aurkitu izena");

		return null;

	}

	public void removeMaskota(ArrayList<Mascota> maskotaList, Mascota m) {
		maskotaList.remove(m);
		System.out.println("Dena ezabatu egin da :");
		datuakAurkeztu(maskotaList);

	}

	public void aldatuDatuak(ArrayList<Mascota> maskotaList, Mascota m, Scanner sc) {

		for (Mascota maskota : maskotaList) {
			if (maskota.equals(m)) {

				System.out.println("Zein datu aldatu nahi duzu?");
				System.out.println("1. Id-a");
				System.out.println("2. Izena");
				System.out.println("3. Adina(Osoa!!)");
				System.err.println("4. NAN_Jabe");
				System.out.println("5. Arraza(Perro)");
				System.out.println("6. Pulgas(Perro)");
				System.out.println("7. Kolorea(Gato)  ");
				System.out.println("8. Pelo(Gato)  ");

				int aldaketa = sc.nextInt();
				switch (aldaketa) {
				case 1:
					System.out.println("Zein da zure Id-a?");
					int id = sc.nextInt();
					maskota.setId(id);
					break;
				case 2:
					System.out.println("Zein da zure izena?");
					String izena = sc.nextLine();
					maskota.setIzena(izena);
					break;
				case 3:
					System.out.println("Zein da zure Adina?");
					int adina = sc.nextInt();
					maskota.setAdina(adina);

					break;
				case 4:
					System.out.println("Zein da zure NAN_Jabe?");
					String nana = sc.nextLine();
					maskota.setNAN_Jabe(nana);
					break;
				case 5:
					if (maskota instanceof Perro) {
						System.out.println("Zein da zure Arraza(Perro)?");
						String arraza = sc.nextLine();
						((Perro) maskota).setArraza(arraza);
					} else {
						System.out.println("Eres un gato no puedes");
					}
					break;
				case 6:
					if (maskota instanceof Perro) {
						System.out.println("Zein da zure Pulgas(Perro)(S/N)?");
						String pulgas = sc.nextLine();
						if (pulgas.equals("S")) {
							((Perro) maskota).setArkakusoak(true);

						} else {
							((Perro) maskota).setArkakusoak(false);

						}
					} else {
						System.out.println("Eres un gato no puedes");
					}

					break;
				case 7:
					if (maskota instanceof Gato) {
						System.out.println("Zein da zure Kolorea(GATO)?");
						String Kolorea = sc.nextLine();
						((Gato) maskota).setKolorea(Kolorea);
					} else {
						System.out.println("Eres un Perro no puedes");
					}
					break;
				case 8:
					if (maskota instanceof Gato) {
						System.out.println("Zein da zure hile TAMAÑO (L/M/C)(GATO)?");
						String hilea = sc.nextLine();
						((Gato) maskota).setIleLuzea(hilea);

					} else {
						System.out.println("Eres un Perro no puedes");
					}
					break;

				}
			}
		}
	}

	public ArrayList<Mascota> sortuMaskota(ArrayList<Mascota> maskotaList, Scanner sc ) {

		System.out.println("QUE QUIERES CREAR?");
		System.out.println("1-PERRO" + "\n 2-GATO");

		int mota =  Integer.parseInt(sc.nextLine());
		System.out.println("1. Id-a");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("2. Izena");
		String izena = sc.nextLine();
		
		System.out.println("3. Adina(Osoa!!)");
		int adina = Integer.parseInt(sc.nextLine());
		
		System.out.println("4. NAN_Jabe");
		String NAN_Jabe = sc.nextLine();

		if (mota == 1) {

			

			System.out.println("5. Arraza(Perro)");
			String arraza = sc.nextLine();
			System.out.println("6. Pulgas(Perro)(S/N)");
			String pulga = sc.nextLine();
			if (pulga.equals("S")) {
				Perro per = new Perro(id, izena, adina, NAN_Jabe, arraza, true);

				maskotaList.add(per);

			} else {
				Perro per = new Perro(id, izena, adina, NAN_Jabe, arraza, false);
				maskotaList.add(per);

			}

		} else {

			System.out.println("7. Kolorea(Gato)  ");
			String kolorea = sc.nextLine();
			System.out.println("8. Pelo(Gato)  ");
			String pelo = sc.nextLine();
			Gato katua = new Gato(id, izena, adina, NAN_Jabe, kolorea, pelo);
			maskotaList.add(katua);

		}
		return maskotaList;
	}
}
