package Funciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Funtzioak {
	
	public static void irakurri() {
		try  {
			BufferedReader bW = new BufferedReader(new FileReader(""));
//			NirePlaylistDao.lortuAbestiakIdPlaylist(playlista);
			
		
			bW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void idatzi() {
		try  {
			BufferedWriter bW = new BufferedWriter(new FileWriter(""));
//			NirePlaylistDao.lortuAbestiakIdPlaylist(playlista);
			
		
			bW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
