/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProductosDao;
import dao.UsuarioDao;
import dto.ProductosDto;
import dto.UsuarioDto;
import java.util.ArrayList;

/**
 *
 * @author PabloTnT
 */
public class Prueba {
    
    public static void main(String[] args){
        ProductosDao dao = new ProductosDao();
        for(ProductosDto list : dao.SeleccionarTodo()){
            System.out.println(list.getNombre());
            System.out.println(list.getPrecio());
            System.out.println(list.getSku());
            System.out.println(list);
        }
        
        
    }
}
