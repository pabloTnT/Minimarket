/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import modelo.dto.Doc_DetailDto;
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
public class Doc_DetailDao implements DaoInterface<Doc_DetailDto>{

    private static final String SQL_INSERT = "INSERT INTO bodegas (id, id_doc, fecha_doc, cod_producto, cantidad) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM bodegas WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE bodegas SET id_doc=?, cod_producto=?, cantidad=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM bodegas WHERE id=?";
    private static final String SQL_SELECTPORFOLIO = "SELECT * FROM bodegas WHERE id_doc=?";
    private static final String SQL_SELECTALL = "SELECT * FROM bodegas";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Doc_DetailDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setInt(2, dto.getId_doc());
            ps.setDate(3, (Date) dto.getFecha_doc());
            ps.setInt(4, dto.getCod_producto());
            ps.setInt(5, dto.getCantidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Doc_DetailDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getId_doc());
            ps.setInt(2, dto.getId());
            ps.setInt(3, dto.getCod_producto());
            ps.setInt(4, dto.getCantidad());
            ps.setInt(5, dto.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Doc_DetailDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        Doc_DetailDto docDetail = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                docDetail = new Doc_DetailDto(res.getInt(1), res.getInt(2), res.getDate(3), res.getInt(4), res.getInt(5));
            }
            return docDetail;
        } catch (SQLException ex) {
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return docDetail;
    }

    @Override
    public List<Doc_DetailDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Doc_DetailDto> docDetail = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                docDetail.add(new Doc_DetailDto(res.getInt(1), res.getInt(2), res.getDate(3), res.getInt(4), res.getInt(5)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return docDetail;
    }
    
    public List<Doc_DetailDto> SeleccionarPorFolio() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Doc_DetailDto> docDetail = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTPORFOLIO);
            res = ps.executeQuery();

            while (res.next()) {
                docDetail.add(new Doc_DetailDto(res.getInt(1), res.getInt(2), res.getDate(3), res.getInt(4), res.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc_DetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return docDetail;
    }
    
}
