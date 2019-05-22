<%-- 
    Document   : CrearBodegas
    Created on : 21-05-2019, 22:01:29
    Author     : mirkomanuelantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear una nueva Bodega</title>
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
                <td>ID:</td>
                <td><input type="text" name="txt_idCrearBodegas"></td>
            </tr>


            <tr>
                <td>Dirección</td>
                <td><input type="text" name="txt_direccionCrearBodegas"></td>
            </tr>

            <tr>
                <td>Encargado</td>
                <td><select name="opt_encargadoCrearBodegas">
                        <option></option>
                        <option>Encargado 1</option>
                        <option>Encargado 2</option>
                        <option>Encargado 3</option>                   

                    </select></td>    
            </tr>
            <tr>
                <td><input type="submit" name="btn_guardarCrearBodegas" value="Guardar"></td>
                <td></td>
            </tr>
        </table>

    </body>
</html>
