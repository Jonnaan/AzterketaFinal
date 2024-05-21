package Errepaso1;

public abstract class Personas {

	private String nan;
	private String izena;
	private int eguna;
	private int hilabetea;

	public Personas(String nan, String izena, int eguna, int hilabetea) {
		this.nan = nan;
		this.izena = izena;
		this.eguna = eguna;
		this.hilabetea = hilabetea;
	}

	public Personas() {

	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		if (nan.length() != 9) {
			System.out.println("NAN ez da zuzena");
		} else {
			for (int i = 0; i < 8; i++) {
				if (!Character.isDigit(nan.charAt(i))) {
					System.out.println("NAN ez da zuzena");
				} else if (!Character.isLetter(nan.charAt(8))) {
					System.out.println("NAN ez da zuzena");
				}else 
					this.nan = nan;
			}
		}
	
		
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
		if (eguna < 1 || eguna > 31) {
            System.out.println("Eguna ez da zuzena");
        } else {
            this.eguna = eguna;
        }
	}

	public int getHilabetea() {
		return hilabetea;
	}

	public void setHilabetea(int hilabetea) {
		if (hilabetea < 1 || hilabetea > 12) {
			System.out.println("Hilabetea ez da zuzena");
		} else {
			this.hilabetea = hilabetea;
		}	
	}

	@Override
	public String toString() {
		return "Personas [nan=" + nan + ", izena=" + izena + ", eguna=" + eguna + ", hilabetea=" + hilabetea + "]";
	}
	
	
	
	
	
	
	
	
}
