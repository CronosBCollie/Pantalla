package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aitor
 */
public class MiConexion {
    static Connection con=null;
    static String url="jdbc:mysql://192.164.103/pantalla";
    static String user="daniel";
    static String passw="root4";
    
    public MiConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passw);
            System.out.println("Se ha conectado correctamente");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha encontrado el driver de JDBC " + ex);
        } catch (SQLException ex) {
            System.out.println("Error al conectarse con la base de datos: " + ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
