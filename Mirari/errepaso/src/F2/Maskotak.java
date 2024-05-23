package F2;

public class Maskotak {
	
protected int identifikadorea;

protected int adina;

protected String izena;

private String nan;

public Maskotak(int identifikadorea, int adina, String izena, String nan) {
	this.identifikadorea = identifikadorea;
	this.adina = adina;
	this.izena = izena;
	this.nan = nan;
}

public int getIdentifikadorea() {
	return identifikadorea;
}

public void setIdentifikadorea(int identifikadorea) {
	this.identifikadorea = identifikadorea;
}

public int getAdina() {
	return adina;
}

public void setAdina(int adina) {
	this.adina = adina;
}

public String getIzena() {
	return izena;
}

public void setIzena(String izena) {
	this.izena = izena;
}

public String getNan() {
	return izena;
}

public void setNan(String nan) {
	this.nan = nan;
}


@Override
public String toString() {
	return "Maskotak [identifikadorea=" + identifikadorea + ", adina=" + adina + ", izena=" + izena + ", nan="+ nan + "]";
}


}
