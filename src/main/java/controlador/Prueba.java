/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDao;

/**
 *
 * @author PabloTnT
 */
public class Prueba {

    public static void main(String[] args) {

        UsuarioDao userDao = new UsuarioDao();
        System.out.println(userDao.UsuarioContraseña("psoto", "sk84life"));
    }
}
