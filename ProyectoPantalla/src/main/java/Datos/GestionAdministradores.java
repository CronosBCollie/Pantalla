/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Conexion.MiConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AlumnadoManana
 */
public class GestionAdministradores {
    private Connection con;
    
    public GestionAdministradores(){
        MiConexion miConexion=new MiConexion();
        con=miConexion.getConnection();
    }
    
    public boolean insertarAdministrador(Administrador a){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO administradores(dni,nombre,correo,password) VALUES(?,?,?,?)");
            pstmt.setString(1, a.getDni());
            pstmt.setString(2, a.getNombre());
            pstmt.setString(3, a.getCorreo());
            pstmt.setString(4, a.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar un administrador: "+ex);
            return false;
        }
    }
    
    public boolean modificarAdministrador(int id, Administrador a){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE administradores SET dni=?,nombre=?,correo=?,password=? WHERE id=?");
            pstmt.setString(1, a.getDni());
            pstmt.setString(2, a.getNombre());
            pstmt.setString(3, a.getCorreo());
            pstmt.setString(4, a.getPassword());
            pstmt.setInt(5, a.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar un administrador: "+ex);
            return false;
        }
    }
    
    public boolean eliminarAdministrador(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE from administradores WHERE id=?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un administrador: "+ex);
            return false;
        }
    }
    
    public ArrayList<Administrador> obtenerAdministradores(){
        try {
            ArrayList<Administrador> administradores=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from administradores");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Administrador a=new Administrador(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"));
                administradores.add(a);
            }
            return administradores;
        } catch (SQLException ex) {
            System.out.println("Error al obtener administradores: "+ex);
            return null;
        }
    }
    
    public Administrador obtenerAdministrador(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from administradores WHERE id=?");
            pstmt.setInt(1,id);
            ResultSet res=pstmt.executeQuery();
            if(res.next()){
                Administrador a=new Administrador(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"));
                return a;
            }else return null;
        } catch (SQLException ex) {
            System.out.println("Error al obtener un administrador: "+ex);
            return null;
        }
    }
}
