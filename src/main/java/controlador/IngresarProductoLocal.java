/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.Doc_DetailDao;
import dao.Doc_HeadDao;
import dto.Doc_HeadDto;
import dto.ProductosDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Goma
 */
public class IngresarProductoLocal extends HttpServlet{
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("btn_buscarNumeroGuia")!=null){
                response.sendRedirect("ingresarProductoLocal.jsp");
            }
            
        }
    }
    
}