/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Brandon
 */
public class vusuarios {
    String nombre_usuario;
    String contrasena;
    
    public vusuarios(String nombre_usuario, String contrasena ){
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;   
    }
    
    public vusuarios(){
        
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
