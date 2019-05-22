<%-- 
    Document   : crearOc
    Created on : 22-05-2019, 0:16:09
    Author     : Nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>Orden de Ingreso</title>
    </head>
    <body background="imagenes/fondo.png">
        <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
            <li><a href="seleccionModulo.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
        </ul>
        <div style="margin-top: 100px">
            <div align="center">
                <table>
                    <tr>
                        <td>Número de Guía: </td>
                        <td><input class="inputModulos" type="text" name="txt_numeroGuía"></td></td><td>
                    </tr>
                    <tr>
                        <td>Rut Proveedor: </td>
                        <td><input class="inputModulos" type="text" name="txt_rutProveedor"></td>
                    </tr>
                    <tr>
                        <td>Fecha: </td>
                        <td><input class="inputModulos" type="text" name="txt_fecha"></td>
                    </tr>
                    <tr>
                        <td>SKU: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProducto"></td>
                    </tr>
                    <tr>
                        <td>Cantidad: </td>
                        <td><input class="inputModulos" type="text" name="txt_cantidad"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" style="margin-top: 20px" name="btn_ordenIngreso" value="Generar Orden de Ingreso"</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
