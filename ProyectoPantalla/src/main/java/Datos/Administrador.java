/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author AlumnadoManana
 */
public class Administrador {
    private int id;
    private String dni;
    private String nombre;
    private String correo;
    private String password;

    public Administrador(String dni, String nombre, String correo, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Administrador(int id, String dni, String nombre, String correo, String password) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + '}';
    }
    
}
