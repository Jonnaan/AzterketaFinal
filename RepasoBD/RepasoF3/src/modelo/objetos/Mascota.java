package modelo.objetos;

public abstract class Mascota {

	protected int id;
	protected String izena;
	protected int adina;
	protected String NAN_Jabe;
	
	public Mascota(int id, String izena, int adina, String nAN_Jabe) {
		this.id = id;
		this.izena = izena;
		this.adina = adina;
		NAN_Jabe = nAN_Jabe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public String getNAN_Jabe() {
		return NAN_Jabe;
	}

	public void setNAN_Jabe(String nAN_Jabe) {
		NAN_Jabe = nAN_Jabe;
	}

	@Override
	public String toString() {
		return id + " ; " + izena + " ; " + adina + " ; " + NAN_Jabe;
	}
	
}
