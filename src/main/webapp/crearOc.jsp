<%-- 
    Document   : crearOc
    Created on : 22-05-2019, 0:16:09
    Author     : Nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/fondo.png">
        <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
            <li><a href="index.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
        </ul> 
        <form>
            <table>
                <tr>
                    <td>SKU: </td>
                    <td><input class="inputModulos" type="text" name="txt_idProducto"></td></td><td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td><input class="inputModulos" type="text" name="txt_Cantidad"></td>
                </tr>
                <tr>
                    <td>Rut proveedor: </td>
                    <td><input class="inputModulos" type="text" name="txt_rutProveedor"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="btn_OC" value="Generar Orden de Compra"</td>
                </tr>
            </table>
        </form>
    </body>
</html>
