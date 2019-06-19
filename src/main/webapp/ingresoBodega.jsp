<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
Author     : PabloTnT
--%>

<%@page import="dao.ProductoDao"%>
<%@page import="dto.ProductoDto"%>
<%@page import="dao.BodegasDao"%>
<%@page import="dto.BodegasDto"%>
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
        <form action="Inventario_controller.do" method="post">
            <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
            <li><a href="seleccionModulo.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
            <li class="active"><a href="#abastecimiento">Abastecimiento</a></li>
            <li><a href="#trasladoMercaderia">Traslado de Mercaderia</a></li>
        </ul> 
            <div align="center">
                <div style="margin-top: 100px">
                    <table>
                        <tr>
                            <td>Producto: </td>
                            <td>
                                <select name="opt_producto">
                                    <option><--Seleccionar Producto--></option>
                                    <%
                                     ProductoDao prodDao = new ProductoDao();
                                     for(ProductoDto prodDto : prodDao.SeleccionarTodo()){
                                    int codigoProducto = prodDto.getId_producto();
                                    String nombreProducto = prodDto.getNombre_producto();
                                    %>
                                    <option value="<%=codigoProducto%>"><%=nombreProducto%></option>
                                         <%
                                     }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Bodega: </td>
                            <td>
                                <select name="opt_bodega">
                                    <%
                                    BodegasDao bodDao = new BodegasDao();
                                    for(BodegasDto bodDto : bodDao.SeleccionarTodo()){
                                        int codigoBodega = bodDto.getId_bodega();
                                        String nombreBodega = bodDto.getNombre_bodega();
                                        %>
                                        <option value="<%=codigoBodega%>"><%=nombreBodega%></option>
                                        <%
                                    }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Cantidad: </td>
                            <td><input class="inputModulos" type="text" name="txt_cantidadProductos"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_generarIngreso">Generar Ingreso</button>
                </div>
            </div>
            
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
