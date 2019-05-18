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
        razonSocial = null;
        direccion = null;
    }

    public Proveedor(int mantiza, String razonSocial, String direccion) {
        this.mantiza = mantiza;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    public int getMantiza() {
        return mantiza;
    }

    public void setMantiza(int mantiza) {
        this.mantiza = mantiza;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
