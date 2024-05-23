package modelo.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import modelo.objetos.Mascota;

public interface I_MaskotaFitxaKude {
	
	public ArrayList<Mascota> kargatuDB() throws IOException;
	
	public void gehituDB(ArrayList<Mascota> list) throws IOException;
	
}
