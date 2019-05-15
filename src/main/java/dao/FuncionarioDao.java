/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.FuncionarioDto;
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
public class FuncionarioDao implements DaoInterface<FuncionarioDto> {

    private static final String SQL_INSERT = "INSERT INTO funcionario (mantiza, dv, nombre, apellido, fecha_ingreso, salario, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM funcionario WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE funcionario SET nombre=?, apellido=?, fecha_ingreso=?, salario=?, cargo=? WHERE mantiza=?";
    private static final String SQL_SELECT = "SELECT * FROM funcionario WHERE mantiza=?";
    private static final String SQL_SELECTALL = "SELECT * FROM funcionario";

    private static final Conexion con = Conexion.estadoConexion();

    @Override
    public boolean Create(FuncionarioDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getMantiza());
            ps.setString(2, dto.getDv());
            ps.setString(3, dto.getNombre());
            ps.setString(4, dto.getApellido());
            ps.setDate(5, (Date) dto.getFecha_ingreso());
            ps.setInt(6, dto.getSalario());
            ps.setString(7, dto.getCargo());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean Update(FuncionarioDto dto) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellido());
            ps.setDate(3, (Date) dto.getFecha_ingreso());
            ps.setInt(4, dto.getSalario());
            ps.setString(5, dto.getCargo());
            ps.setInt(6, dto.getMantiza());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public FuncionarioDto Select(Object key) {
        PreparedStatement ps;
        ResultSet res;
        FuncionarioDto fun = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECT);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                fun = new FuncionarioDto(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getDate(5), res.getInt(6), res.getString(7));
            }
            return fun;
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_GuiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return fun;
    }

    @Override
    public List<FuncionarioDto> SeleccionarTodo() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<FuncionarioDto> fun = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();
            while (res.next()) {
                fun.add(new FuncionarioDto(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getDate(5), res.getInt(6), res.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return fun;
    }

}