package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Katua;
import modelo.Katua.ileLuzea;
import modelo.Maskota;
import modelo.Txakurra;

public class Funtzioak {

	public Scanner teklatu = new Scanner(System.in);
//	private ArrayList<Katua> katuak;
//	private ArrayList<Txakurra> txakurrak;
	private ArrayList<Integer> idGuztiak;
	private ArrayList<Maskota> maskotak;
	private FitxeroFuntzioak fitxeroFuntzioak = new FitxeroFuntzioak();
	private SalbuespenaKudeatu salbupesnak = new SalbuespenaKudeatu();

	public void menu() {
		int emaitza = 0;

//		katuak = new ArrayList<Katua>();
//		txakurrak = new ArrayList<Txakurra>();
		maskotak = new ArrayList<Maskota>();
		idGuztiak = new ArrayList<Integer>();

		fitxeroFuntzioak.fitxeroaIrakurri(maskotak, idGuztiak);

		do {
			System.out.println("1- Maskota gehitzea " + "\n2- Datuak erakutsi " + "\n3- Maskota aldatzea"
					+ "\n4- Ezabatu maskota " + "\n5- Jabearen NAN bidezko maskota kentzea "
					+ "\n6- Bilatu maskota izenaren arabera" + "\n7- Irten");
			String katea = teklatu.nextLine();

			try {

				emaitza = Integer.parseInt(katea);

				switch (emaitza) {
				case 1:
					gehitu();
					break;

				case 2:
					datuakAurkeztu();
					break;

				case 3:

					break;

				case 4:

					System.out.println("Sartu maskotaren id ezabatzeko:");
					try {

						String idString = teklatu.nextLine();
						int id = Integer.parseInt(idString);

						EzabatuMaskota(id);

					} catch (Exception e) {
						System.out.println("Hori ez da zenbakia");
					}

					break;

				case 5:
					System.out.println("Sartu bilatu nahi duzun jabearen nan-a:");
					String jabeaNan = teklatu.nextLine();
					bilatuJabearenArabera(jabeaNan);
					break;

				case 6:
					System.out.println("Sartu bilatu nahi duzun maskotaren izena:");
					String izena = teklatu.nextLine();
					bilatuIzenarenArabera(izena);
					break;

				case 7:
					fitxeroFuntzioak.fitxeroaIdatzi(maskotak);
					System.out.println("Datuak fitxategi barruan gorde dira");
					break;

				}

			} catch (Exception e) {
				System.out.println("Sartu zenbaki balidoa");
			}

		} while (emaitza != 7);
	}

	private void gehitu() {

		boolean amaitu = false;

		do {
			System.out.println("Zer sartu nahi duzu? \n1.- Txakurra 2.- Katua");

			try {
				String katea = teklatu.nextLine();
				int aukera = Integer.parseInt(katea);

				int id = azkenIdLortu();
				System.out.println("Sartu izena:");
				String izena = teklatu.nextLine();
				int adina = adinaKudeatu();
				String jabeaNan = salbupesnak.NanSartu();

				if (aukera == 1) {

					boolean arkakusoak = arkakusoakKudeatu();
					System.out.println("Sartu erraza:");
					String erraza = teklatu.nextLine();

					Txakurra txakurra = new Txakurra(id, izena, adina, jabeaNan, erraza, arkakusoak);
					maskotak.add(txakurra);
					amaitu = true;
					break;

				} else if (aukera == 2) {

					ileLuzea ileaLuzeera = ileLuzeaDu();
					System.out.println("Sartu kolorea:");
					String kolerea = teklatu.nextLine();

					Katua katua = new Katua(id, izena, adina, jabeaNan, ileaLuzeera, kolerea);
					maskotak.add(katua);
					amaitu = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Hori ez da aukera balidoa");
			}

		} while (!amaitu);

	}

	private int adinaKudeatu() {
		boolean errorea = true;
		int adina = -1;

		do {
			System.out.println("Sartu adina:");
			try {
				String katea = teklatu.nextLine();
				adina = Integer.parseInt(katea);
				errorea = false;
			} catch (Exception e) {
				System.out.println("Hori ez da zenbaki");
			}
		} while (errorea);

		return adina;

	}

	private boolean arkakusoakKudeatu() {
		boolean errorea = true;
		boolean arkakusoak = false;

		do {
			System.out.println("Arkakusoak ditu:");

			String katea = teklatu.nextLine();

			if (katea.equalsIgnoreCase("bai")) {
				arkakusoak = true;
				errorea = false;

			} else if (katea.equalsIgnoreCase("ez")) {
				arkakusoak = false;
				errorea = false;
			} else {
				System.out.println("Hori ez da aukera");
			}
		} while (errorea);

		return arkakusoak;

	}

	private ileLuzea ileLuzeaDu() {
		ileLuzea ileTamaina = null;

		while (true) {
			System.out.println("Idatzi ile tamaina ditu: \nL \nM \nS");
			String katea = teklatu.nextLine();

			try {
				ileTamaina = ileLuzea.valueOf(katea.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Hori ez da aukera");
			}
		}

		return ileTamaina;
	}

	private int azkenIdLortu() {

		if (idGuztiak.isEmpty()) {
			return 1;
		} else {
			return idGuztiak.get(idGuztiak.size() - 1) + 1;
		}

	}

	private void datuakAurkeztu() {
		for (int i = 0; i < maskotak.size(); i++) {
			System.out.println(maskotak.get(i).toString());
		}
	}

	private void bilatuIzenarenArabera(String izena) {
		boolean aurkituta = false;

		for (Maskota maskota : maskotak) {
			if (maskota.getIzena().equalsIgnoreCase(izena)) {
				System.out.println(maskota.toString());
				aurkituta = true;
				break;
			}
		}

		if (!aurkituta) {
			System.out.println("Ez da aurkitu maskota izen horrekin.");
		}
	}

	private void bilatuJabearenArabera(String nanJabea) {
		boolean aurkituta = false;

		for (Maskota maskota : maskotak) {
			if (maskota.getJabearenNan().equalsIgnoreCase(nanJabea)) {
				System.out.println(maskota.toString());
				aurkituta = true;
				break;
			}
		}

		if (!aurkituta) {
			System.out.println("Ez da aurkitu maskota jabearen nan horrekin.");
		}
	}

	private void EzabatuMaskota(int id) {
		boolean ezabatuta = false;

		for (int i = 0; i < maskotak.size(); i++) {
			if (maskotak.get(i).getId() == id) {
				maskotak.remove(maskotak.get(i));
				System.out.println("Ezabatu da :D");
				ezabatuta = true;
				break;
			}
		}

		if (!ezabatuta) {
			System.out.println("Ez da aurkitu maskota id horrekin.");
		}
	}


//	public static String dateToString(Date dataAldatzeko) {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = sdf.format(dataAldatzeko);
//		
//		 return dateString;
//		    
//	}
//
//	public static Date stringToDate(String data) throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
//
//		Date date = formatter.parse(data);
//		return date;
//	}
	
	
	
}
