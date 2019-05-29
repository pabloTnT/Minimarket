<%-- 
    Document   : listarBodegas
    Created on : 26-05-2019, 20:31:13
    Author     : PabloTnT
--%>

<%@page import="dto.ProveedorDto"%>
<%@page import="dao.ProveedorDao"%>
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
        </ul>
        <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
            <table class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                <thead>
                    <tr>
                        <th data-sortable="true" data-sort-dir="asc">ID</th>
                        <th data-sortable="true">Rut</th>
                        <th data-sortable="true">Razon Social</th>
                        <th data-sortable="true">Dirección</th>
                        <th data-sortable="true">Nombre Contacto</th>
                        <th data-sortable="true">Telefono Contacto</th>
                        <th data-sortable="true">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProveedorDao provDao = new ProveedorDao();
                        for (ProveedorDto provDto : provDao.SeleccionarTodo()) {
                            int idProv = provDto.getId();
                            String rutProv = provDto.getRut();
                            String razonSocial = provDto.getRazon_social();
                            String direccion = provDto.getDireccion();
                            String nombreContacto = provDto.getNombre_contacto();
                            int telefonoContacto = provDto.getTelefono();

                    %>
                    <tr>
                        <td><%=idProv%></td>
                        <td><%=rutProv%></td>
                        <td><%=razonSocial%></td>
                        <td><%=direccion%></td>
                        <td><%=nombreContacto%></td>
                        <td><%=telefonoContacto%></td>
                        <td>
                            <button class="button success outline" name="btn_editarProveedor"> <i class="fas fa-edit"></i></button>
                            <button class="button success outline" name="btn_eliminarProveedor"><i class="fas fa-trash-alt"></i></button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
