package modelo.objetos;

public class Perro extends Mascota {

	private String arraza;
	private boolean arkakusoak;
	
	public Perro(int id, String izena, int adina, String nAN_Jabe, String arraza, boolean arkakusoak) {
		super(id, izena, adina, nAN_Jabe);
		this.arraza = arraza;
		this.arkakusoak = arkakusoak;
	}

	public String getArraza() {
		return arraza;
	}

	public void setArraza(String arraza) {
		this.arraza = arraza;
	}

	public boolean isArkakusoak() {
		return arkakusoak;
	}

	public void setArkakusoak(boolean arkakusoak) {
		this.arkakusoak = arkakusoak;
	}

	@Override
	public String toString() {
		String string = "P ; " + super.toString() + " ; " + arraza + " ; " + arkakusoak;
		return string;
	}
	
}
