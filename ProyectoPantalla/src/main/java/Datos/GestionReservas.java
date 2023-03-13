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
public class GestionReservas {
    private Connection con;
    
    public GestionReservas(){
        MiConexion miConexion=new MiConexion();
        con=miConexion.getConnection();
    }
    
    public boolean insertarReserva(Reserva r){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO reservas(asunto,fecha,id_usuario) VALUES(?,?,?)");
            pstmt.setString(1, r.getAsunto());
            pstmt.setDate(2, new java.sql.Date(r.getFecha().getTime()));
            pstmt.setInt(3, r.getId_usuario());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: "+ex);
            return false;
        }
    }
    
    public boolean modificarReserva(int id, Reserva r){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE reservas SET asunto=?,fecha=?,id_usuario=? WHERE id=?");
            pstmt.setString(1, r.getAsunto());
            pstmt.setDate(2, new java.sql.Date(r.getFecha().getTime()));
            pstmt.setInt(3, r.getId_usuario());
            pstmt.setInt(4, r.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar una reserva: "+ex);
            return false;
        }
    }
    
    public boolean eliminarReserva(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE from reservas WHERE id=?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una reserva: "+ex);
            return false;
        }
    }
    
    public ArrayList<Reserva> obtenerReservas(){
        try {
            ArrayList<Reserva> reservas=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from reservas");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Reserva r=new Reserva(res.getInt("id"),res.getString("asunto"),res.getDate("fecha"),res.getInt("id_usuario"));
                reservas.add(r);
            }
            return reservas;
        } catch (SQLException ex) {
            System.out.println("Error al obtener reservas: "+ex);
            return null;
        }
    }
    
    public Reserva obtenerReserva(int id){
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from reservas WHERE id=?");
            pstmt.setInt(1,id);
            ResultSet res=pstmt.executeQuery();
            if(res.next()){
                Reserva r=new Reserva(res.getInt("id"),res.getString("asunto"),res.getDate("fecha"),res.getInt("id_usuario"));
                return r;
            }else return null;
        } catch (SQLException ex) {
            System.out.println("Error al obtener una reserva: "+ex);
            return null;
        }
    }
}
