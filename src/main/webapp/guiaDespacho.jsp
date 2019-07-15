<%-- 
    Document   : guiaDespacho
    Created on : 13-07-2019, 17:13:01
    Author     : PabloTnT
--%>

<%@page import="modelo.dto.ProductoDto"%>
<%@page import="modelo.dao.ProductoDao"%>
<%@page import="modelo.dto.BodegasDto"%>
<%@page import="modelo.dao.BodegasDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/fondo.png">
        <form action="Inventario_controller.do" method="post">
            <div align="center" style="margin-top: 100px"> 
                <table>
                    <tr>
                        <td>Bod. Origen:</td>
                        <td>
                            <select style="margin-left: 20px" name="opt_bodegaOrigen">
                                <option><---Bod. Origen--></option>
                                <%
                                    BodegasDao bodDao = new BodegasDao();
                                    for (BodegasDto dto : bodDao.SeleccionarTodo()) {
                                        int codBodega = dto.getId_bodega();
                                        String nombreBodega = dto.getNombre_bodega();
                                %>
                                <option value="<%=codBodega%>"><%=nombreBodega%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Bod. Destino:</td>
                        <td>
                            <select style="margin-left: 20px" name="opt_bodegaDestino">
                                <option><---Bod. Destino---></option>
                                <%
                                    for (BodegasDto dto : bodDao.SeleccionarTodo()) {
                                        int codBodega = dto.getId_bodega();
                                        String nombreBodega = dto.getNombre_bodega();
                                %>
                                <option value="<%=codBodega%>"><%=nombreBodega%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </table>
                <div style="margin-left: 200px; margin-right: 200px">
                    <table id="tableAgregaProductos" class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false" >
                        <thead>
                            <tr>
                                <th data-sortable="true" data-sort-dir="asc">Nombre Proucto</th>
                                <th data-sortable="true">Cod. Proucto</th>
                                <th data-sortable="true">Cantidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                                <td>
                                    <select name="opt_prod">
                                        <option><--Elija Producto--></option>
                                        <%
                                            ProductoDao prodDao = new ProductoDao();
                                            for (ProductoDto prodDto : prodDao.SeleccionarTodo()) {
                                                int codProducto = prodDto.getId_producto();
                                                String nombreProducto = prodDto.getNombre_producto();
                                        %>
                                        <option value="<%=codProducto%>"><%=nombreProducto%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                                <td></td>
                                <td><input type="number" name="txt_cantidadDespacho"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            <button align="center" style="margin-top: 70px; width: 200px" class="button success rounded" name="btn_generarGuiaDespacho">Generar Documento</button>
            </div>
        </form>
    </body>
</html>
