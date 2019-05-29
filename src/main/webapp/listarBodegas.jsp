<%-- 
    Document   : listarBodegas
    Created on : 26-05-2019, 20:31:13
    Author     : PabloTnT
--%>

<%@page import="dto.UsuarioDto"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="dto.BodegasDto"%>
<%@page import="dao.BodegasDao"%>
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
        <form action="listarbodegas_controller.do" method="post">
            <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
                <table class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                    <thead>
                        <tr>
                            <th data-sortable="true" data-sort-dir="asc">ID</th>
                            <th data-sortable="true">Nombre Bodega</th>
                            <th data-sortable="true">Comuna</th>
                            <th data-sortable="true">Dirección</th>
                            <th data-sortable="true">Encargado</th>
                            <th data-sortable="true">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            BodegasDao bodDao = new BodegasDao();
                            for (BodegasDto bod : bodDao.SeleccionarTodo()) {
                                int idBodega = bod.getId_bodega();
                                String nombreBodega = bod.getNombre_bodega();
                                String comunaBodega = bod.getComuna();
                                String direccionBodega = bod.getDireccion();
                                UsuarioDao us = new UsuarioDao();
                                for (UsuarioDto usDto : us.SeleccionarTodo()) {
                                    if (Integer.valueOf(bod.getEncargado()) == usDto.getId()) {
                                        String nombreEncargado = usDto.getNombre() + " " + usDto.getApellidos();

                        %>
                        <tr>
                            <td name="idBodega"><%=idBodega%></td>
                            <td><%=nombreBodega%></td>
                            <td><%=comunaBodega%></td>
                            <td><%=direccionBodega%></td>
                            <td><%=nombreEncargado%></td>
                            <td>
                                <button class="button success outline" name="btn_editarBodega"> <i class="fas fa-edit"></i></button>
                                <button class="button success outline" name="btn_eliminarBodega"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <%
                                    }
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
