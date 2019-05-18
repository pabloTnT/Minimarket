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

    private int numeroGuia;
    private String origen;
    private String fechaLlegada;

    public Guia_Despacho() {
        numeroGuia = 0;
        origen = null;
        fechaLlegada = null;
    }

    public Guia_Despacho(int numeroGuia, String origen, String fechaLlegada) {
        this.numeroGuia = numeroGuia;
        this.origen = origen;
        this.fechaLlegada = fechaLlegada;
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

}
