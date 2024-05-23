package control.metodos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.objetos.Gato;
import modelo.objetos.Mascota;
import modelo.objetos.Perro;

public class MaskotaDAO {

	public static ArrayList<Mascota> kargatuMaskotak() throws SQLException {
		    	Konexioa.konexioaIreki();
		    	ArrayList<Mascota> mascotaList = new ArrayList<Mascota>();
		        String SQLquery = "SELECT tipo,id,izena,adina,NAN_Jabe,atributo1,atributo2,atributo3 from mascotas;";
		        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		        String tipo = emaitza.getString("tipo");
		        boolean atributo3 = emaitza.getBoolean("atributo3");
		        while (emaitza.next()) {
		        	if(tipo == "Gato") {
		        		Gato gato = new Gato(emaitza.getInt("id"), emaitza.getString("izena"), emaitza.getInt("adina"), emaitza.getString("NAN_Jabe"), emaitza.getString("atributo1"), emaitza.getString("atributo2"));
		        		mascotaList.add(gato);
		        	}else {
		        		Perro perro = new Perro(emaitza.getInt("id"), emaitza.getString("izena"), emaitza.getInt("adina"), emaitza.getString("NAN_Jabe"), emaitza.getString("atributo1"), atributo3);
		        		mascotaList.add(perro);
		        	}
		        }
		        Konexioa.konexioaItxi();
		        return mascotaList;
		    }
		
	
	public static void insertGato(Gato mascota) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "INSERT INTO Gato (id, izena, adina, NAN_Jabe, kolorea, ileLuzea)"
				+ "VALUES VALUES ('" + mascota.getId() + "'" + mascota.getIzena() + "'"   + mascota.getAdina() +  "'"   + mascota.getNAN_Jabe() +  "'" + mascota.getKolorea() + "'"+ mascota.getIleLuzea()+ "' );";
		Konexioa.query.executeUpdate(SQLquery); 
		Konexioa.konexioaItxi();
		}
		
	public static void insertPerro(Perro mascota) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "INSERT INTO Gato (id, izena, adina, NAN_Jabe, kolorea, ileLuzea)"
				+ "VALUES VALUES ('" + mascota.getId() + "'" + mascota.getIzena() + "'"   + mascota.getAdina() +  "'"   + mascota.getNAN_Jabe() +  "'" + mascota.getArraza() + "'"+ mascota.isArkakusoak()+ "' );";
		Konexioa.query.executeUpdate(SQLquery); 
		Konexioa.konexioaItxi();
		}
	public static void deletePerro(Perro mascota) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "DELETE FROM PERRO WHERE id = '" + mascota.getId() + "';";
		Konexioa.query.executeUpdate(SQLquery); 
		Konexioa.konexioaItxi();
		}
	public static void deleteGato(Gato mascota) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "DELETE FROM GATO WHERE id = '" + mascota.getId() + "';";
		Konexioa.query.executeUpdate(SQLquery); 
		Konexioa.konexioaItxi();
		}
}
