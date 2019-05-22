<%-- 
    Document   : CrearPersonal
    Created on : 21-05-2019, 23:03:26
    Author     : mirkomanuelantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Craer nuevo Personal</title>
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
                <td>RUN:</td>
                <td><input type="text" name="txt_runCrearPersonal"></td>
            </tr>
            <tr>
                <td>Digito Verificador:</td>
                <td><input type="text" name="txt_dvCrearPersonal"></td>
            </tr>

            <tr>
                <td>Nombres:</td>
                <td><input type="text" name="txt_nombreCrearPersonal"></td>
            </tr>
            <tr>
                <td>Apellidos</td>
                <td><input type="text" name="txt_apellidoCrearPersonal"></td>
            </tr>
            <tr>
                <td>Cargo:</td>
                <td><select name="opt_cargoCrearPersonal">
                        <option></option>
                        <option>Funcionario de Compras</option>
                        <option>Funcionario de Bodega</option>
                        <option>Funcionario del Local</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Fecha de Ingreso:</td>
                <td><input type="date" 
                           name="date_fechaIngresoCrearPersonal"></td>
            </tr>

            <tr>
                <td>Salario:</td>
                <td><input type="text" name="txt_salarioCrearPersonal"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" name="btn_guardarCrearPersonal"></td>
            </tr>

        </table> 


    </body>
</html>
