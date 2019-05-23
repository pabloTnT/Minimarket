/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BodegasDao;
import dao.ProductosDao;
import dto.BodegasDto;
import dto.FuncionarioDto;
import dto.ProductosDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

/**
 *
 * @author PabloTnT
 */
public class creacionBodegas extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("btn_guardarBodega") != null) {
                BodegasDto dto = new BodegasDto();
                dto.setId(Integer.valueOf(request.getParameter("txt_idBodega")));
                dto.setDireccion(request.getParameter("txt_direccionBodega"));
                dto.setEncargado(request.getParameter("opt_encargadoBodega"));
                BodegasDao dao = new BodegasDao();
                dao.Create(dto);
                response.sendRedirect("administracionSistema.jsp");
            }
            if(request.getParameter("btn_guardarProducto")!=null){
                ProductosDto dto = new ProductosDto();
                dto.setNombre(request.getParameter("txt_nombreProducto"));
                dto.setPrecio(Integer.valueOf(request.getParameter("txt_precioEstimado")));
                dto.setSku(Integer.valueOf(request.getParameter("txt_idProducto")));
                ProductosDao dao = new ProductosDao();
                dao.Create(dto);
            }
            if(request.getParameter("btn_guardarPersonal")!=null){
                FuncionarioDto dto = new FuncionarioDto();
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
