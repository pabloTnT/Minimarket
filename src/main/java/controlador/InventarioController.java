/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.Producto_BodegaDao;
import modelo.dto.Producto_BodegaDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.Doc_DetailDto;
import modelo.dto.Doc_HeadDto;
import modelo.dto.UsuarioDto;
import modelo.dao.Doc_HeadDao;
import modelo.dto.RegistroDocumento;

/**
 *
 * @author PabloTnT
 */
public class InventarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("btn_oc") != null) {
                response.sendRedirect("ordenCompra.jsp");
            }
            if (request.getParameter("btn_ingresoBodega") != null) {
                response.sendRedirect("ingresoBodega.jsp");
            }
            if (request.getParameter("btn_generarGuia") != null) {
                response.sendRedirect("transferenciaProductos.jsp");
            }
            if (request.getParameter("btn_tomaInventario") != null) {
                response.sendRedirect("tomaInventario.jsp");
            }
            if (request.getParameter("btn_inventario") != null) {
                response.sendRedirect("modInventario.jsp");
            }

            if (request.getParameter("btn_generarGuiaDespacho") != null) {
                String mensaje = null;
                int codProucto = Integer.valueOf(request.getParameter("opt_prod"));
                int codBodegaOrigen = Integer.valueOf(request.getParameter("opt_bodegaOrigen"));
                int codBodegaDestino = Integer.valueOf(request.getParameter("opt_bodegaDestino"));
                int idDoc = Integer.valueOf(request.getParameter("txt_numeroFolio"));
                int cantidadProductos = Integer.valueOf(request.getParameter("txt_cantidadDespacho"));
                Doc_HeadDto head = new Doc_HeadDto();
                Doc_DetailDto det = new Doc_DetailDto();
                ArrayList<Doc_DetailDto> detail = new ArrayList<Doc_DetailDto>();
                UsuarioDto usuario = (UsuarioDto) request.getSession().getAttribute("sesionUsuario");
                int idUsuario = usuario.getId();
                Producto_BodegaDao prodBod = new Producto_BodegaDao();
                for (Producto_BodegaDto inv : prodBod.SeleccionarTodo()) {
                    if (inv.getCod_producto() == codProucto && inv.getCod_bodega() == codBodegaOrigen) {
                        if (inv.getStock() >= cantidadProductos) {
                            /*completa cabecera documento*/
                            head.setIdUsuario(idUsuario);
                            head.setTipoDoc(3);
                            head.setBodOrigen(codBodegaOrigen);
                            head.setBodDestino(codBodegaDestino);
                            Doc_HeadDao docDao = new Doc_HeadDao();
                            for (Doc_HeadDto docDto : docDao.SeleccionarTodo()) {
                                if (idDoc != docDto.getIdDoc()) {
                                    head.setIdDoc(idDoc);
                                } else {
                                    /*Folio en uso*/
                                }
                            }
                            /*completa detalle documento*/
                            det.setId_doc(head.getIdDoc());
                            LocalDate date = LocalDate.now();
                            det.setId_doc(idDoc);
                            det.setFecha_doc(java.sql.Date.valueOf(date));
                            det.setCantidad(cantidadProductos);
                            det.setCod_producto(codProucto);
                            detail.add(det);
                            RegistroDocumento registro = new RegistroDocumento();
                            registro.generaRegistro(head, detail);
                            response.sendRedirect("transferenciaProductos.jsp");
                        } else {
                            /*mensaje de error, cantidad no disponible*/
                        }
                    } else {
                        /*mensaje de error, producto no disponible*/
                    }
                }

            }

            if (request.getParameter("btn_generarIngreso") != null) {
                Producto_BodegaDto dto = new Producto_BodegaDto();
                Producto_BodegaDao dao = new Producto_BodegaDao();
                int codProducto = Integer.valueOf(request.getParameter("opt_producto"));
                int codBodega = Integer.valueOf(request.getParameter("opt_bodega"));
                int cantidad = Integer.valueOf(request.getParameter("txt_cantidadProductos"));
                dto.setCod_producto(codProducto);
                dto.setCod_bodega(codBodega);
                Producto_BodegaDto dtoStock = dao.SeleccionarPorProdBod(codProducto, codBodega);
                if (dtoStock != null) {
                    int stockAntiguo = dtoStock.getStock();
                    int idProdBodega = dtoStock.getId();
                    int stockNuevo = stockAntiguo + cantidad;
                    dto.setStock(stockNuevo);
                    dto.setId(idProdBodega);
                    dao.Update(dto);
                } else {
                    dao.Create(dto);
                }
                response.sendRedirect("ingresoBodega.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
