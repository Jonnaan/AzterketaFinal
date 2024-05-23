package modelo;


public class Maskota {
	
	protected int id;
	protected String izena;
	protected int adina;
	protected String jabearenNan;
	
	public Maskota(int id, String izena, int adina, String jabearenNan) {
		this.id = id;
		this.izena = izena;
		this.adina = adina;
		this.jabearenNan = jabearenNan;
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

	public String getJabearenNan() {
		return jabearenNan;
	}

	public void setJabearenNan(String jabearenNan) {
		this.jabearenNan = jabearenNan;
	}

	@Override
	public String toString() {
		return "Maskota [id=" + id + ", izena=" + izena + ", adina=" + adina + ", jabearenNan=" + jabearenNan + "]";
	} 
}
