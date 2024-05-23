package ErrepasoF1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ErrepasoF1.Pertsona.Taldea;

public class main {

	public static Scanner teklatu = new Scanner(System.in);
	private static ArrayList<Irakaslea> irakasleak = new ArrayList<Irakaslea>();
	private static ArrayList<Ikaslea> ikasleak = new ArrayList<Ikaslea>();

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		int emaitza = 0;

		do {
			System.out.println("1- Gehitu Pertsona \n2- Datuak erakutsi \n3- Ikaslearen/irakaslearen datuak aldatzea"
					+ "\n4- Ezabatu ikaslea/irakaslea \n5- Zorionak ematea \n6- Bilatu ikaslea taldeka \n7- Irakasgaiaren arabera irakasleak bilatzea"
					+ "\n8- Irten");
			String katea = teklatu.nextLine();

			try {

				emaitza = Integer.parseInt(katea);

				switch (emaitza) {
				case 1:
					gehitu();
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Sartu zenbaki balidoa");
			}

		} while (emaitza != 8);
	}

	public static boolean NanBalidatu(String DNIString) throws StringException {

		Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher matcher = pattern.matcher(DNIString);

		if (matcher.matches()) {
			return true;
		} else {
			throw new StringException();
		}

	}

	public static boolean egunaBalidatu(int eguna) throws DateExcepcion {
		if (eguna > 31 || eguna < 1) {
			throw new DateExcepcion();
		} else {
			return true;
		}
	}

	public static boolean hilabeteBalidatu(int hilabete) throws DateExcepcion {
		if (hilabete > 12 || hilabete < 1) {
			throw new DateExcepcion();
		} else {
			return true;
		}
	}

	public static boolean matrikulaBalidatu(String matrikula) throws StringException {
		Pattern pattern = Pattern.compile("M[0-9]*");
		Matcher matcher = pattern.matcher(matrikula);

		if (matcher.matches()) {
			return true;
		} else {
			throw new StringException();
		}
	}

	public static Pertsona gehitu() {

		boolean errorea = false;
		Pertsona pertsAux = null;

		String nan = NanSartu();
		System.out.println("Sartu izena");
		String izena = teklatu.nextLine();
		int eguna = EgunaSartu();
		int hilabetea = hilbateaSartu();
		Taldea taldea = TaldeaSartu();

		do {

			System.out.println("Sartu nahi duzu ikasle bat edo irakasle bat?");
			String emaitza = teklatu.nextLine();

			if (emaitza.equalsIgnoreCase("Irakaslea")) {
				pertsAux = new Irakaslea(nan, izena, eguna, hilabetea, taldea);
				errorea = true;

			} else if (emaitza.equalsIgnoreCase("Ikaslea")) {
				String matrikula = MatrikulaSartu();
				pertsAux = new Ikaslea(nan, izena, eguna, hilabetea, taldea, matrikula);

				errorea = true;

			} else {
				System.out.println("Hori ez da aukera balidoa");
				break;
			}
		} while (!errorea);

		return pertsAux;

	}

	public static Taldea TaldeaSartu() {
		boolean errorea = true;
		Taldea taldea = null;

		do {
			System.out.println("Zer taldea da? Aukeratu bat: TEL92, INF93");
			String katea = teklatu.nextLine();

			if (katea.equals("TEL92")) {
				taldea = taldea.TEL92;
				errorea = false;
			} else if (katea.equals("INF93")) {
				taldea = taldea.INF93;
				errorea = false;
			} else {
				System.out.println("Sartu aukera balidoa");
			}

		} while (errorea);
		return taldea;
	}

	public static String NanSartu() {

		boolean errorea = true;
		String nan;

		do {

			System.out.println("Sartu NAN");
			nan = teklatu.nextLine();

			try {
				NanBalidatu(nan);
				errorea = false;
			} catch (StringException e) {
				System.out.println("Nan ez balidoa");
			}

		} while (errorea);
		return nan;

	}

	public static String MatrikulaSartu() {

		boolean errorea = true;
		String matrkula;

		do {

			System.out.println("Sartu matrikula");
			matrkula = teklatu.nextLine();

			try {
				NanBalidatu(matrkula);
				errorea = false;
			} catch (StringException e) {
				System.out.println("Matrikula ez balidoa");
			}

		} while (errorea);
		return matrkula;

	}

	public static int EgunaSartu() {

		boolean errorea = true;
		int eguna = -1;

		do {

			System.out.println("Sartu eguna");
			String katea = teklatu.nextLine();

			try {

				eguna = Integer.parseInt(katea);

				try {
					egunaBalidatu(eguna);
					errorea = false;

				} catch (DateExcepcion e) {
					System.out.println("Hori ez da eguna balidoa");
				}
			} catch (Exception e) {
				System.out.println("Sartu egun balidoa");
			}

		} while (errorea);

		return eguna;

	}

	public static int hilbateaSartu() {

		boolean errorea = true;
		int hilabete = -1;

		do {

			System.out.println("Sartu hilabetea");
			String katea = teklatu.nextLine();

			try {

				hilabete = Integer.parseInt(katea);

				try {
					hilabeteBalidatu(hilabete);
					errorea = false;
					
				} catch (DateExcepcion e) {
					System.out.println("Hori ez da eguna balidoa");
				}
			} catch (Exception e) {
				System.out.println("Sartu egun balidoa");
			}

		} while (errorea);

		return hilabete;

	}

}
