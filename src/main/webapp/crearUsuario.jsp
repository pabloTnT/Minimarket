<%-- 
    Document   : creacionUsuario
    Created on : 28-05-2019, 20:06:07
    Author     : PabloTnT
--%>

<%@page import="dto.PrivilegiosDto"%>
<%@page import="dao.PrivilegiosDao"%>
<%@page import="dto.CargosDto"%>
<%@page import="dao.CargosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>JSP Page</title>
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
            <div align="center">
                <div style="margin-top: 100px" id="crearProductos">
                    <table>
                        <tr>
                            <td>Rut: </td>
                            <td><input class="inputModulos" type="text" name="txt_rutUsuario"></td>
                        </tr>
                        <tr>
                            <td>Nombre: </td>
                            <td><input class="inputModulos" type="text" name="txt_nombreUsuario"></td>
                        </tr>
                        <tr>
                            <td>Apellidos: </td>
                            <td><input class="inputModulos" type="text" name="txt_apellidosUsuario"></td>
                        </tr>
                        <tr>
                            <td>Cargo: </td>
                            <td>
                                <select name="opt_cargoUsuario">
                                    <option></option>
                                    <%
                                        CargosDao cargDao = new CargosDao();
                                        for (CargosDto cargDto : cargDao.SeleccionarTodo()) {
                                            String nombreCargo = cargDto.getNombre_cargo();
                                            int idCargo = cargDto.getId_cargo();
                                    %>
                                    <option value="<%=idCargo%>"><%=nombreCargo%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Privilegios: </td>
                            <td>
                                <select name="opt_privilegiousuario">
                                    <option></option>
                                    <%
                                    PrivilegiosDao privDao = new PrivilegiosDao();
                                    for(PrivilegiosDto privDto : privDao.SeleccionarTodo()){
                                        String nombrePrivilegio = privDto.getNombre_privilegio();
                                        int idPrivilegio = privDto.getId();
                                    
                                    %>
                                    <option value="<%=idPrivilegio%>"><%=nombrePrivilegio%></option>
                                    <%
                                    }
                                    %>
                                </select> 
                            </td>
                        </tr>
                        <tr>
                            <td>Contraseña: </td>
                             <td><input class="inputModulos" type="password" name="txt_contraUsuario"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success outline rounded" name="btn_guardarUsuario">Guardar</button>
                </div>
            </div>

        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
