/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Nacho
 */
public class Detalle_Guia {

    private int numero_guia;
    private String fecha;
    private int cantidad;

    public Detalle_Guia() {
        numero_guia = 0;
        fecha = null;
        cantidad = 0;
    }

    public Detalle_Guia(int numero_guia, String fecha, int cantidad) {
        this.numero_guia = numero_guia;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getNumero_guia() {
        return numero_guia;
    }

    public void setNumero_guia(int numero_guia) {
        this.numero_guia = numero_guia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
