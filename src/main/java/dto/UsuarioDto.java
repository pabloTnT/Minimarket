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

    private int id;
    private String rutUsuario;
    private String clave;
    private int privilegios;
    private String nombre;
    private String apellidos;
    private int cargo;

    public UsuarioDto() {
    }

    public UsuarioDto(int id) {
        this.id = id;
    }

    public UsuarioDto(int id, String rutUsuario, String clave, int privilegios, String nombre, String apellidos, int cargo) {
        this.id = id;
        this.rutUsuario = rutUsuario;
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

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void intPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public boolean validarRut(String rutUsuario) {

        boolean validacion = false;
        try {
            rutUsuario = rutUsuario.toUpperCase();
            rutUsuario = rutUsuario.replace(".", "");
            rutUsuario = rutUsuario.replace("-", "");
            int rutAux = Integer.parseInt(rutUsuario.substring(0, rutUsuario.length() - 1));

            char dv = rutUsuario.charAt(rutUsuario.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public int getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }

}
