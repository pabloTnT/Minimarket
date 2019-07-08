/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.UsuarioDto;
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
public class UsuarioDao implements DaoInterface<UsuarioDto> {

    private static final String SQL_INSERT = "INSERT INTO usuario (id, rutUsuario, clave, nombre, apellidos, cargo) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE usuario SET rutUsuario=?, clave=?, nombre=?, apellidos=?, cargo=? WHERE id=?";
    private static final String SQL_SELECT = "SELECT * FROM usuario WHERE id=?";
    private static final String SQL_SELECTALL = "SELECT * FROM usuario";
    private static final String SQL_USUARIO_CONTRASEÑA = "SELECT * FROM usuario WHERE rutUsuario=? AND clave=?";
    private static final String SQL_SELECT_USUARIO = "SELECT * FROM usuario WHERE rutUsuario=?";

    private static final Conexion con = Conexion.estadoConexion();

    public boolean UsuarioContraseña(String usuario, String clave) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(SQL_USUARIO_CONTRASEÑA);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            res = ps.executeQuery();
            if (res.absolute(1)) {
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Create(UsuarioDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getRutUsuario());
            ps.setString(3, dto.getClave());
            ps.setString(4, dto.getNombre());
            ps.setString(5, dto.getApellidos());
            ps.setInt(6, dto.getCargo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(UsuarioDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getRutUsuario());
            ps.setString(2, dto.getClave());
            ps.setString(3, dto.getNombre());
            ps.setString(4, dto.getApellidos());
            ps.setInt(5, dto.getCargo());
            ps.setInt(6, dto.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public UsuarioDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        UsuarioDto user = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                user = new UsuarioDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return user;
    }

    @Override
    public List<UsuarioDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<UsuarioDto> user = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();
            while (res.next()) {
                user.add(new UsuarioDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return user;
    }
    
        public UsuarioDto SelectPorUsuario(Object key) {
        PreparedStatement ps;
        ResultSet res;
        UsuarioDto user = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT_USUARIO);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                user = new UsuarioDto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return user;
    }

}
