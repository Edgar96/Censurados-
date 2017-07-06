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
public class vmedicamentos {
    String numero;
    String medicamento;
    String gramaje;
    String cantidad;
    String observaciones;
    
    public vmedicamentos(String numero,String medicamento,String gramaje,String cantidad, String observaciones){
        this.numero = numero;
        this.medicamento = medicamento;
        this.gramaje = gramaje;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }
    public vmedicamentos(){
        
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getGramaje() {
        return gramaje;
    }

    public void setGramaje(String gramaje) {
        this.gramaje = gramaje;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
