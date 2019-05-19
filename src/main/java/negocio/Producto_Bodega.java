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
public class Producto_Bodega {

    private String sku;
    private int stock;
    private String ubicacion_Interna;

    public Producto_Bodega() {
        sku = null;
        stock = 0;
        ubicacion_Interna = null;
    }

    public Producto_Bodega(String sku, int stock, String ubicacion_Interna) {
        this.sku = sku;
        this.stock = stock;
        this.ubicacion_Interna = ubicacion_Interna;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUbicacion_Interna() {
        return ubicacion_Interna;
    }

    public void setUbicacion_Interna(String ubicacion_Interna) {
        this.ubicacion_Interna = ubicacion_Interna;
    }

}
