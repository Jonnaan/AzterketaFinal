package controlador;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SalbuespenaKudeatu {
	
	Scanner teklatuScanner = new Scanner(System.in);
	
	public boolean NanBalidatu(String DNIString) throws NanExcepcion {

		Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher matcher = pattern.matcher(DNIString);

		if (matcher.matches()) {
			return true;
		} else {
			throw new NanExcepcion();
		}

	}
	
	public String NanSartu() {

		boolean errorea = true;
		String nan;

		do {

			System.out.println("Sartu NAN");
			nan = teklatuScanner.nextLine();

			try {
				NanBalidatu(nan);
				errorea = false;
			} catch (NanExcepcion e) {
				System.out.println("Nan ez balidoa");
			}

		} while (errorea);
		return nan;

	}

}
