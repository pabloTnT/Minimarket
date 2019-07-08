/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.Doc_HeadDao;

/**
 *
 * @author PabloTnT
 */
//Clase java, que contiene tributos, constructor, getters y setters

public class Doc_HeadDto {
    private int idDoc;
    private int idUsuario;
    private int tipoDoc;
    private int numDoc;
    private int idProveedor;
    private int bodOrigen;
    private int bodDestino;

    public Doc_HeadDto() {
    }

    public Doc_HeadDto(int id_doc) {
        this.idDoc = idDoc;
    }

    public Doc_HeadDto(int idDoc, int idUsuario, int tipoDoc, int numDoc, int idProveedor, int bodOrigen, int bodDestino) {
        this.idDoc = idDoc;
        this.idUsuario = idUsuario;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.idProveedor = idProveedor;
        this.bodOrigen = bodOrigen;
        this.bodDestino = bodDestino;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(int tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getBodOrigen() {
        return bodOrigen;
    }

    public void setBodOrigen(int bodOrigen) {
        this.bodOrigen = bodOrigen;
    }

    public int getBodDestino() {
        return bodDestino;
    }

    public void setBodDestino(int bodDestino) {
        this.bodDestino = bodDestino;
    }

    
    
    public boolean validaFolioEnUso(int idDoc){
        Doc_HeadDao dao = new Doc_HeadDao();
        if(dao.Select(idDoc)!=null){
            return true;
        }else{
            return false;
        }
    }
    
}
