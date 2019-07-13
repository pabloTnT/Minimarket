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
/* Clase java, que contiene tributos, constructor, getters y setters, de los cargos de los funcionarios. */

public class CargosDto {
    private int idCargo;
    private String nombreCargo;
    private int idPrivilegio;

    public CargosDto() {
    }

    public CargosDto(int idCargo, String nombreCargo, int idPrivilegio) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.idPrivilegio = idPrivilegio;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    
    
    
}
