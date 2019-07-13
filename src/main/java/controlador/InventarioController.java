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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            if(request.getParameter("btn_oc")!=null){
                response.sendRedirect("ordenCompra.jsp");
            }
            if(request.getParameter("btn_ingresoBodega")!=null){
                response.sendRedirect("ingresoBodega.jsp");
            }
            if(request.getParameter("btn_generarIngreso")!=null){
                Producto_BodegaDto dto = new Producto_BodegaDto();
                Producto_BodegaDao dao = new Producto_BodegaDao();
                int codProducto = Integer.valueOf(request.getParameter("opt_producto"));
                int codBodega = Integer.valueOf(request.getParameter("opt_bodega"));
                int cantidad = Integer.valueOf(request.getParameter("txt_cantidadProductos"));
                dto.setCod_producto(codProducto);
                dto.setCod_bodega(codBodega);
                Producto_BodegaDto dtoStock = dao.SeleccionarPorProdBod(codProducto, codBodega);
                if(dtoStock != null){
                    int stockAntiguo = dtoStock.getStock();
                    int idProdBodega = dtoStock.getId();
                    int stockNuevo =  stockAntiguo + cantidad;
                    dto.setStock(stockNuevo);
                    dto.setId(idProdBodega);
                    dao.Update(dto);
                }else{
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
