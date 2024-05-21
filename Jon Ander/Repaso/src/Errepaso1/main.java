package Errepaso1;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	private static ArrayList<Personas> personas = new ArrayList<Personas>();
	static  Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
      menua();
	}
	public static void menua() {
		  int aukera = 0;
	        scan = new Scanner(System.in);
	        System.out.println("Zer egin nahi duzu?");
	        System.out.println("1. Gehitu pertsona.");
	        System.out.println("2. Datuak erakutsi.");
	        System.out.println("3. Ikaslearen/irakaslearen datuak aldatzea.");
	        System.out.println("4. Ezabatu ikaslea/irakaslea.");
	        System.out.println("5. Zorionak ematea.");
	        System.out.println("6. Bilatu ikaslea taldeka.");
	        System.out.println("7. Irakasgaiaren arabera irakasleak bilatzea.");
	        System.out.println("8. Irten");
	        do {
	        	try {
            		aukera = scan.nextInt();
	        switch (aukera) {   
	        case 1:{
	        	gehitupersonas();
	        	break;
	        }case 2: {
            	datuakErakutsi();
            	break;
	        } case 3: {
            	aldatu();
            	break;
            } case 4: {
            	ezabatu();
            	break;
            } case 5: {
            	zorionak();
            	break;
            } case 6: {
            	bilatu();
            	break;
            } case 7: {
            	irakasgai();
            	break;
            } case 8: {
            	System.out.println("Agur");
            	break;
            } default: {
            	System.out.println("Sartu duzun zenbakia ez da zuzena");
            	break;
            }
	}}catch (Exception e) {
	System.out.println("Sartu duzun zenbakia ez da zuzena");
	scan.next();
	aukera = 0;
	}
	        }while (aukera < 1 || aukera > 8);
    }
    
	private static void irakasgai() {
		// TODO Auto-generated method stub
		
	}
	private static void bilatu() {
		// TODO Auto-generated method stub
		
	}
	private static void zorionak() {
		// TODO Auto-generated method stub
		
	}
	private static void ezabatu() {
		// TODO Auto-generated method stub
		
	}
	private static void aldatu() {
		// TODO Auto-generated method stub
		
	}
	private static void datuakErakutsi() {
		// TODO Auto-generated method stub
		
	}
	public static void gehitupersonas() {
		pesonaMota personaMota;
		String nan = "";
		String izena = "";
		int eguna = 0;
		int hilabetea = 0;
		scan = new Scanner(System.in);
		if (personas.size() > 100) {
			System.out.println("Ez daiteke gehitu 100 pertsona baino gehiago");
		}else {
		System.out.println("Zer gehituko duzu irakaslea edo ikaslea");
		String katea = scan.next();
		katea.toUpperCase();
		personaMota = pesonaMota.valueOf(katea);
		System.out.println("NAN");
		nan = scan.next();
		System.out.println("Izena");
		izena = scan.next();		
		System.out.println("Eguna");
		eguna = scan.nextInt();
		System.out.println("Hilabetea");
		hilabetea = scan.nextInt();
		if (personaMota == pesonaMota.IKASLEA) {
			Ikaslea newpersona = new Ikaslea();
			newpersona.setNan(nan);
			newpersona.setIzena(izena);
			newpersona.setEguna(eguna);
			newpersona.setHilabetea(hilabetea);
			System.out.println("Matrikula");
			newpersona.setMatrikula(scan.next());
			System.out.println("Taldea");
			newpersona.setTaldea(scan.next());
		}else {
			Irakaslea newpersona = new Irakaslea();
			System.out.println("Taldeak (5 talde maximo)");
			ArrayList<String> taldeak = new ArrayList<String>();
			for (int i = 0; i < 5; i++) {
				System.out.println("Taldeak sartu" + (i+1) + "garren taldea" );
				taldeak.add(scan.next());
			}
			System.out.println("Irakasgaiak (5 irakasgai maximo)");
			String[] irakasgiak = new String[5];
			for (int i = 0; i < irakasgiak.length; i++) {
				irakasgiak[i] = scan.next();
			}
			personas.add(newpersona);
		}
	}
		
		
		
	}
	
	
	
	
	
}
