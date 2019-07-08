<%-- 
    Document   : ordenCompra
    Created on : 30-06-2019, 19:53:30
    Author     : PabloTnT
--%>

<%@page import="dto.BodegasDto"%>
<%@page import="dao.BodegasDao"%>
<%@page import="dto.ProveedorDto"%>
<%@page import="dao.ProveedorDao"%>
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
        <h2 align="center">Crear Orden de Compra</h2>
        <form action="Documentos_controller.do" method="post">
            <div align="center">
                <table>
                    <tr>
                        <td>Proveedor: </td>
                        <td>
                            <select name="opt_proveedor">
                                <option>Seleccionar Proveedor</option>
                                <%
                                    ProveedorDao provDao = new ProveedorDao();
                                    for (ProveedorDto provDto : provDao.SeleccionarTodo()) {
                                        int codProveedor = provDto.getId();
                                        String nombreProveedor = provDto.getRazon_social();
                                %>
                                <option value="<%=codProveedor%>"><%=nombreProveedor%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Bodega Destino: </td>
                        <td>
                            <select name="opt_bodDestino">
                                <option>Seleccione Bodega:</option>
                                <%
                                    BodegasDao bodDao = new BodegasDao();
                                    for (BodegasDto bodDto : bodDao.SeleccionarTodo()) {
                                        int codBodega = bodDto.getId_bodega();
                                        String nombreBodega = bodDto.getNombre_bodega();
                                %>
                                <option value="<%=codBodega%>"><%=nombreBodega%></option>
                                <%
                                    }

                                %>
                            </select>
                        </td>
                    </tr>
                </table>
                <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
                    <table id="agregaDetalle" class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                        <thead>
                            <tr>
                                <th data-sortable="true" data-sort-dir="asc">ID</th>
                                <th data-sortable="true">Producto</th>
                                <th data-sortable="true">Bodega</th>
                                <th data-sortable="true">Stock</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><button onclick="agregarFila()">Agregar</button></td>
                            </tr>
                        </tbody>    
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarProducto">Guardar</button>

                </div>
        </form>
        <script>
            function agregarFila() {
                document.getElementById("agregaDetalle").insertRow(-1).innerHTML = '<td></td><td></td><td></td><td><button onclick="agregarFila()">Agregar</button></td>';
            }
            function eliminarFila() {
                var table = document.getElementById("agregaDetalle");
                var rowCount = table.rows.length;
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
