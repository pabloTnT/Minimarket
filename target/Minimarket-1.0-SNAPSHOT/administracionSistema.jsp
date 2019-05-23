<%-- 
    Document   : administracionSistema
    Created on : 19-05-2019, 17:33:20
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
            <li class="active"><a href="#crearBodegas">Crear Bodegas</a></li>
            <li><a href="#crearProductos">Crear Productos</a></li>
            <li><a href="#crearPersonal">Crear Personal</a></li>
            <li><a href="#crearProveedor">Crear Proveedor</a></li>
            
        </ul> 
        <div style="margin-top: 100px" id="crearBodegas">
            <div align="center">
                <table>
                    <tr>
                        <td>ID:</td>
                        <td><input class="inputAdministracion" type="text" name="txt_idBodega"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input class="inputAdministracion" type="text" name="txt_nombreBodega"> </td>
                    </tr>
                    <tr>
                        <td>Comuna: </td>
                        <td><input class="inputAdministracion" style="margin-left: 20px" type="text" name="txt_comunaBodega"> </td>
                    </tr>
                    <tr>
                        <td>Dirección: </td>
                        <td><input class="inputAdministracion" style="margin-left: 20px" type="text" name="txt_direccionBodega"></td>
                    </tr>
                    <tr>
                        <td>Encargado: </td>
                        <td>
                            <select name="opt_encargadoBodega" style="margin-left: 20px" >
                                <option></option>
                                <option>prueba1</option>
                                <option>prueba2</option>
                                <option>prueba3</option>
                                <option>prueba4</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarBodega">Guardar</button>
            </div>
        </div>
        <div align="center">
            <div style="margin-top: 100px" id="crearProductos">
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
                <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarProducto">Guardar</button>
            </div>
        </div>
        <div align="center">
            <div style="margin-top: 100px" id="crearPersonal">
                <table>
                    <tr>
                        <td>RUN: </td>
                        <td><input class="inputModulos" type="text" name="txt_runPersonal"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input class="inputModulos" type="text" name="txt_nombrePersonal"></td>
                    </tr>
                    <tr>
                        <td>Apellido: </td>
                        <td><input class="inputModulos"type="text" name="txt_apellidoPersonal"</td>
                    </tr>
                    <tr>
                        <td>Cargo: </td>
                        <td>
                            <select name="cargoPersonal">
                                <option></option>
                                <option>prueba1</option>
                                <option>pruena2</option>
                                <option>prueba3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Estado: </td>
                        <td><input style="margin-left: 50px"type="checkbox" data-role="switch" checked data-material="true"></td>
                    </tr>
                </table>
                <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarPersonal">Guardar</button>
            </div>
        </di</div><div align="center">
        <div style="margin-top: 100px" id="crearProveedor">
            <table>
                <tr>
                    <td>RUT: </td>
                    <td><input class="inputModulos" type="text" name="txt_rutProveedor"></td>
                </tr>
                <tr>
                    <td>Razón Social: </td>
                    <td><input class="inputModulos" type="text" name="txt_razonSocial"></td>
                </tr>
                <tr>
                    <td>Dirección: </td>
                    <td><input class="inputModulos" type="text" name="txt_direccionProveedor"></td>
                </tr>
                <tr>
                    <td>Nombre Contacto: </td>
                    <td><input class="inputModulos" type="text" name="txt_nombreContacto"></td>
                </tr>
                <tr>
                    <td>Teléfono Contacto: </td>
                    <td><input class="inputModulos" type="text" name="txt_telefonoContacto"></td>
                </tr>
            </table>
            <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded">Guardar</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
</body>
</html>
