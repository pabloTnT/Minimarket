/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author PabloTnT
 */
public class FuncionarioDto {

    private int mantiza;
    private String dv;
    private String nombre;
    private String apellido;
    private Date fecha_ingreso;
    private int salario;
    private String cargo;

    public FuncionarioDto() {
    }

    public FuncionarioDto(int mantiza) {
        this.mantiza = mantiza;
    }

    public FuncionarioDto(int mantiza, String dv, String nombre, String apellido, Date fecha_ingreso, int salario, String cargo) {
        this.mantiza = mantiza;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_ingreso = fecha_ingreso;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getMantiza() {
        return mantiza;
    }

    public void setMantiza(int mantiza) {
        this.mantiza = mantiza;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
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

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public void setCargo(String cargo) throws Exception{
        if (cargo.equals("Administrador") || cargo.equals("Encargado de Compras") || cargo.equals("Encargado de Bodega") || cargo.equals("Encargado de Local")) {
            this.cargo = cargo;
        } else {
            throw new Exception("Cargo solo puede ser Administrador, Encargado de Bodega, Encargado de Local o Encargado de Compras");
        }
    }

}
