package F1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int buklea = 0;
		Ikaslea ikas = new Ikaslea(null, null, 0, 0, null, null);
		Irakaslea irakas = new Irakaslea(null, null, 0, 0, null);
		Pertsona per = new Pertsona(null, null, 0, 0);
		ArrayList<Ikaslea> ikasList = new  ArrayList<Ikaslea>();
		ArrayList<Irakaslea> irakasList = new  ArrayList<Irakaslea>();
		
		while (buklea == 0) {
		System.out.println("1.- Gehitu pertsona.\r\n"
				+ "2.-Datuak erakutsi\r\n"
				+ "3.- Ikaslearen/irakaslearen datuak aldatzea\r\n"
				+ "4.- Ezabatu ikaslea/irakaslea\r\n"
				+ "5.- Zorionak ematea\r\n"
				+ "6.- Bilatu ikaslea taldeka\r\n"
				+ "7.- Irakasgaiaren arabera irakasleak bilatzea\r\n"
				+ "8.- Irten\r\n");
		
		String tekla = sc.nextLine();
		int aukera = Integer.parseInt(tekla);
		
		switch (aukera) {
		
		
		case 1 :GehituPertsona(sc, ikas, irakas, per, irakasList, ikasList); break;
		case 2:  DatuakErakutzi(ikas,irakas); break;
		case 3: break;
		case 4:  Ezabatu(sc,irakasList,ikasList); break;
		case 5: ZorionakEman (irakasList,ikasList); break;
		case 6: TaldeaBilatu (ikasList,sc); break;
		case 7: IrakasgaiaBilatu(irakasList, sc); break;
		case 8:Fitxategiak (irakasList,ikasList); buklea++; break;
		}

	}
	}
	
	public static void GehituPertsona (Scanner sc, Ikaslea ikas, Irakaslea irakas, Pertsona per,  ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
		boolean errorea = true;
		String matrikula = "M";
		String[] taldeak = new String[5];
		
		System.out.println("Zer zara?" + "\n "+" 1.-ikaslea \n 2.-irakaslea");
		String pertsona = sc.nextLine();
		int zer = Integer.parseInt(pertsona);
		
		
		System.out.println("Zein da zure nan");
		String nan = sc.nextLine();
		try {
			per.NanBalidatu(nan);
		} catch (Salbuespena e) {
			System.out.println("NAN ez dago ondo");
		}
		
		System.out.println("Zein da zure izena");
		String izena = sc.nextLine();
		
		do {
		System.out.println("Zein egunetan jaio zinen");
		String tekla = sc.nextLine();
		int eguna = Integer.parseInt(tekla);
		
		try {
			per.egunaBalidatu(eguna);
			errorea = false;
		} catch (Salbuespena e) {
			System.out.println("Eguna ez dago ondo");
		}
		}while(errorea);
		
		System.out.println("Zein hilabetean jaio zinen");
		String tekla = sc.nextLine();
		int hilabetea = Integer.parseInt(tekla);
		try {
			per.HilabeteaBalidatu(hilabetea);
		} catch (Salbuespena e) {
			System.out.println("Hilabetea ez dago ondo");
			
		}
		
		if (zer == 1) {
			int zbk = (int) (Math.random() * 100) + 1;
			matrikula += zbk;
			
			System.out.println("Zein da zure taldea");
			String taldea = sc.nextLine();
			
			ikas.setNan(nan);
			ikas.setIzena(izena);
			ikas.setEguna(01);
			ikas.setHilabetea(hilabetea);
			ikas.setMatrikula(matrikula);
			ikas.setTaldea(taldea);
			ikasList.add(ikas);
			
		}else if (zer == 2) {
			System.out.println("Zein dira zure taldea");
			String taldea = sc.nextLine();
			
			for (int i = 0; i < taldeak.length; i++) {		
				taldeak [i] = taldea;
			}
			irakas.setNan(nan);
			irakas.setIzena(izena);
			irakas.setEguna(01);
			irakas.setHilabetea(hilabetea);
			irakas.setTaldea(taldeak);
			irakasList.add(irakas);
		}
	}

public static void DatuakErakutzi(Ikaslea ikas, Irakaslea irakas) {
		
		System.out.println(ikas.toString());	
		System.out.println(irakas.toString());
	
}

public static void Ezabatu (Scanner sc, ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
	
	System.out.println("Zein irakasle o ikasle ezabatu nahi duzu?");
	String pertsona = sc.nextLine();
	
	for(int i = 0; i < irakasList.size(); i++) {
		if (irakasList.get(i).getIzena().equals(pertsona)) {
				irakasList.remove(i);
		}
	}
	
	for(int i = 0; i < ikasList.size(); i++) {
		if (ikasList.get(i).getIzena().equals(pertsona)) {
			ikasList.remove(i);
		}
	}
	
}

public static void Fitxategiak (ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
	
	
	try  {
		BufferedWriter bWIrakas = new BufferedWriter(new FileWriter("irakasle.txt"));
				BufferedWriter bWIkas = new BufferedWriter(new FileWriter("Ikasle.txt"));
						
		for (int i = 0; i < irakasList.size(); i++) {
			bWIrakas.write(irakasList.get(i).toString());
			bWIrakas.newLine();
		}
		
		for(int i = 0; i < ikasList.size(); i++) {
			bWIkas.write(ikasList.get(i).toString());
			bWIkas.newLine();
			}	
		
			System.out.println("Sortu egin dira fitxategiak");
			
			bWIrakas.close();
			bWIkas.close();
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

public static void ZorionakEman (ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
	
	String gaur = LocalDatetoString(LocalDate.now());
	
	
	for (int i = 0; i < irakasList.size(); i++) {
		String pertsona = irakasList.get(i).getHilabetea() + "-" + irakasList.get(i).getEguna();
		if (gaur.contains(pertsona)) {
			System.out.println("Zorionak " + irakasList.get(i).getIzena());
		}
	}
	
	for (int i = 0; i < ikasList.size(); i++) {
		String pertsona = ikasList.get(i).getHilabetea() + "-" + ikasList.get(i).getEguna();
		if (gaur.contains(pertsona)) {
			System.out.println("Zorionak " + ikasList.get(i).getIzena());
		}
	}
	
	
}

public static String LocalDatetoString(LocalDate localDate) {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

	String formattedString = localDate.format(formatter);

	return formattedString;

}

public static void TaldeaBilatu (ArrayList<Ikaslea> ikasList, Scanner sc) {
	
	System.out.println("Zein taldea bilatu nahi duzu?");
	String taldea = sc.nextLine();
	
	for (int i = 0; i < ikasList.size(); i++) {
		if (ikasList.get(i).getTaldea().equals(taldea)) {
			System.out.println(ikasList.get(i).toString());
		}
	}
	
}
public static void IrakasgaiaBilatu (ArrayList<Irakaslea> irakasList, Scanner sc) {
	
	System.out.println("Zein taldea bilatu nahi duzu?");
	String taldea = sc.nextLine();
	
	for (int i = 0; i < irakasList.size(); i++) {
		if (irakasList.get(i).getTaldea().equals(taldea)) {
			System.out.println(irakasList.get(i).toString());
		}
	}
	
}

}
