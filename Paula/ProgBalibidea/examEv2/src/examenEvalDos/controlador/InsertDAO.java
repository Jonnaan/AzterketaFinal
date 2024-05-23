package examenEvalDos.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import examenEvalDos.examen.modelo.Libro;

public class InsertDAO {

	 public void liburuInsert(Libro liburu, String data) {
		 
	        try {
	            Konexioa.konexioa(); 
	            
	         PreparedStatement preparedStatement = Konexioa.konektatua.prepareStatement("INSERT INTO t_libros (id, titulo, autor, editorial, fechaPublicacion)"
	            		+ " VALUES (?, ?, ?, ?, ?)");	            
             preparedStatement.setInt(1, liburu.getId());
             preparedStatement.setString(2, liburu.getTitulo());
             preparedStatement.setString(3, liburu.getAutor());
             preparedStatement.setString(4, liburu.getEditorial());
             
             preparedStatement.setString(5, data);

            preparedStatement.executeUpdate();
	        
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            Konexioa.konexioaExit();
	        }

		 
	 }
	
}
