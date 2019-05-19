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
public class Proveedor {

    private int mantiza;
    private String razonSocial;
    private String direccion;

    public Proveedor() {
        mantiza = 0;
        razon_social = null;
        direccion = null;
    }

    public Proveedor(int mantiza, String razon_social, String direccion) {
        this.mantiza = mantiza;
        this.razon_social = razon_social;
        this.direccion = direccion;
    }

    public int getMantiza() {
        return mantiza;
    }

    public void setMantiza(int mantiza) {
        this.mantiza = mantiza;
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

}
