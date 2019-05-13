/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.Guia_DespachoDto;
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
 * @author PROGESA
 */
public class Guia_DespachoDao implements DaoInterface<Guia_DespachoDto> {

    private static final String SQL_INSERT = "INSERT INTO guia_despacho (numero_guia, origen, fecha_llegada) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM guia_despacho WHERE numero_guia=?";
    private static final String SQL_UPDATE = "UPDATE guia_despacho SET numero_guia=?, origen=?, fecha_llegada=? WHERE numero_guia=?";
    private static final String SQL_SELECT = "SELECT * FROM guia_despacho WHERE numero_guia=?";
    private static final String SQL_SELECTALL = "SELECT * FROM guia_despacho";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Guia_DespachoDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getNumero_guia());
            ps.setString(2, dto.getOrigen());
            ps.setDate(3, (Date) dto.getFecha_llegada());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Guia_DespachoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Guia_DespachoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Guia_DespachoDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getNumero_guia());
            ps.setString(2, dto.getOrigen());
            ps.setDate(3, (Date) dto.getFecha_llegada());
            ps.setInt(4, dto.getNumero_guia());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Guia_DespachoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Guia_DespachoDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        Guia_DespachoDto guia = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();
            while (res.next()) {
                guia = new Guia_DespachoDto(res.getInt(1), res.getString(2), res.getDate(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Guia_DespachoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return guia;
    }

    @Override
    public List<Guia_DespachoDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Guia_DespachoDto> guia = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();
            while (res.next()) {
                guia.add(new Guia_DespachoDto(res.getInt(1), res.getString(2), res.getDate(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Guia_DespachoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return guia;
    }

}
