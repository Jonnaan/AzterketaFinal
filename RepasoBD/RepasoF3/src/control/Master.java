package control;

import java.io.IOException;
import java.sql.SQLException;

import control.salbuespena.DNIBalidatu;
import control.salbuespena.IleLuzeaBalidatu;
import vista.Menu;


public class Master {

	public static void main(String[] args) throws SQLException {

		Menu menu = new Menu();
		try {
			menu.menuaAtera();
		} catch (IOException | DNIBalidatu | IleLuzeaBalidatu e) {
			e.printStackTrace();
		} 
	}

}
