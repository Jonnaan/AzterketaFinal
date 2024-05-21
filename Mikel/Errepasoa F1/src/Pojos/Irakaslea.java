package Pojos;

import java.util.ArrayList;

public class Irakaslea extends Pertsona {
	private ArrayList<String> irakasgai;

	public Irakaslea(String nan, String izena, int urtebetetzeEguna, int urtebetetzeHilabete,
			ArrayList<String> irakasgai) {
		super(nan, izena, urtebetetzeEguna, urtebetetzeHilabete);
		this.setIrakasgai(irakasgai);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getIrakasgai() {
		return irakasgai;
	}

	public void setIrakasgai(ArrayList<String> irakasgai) {
		this.irakasgai = new ArrayList<String>(5);
	}

	@Override
	public String toString() {
		return "Irakaslea [irakasgai=" + irakasgai + "]";
	}

}
