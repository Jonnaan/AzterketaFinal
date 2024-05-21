package ErrepasoF1;

public class Ikaslea extends Pertsona {

	private String matrikulaZbk;

	public Ikaslea(String nAN, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea, Taldea taldea) {
		super(nAN, izena, urtebetetzeEguna, urtebetetzeHilabetea, taldea);
	}

	public String getMatrikulaZbk() {
		return matrikulaZbk;
	}

	public void setMatrikulaZbk(String matrikulaZbk) {
		this.matrikulaZbk = matrikulaZbk;
	}

}
