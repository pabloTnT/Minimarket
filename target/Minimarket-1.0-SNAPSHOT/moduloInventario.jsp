<%-- 
    Document   : moduloInventario
    Created on : 21-05-2019, 14:44:03
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

        <title>JSP Page</title>

    </head>
    <body background="imagenes/fondo.png">
        <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
            <li><a href="seleccionModulo.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
            <li><a href="#abastecimiento">Abastecimiento</a></li>
            <li><a href="#trasladoMercaderia">Traslado de Mercaderia</a></li>
        </ul> 
        <div style="margin-top: 100px" id="abastecimiento">
            <div align="center">
                <table>
                    <tr>
                        <td>ID:</td>
                        <td><input class="inputModulos" type="text" name="txt_idBodega"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input class="inputModulos" type="text" name="txt_nombreBodega"> </td>
                    </tr>
                    <tr>
                        <td>Comuna: </td>
                        <td><input class="inputModulos" style="margin-left: 20px" type="text" name="txt_comunaBodega"> </td>
                    </tr>
                    <tr>
                        <td>Dirección: </td>
                        <td><input class="inputModulos" style="margin-left: 20px" type="text" name="txt_direccionBodega"></td>
                    </tr>
                    <tr>
                        <td>Encargado: </td>
                        <td>
                            <select style="margin-left: 20px" >
                                <option></option>
                                <option>prueba1</option>
                                <option>prueba2</option>
                                <option>prueba3</option>
                                <option>prueba4</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div align="center">
            <div style="margin-top: 100px" id="trasladoMercaderia">
                <table>
                    <tr>
                        <td>ID: </td>
                        <td><input class="inputModulos" type="text" name="txt_idProducto"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input class="inputModulos" type="text" name="txt_nombreProducto"></td>
                    </tr>
                    <tr>
                        <td>Tipo Producto: </td>
                        <td>
                            <select name="opt_tipoProducto">
                                <option></option>
                                <option>Ejemplo 1</option>
                                <option>Ejemplo 2</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Precio Estimado: </td>
                        <td><input class="inputModulos" type="text" name="txt_precioEstimado"></td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
</body>
</html>
