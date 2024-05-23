package modelo;

public class Katua extends Maskota {

	public enum ileLuzea {L, M, S};
	public static ileLuzea ileLuzea;
	private String kolorea;
	
	
	public Katua(int id, String izena, int adina, String jabearenNan, String kolorea) {
		super(id, izena, adina, jabearenNan);
		this.kolorea = kolorea;
	}


	public Katua(int id, String izena, int adina, String jabearenNan, ileLuzea ileLuzea, String kolorea) {
		super(id, izena, adina, jabearenNan);
		this.ileLuzea = ileLuzea;
		this.kolorea = kolorea;
	}


	public ileLuzea getIleLuzea() {
		return ileLuzea;
	}


	public void setIleLuzea(ileLuzea ileLuzea) {
		this.ileLuzea = ileLuzea;
	}


	public String getKolorea() {
		return kolorea;
	}


	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}


	@Override
	public String toString() {
		return super.toString() + "Katua [ileLuzea=" + ileLuzea + ", kolorea=" + kolorea + "]";
	}
	
	

}
