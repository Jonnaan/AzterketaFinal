package control.metodos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Konexioa {

    
    private static final String URL = "jdbc:mysql://localhost:3306/mascotas_db";
    private static String user = "root";
    private static String pass = "";

    public static Connection konexioa;
    public static Statement query;

 
    public static void konexioaIreki() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            konexioa = DriverManager.getConnection(URL, user, pass);
            query = konexioa.createStatement();
        } catch (ClassNotFoundException e) {
         
        } catch (SQLException e) {
        
        }
    }
 
    public static void konexioaItxi() {
        try {
            konexioa.close();
            query.close();
        } catch (SQLException e) {
         
        }
    }

}