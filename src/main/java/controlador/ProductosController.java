/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.ProductoDao;
import modelo.dto.ProductoDto;
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
/* clase java utilizada como controlador de los datos ingresado en los jsp relacionado con el CRUD de los productos */
public class ProductosController extends HttpServlet {

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
            ProductoDao dao = new ProductoDao();
            /*IF utilizado para crear un nuevo producto dentro de la base de datos */
            if(request.getParameter("btn_guardarProducto")!=null){
            ProductoDto dto = new ProductoDto();
                dto.setNombre_producto(request.getParameter("txt_nombreProducto"));
                dto.setPrecio_producto(Integer.valueOf(request.getParameter("txt_precioEstimado")));
                dto.setId_producto(Integer.valueOf(request.getParameter("txt_idProducto")));
                dto.setTipo_producto(Integer.valueOf(request.getParameter("opt_tipoProducto")));
                dao.Create(dto);
                response.sendRedirect("crearProducto.jsp");
            }
            /*IF utilizado para elimir un producto dentro de la base de datos */
            if(request.getParameter("btn_eliminarProducto")!=null){
                String codProducto = request.getParameter("btn_eliminarProducto");
                dao.Delete(codProducto);
                response.sendRedirect("listarProductos.jsp");
            }
            /*IF utilizado para editar un producto existente dentro de la base de datos*/
            if(request.getParameter("btn_guardarCambios")!=null){
            ProductoDto dto = new ProductoDto();
                dto.setId_producto(Integer.valueOf(request.getParameter("txt_idProducto")));
                dto.setNombre_producto(request.getParameter("txt_nombreProducto"));
                dto.setTipo_producto(Integer.valueOf(request.getParameter("opt_tipoProducto")));
                dto.setPrecio_producto(Integer.valueOf(request.getParameter("txt_precioEstimado")));
                dao.Update(dto);
                response.sendRedirect("editarProductos.jsp?cambio="+"ok");
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
