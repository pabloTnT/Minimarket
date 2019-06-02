<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
Author     : PabloTnT
--%>

<%@page import="dao.ProductoDao"%>
<%@page import="dto.ProductoDto"%>
<%@page import="dto.Tipo_productoDto"%>
<%@page import="dao.Tipo_productoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    </head>
    <body background="imagenes/fondo.png">
        <form action="Productos_controller.do" method="post">
            <div align="center">
                <div style="margin-top: 100px" id="crearProductos">
                    <%
                        ProductoDao prodDao = new ProductoDao();
                    ProductoDto prod = prodDao.Select(request.getParameter("idProd"));
                    int id = prod.getId_producto();
                    String nombre =  prod.getNombre_producto();
                    int precio = prod.getPrecio_producto();
                    %>
                    <table>
                        <tr>
                            <td>ID: </td>
                            <td><input class="inputModulos" type="text" name="txt_idProducto" value="<%=id%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre: </td>
                            <td><input class="inputModulos" type="text" name="txt_nombreProducto" value="<%=nombre%>"></td>
                        </tr>
                        <tr>
                            <td>Tipo Producto: </td>
                            <td>
                                <select name="opt_tipoProducto">
                                    <option></option>
                                    <%
                                        Tipo_productoDao tipoProdDao = new Tipo_productoDao();
                                        for (Tipo_productoDto tipoProd : tipoProdDao.SeleccionarTodo()) {
                                            String nombreTipo = tipoProd.getNombre_tipo();
                                            int codTipo = tipoProd.getId();
                                    %>
                                    <option value="<%=codTipo%>"><%=nombreTipo%></option>
                                    <%

                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Precio Estimado: </td>
                            <td><input class="inputModulos" type="text" name="txt_precioEstimado" value="<%=precio%>"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarProducto">Guardar</button>
                </div>
            </div>
            
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
