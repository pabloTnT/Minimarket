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
/* Clase java, que contiene tributos, constructor, getters y setters, de las categorías, a las cuales pertenecen los proveedores y los productos. */

public class CategoriaDto {

    private int id;
    private String nombre;

    public CategoriaDto() {
    }

    public CategoriaDto(int id) {
        this.id = id;
    }

    public CategoriaDto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
