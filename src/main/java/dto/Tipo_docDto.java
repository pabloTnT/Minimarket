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
//   Clase java, que contiene tributos, constructor, getters y setters, de los tipos de documentos.



public class Tipo_docDto {
    private int id_doc;
    private String doc_nombre;

    public Tipo_docDto() {
    }

    public Tipo_docDto(int id_doc) {
        this.id_doc = id_doc;
    }

    public Tipo_docDto(int id_doc, String doc_nombre) {
        this.id_doc = id_doc;
        this.doc_nombre = doc_nombre;
    }

    public String getDoc_nombre() {
        return doc_nombre;
    }

    public void setDoc_nombre(String doc_nombre) {
        this.doc_nombre = doc_nombre;
    }

    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }
    
    
}
