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
public class Detalle_GuiaDto {

    private int id;
    private int numero_guia;
    private Date fecha;
    private int cantidad;

    public Detalle_GuiaDto() {
    }

    public Detalle_GuiaDto(int id) {
        this.id = id;
    }

    public Detalle_GuiaDto(int id, int numero_guia, Date fecha, int cantidad) {
        this.id = id;
        this.numero_guia = numero_guia;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumero_guia() {
        return numero_guia;
    }

    public void setNumero_guia(int numero_guia) {
        this.numero_guia = numero_guia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
