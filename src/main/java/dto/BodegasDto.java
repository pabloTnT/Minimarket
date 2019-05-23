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
public class BodegasDto {

    private int id;
    private String nombre_bodega;
    private String comuna;
    private String direccion;
    private String encargado;

    public BodegasDto() {
    }

    public BodegasDto(int id) {
        this.id = id;
    }

    public BodegasDto(int id, String nombre_bodega, String comuna, String direccion, String encargado) {
        this.id = id;
        this.nombre_bodega = nombre_bodega;
        this.comuna = comuna;
        this.direccion = direccion;
        this.encargado = encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    

}
