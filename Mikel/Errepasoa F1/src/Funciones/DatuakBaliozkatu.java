package Funciones;

import java.awt.PageAttributes;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Salbuespenak.EgunaSalbuespena;
import Salbuespenak.HilabeteSalbuespena;
import Salbuespenak.MatrikulaSalbuespena;
import Salbuespenak.konprobatuNAN;

public class DatuakBaliozkatu {

	public static int egunaEskatu(Scanner sc) throws EgunaSalbuespena {

		System.out.println("sartu urtebetetze eguna");

		String katea = sc.nextLine();

		int zenbakiak = Integer.parseInt(katea);
		if (zenbakiak < 1 || zenbakiak > 31) {
			throw new EgunaSalbuespena();

		}
		return zenbakiak;
	}

	public static int hilabeteEskatu(Scanner sc) throws HilabeteSalbuespena {

		System.out.println("sartu urtebetetze hilabete");

		String katea = sc.nextLine();

		int zenbakiak = Integer.parseInt(katea);
		if (zenbakiak < 1 || zenbakiak > 12) {
			throw new HilabeteSalbuespena();

		}
		return zenbakiak;
	}

	public static String nanEskatu(Scanner sc) throws konprobatuNAN {

		System.out.println("sartu NAN-a");

		String katea = sc.nextLine();
		Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher mat = pattern.matcher(katea);
		if (mat.matches() == false) {
			throw new konprobatuNAN();
		}

		return katea;
	}

	public static String matrikulaEskatu(Scanner sc) throws MatrikulaSalbuespena {

		System.out.println("sartu matrikula zebakia (M****)");

		String katea = sc.nextLine();
		Pattern pattern = Pattern.compile("[M][0-9]*");
		Matcher mat = pattern.matcher(katea);
		if (mat.matches() == false) {
			throw new MatrikulaSalbuespena ();
		}

		return katea;
	}

}
