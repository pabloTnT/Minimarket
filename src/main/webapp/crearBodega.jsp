<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
Author     : PabloTnT
--%>

<%@page import="modelo.dto.UsuarioDto"%>
<%@page import="modelo.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    </head>
    <body background="imagenes/fondo.png">
        <ul class="h-menu mega">
            <li><a href="seleccionModulo.jsp"><i style="margin-right: 15px" class="fas fa-home"></i>Inicio</a></li>
            <li>
                <a href="#" class="dropdown-toggle">Bodegas</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearBodega.jsp">Crear Bodega</a></li>
                    <li><a href="listarBodegas.jsp">Listar Bodegas</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Productos</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearProducto.jsp">Crear Producto</a></li>
                    <li><a href="listarProductos.jsp">Listar Productos</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Proveedores</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearProveedor.jsp">Crear Proveedor</a></li>
                    <li><a href="listarProveedores.jsp">Listar Proveedores</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Usuarios</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearUsuario.jsp">Crear Usuario</a></li>
                    <li><a href="listarUsuarios.jsp">Listar Usuarios</a></li>
                </ul>
            </li>
        </ul> 
        <form action="Bodegas_controller.do" method="post">
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
                                    <option><i class="fas fa-angle-down"></i></option>
                                    <%
                                        UsuarioDao userDao = new UsuarioDao();
                                        for (UsuarioDto userDto : userDao.SeleccionarTodo()) {
                                            int codigoUsuario = userDto.getId();
                                            String nombreUsuario = userDto.getNombre()+" "+ userDto.getApellidos();
                                    %>
                                <option value="<%=codigoUsuario%>"><%=nombreUsuario%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarBodega">Guardar</button>
                    </form>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
            <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
