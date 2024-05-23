package examenEvalDos.controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import examenEvalDos.examen.modelo.Libro;



/**
 * Clase de menus.
 */
public class Menu {
	private static final String PATH_FICHERO = "C:\\Users\\in1dm3-d\\Desktop\\";
	private static final String NOMBRE_FICHERO = "examen.txt";
	public static final String URL = "jdbc:mysql://localhost:3306/exameneval2";
	public static final String USER = "root";
	public static final String PASS = "";
	
	private LiburuDAO liburuDAO = new LiburuDAO();
	private InsertDAO inserta = new InsertDAO();
	private InsertArrayDAO insertARRAY = new InsertArrayDAO();
	public Libro [] liburuList = liburuDAO.liburuakKargatu();
	private Scanner teclado = null;

	public Menu() {
		teclado = new Scanner(System.in);
	}

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > 8));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Buscar todos los libros ");
		System.out.println("---- 2 - Buscar libro por ID ");
		System.out.println("---- 3 - Buscar todos los libros de un autor ");
		System.out.println("---- 4 - Buscar todos los libros publicados antes de 2020-01-01 ");
		System.out.println("---- 5 - Añadir libro ");
		System.out.println("---- 6 - Guardar todos los libros en un fichero ");
		System.out.println("---- 7 - Mostrar todos los libros del fichero ");
		System.out.println("---- 8 - Insertar todos los libros del fichero en BBDD");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 1: // TODO A responder por el alumno
			
			mostrarLibros(liburuList);
			
			break;
		case 2: // TODO A responder por el alumno
			
			System.out.println(liburuBilatuID(teclado));
			
			break;
		case 3: // TODO A responder por el alumno
			
			liburuBilatuIdazlea(teclado);
			
			break;
		case 4: // TODO A responder por el alumno
			
			liburuBilatuData();
			
			break;
		case 5: // TODO A responder por el alumno
			
			Libro liburuBerria = liburuSortu(teclado);
			String data = dateToString(liburuBerria.getFechaPublicacion());
			inserta.liburuInsert(liburuBerria, data);
			liburuList[azkenPosizioa()] = liburuBerria;
			
			break;
		case 6: // TODO A responder por el alumno
			
			fitxeroaIdatzi();
			
			break;
		case 7: // TODO A responder por el alumno
			
			fitxeroDatuakKargatu();
		
			
			break;
		case 8: // TODO A responder por el alumno
			
			//fitxeroDatuakKargatu();
			//insertARRAY.liburuARRAYInsert(liburuList);
			
			
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}


	private void mostrarLibros(Libro [] libros) {
		for (int i = 0; i < liburuList.length; i++) {
			if (liburuList[i] != null) {				
				if (liburuList[i].getId() != 0) {
					System.out.println(liburuList[i].toString());
				}
			}
		}
	}
	
	private String liburuBilatuID(Scanner teklatu) {	
		String returneo = "Ez dago liburik";
		int idScanner = idEgiaztatu(teklatu);
				
				for (int i = 0; i < liburuList.length; i++) {
					if (liburuList[i] != null) {
						if (liburuList[i].getId() != 0) {
							if (liburuList[i].getId() == idScanner) {
								returneo = liburuList[i].toString();
								break;
							}
						}
					}
				}
				
		return returneo;
	}

	private void liburuBilatuIdazlea(Scanner teklatu) {
		
		System.out.println("Sartu idazleen izena:");
		String idazleaSartutakoa = teklatu.nextLine();
		
		for (int i = 0; i < liburuList.length; i++) {
			if (liburuList[i] != null) {
				if (liburuList[i].getAutor() != null) {
					if (liburuList[i].getAutor().contains(idazleaSartutakoa)) {
						System.out.println(liburuList[i].toString());
					}
				}
			}
		}
		
	}
	
	private int idEgiaztatu(Scanner teklatu) {
		
		int idBuelta = 0;
		boolean bukatu = false;
		
		do {
			try {
				System.out.println("Sartu id:");
				String idString = teklatu.nextLine();
				int id = Integer.parseInt(idString);
				
				idBuelta = id;
				break;
				
			} catch (Exception e) {
				System.out.println("Sartu id balidoa");
				// TODO: handle exception
			}
		} while (bukatu == false);
		
		return idBuelta;
		
	}
 	
	
	private void liburuBilatuData() {
		
		Date dataDate = stringToDate("2020-01-01");
		
		for (int i = 0; i < liburuList.length; i++) {
			if (liburuList[i] != null) {
				if (liburuList[i].getAutor() != null) {
					if (liburuList[i].getFechaPublicacion().after(dataDate)) {
						System.out.println(liburuList[i].toString());
					}
				}
			}
		}
		
	}

	public String dateToString(Date fecha) {
		String ret = null;
		String pattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		ret = dateFormat.format(fecha);
		return ret;
	}


	public Date stringToDate(String fecha) {
		Date ret = null;
		try {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
			ret = formatter.parse(fecha);
		} catch (Exception e) {
			// Algo ha ido mal, devolvemos la fecha del sistema
			ret = new Date();
		}
		return ret;
	}
	
	private Libro liburuSortu(Scanner teklatu) {
		
		int id = idEgiaztatu(teklatu);
		
		System.out.println("Titulua:");
		String titulua = teklatu.nextLine();
		
		System.out.println("Idazlea:");
		String idazlea = teklatu.nextLine();
		
		System.out.println("Editoriala:");
		String editoriala = teklatu.nextLine();
		
		System.out.println("Fecha de Publicacion:");
		String data = teklatu.nextLine();
		Date liburuData = stringToDate(data);
		
		Libro liburuBerria = new Libro(id, titulua, idazlea, editoriala, liburuData);
		
		return liburuBerria;
	}
	
	
	private int azkenPosizioa() {
	 	int azkena = -1; 
        for (int i = 0; i < liburuList.length; i++) {
            if (liburuList[i] == null) {
            	azkena = i;
                break;
            }
        }
    return azkena; 
	}
	
	private void fitxeroaIdatzi() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_FICHERO + NOMBRE_FICHERO))) {
			for (int i = 0; i < liburuList.length; i++) {
				if (liburuList[i] != null) {
					if (liburuList[i].getAutor() != null && liburuList[i].getId() != 0 && liburuList[i].getEditorial() != null && liburuList[i].getTitulo() != null) {
												
                    	String id = "Id:" + liburuList[i].getId();
                        String titulua = "Titulua:" + liburuList[i].getTitulo();                        
                        String idazlea = "Idazlea:" + liburuList[i].getAutor();
                        String editoriala = "Editoriala:" + liburuList[i].getEditorial();
                        String data = "Data:" + liburuList[i].getFechaPublicacion();

                        writer.newLine();
                        writer.write(id);
                        writer.newLine();
                        writer.write(titulua);
                        writer.newLine();
                        writer.write(idazlea);
                        writer.newLine();
                        writer.write(editoriala);
                        writer.newLine();
                        writer.write(data);
                        writer.newLine();
                        writer.write("----------------");
					}
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void fitxeroDatuakKargatu() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH_FICHERO + NOMBRE_FICHERO));
			String lerroa;			
            int kopuru = 0; 

            liburuList = new Libro[100];
            
            while ((lerroa = br.readLine()) != null) {
                if (lerroa.isEmpty()) {
                    continue;
                }
                if (lerroa.startsWith("----------------")) {
                    kopuru++;
                    
                } else {
                    String[] lerroBakoitza = lerroa.split(":");
                    String izena = lerroBakoitza[0].trim(); //TRIM ESPAZIO ZURIAK KENTZEN DITU
                    String balorea = lerroBakoitza[1].trim();

                    if (liburuList[kopuru] == null) {
                    	liburuList[kopuru] = new Libro();
                    }

                    switch (izena) {
                        case "Id":
                        	liburuList[kopuru].setId(Integer.parseInt(balorea));
                            break;
                        case "Titulua":
                        	liburuList[kopuru].setTitulo(balorea);
                            break;
                        case "Idazlea":
                        	liburuList[kopuru].setAutor(balorea);
                            break;
                        case "Editoriala":
                        	liburuList[kopuru].setEditorial(balorea);
                            break;
                        case "Data":
                        	Date data = stringToDate(balorea);
                        	liburuList[kopuru].setFechaPublicacion(data);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            for (int i = 0; i < liburuList.length; i++) {
    			if (liburuList[i] != null) {
    				if (liburuList[i].getAutor() != null && liburuList[i].getId() != 0 && liburuList[i].getEditorial() != null) {
    					System.out.println(liburuList[i]);
    				}
    			}
            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
