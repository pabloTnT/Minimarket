<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
Author     : PabloTnT
--%>

<%@page import="modelo.dto.Tipo_productoDto"%>
<%@page import="modelo.dao.Tipo_productoDao"%>
<%@page import="modelo.dto.UsuarioDto"%>
<%@page import="modelo.dao.UsuarioDao"%>
<%@page import="modelo.dto.CargosDto"%>
<%@page import="modelo.dao.CargosDao"%>
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
            <%
            UsuarioDto sesion = (UsuarioDto) request.getSession().getAttribute("sesionUsuario");
            int cargo = sesion.getCargo();
            if(cargo == 1){
            %>
            <li>
                <a href="#" class="dropdown-toggle">Usuarios</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearUsuario.jsp">Crear Usuario</a></li>
                    <li><a href="listarUsuarios.jsp">Listar Usuarios</a></li>
                </ul>
            </li>
            <%
            }
            %>
        </ul>  
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
