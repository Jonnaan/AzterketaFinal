package F2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import F2.gato.Ilea;
import F2.gato.Kolorea;


public class Menua {
	
	public ArrayList<Maskotak> cargarDatos() {
		
		
		ArrayList<Maskotak> maskota = new ArrayList<Maskotak>();
	

		try {
			 BufferedReader	ficheroperros = new BufferedReader(new FileReader("archivos/perros.txt"));
			 BufferedReader ficherogatos = new BufferedReader(new FileReader("archivos/gatos.txt"));
		
	      
	     
	      String linea; 
	      while((linea = ficheroperros.readLine())!=null) 
	      {
	    	  String sub = linea.split(":")[1];
	    	  int iden = Integer.valueOf(sub.split(" ")[1]);
	    	  int adina = Integer.valueOf(sub.split(" ")[2].split(",")[0]);
	    	  String izena = sub.split(",")[1];
	    	  String arraza = sub.split(",")[2].trim();
	    	  boolean arkakusoak = Boolean.valueOf(sub.split(",")[3].trim());
	    	  String dni = sub.split(",")[4].trim();
	    	  txakurrak tx = null;
			tx = new txakurrak(iden, adina, izena, arraza, arkakusoak, dni);
	    	  maskota.add(tx);

	      }
	      
	      while((linea = ficherogatos.readLine())!=null) 
	      {
	    	  String sub = linea.split(":")[1];
	    	  int iden = Integer.valueOf(sub.split(" ")[1]);
	    	  int adina = Integer.valueOf(sub.split(" ")[2].split(",")[0]);
	    	  String izena = sub.split(",")[1];
	    	  Kolorea.valueOf(sub.split(",")[2].trim());
	    	  Ilea.valueOf(sub.split(",")[3].trim());
	    	  String dni = sub.split(",")[4].trim();
	    	 
	      gato gt = null; 

			gt = new gato(iden, adina, izena,,Ilea,dni);
			maskota.add(gt);
	      }
		ficheroperros.close();
		ficherogatos.close();
	      
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} 
		// Carga del txt
		return maskota;

	}
	

	public  void MaskotakMenua() {
		
		
		
		
		
	}

}
