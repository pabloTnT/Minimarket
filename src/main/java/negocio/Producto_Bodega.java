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
    private String ubicacionInterna;

    public Producto_Bodega() {
        sku = null;
        stock = 0;
        ubicacionInterna = null;
    }

    public Producto_Bodega(String sku, int stock, String ubicacionInterna) {
        this.sku = sku;
        this.stock = stock;
        this.ubicacionInterna = ubicacionInterna;
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

    public String getUbicacionInterna() {
        return ubicacionInterna;
    }

    public void setUbicacionInterna(String ubicacionInterna) {
        this.ubicacionInterna = ubicacionInterna;
    }

}
