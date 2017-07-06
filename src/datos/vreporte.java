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
public class vreporte {
    String codigo;
    String fecha_entrega;
    String medicamentos;
    String r_gramaje;
    String r_cantidad;
    String r_observaciones;
    
    public vreporte (String codigo, String fecha_entrega, String medicamentos, String r_gramaje, String r_cantidad, String r_observaciones ){
    this.codigo = codigo;
    this.fecha_entrega = fecha_entrega;
    this.medicamentos = medicamentos;
    this.r_gramaje = r_gramaje;
    this.r_cantidad = r_cantidad;
    this.r_observaciones = r_observaciones;    
        
    }

    public vreporte() {
    } 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getR_gramaje() {
        return r_gramaje;
    }

    public void setR_gramaje(String r_gramaje) {
        this.r_gramaje = r_gramaje;
    }

    public String getR_cantidad() {
        return r_cantidad;
    }

    public void setR_cantidad(String r_cantidad) {
        this.r_cantidad = r_cantidad;
    }

    public String getR_observaciones() {
        return r_observaciones;
    }

    public void setR_observaciones(String r_observaciones) {
        this.r_observaciones = r_observaciones;
    }
    
    
}
