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
//Clase java, que contiene tributos, constructor, getters y setters, de los productos

public class ProductoDto {

    private int id_producto;
    private String nombre_producto;
    private int tipo_producto;
    private int precio_producto;

    public ProductoDto() {
    }

    public ProductoDto(int id_producto) {
        this.id_producto = id_producto;
    }

    public ProductoDto(int id_producto, String nombre_producto, int tipo_producto, int precio_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.tipo_producto = tipo_producto;
        this.precio_producto = precio_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(int tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }
    
    

}
