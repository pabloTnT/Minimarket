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
public class Guia_Despacho {

    private int numero_guia;
    private String origen;
    private String fecha_llegada;

    public Guia_Despacho() {
        numero_guia = 0;
        origen = null;
        fecha_llegada = null;
    }

    public Guia_Despacho(int numero_guia, String origen, String fecha_llegada) {
        this.numero_guia = numero_guia;
        this.origen = origen;
        this.fecha_llegada = fecha_llegada;
    }

    public int getNumero_guia() {
        return numeroGuia;
    }

    public void setNumero_guia(int numero_guia) {
        this.numero_guia = numero_guia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFechaLlegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

}
