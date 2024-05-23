package control.metodos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.salbuespena.DNIBalidatu;
import control.salbuespena.IleLuzeaBalidatu;

public class BSalbuespena {

	public static String nanEskatu(Scanner sc) throws DNIBalidatu {
		boolean error = false;
		String nan = "";
		do {
			error = true;
			nan = sc.nextLine();
			Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
			Matcher mat = pattern.matcher(nan);
			if (mat.matches() == false) {
				System.out.println("NAN-a ez da zuzena");
			} else {
				error = false;
			}
		} while (error);
		return nan;

	}

	public static String BileIleLuzea(Scanner sc) throws IleLuzeaBalidatu {
		boolean error = false;
		String ilea = "";
		do {
			error = true;
			System.out.println("Sartu IleLuzea (c, C, m, M, l, L)");
			ilea = sc.nextLine();
			Pattern pattern = Pattern.compile("^[cCmMlL]$"); // Sirve para validar si la letra es correcta en el
																// IleLuzea entre c, C, m, M, l, L(solo se puede
																// introducir una letra)
			Matcher mat = pattern.matcher(ilea);
			if (mat.matches() == false) {
				System.out.println("Ilea ez da zuzena");
			} else {
				error = false;
			}
		} while (error);
		return ilea;

	}

	public static int BalidatuZenbakia(Scanner sc) {
		boolean error = false;
		int aukera = 0;
		do {
			error = false;
			try {
				aukera = Integer.parseInt(sc.nextLine());
			} catch (Exception ex) {
				error = true;
				System.err.println("Ez duzu zenbakia bat sartu, saiatu berriro:");
			}
		} while (error);
		return aukera;
	}

//	    public static int egunaEskatu(Scanner sc) throws EgunaSalbuespena {
//
//	        System.out.println("sartu urtebetetze eguna");
//
//	        String katea = sc.nextLine();
//
//	        int zenbakiak = Integer.parseInt(katea);
//	        if (zenbakiak < 1 || zenbakiak > 31) {
//	            throw new EgunaSalbuespena("Sartutako zenbakia ez da baliozkoa");
//
//	        }
//	        return zenbakiak;
//	    }

//	    public static int hilabeteEskatu(Scanner sc) throws HilabeteSalbuespena {
//
//	        System.out.println("sartu urtebetetze hilabete");
//
//	        String katea = sc.nextLine();
//
//	        int zenbakiak = Integer.parseInt(katea);
//	        if (zenbakiak < 1 || zenbakiak > 12) {
//	            throw new HilabeteSalbuespena();
//
//	        }
//	        return zenbakiak;
//	    }

//	    public static String matrikulaEskatu(Scanner sc) throws MatrikulaSalbuespena {
//
//	        System.out.println("Sartu matrikula zebakia (M****)");
//
//	        String katea = sc.nextLine();
//	        Pattern pattern = Pattern.compile("[M][0-9]*");
//	        Matcher mat = pattern.matcher(katea);
//	        if (mat.matches() == false) {
//	            throw new MatrikulaSalbuespena ();
//	        }
//
//	        return katea;
//	    }

}
