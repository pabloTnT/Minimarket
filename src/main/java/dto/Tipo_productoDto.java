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
// Clase java, que contiene tributos, constructor, getters y setters, de los tipos de productos.

public class Tipo_productoDto {
    private int id;
    private String nombre_tipo;

    public Tipo_productoDto() {
    }

    public Tipo_productoDto(int id) {
        this.id = id;
    }

    public Tipo_productoDto(int id, String nombre_tipo) {
        this.id = id;
        this.nombre_tipo = nombre_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
