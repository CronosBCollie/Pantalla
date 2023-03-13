/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.Date;

/**
 *
 * @author AlumnadoManana
 */
public class Reserva {
    private int id;
    private String asunto;
    private Date fecha;
    private int id_usuario;

    public Reserva(int id, String asunto, Date fecha, int id_usuario) {
        this.id = id;
        this.asunto = asunto;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
    }

    public Reserva(int id, Date fecha, int id_usuario) {
        this.id = id;
        this.asunto="";
        this.fecha = fecha;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public String getAsunto() {
        return asunto;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", asunto=" + asunto + ", fecha=" + fecha + ", id_usuario=" + id_usuario + '}';
    }
    
}
