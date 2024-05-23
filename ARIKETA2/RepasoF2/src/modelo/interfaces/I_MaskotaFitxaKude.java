package modelo.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import modelo.objetos.Mascota;

public interface I_MaskotaFitxaKude {
	
	public ArrayList<Mascota> leerEnTXT() throws IOException;
	
	public void escribirEnTXT(ArrayList<Mascota> list) throws IOException;
	
}
