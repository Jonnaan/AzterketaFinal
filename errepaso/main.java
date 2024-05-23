package errepaso;

import java.util.ArrayList;
import java.util.Scanner;

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
				+ "4.- Zorionak ematea\r\n"
				+ "5.- Bilatu ikaslea taldeka\r\n"
				+ "6.- Irakasgaiaren arabera irakasleak bilatzea\r\n"
				+ "7.- Irten\r\n");
		
		String tekla = sc.nextLine();
		int aukera = Integer.parseInt(tekla);
		
		switch (aukera) {
		
		
		case 1 :GehituPertsona(sc, ikas, irakas, per, irakasList, ikasList); break;
		case 2:  DatuakErakutzi(irakasList, ikasList); break;
		case 3: break;
		case 4:  Ezabatu(sc,irakasList,ikasList); break;
		case 5: break;
		case 6: break;
		case 7: buklea++; break;
		}

	}
	}
	
	public static void GehituPertsona (Scanner sc, Ikaslea ikas, Irakaslea irakas, Pertsona per,  ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
		
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
		
		System.out.println("Zein egunetan jaio zinen");
		String tekla = sc.nextLine();
		int eguna = Integer.parseInt(tekla);
		try {
			per.egunaBalidatu(eguna);
		} catch (Salbuespena e) {

			System.out.println("Eguna ez dago ondo");
		}
		
		System.out.println("Zein hilabetean jaio zinen");
		 tekla = sc.nextLine();
		int hilabetea = Integer.parseInt(tekla);
		try {
			per.HilabeteaBalidatu(hilabetea);
		} catch (Salbuespena e) {
			System.out.println("Hilabetea ez dago ondo");
			try {
				per.HilabeteaBalidatu(hilabetea);
			} catch (Salbuespena e1) {
				System.out.println("Hilabetea ez dago ondo");
			}
		}
		
		if (zer == 1) {
			int zbk = (int) (Math.random() * 100) + 1;
			matrikula += zbk;
			
			System.out.println("Zein da zure taldea");
			String taldea = sc.nextLine();
			
			ikas.setNan(nan);
			ikas.setIzena(izena);
			ikas.setEguna(eguna);
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
			irakas.setEguna(eguna);
			irakas.setHilabetea(hilabetea);
			irakas.setTaldea(taldeak);
			irakasList.add(irakas);
		}
	}

public static void DatuakErakutzi( ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
		
	for(int i = 0; i < irakasList.size(); i++) {
		System.out.println(irakasList.get(i));
	}
	
	for(int i = 0; i < ikasList.size(); i++) {
		System.out.println(ikasList.get(i));
	}
		
	
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

public static void Aldatu (Scanner sc, ArrayList<Irakaslea> irakasList, ArrayList<Ikaslea> ikasList) {
	
	System.out.println("Jarri NAN");
	String nan = sc.nextLine();
	
	for(int i = 0; i < irakasList.size(); i++) {
		if (irakasList.get(i).getNan() == nan) {
			
			
		}
	}
	
	for(int i = 0; i < ikasList.size(); i++) {
		if (ikasList.get(i).getNan() == nan) {
			ikasList.remove(i);
		}
	}
}

public static void AldatuIrakaslea(int i, ArrayList<Irakaslea> irakasList) {
	
	
	
}
	
}
