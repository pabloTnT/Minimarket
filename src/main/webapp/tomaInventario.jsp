<%-- 
    Document   : moduloReportes
    Created on : 21-05-2019, 14:44:20
    Author     : PabloTnT
--%>

<%@page import="modelo.dto.ProductoDto"%>
<%@page import="modelo.dao.ProductoDao"%>
<%@page import="modelo.dto.ProveedorDto"%>
<%@page import="modelo.dao.ProveedorDao"%>
<%@page import="modelo.dto.BodegasDto"%>
<%@page import="modelo.dao.BodegasDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>Reportería</title>
    </head>
    <body background="imagenes/fondo.png">
    <form action="Inventario_controller.do" method="post">
        <div style="margin-top: 100px">
            <div align="center">
                <table>
                    <tr>
                        <td>Bodega: </td>
                        <td>
                            <select name="opt_bodega">
                                <option value="0"><--Seleccionar Todo--></option>
                                <%
                                    BodegasDao bod = new BodegasDao();
                                    for (BodegasDto dto : bod.SeleccionarTodo()) {
                                        String nombreBod = dto.getNombre_bodega();
                                        int codBod = dto.getId_bodega();
                                %>
                                <option value="<%=codBod%>"><%=nombreBod%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>

                    </tr>
                </table>
            </div>
        </div>
        <div align="center">
            <button style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_inventario">Continuar</button>
        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
</body>
</html>
