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
/* Clase java, que contiene tributos, constructor, getters y setters, de los usuarios. */

public class UsuarioDto {

    private String id;
    private String clave;
    private String privilegios;
    private String nombre;
    private String apellidos;
    private int cargo;

    public UsuarioDto() {
    }

    public UsuarioDto(String id) {
        this.id = id;
    }

    public UsuarioDto(String id, String clave, String privilegios, String nombre, String apellidos, int cargo) {
        this.id = id;
        this.clave = clave;
        this.privilegios = privilegios;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    

}
