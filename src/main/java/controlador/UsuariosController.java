/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDao;
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
public class UsuariosController extends HttpServlet {

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
            UsuarioDao dao = new UsuarioDao();
            if (request.getParameter("btn_guardarUsuario") != null) {
                UsuarioDto dto = new UsuarioDto();
                if (dto.validarRut(request.getParameter("txt_rutUsuario"))) {
                    dto.setRutUsuario(request.getParameter("txt_rutUsuario"));
                    dto.setNombre(request.getParameter("txt_nombreUsuario"));
                    dto.setApellidos(request.getParameter("txt_apellidosUsuario"));
                    dto.setCargo(Integer.valueOf(request.getParameter("opt_cargoUsuario")));
                    dto.setClave(request.getParameter("txt_contraUsuario"));
                    dao.Create(dto);
                    response.sendRedirect("crearUsuario.jsp");
                }

            }
            if (request.getParameter("btn_eliminarUsuario") != null) {
                String codUsuario = request.getParameter("btn_eliminarUsuario");
                dao.Delete(codUsuario);
                response.sendRedirect("listarUsuarios.jsp");
            }
            if (request.getParameter("btn_updateUsuario") != null) {
                UsuarioDto dto = new UsuarioDto();
                dto.setId(Integer.valueOf(request.getParameter("txt_idUsuario")));
                dto.setRutUsuario(request.getParameter("txt_rutUsuario"));
                dto.setNombre(request.getParameter("txt_nombreUsuario"));
                dto.setApellidos(request.getParameter("txt_apellidosUsuario"));
                dto.setCargo(Integer.valueOf(request.getParameter("opt_cargoUsuario")));
                dto.setClave(request.getParameter("txt_contraUsuario"));
                dao.Update(dto);
                response.sendRedirect("editarUsuarios.jsp?cambio="+"ok");
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
