/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.FuncionarioDto;
import interfaces.DaoInterface;
import java.util.List;

/**
 *
 * @author PabloTnT
 */
public class FuncionarioDao implements DaoInterface<FuncionarioDto>{

    public static final String SQL_INSERT="";
    public static final String SQL_DELETE="";
    public static final String SQL_UPDATE="";
    public static final String SQL_SELECT="";
    public static final String SQL_SELECTALL="";
    
    public static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(FuncionarioDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(FuncionarioDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FuncionarioDto Select(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FuncionarioDto> SeleccionarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
