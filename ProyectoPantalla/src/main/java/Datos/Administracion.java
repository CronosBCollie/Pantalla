/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author AlumnadoManana
 */
public class Administracion {
    private int id_admin;
    private int id_usuario;

    public Administracion(int id_admin, int id_usuario) {
        this.id_admin = id_admin;
        this.id_usuario = id_usuario;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    

}
