/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.Producto_BodegaDto;
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
public class Producto_BodegaDao implements DaoInterface<Producto_BodegaDto> {

    private static final String SQL_INSERT = "INSERT INTO producto_bodega (sku, stock, ubicacion_interna) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM producto_bodega WHERE sku=?";
    private static final String SQL_UPDATE = "UPDATE producto_bodega SET stock=?, ubicacion_interna=? WHERE sku=?";
    private static final String SQL_SELECT = "SELECT * FROM producto_bodega WHERE sku=?";
    private static final String SQL_SELECTALL = "SELECT * FROM producto_bodega";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Producto_BodegaDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getSku());
            ps.setInt(2, dto.getStock());
            ps.setInt(3, dto.getUbicacion_interna());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto_BodegaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto_BodegaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Producto_BodegaDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getSku());
            ps.setInt(2, dto.getUbicacion_interna());
            ps.setInt(3, dto.getSku());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto_BodegaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Producto_BodegaDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        Producto_BodegaDto prod = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                prod = new Producto_BodegaDto(res.getInt(1), res.getInt(2), res.getInt(3));
            }
            return prod;
        } catch (SQLException ex) {
            Logger.getLogger(Producto_BodegaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return prod;
    }

    @Override
    public List<Producto_BodegaDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Producto_BodegaDto> prod = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            res = ps.executeQuery();
            while (res.next()) {
                prod.add(new Producto_BodegaDto(res.getInt(1), res.getInt(2), res.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto_BodegaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return prod;
    }

}
