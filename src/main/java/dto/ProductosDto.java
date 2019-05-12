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
public class ProductosDto {

    private int sku;
    private String nombre;
    private String precio;

    public ProductosDto() {
    }

    public ProductosDto(int sku) {
        this.sku = sku;
    }

    public ProductosDto(int sku, String nombre, String precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
