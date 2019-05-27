/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.PrivilegiosDto;
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
public class PrivilegiosDao implements DaoInterface<PrivilegiosDto>{

    private static final String SQL_INSERT = "INSERT INTO bodegas (id, nombre_privilegio) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM bodegas WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE bodegas SET nombre_privilegio=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM bodegas WHERE id=?";
    private static final String SQL_SELECTALL = "SELECT * FROM bodegas";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(PrivilegiosDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getNombre_privilegio());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegiosDao.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.setString(1, (key.toString()));

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegiosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(PrivilegiosDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre_privilegio());
            ps.setInt(2, dto.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegiosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public PrivilegiosDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        PrivilegiosDto privilegios = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                privilegios = new PrivilegiosDto(res.getInt(1), res.getString(2));
            }
            return privilegios;
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegiosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return privilegios;
    }

    @Override
    public List<PrivilegiosDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<PrivilegiosDto> privilegios = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                privilegios.add(new PrivilegiosDto(res.getInt(1), res.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegiosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return privilegios;
    }
    
}
