/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import modelo.dto.ProductoDto;
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
public class ProductoDao implements DaoInterface<ProductoDto>{

    private static final String SQL_INSERT="INSERT INTO producto (id_producto, nombre_producto, tipo_producto, precio_producto) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto=?";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre_producto=?, tipo_producto=?, precio_producto=? WHERE id_producto=?";
    private static final String SQL_SELECT = "SELECT * FROM producto WHERE id_producto=?";
    private static final String SQL_SELECTALL = "SELECT * FROM producto";
    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(ProductoDto dto) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId_producto());
            ps.setString(2, dto.getNombre_producto());
            ps.setInt(3, dto.getTipo_producto());
            ps.setInt(4, dto.getPrecio_producto());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(ProductoDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre_producto());
            ps.setInt(2, dto.getTipo_producto());
            ps.setInt(3, dto.getPrecio_producto());
            ps.setInt(4, dto.getId_producto());
            if(ps.executeUpdate()>0){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ProductoDto Select(Object key) {
        PreparedStatement ps;
            ResultSet res;
            ProductoDto prod = null;
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res =ps.executeQuery();
            while(res.next()){
                prod = new ProductoDto(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
            }
            return prod;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return prod;
    }

    @Override
    public List<ProductoDto> SeleccionarTodo() {
        PreparedStatement ps;
            ResultSet res;
            ArrayList<ProductoDto> prod = new ArrayList();
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECTALL);
            res=ps.executeQuery();
            while(res.next()){
                prod.add(new ProductoDto(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4)));
            }   } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return prod;
    }
    
}
