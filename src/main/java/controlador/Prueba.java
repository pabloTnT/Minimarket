/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDao;
import dto.UsuarioDto;

/**
 *
 * @author PabloTnT
 */
public class Prueba {
    
    public static void main(String[] args){
        UsuarioDao user = new UsuarioDao();
        System.err.println(user.UsuarioContraseña("pussy", "12345"));
        
    }
}
