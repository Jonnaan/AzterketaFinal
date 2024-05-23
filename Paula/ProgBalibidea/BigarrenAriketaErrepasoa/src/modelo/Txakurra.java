package modelo;

public class Txakurra extends Maskota {
	
	private String arraza;
	private boolean Arkakusoak;
	
	public Txakurra(int id, String izena, int adina, String jabearenNan) {
		super(id, izena, adina, jabearenNan);
	}

	public Txakurra(int id, String izena, int adina, String jabearenNan, String arraza, boolean arkakusoak) {
		super(id, izena, adina, jabearenNan);
		this.arraza = arraza;
		Arkakusoak = arkakusoak;
	}

	public String getArraza() {
		return arraza;
	}

	public void setArraza(String arraza) {
		this.arraza = arraza;
	}

	public boolean isArkakusoak() {
		return Arkakusoak;
	}

	public void setArkakusoak(boolean arkakusoak) {
		Arkakusoak = arkakusoak;
	}

	@Override
	public String toString() {
		return super.toString() + "Txakurra [arraza=" + arraza + ", Arkakusoak=" + Arkakusoak + "]";
	}


}
