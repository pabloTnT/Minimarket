/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ProveedorDto;
import interfaces.DaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PabloTnT
 */
public class ProveedorDao implements DaoInterface<ProveedorDto>{

    private static final String SQL_INSERT = "INSERT INTO ProveedorDto (rut, razon_social, direccion, nombre_contacto, telefono;) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM ProveedorDto WHERE rut=?";
    private static final String SQL_UPDATE = "UPDATE ProveedorDto SET razon_social=?, direccion=?, nombre_contacto=?, telefono=? WHERE rut=?";
    private static final String SQL_SELECT = "SELECT * FROM ProveedorDto WHERE sku=?";
    private static final String SQL_SELECTALL = "SELECT * FROM ProveedorDto";

    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(ProveedorDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getRut());
            ps.setString(2, dto.getRazon_social());
            ps.setString(3, dto.getDireccion());
            ps.setString(4, dto.getNombre_contacto());
            ps.setInt(5, dto.getTelefono());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Delete(Object key) {
     PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(ProveedorDto dto) {
    PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getRazon_social());
            ps.setString(2, dto.getDireccion());
            ps.setString(3, dto.getNombre_contacto());
            ps.setInt(4, dto.getTelefono());
            ps.setString(5, dto.getRut());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ProveedorDto Select(Object key) {
        PreparedStatement ps;
            ResultSet res;
            ProveedorDto provee = null;
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            res=ps.executeQuery();
            while(res.next()){
                provee = new ProveedorDto(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
            }
            return provee;
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return provee;
    }

    @Override
    public List<ProveedorDto> SeleccionarTodo() {
        PreparedStatement ps;
            ResultSet res;
            ArrayList<ProveedorDto> provee = new ArrayList();
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            res=ps.executeQuery();
            while(res.next()){
                provee.add(new ProveedorDto(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5)));
                        }   
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return provee;
    }
    
}
