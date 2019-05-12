/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PabloTnT
 */
public class Producto_BodegaDto {
    private int sku;
    private int stock;
    private int ubicacion_interna;

    public Producto_BodegaDto() {
    }

    public Producto_BodegaDto(int sku) {
        this.sku = sku;
    }

    public Producto_BodegaDto(int sku, int stock, int ubicacion_interna) {
        this.sku = sku;
        this.stock = stock;
        this.ubicacion_interna = ubicacion_interna;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUbicacion_interna() {
        return ubicacion_interna;
    }

    public void setUbicacion_interna(int ubicacion_interna) {
        this.ubicacion_interna = ubicacion_interna;
    }
    
    
}
