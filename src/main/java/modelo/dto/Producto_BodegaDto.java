/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author PabloTnT
 */
//Clase java, que contiene tributos, constructor, getters y setters, de los productos en bodega

public class Producto_BodegaDto {
    private int id;
    private int cod_producto;
    private int cod_bodega;
    private int stock;

    public Producto_BodegaDto() {
    }

    public Producto_BodegaDto(int id) {
        this.id = id;
    }

    public Producto_BodegaDto(int id, int cod_producto, int cod_bodega, int stock) {
        this.id = id;
        this.cod_producto = cod_producto;
        this.cod_bodega = cod_bodega;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCod_bodega() {
        return cod_bodega;
    }

    public void setCod_bodega(int cod_bodega) {
        this.cod_bodega = cod_bodega;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
