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
<<<<<<< HEAD
        </ul> 
=======
        </ul>  
>>>>>>> 4270ddf45c0a25c20763a2f750eba908c035dd24
        <div style="margin-top: 100px">
            <div align="center">
                <table>
                    <tr>
                        <td>Bodega: </td>
                        <td>
                            <select>
                                <option><---Seleccionar---></option>
                                <option>Bodega Central</option>
                                <option>Local</option> 
                            </select>
                        </td>
                        <td>Producto: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProducto"></td>
                    </tr>
                    <tr>
                        <td>Rut Proveedor: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProveedor"></td>
                        <td>Fecha Consulta: </td>
                        <td><input class="inputModulos"type="date"  name="fecha"</td>
                    </tr>
                </table>
            </div>
        </div>
        <div align="center">
        <button style="margin-top: 30px" class="button success outline rounded">Generar Reporte</button>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
