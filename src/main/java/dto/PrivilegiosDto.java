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
public class PrivilegiosDto {
    private int id;
    private String nombre_privilegio;

    public PrivilegiosDto() {
    }

    public PrivilegiosDto(int id) {
        this.id = id;
    }

    public PrivilegiosDto(int id, String nombre_privilegio) {
        this.id = id;
        this.nombre_privilegio = nombre_privilegio;
    }

    public String getNombre_privilegio() {
        return nombre_privilegio;
    }

    public void setNombre_privilegio(String nombre_privilegio) {
        this.nombre_privilegio = nombre_privilegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
