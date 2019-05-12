/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BodegasDao;
import dto.BodegasDto;

/**
 *
 * @author PabloTnT
 */
public class Prueba {
    public static void main(String[] args){
        BodegasDao bod = new BodegasDao();
        
        BodegasDto bodaBuscar = bod.Select("10");
        
        System.out.println(bodaBuscar.getId()+" "+bodaBuscar.getDireccion()+" "+bodaBuscar.getEncargado());
    }
}
