package Errepaso1;

public class Ikaslea extends Personas {
	private String matrikula;
	private String taldea;
	
	public Ikaslea(String nan, String izena, int eguna, int hilabetea, String matrikula, String taldea) {
		super(nan, izena, eguna, hilabetea);
		this.matrikula = matrikula;
		this.taldea = taldea;
	}

	public Ikaslea() {

	}

	public String getMatrikula() {
		return matrikula;
	}

	public void setMatrikula(String matrikula) {
		this.matrikula = matrikula;
	}

	public String getTaldea() {
		return taldea;
	}

	public void setTaldea(String taldea) {
		this.taldea = taldea;
	}
	
}
