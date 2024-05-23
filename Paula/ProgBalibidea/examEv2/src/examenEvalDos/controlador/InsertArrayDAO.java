package examenEvalDos.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import examenEvalDos.examen.modelo.Libro;

public class InsertArrayDAO {
	
	 public void liburuARRAYInsert(Libro[] liburulist) {
		 
		 try {
			 Konexioa.konexioa(); 
	            
	      PreparedStatement preparedStatement = Konexioa.konektatua.prepareStatement("INSERT INTO t_libros (id, titulo, autor, editorial, fechaPublicacion)"
	            		+ " VALUES (?, ?, ?, ?, ?)");	   
	      
	      for (int i = 0; i < liburulist.length; i++) {
	    	  if (liburulist[i].getAutor() != null && liburulist[i].getId() != 0 && liburulist[i].getEditorial() != null) {
	    		  
	              preparedStatement.setInt(1, liburulist[i].getId());
	              preparedStatement.setString(2, liburulist[i].getTitulo());
	              preparedStatement.setString(3, liburulist[i].getAutor());
	              preparedStatement.setString(4, liburulist[i].getEditorial());
	              preparedStatement.setString(5, "2024-03-01");

	             preparedStatement.executeUpdate();
	    		  
	    		  
	    	  }
	      }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            Konexioa.konexioaExit();
	        }

		 
	 }
	
}
