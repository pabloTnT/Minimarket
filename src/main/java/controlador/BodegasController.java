/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BodegasDao;
import dto.BodegasDto;
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
public class BodegasController extends HttpServlet {

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
                BodegasDao dao = new BodegasDao();
            if (request.getParameter("btn_guardarBodega") != null) {
                BodegasDto dto = new BodegasDto();
                dto.setId_bodega(Integer.valueOf(request.getParameter("txt_idBodega")));
                dto.setNombre_bodega(request.getParameter("txt_nombreBodega"));
                dto.setComuna(request.getParameter("txt_comunaBodega"));
                dto.setDireccion(request.getParameter("txt_direccionBodega"));
                dto.setEncargado(request.getParameter("opt_encargadoBodega"));
                dao.Create(dto);
                String mensaje = null;
                if(dao.Create(dto)){
                    mensaje = "Bodega creada";
                }else{
                    mensaje = "Hubo un problema al crear la bodega";
                }
                response.sendRedirect("crearBodega.jsp?mensaje="+mensaje);
            }
            if (request.getParameter("btn_eliminarBodega") != null) {
                String codBodega = request.getParameter("btn_eliminarBodega");
                dao.Delete(codBodega);
                response.sendRedirect("listarBodegas.jsp");
            }
            if(request.getParameter("btn_updateBodega")!= null){
                BodegasDto dto = new BodegasDto();
                dto.setId_bodega(Integer.valueOf(request.getParameter("txt_idBodega")));
                dto.setNombre_bodega(request.getParameter("txt_nombreBodega"));
                dto.setComuna(request.getParameter("txt_comunaBodega"));
                dto.setDireccion(request.getParameter("txt_direccionBodega"));
                dto.setEncargado(request.getParameter("opt_encargadoBodega"));
                dao.Update(dto);
                response.sendRedirect("editarBodega.jsp?cambios="+"ok");
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
