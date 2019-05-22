<%-- 
    Document   : CrearProducto
    Created on : 21-05-2019, 22:47:26
    Author     : mirkomanuelantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear un nuevo Producto</title>
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
                <td>Sku del producto:</td>
                <td><input type="text" name="txt_skuCrearProducto"</td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="text_nombreCrearProducto"</td>
            </tr>
           
           
            <tr>
                <td>Precio:</td>
                <td><input type="text" 
                           name="text_precioCrearProducto"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"
                           name="btn_GuardarCrearProducto" value="Guardar"></td>
            </tr>

        </table>
    </body>
</html>
