package modelo.objetos;

public class Gato extends Mascota {
	
	private String kolorea;
	private String ileLuzea;
	
	public Gato(int id, String izena, int adina, String nAN_Jabe, String kolorea, String ileLuzea) {
		super(id, izena, adina, nAN_Jabe);
		this.kolorea = kolorea;
		this.ileLuzea = ileLuzea;
	}

	public String getKolorea() {
		return kolorea;
	}

	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}

	public String getIleLuzea() {
		return ileLuzea;
	}

	public void setIleLuzea(String ileLuzea) {
		this.ileLuzea = ileLuzea;
	}

	@Override
	public String toString() {
		String string = "G ; " + super.toString() + " ; " + kolorea + " ; " + ileLuzea;
		return string;
	}
	
}
