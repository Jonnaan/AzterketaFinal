package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Funciones.Funtzioak;
import Pojos.Ikasle;
import Pojos.Irakaslea;
import Pojos.Pertsona;
import Pojos.Taldea;
import Salbuespenak.EgunaSalbuespena;
import Salbuespenak.HilabeteSalbuespena;
import Salbuespenak.MatrikulaSalbuespena;
import Salbuespenak.konprobatuNAN;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static Taldea talde;
	public static ArrayList<Ikasle> ikasleak = new ArrayList<Ikasle>(100);
	public static ArrayList<Irakaslea> irakasleak = new ArrayList<Irakaslea>();

	public static void main(String[] args) {

		talde = new Taldea("kk");
		Ikasle ikasle = new Ikasle(null, null, 0, 0, null, null);

		ikasleak.add(ikasle);
		talde.setIkasleak(ikasleak);
		menu();

		egunaEskatu(sc);
		hilabeteEskatu(sc);
	}

	public static void menu() {
		System.out.println("|===============================================|");
		System.out.println("|                     MENU                      |");
		System.out.println("|===============================================|");
		System.out.println("| 1.- Gehitu pertsona                           |");
		System.out.println("| 2.- Datuak erakutsi                           |");
		System.out.println("| 3.- Ikaslearen/irakaslearen datuak aldatzea   |");
		System.out.println("| 4.- Ezabatu ikaslea/irakaslea                 |");
		System.out.println("| 5.- Zorionak ematea                           |");
		System.out.println("| 6.- Bilatu ikaslea taldeka                    |");
		System.out.println("| 7.- Irakasgaiaren arabera irakasleak bilatzea |");
		System.out.println("| 8.- Irten                                     |");
		System.out.println("|===============================================|");
		int aukera = 0;

		switch (aukera) {
		case 1: {

			ikasleakGehitu(sc);

			// Gehitu pertsona
			break;
		}
		case 2: {
			// Datuak erakutsi
			ikaslearen_IrakaslearenDatuak();

			break;
		}
		case 3: {
			aldatuInfo(bilatuNana(sc));
			// Ikaslearen/irakaslearen datuak aldatzea
			break;
		}
		case 4: {
			// Ezabatu ikaslea/irakaslea
			pertsonaEzabatu(sc);
			break;
		}
		case 5: {
			// Zorionak ematea
			break;
		}
		case 6: {
			bilatuIkasleaTaldeka("kk");
			// Bilatu ikaslea taldeka
			break;
		}
		case 7: {
			// Irakasgaiaren arabera irakasleak bilatzea
			break;
		}
		case 8: {
			System.out.println("Datu guztiak, txt-ean gorde egin da");
			break;
		}
		}

	}

	// --- Sortu ikaslea -----------------------------

	public static void ikasleakGehitu(Scanner sc) {

		System.out.println("Sarti ikaslearen datuak");
		System.out.println("Izena: ");
		String izena = sc.nextLine();
		System.out.println("Nan: ");

		String nan = nanEskatu(sc);
		System.out.println("Eguna: ");

		int eguna = egunaEskatu(sc);
		System.out.println("Hilabete: ");

		int hilabete = hilabeteEskatu(sc);
		System.out.println("Matrikula: ");

		String matrikula = matrikulaEskatu(sc);
		System.out.println("Taldearen izena: ");

		String taldeaa = sc.nextLine();

		Ikasle ikasle = new Ikasle(nan, izena, eguna, hilabete, matrikula, taldeaa);

		talde.getIkasleak().add(ikasle);

	}

	// --- Bilatu ikasleak taldearen izenarekin -----------------------------

	public static Ikasle bilatuIkasleaTaldeka(String taldea) {

		for (Ikasle ikasle : talde.getIkasleak()) {
			if (ikasle.getTaldea().equals(taldea))
				return ikasle;
		}
		return null;

	}

	public static Pertsona bilatuNana(Scanner sc) {

		String nana = nanEskatu(sc);

		for (Ikasle ikasle : talde.getIkasleak()) {
			if (ikasle.getNan().equals(nana))
				;
			return ikasle;

		}
		for (Irakaslea irakasle : irakasleak) {
			if (irakasle.getNan().equals(nana))
				;
			return irakasle;

		}
		return null;

	}

	public static Pertsona aldatuInfo(Pertsona per) {
		System.out.println("ZER ALDATU NAHI DUZU");

		System.out.println("|===============================================|");
		System.out.println("|                     Zer?                      |");
		System.out.println("|===============================================|");
		System.out.println("| 1.- Izena                                     |");
		System.out.println("| 2.- urtebetetzeEguna                          |");
		System.out.println("| 3.- urtebetetzeHilabete                       |");
		System.out.println("| 4.- matrikulaZbk(Ikasle)                      |");
		System.out.println("| 5.- taldea(Ikasle)                            |");
		System.out.println("| 6.- irakasgai(Irakasle)                       |");
		System.out.println("| 7.- Irten                                     |");
		System.out.println("|===============================================|");
		int aukera = 0;

		switch (aukera) {
		case 1: {
			System.out.println("Sartu nahi duzun izena");
			per.setIzena(sc.nextLine());

			break;
		}
		case 2: {

			System.out.println("Sartu nahi duzun eguna");
			per.setUrtebetetzeEguna(egunaEskatu(sc));

			break;
		}
		case 3: {

			System.out.println("Sartu nahi duzun eguna");
			per.setUrtebetetzeEguna(hilabeteEskatu(sc));
			break;
		}
		case 4: {
			if (per instanceof Ikasle) {
				System.out.println("Sartu nahi duzun matrikulaZBK");
				((Ikasle) per).setMatrikulaZbk(matrikulaEskatu(sc));
			} else {
				System.out.println("Ez zara ikasle bat! :C");
			}

			break;
		}
		case 5: {
			if (per instanceof Ikasle) {
				System.out.println("Sartu nahi duzun matrikulaZBK");
				((Ikasle) per).setTaldea(sc.nextLine());
			} else {
				System.out.println("Ez zara ikasle bat! :C");
			}
			break;
		}
		case 6: {

			if (per instanceof Irakaslea) {
				System.out.println("Sartu nahi duzun matrikulaZBK");
				((Irakaslea) per).setIrakasgai(null);
			} else {
				System.out.println("Ez zara Irakaslea bat! :C");
			}
			break;
		}
		case 7: {

			break;
		}
		}
		return per;

	}

	// --- Bilatu ikasleak taldearen izenarekin -----------------------------

	public static void ikaslearen_IrakaslearenDatuak() {
		for (Ikasle ikasle : ikasleak) {
			System.out.println("Ikaslea" + ikasle.getNan() + " " + ikasle.getIzena() + ", " + ikasle.getTaldea() + ", "
					+ ikasle.getMatrikulaZbk());
		}
		for (Irakaslea irakasle : irakasleak) {
			System.out.println("Irakasle" + irakasle.getNan() + " " + irakasle.getIzena() + ", "
					+ irakasle.getIrakasgai().toString());
		}

	}

	public static void pertsonaEzabatu(Scanner sc) {
		Pertsona per = bilatuNana(sc);
		if (per instanceof Ikasle) {
			ikasleak.remove(per);
		} else {
			irakasleak.remove(per);
		}
	}

// --- Salbuespenak -----------------------------

	public static int egunaEskatu(Scanner sc) {
		boolean egunaErr;
		int eguna = 0;
		do {

			try {
				eguna = Funciones.DatuakBaliozkatu.egunaEskatu(sc);
				egunaErr = false;

			} catch (EgunaSalbuespena e) {
				System.out.println("Sartutako zenbakia ez da baliozkoa");
				egunaErr = true;
			}
		} while (egunaErr == true);
		return eguna;
	}

	public static String nanEskatu(Scanner sc) {
		boolean egunaErr;
		String nan = "";
		do {

			try {
				nan = Funciones.DatuakBaliozkatu.nanEskatu(sc);
			} catch (konprobatuNAN e) {
				System.out.println("Sartutako nan ez da baliozkoa");
				egunaErr = true;
			}
			egunaErr = false;
		} while (egunaErr == true);
		return nan;
	}

	public static int hilabeteEskatu(Scanner sc) {
		boolean egunaErr;
		int eguna = 0;
		do {

			try {
				eguna = Funciones.DatuakBaliozkatu.hilabeteEskatu(sc);
				egunaErr = false;

			} catch (HilabeteSalbuespena e) {
				System.out.println("Sartutako zenbakia ez da baliozkoa");
				egunaErr = true;
			}
		} while (egunaErr == true);
		return eguna;
	}

	public static String matrikulaEskatu(Scanner sc) {
		boolean egunaErr;
		String matrikula = "";
		do {

			try {
				matrikula = Funciones.DatuakBaliozkatu.matrikulaEskatu(sc);
				egunaErr = false;

			} catch (MatrikulaSalbuespena e) {
				System.out.println("Sartutako nana ez da baliozkoa");
				egunaErr = true;
			}
		} while (egunaErr == true);
		return matrikula;
	}

	public static void txtIdatzi() {
		Funtzioak.idatzi();
	}

	public static ArrayList<Pertsona> txtIrakurri() {

		Funtzioak.irakurri();

		return null;

	}

}
