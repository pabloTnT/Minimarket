<%-- 
    Document   : CrearProveedores
    Created on : 21-05-2019, 22:31:39
    Author     : mirkomanuelantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear nuevo Proveedor</title>
    </head>
    <body>
              <%-- las dejo como comentarios mientrass
        
        <a href="CrearBodegas.jsp">Crear Bodegas</a>
        <a href="CrearProducto.jsp">Crear productos</a>
        <a href="CrearPersonal.jsp">Crear Personal</a
        <a href="CrearProveedores.jsp">Craer Proveedores</a>
--%>
        
        <table>
            <tr>
                <td>RUT:</td>
                <td><input type="text" name="txt_rutCrearProveedores"></td>
            </tr>
            <tr>
                <td>Razón social:</td>
                <td><input type="text"
                           name="txt_razonSocialCrearProveedores"></td>
            </tr>
            <tr>
                <td>Dirección:</td>
                <td><input type="text" 
                           name="txt_direccionCrearProveedores"></td>
            </tr>
            <tr>
                <td>Nombre de Contacto:</td>
                <td><input type="text" 
                           name="txt_nombreContactoCrearProveedores"></td>
            </tr>
            <tr>
                <td>Teléfono de Contacto:</td>
                <td><input type="text" 
                           name="txt_telefonoContactoCrearProveedores"</td>
            </tr>
            <hr>
            <tr>
                <td></td>
                <td><input type="submit" name="btn_guardarCrearProveedores" 
                           value="Guardar"></td>
            </tr>

        </table>


    </body>
</html>
