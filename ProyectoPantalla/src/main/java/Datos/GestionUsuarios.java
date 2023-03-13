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
public class GestionUsuarios {
    private Connection con;
    
    public GestionUsuarios(){
        MiConexion miConexion=new MiConexion();
        con=miConexion.getConnection();
    }
    
    public boolean insertarUsuario(Usuario u){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO usuarios(dni,nombre,correo,password) VALUES(?,?,?,?)");
            pstmt.setString(1, u.getDni());
            pstmt.setString(2, u.getNombre());
            pstmt.setString(3, u.getCorreo());
            pstmt.setString(4, u.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar un usuario: "+ex);
            return false;
        }
    }
    
    public boolean modificarUsuario(int id, Usuario u){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE usuarios SET dni=?,nombre=?,correo=?,password=? WHERE id=?");
            pstmt.setString(1, u.getDni());
            pstmt.setString(2, u.getNombre());
            pstmt.setString(3, u.getCorreo());
            pstmt.setString(4, u.getPassword());
            pstmt.setInt(5, u.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar un usuario: "+ex);
            return false;
        }
    }
    
    public boolean eliminarUsuario(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE from usuarios WHERE id=?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un usuario: "+ex);
            return false;
        }
    }
    
    public ArrayList<Usuario> obtenerUsuarios(){
        try {
            ArrayList<Usuario> usuarios=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from usuarios");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Usuario u=new Usuario(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"));
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuarios: "+ex);
            return null;
        }
    }
    
    public Usuario obtenerUsuario(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from usuarios WHERE id=?");
            pstmt.setInt(1,id);
            ResultSet res=pstmt.executeQuery();
            if(res.next()){
                Usuario u=new Usuario(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"));
                return u;
            }else return null;
        } catch (SQLException ex) {
            System.out.println("Error al obtener un usuario: "+ex);
            return null;
        }
    }
}