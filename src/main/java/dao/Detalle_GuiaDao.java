/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.Detalle_GuiaDto;
import interfaces.DaoInterface;
import java.sql.Date;
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
public class Detalle_GuiaDao implements DaoInterface<Detalle_GuiaDto> {

    private static final String SQL_INSERT = "INSERT INTO detalle_guia (id, numero_guia, fecha, cantidad) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM detalle_guia WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE detalle_guia SET numero_guia=?, fecha=?, cantidad=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM detalle_guia WHERE id=?";
    private static final String SQL_SELECTALL = "SELECT * FROM detalle_guia";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Detalle_GuiaDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setInt(2, dto.getNumero_guia());
            ps.setDate(3, (Date) dto.getFecha());
            ps.setInt(4, dto.getCantidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Detalle_GuiaDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getNumero_guia());
            ps.setDate(2, (Date) dto.getFecha());
            ps.setInt(3, dto.getCantidad());
            ps.setInt(4, dto.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Detalle_GuiaDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        Detalle_GuiaDto det = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                det = new Detalle_GuiaDto(res.getInt(1), res.getInt(2), res.getDate(3), res.getInt(4));
            }
            return det;
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return det;
    }

    @Override
    public List<Detalle_GuiaDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Detalle_GuiaDto> detalle = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();
            while (res.next()) {
                detalle.add(new Detalle_GuiaDto(res.getInt(1), res.getInt(2), res.getDate(3), res.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return detalle;

    }

}
