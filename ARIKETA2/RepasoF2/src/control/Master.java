package control;

import java.io.IOException;

import vista.Menu;


public class Master {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		try {
			menu.menuaAtera();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
