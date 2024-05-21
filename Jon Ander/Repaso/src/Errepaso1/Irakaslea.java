package Errepaso1;

import java.util.ArrayList;

public class Irakaslea extends Personas {
	private ArrayList<String> taldeak;
	private String[] irakasgiak = new String[5];

	public Irakaslea(String nan, String izena, int eguna, int hilabetea, ArrayList<String> taldeak,
			String[] irakasgiak) {
		super(nan, izena, eguna, hilabetea);
		this.taldeak = taldeak;
		this.irakasgiak = irakasgiak;
	}

	public Irakaslea() {

	}

	public ArrayList<String> getTaldeak() {
		return taldeak;
	}

	public void setTaldeak(ArrayList<String> taldeak) {
		this.taldeak = taldeak;
	}

	public String[] getIrakasgiak() {
		return irakasgiak;
	}

	public void setIrakasgiak(String[] irakasgiak) {
		this.irakasgiak = irakasgiak;
	}

}
