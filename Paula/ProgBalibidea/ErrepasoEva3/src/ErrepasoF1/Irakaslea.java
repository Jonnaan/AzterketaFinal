package ErrepasoF1;

import java.util.ArrayList;

public class Irakaslea extends Pertsona {

	private ArrayList<String> irakasgaiak;

	public Irakaslea(String nAN, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea, Taldea taldea) {
		super(nAN, izena, urtebetetzeEguna, urtebetetzeHilabetea, taldea);
	}

	public Irakaslea(String nAN, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea, Taldea taldea,
			ArrayList<String> irakasgaiak) {
		super(nAN, izena, urtebetetzeEguna, urtebetetzeHilabetea, taldea);
		this.irakasgaiak = irakasgaiak;
	}

	public ArrayList<String> getIrakasgaiak() {
		return irakasgaiak;
	}

	public void setIrakasgaiak(ArrayList<String> irakasgaiak) {
		this.irakasgaiak = irakasgaiak;
	}
	
	public void ematen(String irakasgai) {
		if (irakasgaiak.size() == 5) {
			System.out.println("Irakasle bat bakarrik eman ahal du 5 irakasgai");
		}else {
			irakasgaiak.add(irakasgai);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Irakaslea [irakasgaiak=" + irakasgaiak + "]";
	}

}
