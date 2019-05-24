/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.Tipo_productoDto;
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
public class Tipo_productoDao implements DaoInterface<Tipo_productoDto> {

    private static final String SQL_INSERT = "INSERT INTO productos (id, nombre_tipo) VALUES (?, ?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE productos SET  nombre_tipo=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM productos WHERE id=?";
    private static final String SQL_SELECTALL = "SELECT * FROM productos";
    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(Tipo_productoDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getNombre_tipo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
            Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Tipo_productoDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre_tipo());
            ps.setInt(2, dto.getId());
            if(ps.executeUpdate()>0){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Tipo_productoDto Select(Object key) {
        PreparedStatement ps;
            ResultSet res;
            Tipo_productoDto tipoProd = null;
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res =ps.executeQuery();
            while(res.next()){
                tipoProd = new Tipo_productoDto(res.getInt(1), res.getString(2));
            }
            return tipoProd;
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return tipoProd;
    }

    @Override
    public List<Tipo_productoDto> SeleccionarTodo() {
        PreparedStatement ps;
            ResultSet res;
            ArrayList<Tipo_productoDto> tipoProd = new ArrayList();
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECTALL);
            res=ps.executeQuery();
            while(res.next()){
                tipoProd.add(new Tipo_productoDto(res.getInt(1), res.getString(2)));
            }   } catch (SQLException ex) {
            Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return tipoProd;
    }

}
