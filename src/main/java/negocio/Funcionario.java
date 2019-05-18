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
public class Funcionario {

    private int mantiza;
    private String nombre;
    private String apellido;
    private String fechaIngreso;
    private int salario;
    private String cargo;

    public Funcionario() {
        mantiza = 0;
        nombre = null;
        apellido = null;
        fechaIngreso = null;
        salario = 0;
        cargo = null;
    }

    public Funcionario(int mantiza, String nombre, String apellido, String fechaIngreso, int salario, String cargo) {
        this.mantiza = mantiza;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getMantiza() {
        return mantiza;
    }

    public void setMantiza(int mantiza) {
        this.mantiza = mantiza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception {
        if (cargo.equals("Administrador") || cargo.equals("Encargado de Compras") || cargo.equals("Encargado de Bodega") || cargo.equals("Encargado de Local")) {
            this.cargo = cargo;
        } else {
            throw new Exception("Cargo solo puede ser Administrador, Encargado de Bodega, Encargado de Local o Encargado de Compras");
        }
    }

}
