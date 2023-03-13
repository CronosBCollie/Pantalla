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
public class GestionAdministraciones {
    private Connection con;
    
    public GestionAdministraciones(){
        MiConexion miConexion=new MiConexion();
        con=miConexion.getConnection();
    }
    
    public boolean insertarAdministracion(Administracion a){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO administraciones(id_admin,id_usuario) VALUES(?,?)");
            pstmt.setInt(1, a.getId_admin());
            pstmt.setInt(2, a.getId_usuario());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar una administracion: "+ex);
            return false;
        }
    }
    
    public boolean modificarAdministracion(int id_admin, Administracion a){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE administraciones SET id_usuario=? WHERE id_admin=?");
            pstmt.setInt(1, a.getId_usuario());
            pstmt.setInt(2, id_admin);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar una administracion: "+ex);
            return false;
        }
    }
    
    public boolean modificarAdministracionUsuario(int id_usuario, Administracion a){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE administraciones SET id_admin=? WHERE id_usuario=?");
            pstmt.setInt(1, id_usuario);
            pstmt.setInt(2, a.getId_admin());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar una administracion de usuario: "+ex);
            return false;
        }
    }
    
    public boolean eliminarAdministracion(int id_admin, int id_usuario){
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE from administraciones WHERE id_admin=? AND is_usuario=?");
            pstmt.setInt(1,id_admin);
            pstmt.setInt(2, id_usuario);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una administracion: "+ex);
            return false;
        }
    }
    
    public ArrayList<Administracion> obtenerAdministraciones(){
        try {
            ArrayList<Administracion> administraciones=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from administraciones");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Administracion a=new Administracion(res.getInt("id_admin"),res.getInt("id_usuario"));
                administraciones.add(a);
            }
            return administraciones;
        } catch (SQLException ex) {
            System.out.println("Error al obtener administraciones: "+ex);
            return null;
        }
    }
    
    public Administracion obtenerAdministracion(int id_admin, int id_usuario){
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from administradores WHERE id_admin=? AND id_usuario=?");
            pstmt.setInt(1,id_admin);
            pstmt.setInt(2,id_usuario);
            ResultSet res=pstmt.executeQuery();
            if(res.next()){
                Administracion a=new Administracion(res.getInt("id_admin"),res.getInt("id_usuario"));
                return a;
            }else return null;
        } catch (SQLException ex) {
            System.out.println("Error al obtener una administracion: "+ex);
            return null;
        }
    }
    
    public ArrayList<Administracion> obtenerAdministracionesPorAdmin(int id_admin){
        try {
            ArrayList<Administracion> administraciones=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from administraciones WHERE id_admin=?");
            pstmt.setInt(1, id_admin);
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Administracion a=new Administracion(res.getInt("id_admin"),res.getInt("id_usuario"));
                administraciones.add(a);
            }
            return administraciones;
        } catch (SQLException ex) {
            System.out.println("Error al obtener administraciones por administrador: "+ex);
            return null;
        }
    }
    
        public ArrayList<Administracion> obtenerAdministracionesPorUsuario(int id_usuario){
        try {
            ArrayList<Administracion> administraciones=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from administraciones WHERE id_usuario=?");
            pstmt.setInt(1, id_usuario);
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Administracion a=new Administracion(res.getInt("id_admin"),res.getInt("id_usuario"));
                administraciones.add(a);
            }
            return administraciones;
        } catch (SQLException ex) {
            System.out.println("Error al obtener administraciones por usuario: "+ex);
            return null;
        }
    }
}
