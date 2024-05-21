package Pojos;

import java.util.Objects;

public abstract class Pertsona {

	protected String nan;
	protected String izena;
	protected int urtebetetzeEguna;
	protected int urtebetetzeHilabete;

	public Pertsona(String nan, String izena, int urtebetetzeEguna, int urtebetetzeHilabete) {
		super();
		this.nan = nan;
		this.izena = izena;
		this.urtebetetzeEguna = urtebetetzeEguna;
		this.urtebetetzeHilabete = urtebetetzeHilabete;
	}
	
	// -------------------------------- GET/SET -------------------------------------------------------


	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	
	

	public int getUrtebetetzeEguna() {
		return urtebetetzeEguna;
	}

	public void setUrtebetetzeEguna(int urtebetetzeEguna) {
		
		this.urtebetetzeEguna = urtebetetzeEguna;
	}

	public int getUrtebetetzeHilabete() {
		return urtebetetzeHilabete;
	}

	public void setUrtebetetzeHilabete(int urtebetetzeHilabete) {
		this.urtebetetzeHilabete = urtebetetzeHilabete;
	}

	// -------------------------------- Equals -------------------------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pertsona other = (Pertsona) obj;
		return Objects.equals(izena, other.izena) && Objects.equals(nan, other.nan)
				&& Objects.equals(urtebetetzeEguna, other.urtebetetzeEguna)
				&& Objects.equals(urtebetetzeHilabete, other.urtebetetzeHilabete);
	}
	
	// -------------------------------- toString -------------------------------------------------------

	
	@Override
	public String toString() {
		return "Pertsona [nan=" + nan + ", izena=" + izena + ", urtebetetzeEguna=" + urtebetetzeEguna
				+ ", urtebetetzeHilabete=" + urtebetetzeHilabete + "]";
	}
	
	
	

}
