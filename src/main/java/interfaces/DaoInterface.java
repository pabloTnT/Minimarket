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
public interface DaoInterface <NombreDto>{
    public boolean Create(NombreDto dto);
    public boolean Delete(Object key);
    public boolean Update(NombreDto dto);
    
    public NombreDto Select(Object key);
    public List<NombreDto> SeleccionarTodo();
    
}
