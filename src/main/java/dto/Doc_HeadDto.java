/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PabloTnT
 */
//Clase java, que contiene tributos, constructor, getters y setters

public class Doc_HeadDto {
    private int id_doc;
    private int tipo_doc;
    private int num_doc;
    private int bod_origen;
    private int bod_destino;

    public Doc_HeadDto() {
    }

    public Doc_HeadDto(int id_doc) {
        this.id_doc = id_doc;
    }

    public Doc_HeadDto(int id_doc, int tipo_doc, int num_doc, int bod_origen, int bod_destino) {
        this.id_doc = id_doc;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.bod_origen = bod_origen;
        this.bod_destino = bod_destino;
    }

    public int getBod_destino() {
        return bod_destino;
    }

    public void setBod_destino(int bod_destino) {
        this.bod_destino = bod_destino;
    }

    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public int getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(int tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public int getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(int num_doc) {
        this.num_doc = num_doc;
    }

    public int getBod_origen() {
        return bod_origen;
    }

    public void setBod_origen(int bod_origen) {
        this.bod_origen = bod_origen;
    }
    
    
}
