/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import modelo.dto.Tipo_docDto;
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
public class Tipo_docDao implements DaoInterface<Tipo_docDto>{

    private static final String SQL_INSERT="INSERT INTO productos (id_doc, doc_nombre) VALUES (?, ?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE id_doc=?";
    private static final String SQL_UPDATE = "UPDATE productos SET  doc_nombre=? WHERE id_doc=?";
    private static final String SQL_SELECT = "SELECT * FROM productos WHERE id_doc=?";
    private static final String SQL_SELECTALL = "SELECT * FROM productos";
    private static final Conexion con = Conexion.estadoConexion();
    
    @Override
    public boolean Create(Tipo_docDto dto) {
        try {
            PreparedStatement ps;
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId_doc());
            ps.setString(2, dto.getDoc_nombre());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_docDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tipo_docDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Tipo_docDto dto) {
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getDoc_nombre());
            ps.setInt(2, dto.getId_doc());
            if(ps.executeUpdate()>0){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_docDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Tipo_docDto Select(Object key) {
        PreparedStatement ps;
            ResultSet res;
            Tipo_docDto tipoDoc = null;
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res =ps.executeQuery();
            while(res.next()){
                tipoDoc = new Tipo_docDto(res.getInt(1), res.getString(2));
            }
            return tipoDoc;
        } catch (SQLException ex) {
            Logger.getLogger(Tipo_docDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return tipoDoc;
    }

    @Override
    public List<Tipo_docDto> SeleccionarTodo() {
        PreparedStatement ps;
            ResultSet res;
            ArrayList<Tipo_docDto> tipoDoc = new ArrayList();
        try {
            ps=con.getCnn().prepareStatement(SQL_SELECTALL);
            res=ps.executeQuery();
            while(res.next()){
                tipoDoc.add(new Tipo_docDto(res.getInt(1), res.getString(2)));
            }   } catch (SQLException ex) {
            Logger.getLogger(Tipo_docDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return tipoDoc;
    }
    
}
