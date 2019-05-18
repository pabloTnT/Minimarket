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

    private int numeroGuia;
    private String fecha;
    private int cantidad;

    public Detalle_Guia() {
        numeroGuia = 0;
        fecha = null;
        cantidad = 0;
    }

    public Detalle_Guia(int numeroGuia, String fecha, int cantidad) {
        this.numeroGuia = numeroGuia;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
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
