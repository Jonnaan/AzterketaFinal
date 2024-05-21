package Pojos;

import java.util.ArrayList;

public class Taldea {
	public Taldea(String izena) {
		super();
		this.izena = izena;

	}

	private String izena;
	private ArrayList<Ikasle> ikasleak;

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public ArrayList<Ikasle> getIkasleak() {
		return ikasleak;
	}

	public void setIkasleak(ArrayList<Ikasle> ikasleak) {
		this.ikasleak = ikasleak;
	}

}
