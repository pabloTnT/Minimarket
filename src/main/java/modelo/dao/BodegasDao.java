/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import modelo.dto.BodegasDto;
import interfaces.DaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author PabloTnT
 */
public class BodegasDao implements DaoInterface<BodegasDto> {

    private static final String SQL_INSERT = "INSERT INTO bodegas (id_bodega, nombre_bodega, comuna, direccion, encargado) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM bodegas WHERE id_bodega=?";
    private static final String SQL_UPDATE = "UPDATE bodegas SET nombre_bodega=?, comuna=?, direccion=?, encargado=? WHERE id_bodega=?";
    private static final String SQL_SELECT = "SELECT * FROM bodegas WHERE id_bodega=?";
    private static final String SQL_SELECTALL = "SELECT * FROM bodegas";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(BodegasDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId_bodega());
            ps.setString(2, dto.getNombre_bodega());
            ps.setString(3, dto.getComuna());
            ps.setString(4, dto.getDireccion());
            ps.setString(5, dto.getEncargado());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BodegasDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BodegasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(BodegasDto dto) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre_bodega());
            ps.setString(2, dto.getComuna());
            ps.setString(3, dto.getDireccion());
            ps.setString(4, dto.getEncargado());
            ps.setInt(5, dto.getId_bodega());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BodegasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;

    }

    @Override
    public BodegasDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        BodegasDto bod = null;
        try {

            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                bod = new BodegasDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            return bod;
        } catch (SQLException ex) {
            Logger.getLogger(BodegasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return bod;
    }

    @Override
    public List<BodegasDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<BodegasDto> bodegas = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                bodegas.add(new BodegasDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BodegasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return bodegas;
    }

}
