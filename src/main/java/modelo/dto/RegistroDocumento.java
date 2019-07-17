/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.util.ArrayList;
import modelo.dao.Doc_DetailDao;
import modelo.dao.Doc_HeadDao;
import modelo.dao.Producto_BodegaDao;

/**
 *
 * @author PabloTnT
 */
public class RegistroDocumento {
    private Doc_HeadDto docHeadDto;
    private ArrayList<Doc_DetailDto> docDetailDto;

    public RegistroDocumento() {
    }

    public Doc_HeadDto getDocHeadDto() {
        return docHeadDto;
    }

    public void setDocHeadDto(Doc_HeadDto docHeadDto) {
        this.docHeadDto = docHeadDto;
    }

    public ArrayList<Doc_DetailDto> getDocDetailDto() {
        return docDetailDto;
    }

    public void setDocDetailDto(ArrayList<Doc_DetailDto> docDetailDto) {
        this.docDetailDto = docDetailDto;
    }

    public void generaRegistro (Doc_HeadDto docHeadDto, ArrayList<Doc_DetailDto> listadoDetalle){
        try{
        Doc_HeadDao headDao = new Doc_HeadDao();
        Doc_DetailDao detailDao = new Doc_DetailDao();
        headDao.Create(docHeadDto);
        for(Doc_DetailDto detalle : listadoDetalle){
            Producto_BodegaDao listado = new Producto_BodegaDao();
                int stockActualDestino = listado.SeleccionarPorProdBod(detalle.getCod_producto(), docHeadDto.getBodDestino()).getStock();
                int stockActualOrigen = listado.SeleccionarPorProdBod(detalle.getCod_producto(), docHeadDto.getBodOrigen()).getStock();
            if(listado.SeleccionarPorProdBod(detalle.getCod_producto(), docHeadDto.getBodDestino())!=null){
                listado.modificaStock(detalle.getCantidad()+stockActualDestino, detalle.getCod_producto(), docHeadDto.getBodDestino());
                listado.modificaStock(stockActualOrigen - detalle.getCantidad(), detalle.getCod_producto(), docHeadDto.getBodOrigen());
            }else{
                Producto_BodegaDto prodBodDto = new Producto_BodegaDto();
                prodBodDto.setCod_bodega(docHeadDto.getBodDestino());
                prodBodDto.setCod_producto(detalle.getCod_producto());
                prodBodDto.setStock(detalle.getCantidad());
                listado.modificaStock(stockActualOrigen - detalle.getCantidad(), detalle.getCod_producto(), docHeadDto.getBodOrigen());
                listado.Create(prodBodDto);
            }
            detailDao.Create(detalle);
        }
        }catch(Exception ex){
            
        }
    } 
    
    
}
