package F2;

public class txakurrak extends Maskotak{
	
private String arraza;
private boolean arkakusoak;


	public txakurrak(int identifikadorea, int adina, String izena, String arraza, boolean arkakusoak, String nan) {
		super(identifikadorea, adina, izena, nan);
		this.arkakusoak = arkakusoak;
		this.arraza = arraza;
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
		return super.toString() + "txakurrak [arraza=" + arraza + ", arkakusoak=" + arkakusoak + "]";
	}
	
	

}
