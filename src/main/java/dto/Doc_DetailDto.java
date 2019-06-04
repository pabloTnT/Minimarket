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
//Clase java, que contiene tributos, constructor, getters y setters

public class Doc_DetailDto {
    private int id;
    private int id_doc;
    private Date fecha_doc;
    private int cod_producto;
    private int cantidad;

    public Doc_DetailDto() {
    }

    public Doc_DetailDto(int id) {
        this.id = id;
    }

    public Doc_DetailDto(int id, int id_doc, Date fecha_doc, int cod_producto, int cantidad) {
        this.id = id;
        this.id_doc = id_doc;
        this.fecha_doc = fecha_doc;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public Date getFecha_doc() {
        return fecha_doc;
    }

    public void setFecha_doc(Date fecha_doc) {
        this.fecha_doc = fecha_doc;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
    
    
}
