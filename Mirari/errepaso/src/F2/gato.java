package F2;

public class gato extends Maskotak {
	
private Kolorea kolorea;
private Ilea ilea;


public enum Kolorea {
	
	grisa, beltza, zuria, marroia
}

public enum Ilea {
	
	G,M,S
}

	public gato(int identifikadorea, int adina, String izena, String nan, Kolorea kolorea, Ilea ilea) {
		super(identifikadorea, adina, izena, nan);
		this.ilea = ilea;
		this.kolorea = kolorea;
	}

	public Kolorea getKolorea() {
		return kolorea;
	}

	public void setKolorea(Kolorea kolorea) {
		this.kolorea = kolorea;
	}

	public Ilea getIlea() {
		return ilea;
	}

	public void setIlea(Ilea ilea) {
		this.ilea = ilea;
	}

	@Override
	public String toString() {
		return super.toString() + "gato [kolorea=" + kolorea + ", ilea=" + ilea + "]";
	}
	
	

}
