/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BodegasDao;
import dao.ProductoDao;
import dao.ProveedorDao;
import dto.BodegasDto;
import dto.ProductoDto;
import dto.ProveedorDto;
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
public class AdmSistemaController extends HttpServlet {

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
                dto.setId_bodega(Integer.valueOf(request.getParameter("txt_idBodega")));
                dto.setNombre_bodega(request.getParameter("txt_nombreBodega"));
                dto.setComuna(request.getParameter("txt_comunaBodega"));
                dto.setDireccion(request.getParameter("txt_direccionBodega"));
                dto.setEncargado(request.getParameter("opt_encargadoBodega"));
                BodegasDao dao = new BodegasDao();
                dao.Create(dto);
                response.sendRedirect("admSistema.jsp");
            }
            if(request.getParameter("btn_guardarProducto")!=null){
                ProductoDto dto = new ProductoDto();
                dto.setNombre_producto(request.getParameter("txt_nombreProducto"));
                dto.setPrecio_producto(Integer.valueOf(request.getParameter("txt_precioEstimado")));
                dto.setId_producto(Integer.valueOf(request.getParameter("txt_idProducto")));
                dto.setTipo_producto(Integer.valueOf(request.getParameter("opt_tipoProducto")));
                ProductoDao dao = new ProductoDao();
                dao.Create(dto);
                response.sendRedirect("admSistema.jsp");
            }
            if(request.getParameter("btn_guardarProveedor")!=null){
                ProveedorDto dto = new ProveedorDto();
                dto.setId(Integer.valueOf(request.getParameter("txt_codProveedor")));
                dto.setRut(request.getParameter("txt_rutProveedor"));
                dto.setRazon_social(request.getParameter("txt_razonSocial"));
                dto.setDireccion(request.getParameter("txt_direccionProveedor"));
                dto.setNombre_contacto(request.getParameter("txt_nombreContacto"));
                dto.setTelefono(Integer.valueOf(request.getParameter("txt_telefonoContacto")));
                ProveedorDao dao = new ProveedorDao();
                dao.Create(dto);
                response.sendRedirect("admSistema.jsp");
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
