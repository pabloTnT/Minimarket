<%-- 
    Document   : ingresarProductoLocal
    Created on : 21-05-2019, 21:16:17
    Author     : Goma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

    </head>
    <body background="imagenes/fondo.png">
        <div style="margin-top: 100px">
            <div align="center">
                <br><br><br><br><br>
                <table>
                    <tr>
                        <td>Numero de guia:</td>
                        <td><input class="inputModulos" type="text" name="txt_ingresoNumeroGuia" placeholder="Ingrese numero de guia"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="inputModulos" type="button" name="btn_buscarNumeroGuia" value="Buscar" </td>
                    </tr>

                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
