package errepaso;

public class Irakaslea extends Pertsona {
	
	protected String[] taldea = new String [5];
	
	
	
public Irakaslea(String nan, String izena, int eguna, int hilabetea, String[] taldea) {
		super(nan, izena, eguna, hilabetea);
		this.taldea = taldea;
	}



public String[] getTaldea() {
	return taldea;
}



public void setTaldea(String[] taldea) {
	this.taldea = taldea;
}



@Override
public String toString() {
	return super.toString() + "Irakaslea [taldea=" + taldea + "]";
}

}
