package Pojos;

import java.util.Objects;

public class Ikasle extends Pertsona {
	private String matrikulaZbk;
	private String taldea;

	public Ikasle(String nan, String izena, int urtebetetzeEguna, int urtebetetzeHilabete, String matrikulaZbk,
			String taldea) {
		super(nan, izena, urtebetetzeEguna, urtebetetzeHilabete);
		this.matrikulaZbk = matrikulaZbk;
		this.taldea = taldea;

		// TODO Auto-generated constructor stub
	}

	// -------------------------------- GET/SET -------------------------------------------------------

	
	public String getMatrikulaZbk() {
		return matrikulaZbk;
	}

	public void setMatrikulaZbk(String matrikulaZbk) {
		this.matrikulaZbk = matrikulaZbk;
	}

	public String getTaldea() {
		return taldea;
	}

	public void setTaldea(String taldea) {
		this.taldea = taldea;
	}

	
	// -------------------------------- equals -------------------------------------------------------

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ikasle other = (Ikasle) obj;
		return Objects.equals(matrikulaZbk, other.matrikulaZbk) && Objects.equals(taldea, other.taldea);
	}

	// -------------------------------- toString -------------------------------------------------------

	
	@Override
	public String toString() {
		return super.toString() +  " Ikasle [matrikulaZbk=" + matrikulaZbk + ", taldea=" + taldea + "]";
	}
	
	
	

}
