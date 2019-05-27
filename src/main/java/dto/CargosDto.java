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
public class CargosDto {
    private int id_cargo;
    private String nombre_cargo;

    public CargosDto() {
    }

    public CargosDto(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public CargosDto(int id_cargo, String nombre_cargo) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    
}
