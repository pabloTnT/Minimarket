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
public class ProveedorDto {

    private String rut;
    private String razon_social;
    private String direccion;
    private String nombre_contacto;
    private int telefono;

    public ProveedorDto() {
    }

    public ProveedorDto(String rut) {
        this.rut = rut;
    }

    public ProveedorDto(String rut, String razon_social, String direccion, String nombre_contacto, int telefono) {
        this.rut = rut;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.nombre_contacto = nombre_contacto;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
