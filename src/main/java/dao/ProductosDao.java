/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ProductosDto;
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
public class ProductosDao implements DaoInterface<ProductosDto>{

    private static final String SQL_INSERT="INSERT INTO productos (sku, nombre, precio) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE sku=?";
    private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE sku=?";
    private static final String SQL_SELECT = "SELECT * FROM productos WHERE sku=?";
    private static final String SQL_SELECTALL = "SELECT * FROM productos";
    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(ProductosDto dto) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getSku());
            ps.setString(2, dto.getNombre());
            ps.setInt(3, dto.getPrecio());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(ProductosDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setInt(2, dto.getPrecio());
            ps.setInt(3, dto.getSku());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ProductosDto Select(Object key) {
        PreparedStatement ps;
            ResultSet res;
            ProductosDto prod = null;
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res =ps.executeQuery();
            while(res.next()){
                prod = new ProductosDto(res.getInt(1), res.getString(2), res.getInt(3));
            }
            return prod;
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return prod;
    }

    @Override
    public List<ProductosDto> SeleccionarTodo() {
        PreparedStatement ps;
            ResultSet res;
            ArrayList<ProductosDto> prod = new ArrayList();
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECTALL);
            res=ps.executeQuery();
            while(res.next()){
                prod.add(new ProductosDto(res.getInt(1), res.getString(2), res.getInt(3)));
            }   } catch (SQLException ex) {
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return prod;
    }
    
}