/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author PabloTnT
 */
public class Guia_DespachoDto {

    private int numero_guia;
    private String origen;
    private Date fecha_llegada;

    public Guia_DespachoDto() {
    }

    public Guia_DespachoDto(int numero_guia) {
        this.numero_guia = numero_guia;
    }

    public Guia_DespachoDto(int numero_guia, String origen, Date fecha_llegada) {
        this.numero_guia = numero_guia;
        this.origen = origen;
        this.fecha_llegada = fecha_llegada;
    }

    public int getNumero_guia() {
        return numero_guia;
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

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

}
