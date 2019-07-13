/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import modelo.dto.ProveedorDto;
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

    private static final String SQL_INSERT = "INSERT INTO proveedor (id, rut, razon_social, direccion, nombre_contacto, telefono) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM proveedor WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE proveedor SET rut=?, razon_social=?, direccion=?, nombre_contacto=?, telefono=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM proveedor WHERE id=?";
    private static final String SQL_SELECTALL = "SELECT * FROM proveedor";

    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(ProveedorDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getRut());
            ps.setString(3, dto.getRazon_social());
            ps.setString(4, dto.getDireccion());
            ps.setString(5, dto.getNombre_contacto());
            ps.setInt(6, dto.getTelefono());
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
            ps.setString(1, dto.getRut());
            ps.setString(2, dto.getRazon_social());
            ps.setString(3, dto.getDireccion());
            ps.setString(4, dto.getNombre_contacto());
            ps.setInt(5, dto.getTelefono());
            ps.setInt(6, dto.getId());
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
            ps.setString(1, key.toString());
            res=ps.executeQuery();
            while(res.next()){
                provee = new ProveedorDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
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
            ps=con.getCnn().prepareStatement(SQL_SELECTALL);
            res=ps.executeQuery();
            while(res.next()){
                provee.add(new ProveedorDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6)));
                        }   
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return provee;
    }
    
}
