package ErrepasoF1;

public abstract class Pertsona {

	protected String NAN;
	protected String izena;
	protected int urtebetetzeEguna;
	protected int urtebetetzeHilabetea;
	protected enum Taldea{TEL92, INF93};
	protected Taldea taldea;

	public Pertsona(String nAN, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea, Taldea taldea) {
		NAN = nAN;
		this.izena = izena;
		this.urtebetetzeEguna = urtebetetzeEguna;
		this.urtebetetzeHilabetea = urtebetetzeHilabetea;
		this.taldea = taldea;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
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

	public int getUrtebetetzeHilabetea() {
		return urtebetetzeHilabetea;
	}

	public void setUrtebetetzeHilabetea(int urtebetetzeHilabetea) {
		this.urtebetetzeHilabetea = urtebetetzeHilabetea;
	}

	public Taldea getTaldea() {
		return taldea;
	}

	public void setTaldea(Taldea taldea) {
		this.taldea = taldea;
	}

	@Override
	public String toString() {
		return "Pertsona [NAN=" + NAN + ", izena=" + izena + ", urtebetetzeEguna=" + urtebetetzeEguna
				+ ", urtebetetzeHilabetea=" + urtebetetzeHilabetea + ", taldea=" + taldea + "]";
	}

}
