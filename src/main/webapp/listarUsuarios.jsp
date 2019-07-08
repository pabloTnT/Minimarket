<%-- 
    Document   : listarBodegas
    Created on : 26-05-2019, 20:31:13
    Author     : PabloTnT
--%>

<%@page import="dto.PrivilegiosDto"%>
<%@page import="dao.PrivilegiosDao"%>
<%@page import="dto.CargosDto"%>
<%@page import="dao.CargosDao"%>
<%@page import="dto.UsuarioDto"%>
<%@page import="dao.UsuarioDao"%>
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
        <form action="Usuarios_controller.do" method="post">
            <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
                <table class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                    <thead>
                        <tr>
                            <th data-sortable="true" data-sort-dir="asc">ID</th>
                            <th data-sortable="true">Rut</th>
                            <th data-sortable="true">Nombre</th>
                            <th data-sortable="true">Apellidos</th>
                            <th data-sortable="true">Cargo</th>
                            <th data-sortable="true">Privilegios</th>
                            <th data-sortable="true">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            UsuarioDao usDao = new UsuarioDao();
                            for (UsuarioDto usDto : usDao.SeleccionarTodo()) {
                                int idUs = usDto.getId();
                                String rutUs = usDto.getRutUsuario();
                                String nombre = usDto.getNombre();
                                String apellidos = usDto.getApellidos();
                                CargosDao cargDao = new CargosDao();
                                for (CargosDto cargDto : cargDao.SeleccionarTodo()) {
                                    if (usDto.getCargo() == cargDto.getId_cargo()) {
                                        String nombreCargo = cargDto.getNombre_cargo();
                                        int codigoCargo = cargDto.getId_cargo();
                                        PrivilegiosDao privDao = new PrivilegiosDao();
                                        for (PrivilegiosDto privDto : privDao.SeleccionarTodo()) {
                                            if (usDto.getPrivilegios() == privDto.getId()) {
                                                String nombrePrivilegio = privDto.getNombre_privilegio();
                                                int codigoPrivilegio = privDto.getId();

                        %>
                        <tr>
                            <td><%=idUs%></td>
                            <td><%=rutUs%></td>
                            <td><%=nombre%></td>
                            <td><%=apellidos%></td>
                            <td value="<%=codigoCargo%>"><%=nombreCargo%></td>
                            <td value="<%=codigoPrivilegio%>"><%=nombrePrivilegio%></td>
                            <td>
                                <button class="button success outline" data-role="hint"
                                        data-hint-text="Editar Usuario" onClick="window.open('editarUsuarios.jsp?idUs=' +<%=idUs%> + '&codCargo=' + <%=codigoCargo%> +
                                                        '&codPriv=' +<%=codigoPrivilegio%>, '_blank', 'width=1000,height=600'); return false" 
                                        name="btn_editarUsuario"> 
                                    <i class="fas fa-edit"></i></button>
                                <button class="button success outline" value="<%=idUs%>" name="btn_eliminarUsuario"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <%
                                            }
                                        }
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
