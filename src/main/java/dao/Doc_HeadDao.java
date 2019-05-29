/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.Doc_HeadDto;
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
public class Doc_HeadDao implements DaoInterface<Doc_HeadDto>{

    private static final String SQL_INSERT = "INSERT INTO bodegas (id_doc, tipo_doc, num_doc, bod_origen, bod_destino) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM bodegas WHERE id_doc=?";
    private static final String SQL_UPDATE = "UPDATE bodegas SET tipo_doc=?, num_doc=?, bod_origen=?, bod_destino=? WHERE id_doc=?";
    private static final String SQL_SELECT = "SELECT * FROM bodegas WHERE id_doc=?";
    private static final String SQL_SELECTALL = "SELECT * FROM bodegas";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Doc_HeadDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId_doc());
            ps.setInt(2, dto.getTipo_doc());
            ps.setInt(3,dto.getNum_doc());
            ps.setInt(4, dto.getBod_origen());
            ps.setInt(5, dto.getBod_destino());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc_HeadDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Doc_HeadDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Doc_HeadDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getTipo_doc());
            ps.setInt(2, dto.getNum_doc());
            ps.setInt(3, dto.getBod_origen());
            ps.setInt(4, dto.getBod_destino());
            ps.setInt(5, dto.getId_doc());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doc_HeadDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Doc_HeadDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        Doc_HeadDto docHead = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                docHead = new Doc_HeadDto(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5));
            }
            return docHead;
        } catch (SQLException ex) {
            Logger.getLogger(Doc_HeadDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return docHead;
    }

    @Override
    public List<Doc_HeadDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Doc_HeadDto> docHead = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                docHead.add(new Doc_HeadDto(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Doc_HeadDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return docHead;
    }
    
}
