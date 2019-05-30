/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author PabloTnT
 */
/** En esta interface, se declaran todos los métodos para acceder a la base de datos,
los cuales van hacer implementados por todas las clases, dentro del package dao
*/

public interface DaoInterface <NombreDto>{
    public boolean Create(NombreDto dto);
    public boolean Delete(Object key);
    public boolean Update(NombreDto dto);
    
    public NombreDto Select(Object key);
    public List<NombreDto> SeleccionarTodo();
    
}
