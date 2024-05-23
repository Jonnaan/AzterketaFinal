package controlador;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Mascota;

public interface GestorFichMascotasI {
	ArrayList<Mascota> leer() throws IOException;
	void guardar(ArrayList<Mascota> mascotas) throws IOException;
}
