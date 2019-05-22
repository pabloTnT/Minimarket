<%-- 
    Document   : moduloReportes
    Created on : 21-05-2019, 14:44:20
    Author     : PabloTnT
--%>

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
        <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
            <li><a href="seleccionModulo.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
        </ul> 
        <div style="margin-top: 100px">
            <div align="center">
                <table>
                    <tr>
                        <td>Bodega: </td>
                        <td>
                            <select style="margin-left: 20px">
                                <option align="center">-- Seleccione --</option>
                                <option>Bodega Central</option>
                                <option>Local</option>
                            </select>
                        </td>
                        <td> </td>
                        <td>Producto: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProducto"></td>
                    </tr>
                    <tr>
                        <td>Rut Proveedor: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProveedor"></td>
                        <td> </td>
                        <td>Fecha Consulta: </td>
                        <td><input type="date" style="margin-left: 20px" name="fecha"</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><input type="submit" style="margin-top: 20px" name="btn_reporte" value="Generar Reporte"</td>
                        <td></td>
                        <td></td>
                    </tr>
            </div>
        </div>
    </table>
</body>
</html>
