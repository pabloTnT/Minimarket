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
    private String direccion;
    private String encargado;

    public BodegasDto() {
    }

    public BodegasDto(int id) {
        this.id = id;
    }

    public BodegasDto(int id, String direccion, String encargado) {
        this.id = id;
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

}
