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
public class UsuarioDto {

    private String id;
    private String clave;
    private String privilegios;

    public UsuarioDto() {
    }

    public UsuarioDto(String id) {
        this.id = id;
    }

    public UsuarioDto(String id, String clave, String privilegios) {
        this.id = id;
        this.clave = clave;
        this.privilegios = privilegios;
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
