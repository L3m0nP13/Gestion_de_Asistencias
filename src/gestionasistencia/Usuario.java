/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionasistencia;

/**
 *
 * @author diego
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;

    private String rol;
    
    //CONSTRUCTOR
    public Usuario(int id,String nombre,String correo,String contrasena,String rol)
    {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    //METODOS
    /*
    public boolean Login(String correo, String contrasena)
    {
        return this.correo.equals(correo) && this.contrasena.equals(contrasena);
    }
    */
    
    //GETTERS
    public int getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getCorreo(){return this.correo;}
    public String getContrasena(){return this.contrasena;}
    
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}
