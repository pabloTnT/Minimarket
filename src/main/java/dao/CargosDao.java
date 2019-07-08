/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.CargosDto;
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
public class CargosDao implements DaoInterface<CargosDto>{

    private static final String SQL_INSERT = "INSERT INTO cargos (id_cargo, nombre_cargo, id_privilegio) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM cargos WHERE id_cargo=?";
    private static final String SQL_UPDATE = "UPDATE cargos SET nombre_cargo=?, id_privilegio=? WHERE id_cargo=?";
    private static final String SQL_SELECT = "SELECT * FROM cargos WHERE id_cargo=?";
    private static final String SQL_SELECTALL = "SELECT * FROM cargos";

    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(CargosDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getIdCargo());
            ps.setString(2, dto.getNombreCargo());
            ps.setInt(3, dto.getIdPrivilegio());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(CargosDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombreCargo());
            ps.setInt(2, dto.getIdPrivilegio());
            ps.setInt(3, dto.getIdCargo());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public CargosDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        CargosDto car = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                car = new CargosDto(res.getInt(1), res.getString(2), res.getInt(3));
            }
            return car;
        } catch (SQLException ex) {
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return car;
    }

    @Override
    public List<CargosDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<CargosDto> cargos = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                cargos.add(new CargosDto(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return cargos;
    }
    
}
