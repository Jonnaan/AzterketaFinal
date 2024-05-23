package errepaso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ebaluazio3.salbuespenak.mate.Salbuespena2;

public class Pertsona {
	
	protected String nan;
	protected String izena;
	protected int eguna;
	protected int hilabetea;
	
	public Pertsona(String nan, String izena, int eguna,int hilabetea) {
		this.nan = nan;
		this.izena = izena;
		this.eguna = eguna;
		this.hilabetea = hilabetea;
		
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getEguna() {
		return eguna;
	}

	public void setEguna(int eguna) {
		this.eguna = eguna;
	}

	public int getHilabetea() {
		return hilabetea;
	}

	public void setHilabetea(int hilabetea) {
		this.hilabetea = hilabetea;
	}

	@Override
	public String toString() {
		return "Pertsona [nan=" + nan + ", izena=" + izena + ", eguna=" + eguna + ", hilabetea=" + hilabetea + "]";
	}

	public void egunaBalidatu (int eguna) throws Salbuespena {
		
		if (eguna > 31   || eguna <= 0) {
			throw new Salbuespena();
			
		}
	}
	
	public void HilabeteaBalidatu (int hilabetea) throws Salbuespena {
		
		if (hilabetea > 12  || hilabetea <= 0) {
			throw new Salbuespena();
			
		}
	}
	
	public boolean NanBalidatu (String nan) throws Salbuespena {
		
	Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
		
	if (nan.length() != 9) {
			System.out.println("NAN ez da zuzena");
		}else {
			 Matcher mat = patron.matcher(nan);
		while(!mat.matches()) {
			throw new Salbuespena();
		}
		}
		
		return false;
		
	}
}
