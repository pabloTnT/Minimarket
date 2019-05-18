/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Nacho
 */
public class Bodegas {

    private int id;
    private String dirección;
    private String encargado;

    public Bodegas() {
        id = 0;
        dirección = null;
        encargado = null;
    }

    public Bodegas(int id, String dirección, String encargado) {
        this.id = id;
        this.dirección = dirección;
        this.encargado = encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

}
