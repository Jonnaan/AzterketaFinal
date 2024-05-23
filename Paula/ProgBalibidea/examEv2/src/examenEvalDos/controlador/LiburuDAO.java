package examenEvalDos.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import examenEvalDos.examen.modelo.Libro;

public class LiburuDAO {
	
	public int sartuta = 0;
	
	public Libro[] liburuakKargatu() {
		Libro[] liburuList = new Libro[100];
		
		try {
            Konexioa.konexioa(); 
            
            PreparedStatement preparedStatement = Konexioa.konektatua.prepareStatement("SELECT * FROM t_libros");	            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String provincia = resultSet.getString("titulo"); 
                String autorea = resultSet.getString("autor"); 
                String editoriala = resultSet.getString("editorial");
                Date data = resultSet.getDate("fechaPublicacion");

                Libro liburuBerria = new Libro(id, provincia, autorea, editoriala, data);
                
                liburuList[sartuta] = liburuBerria;
                
                sartuta++;
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Konexioa.konexioaExit();
        }

        return liburuList;
    }

}
