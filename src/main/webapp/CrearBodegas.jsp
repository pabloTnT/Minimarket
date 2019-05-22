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
        <%-- 
    Faltan Link para redireccionar a los demas crear(productos, personal proveedores y agregar css)
--%>
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="txt_idCrearBodegas"></td>
            </tr>

            <tr>
                <td>Nombre</td>
                <td><input type="text" name="txt_nombreCrearBodegas"></td>
            </tr>
            
            <tr>
                <td>Comuna</td>
                <td><select>
                        <option></option>
                        <option>Comuna 1</option>
                        <option>Comuna 2</option>
                        <option>Comuna 3</option>
                        <option>Comuna 4</option>                        
                    </select></td>
            </tr>
            <tr>
                <td>Dirección</td>
                <td><input type="text" name="txt_direccionCrearBodegas"></td>
            </tr>
            
            <tr>
                <td>Encargado</td>
                <td><select>
                        <option></option>
                        <option>Encargado 1</option>
                        <option>Encargado 2</option>
                        <option>Encargado 3</option>                   
                        
                    </select></td>    
            </tr>
            <tr>
                <td><input type="submit" name="txt_guardarCrearBodegas" value="Guardar"></td>
                <td></td>
            </tr>
        </table>

    </body>
</html>
