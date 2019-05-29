<%-- 
    Document   : generarGuiaDespacho
    Created on : 22-05-2019, 1:18:17
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

        <title>Generar guia de despacho</title>
    </head>
    <body background="imagenes/fondo.png">
        <div style="margin-top: 100px">
            <div align="center">
                <table>
                    <tr>
                        <td align="center">Datos de la guia /td>
                    </tr> 
                    <tr>
                        </td>

                        <td>ID </td>
                        <td><input class="inputModulos" type="text" readonly="readonly" name="txt_idGuiaDespacho"></td>
                    </tr>
                    <tr>
                        <td>Bodega origen</td>
                        <td><input class="inputModulos" type="text" name="txt_bodegaGuiaDespacho" placeholder="Ingrese bodega de origen"></td>
                        
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="inputModulos" type="button" name="btn_generarGuia" value="Generar" </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
