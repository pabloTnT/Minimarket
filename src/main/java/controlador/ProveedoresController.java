/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProveedorDao;
import dto.ProveedorDto;
import dto.UsuarioDto;
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
public class ProveedoresController extends HttpServlet {

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
            ProveedorDao dao = new ProveedorDao();
            if (request.getParameter("btn_guardarProveedor") != null) {
                ProveedorDto dto = new ProveedorDto();
                UsuarioDto usDto = new UsuarioDto();
                if (usDto.validarRut(request.getParameter("txt_rutProveedor"))) {
                    dto.setId(Integer.valueOf(request.getParameter("txt_codProveedor")));
                    dto.setRut(request.getParameter("txt_rutProveedor"));
                    dto.setRazon_social(request.getParameter("txt_razonSocial"));
                    dto.setDireccion(request.getParameter("txt_direccionProveedor"));
                    dto.setNombre_contacto(request.getParameter("txt_nombreContacto"));
                    dto.setTelefono(Integer.valueOf(request.getParameter("txt_telefonoContacto")));
                    dao.Create(dto);
                }

                response.sendRedirect("crearProveedor.jsp");
            }
            if (request.getParameter("btn_eliminarProveedor") != null) {
                String codProveedor = request.getParameter("btn_eliminarProveedor");
                dao.Delete(codProveedor);
                response.sendRedirect("listarProveedores.jsp");
            }
            if (request.getParameter("btn_updateProveedor") != null) {
                ProveedorDto dto = new ProveedorDto();
                dto.setId(Integer.valueOf(request.getParameter("txt_codProveedor")));
                dto.setRut(request.getParameter("txt_rutProveedor"));
                dto.setRazon_social(request.getParameter("txt_razonSocial"));
                dto.setDireccion(request.getParameter("txt_direccionProveedor"));
                dto.setNombre_contacto(request.getParameter("txt_nombreContacto"));
                dto.setTelefono(Integer.valueOf(request.getParameter("txt_telefonoContacto")));
                dao.Update(dto);
                response.sendRedirect("editarProveedores.jsp?cambio="+"ok");
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
