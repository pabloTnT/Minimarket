<%-- 
    Document   : reporteStock
    Created on : 03-06-2019, 22:06:55
    Author     : PabloTnT
--%>

<%@page import="dto.BodegasDto"%>
<%@page import="dao.BodegasDao"%>
<%@page import="dto.ProductoDto"%>
<%@page import="dao.ProductoDao"%>
<%@page import="dao.Producto_BodegaDao"%>
<%@page import="dto.Producto_BodegaDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/fondo.png">
        <%
            int codigoBodega = 0;
            int codigoProducto = 0;
            int id = 0;
            int stock = 0;
            int codProducto = Integer.valueOf(request.getParameter("codProd"));
            int codBodega = Integer.valueOf(request.getParameter("codBod"));
            Producto_BodegaDao dao = new Producto_BodegaDao();
        %>
        <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
            <table class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                <thead>
                    <tr>
                        <th data-sortable="true" data-sort-dir="asc">ID</th>
                        <th data-sortable="true">Producto</th>
                        <th data-sortable="true">Bodega</th>
                        <th data-sortable="true">Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (codProducto == 0 && codBodega == 0) {
                            for (Producto_BodegaDto dto : dao.SeleccionarTodo()) {
                                codigoBodega = dto.getCod_bodega();
                                codigoProducto = dto.getCod_producto();
                                id = dto.getId();
                                stock = dto.getStock();
                                ProductoDao prodDao = new ProductoDao();
                                for (ProductoDto prodDto : prodDao.SeleccionarTodo()) {
                                    if (codigoProducto == prodDto.getId_producto()) {
                                        String nombreProducto = prodDto.getNombre_producto();
                                        BodegasDao bodDao = new BodegasDao();
                                        for (BodegasDto bodDto : bodDao.SeleccionarTodo()) {
                                            if (codigoBodega == bodDto.getId_bodega()) {
                                                String nombreBodega = bodDto.getNombre_bodega();


                    %>
                    <tr>
                        <td> <%=id%></td>
                        <td value="<%=codigoProducto%>"><%=nombreProducto%></td>
                        <td value="<%=codigoBodega%>"><%=nombreBodega%></td>
                        <td><%=stock%></td>
                    </tr>
                    <%}
                                        }
                                    }
                                }
                            }
                        }%>

                    <%
                        if (codProducto != 0 && codBodega != 0) {
                            for (Producto_BodegaDto dto : dao.SeleccionarPorProdBod(codProducto, codBodega)) {
                                codigoBodega = dto.getCod_bodega();
                                codigoProducto = dto.getCod_producto();
                                id = dto.getId();
                                stock = dto.getStock();
                                ProductoDao prodDao = new ProductoDao();
                                for (ProductoDto prodDto : prodDao.SeleccionarTodo()) {
                                    if (codigoProducto == prodDto.getId_producto()) {
                                        String nombreProducto = prodDto.getNombre_producto();
                                        BodegasDao bodDao = new BodegasDao();
                                        for (BodegasDto bodDto : bodDao.SeleccionarTodo()) {
                                            if (codigoBodega == bodDto.getId_bodega()) {
                                                String nombreBodega = bodDto.getNombre_bodega();


                    %>
                    <tr>
                        <td> <%=id%></td>
                        <td value="<%=codigoProducto%>"><%=nombreProducto%></td>
                        <td value="<%=codigoBodega%>"><%=nombreBodega%></td>
                        <td><%=stock%></td>
                    </tr>
                    <%}
                                        }
                                    }
                                }
                            }
                        }
                    %>
                    <%
                        if (codProducto != 0 && codBodega == 0) {
                            for (Producto_BodegaDto dto : dao.SeleccionarPorProducto(codProducto)) {
                                codigoBodega = dto.getCod_bodega();
                                codigoProducto = dto.getCod_producto();
                                id = dto.getId();
                                stock = dto.getStock();
                                ProductoDao prodDao = new ProductoDao();
                                for (ProductoDto prodDto : prodDao.SeleccionarTodo()) {
                                    if (codigoProducto == prodDto.getId_producto()) {
                                        String nombreProducto = prodDto.getNombre_producto();
                                        BodegasDao bodDao = new BodegasDao();
                                        for (BodegasDto bodDto : bodDao.SeleccionarTodo()) {
                                            if (codigoBodega == bodDto.getId_bodega()) {
                                                String nombreBodega = bodDto.getNombre_bodega();


                    %>
                    <tr>
                        <td> <%=id%></td>
                        <td value="<%=codigoProducto%>"><%=nombreProducto%></td>
                        <td value="<%=codigoBodega%>"><%=nombreBodega%></td>
                        <td><%=stock%></td>
                    </tr>
                    <%}
                                        }
                                    }
                                }
                            }
                        }%>
                    <%
                        if (codProducto == 0 && codBodega != 0) {
                            for (Producto_BodegaDto dto : dao.SeleccionarPorBodega(codBodega)) {
                                codigoBodega = dto.getCod_bodega();
                                codigoProducto = dto.getCod_producto();
                                id = dto.getId();
                                stock = dto.getStock();
                                ProductoDao prodDao = new ProductoDao();
                                for (ProductoDto prodDto : prodDao.SeleccionarTodo()) {
                                    if (codigoProducto == prodDto.getId_producto()) {
                                        String nombreProducto = prodDto.getNombre_producto();
                                        BodegasDao bodDao = new BodegasDao();
                                        for (BodegasDto bodDto : bodDao.SeleccionarTodo()) {
                                            if (codigoBodega == bodDto.getId_bodega()) {
                                                String nombreBodega = bodDto.getNombre_bodega();


                    %>
                    <tr>
                        <td> <%=id%></td>
                        <td value="<%=codigoProducto%>"><%=nombreProducto%></td>
                        <td value="<%=codigoBodega%>"><%=nombreBodega%></td>
                        <td><%=stock%></td>
                    </tr>
                </tbody>
                <%}
                                    }
                                }
                            }
                        }
                    }
                %>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>s
    </body>
</html>