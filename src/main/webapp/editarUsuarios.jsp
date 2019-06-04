<%-- 
    Document   : creacionUsuario
    Created on : 28-05-2019, 20:06:07
    Author     : PabloTnT
--%>

<%@page import="dto.UsuarioDto"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="dto.PrivilegiosDto"%>
<%@page import="dao.PrivilegiosDao"%>
<%@page import="dto.CargosDto"%>
<%@page import="dao.CargosDao"%>
<%@page session="true" contentType="text/html" pageEncoding="UTF-8"%>
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
        <%
            if (request.getParameter("cambio") != null) {
        %>
        <script>
                opener.location.reload();
                window.close();
            </script>
        <%
            }
        %>
        <form action="Usuarios_controller.do" method="post">
            <div align="center">
                <div style="margin-top: 70px" id="crearProductos">
                    <%
                        if (request.getParameter("idUs") != null) {
                            UsuarioDao dao = new UsuarioDao();
                            UsuarioDto dto = dao.Select(request.getParameter("idUs"));
                            int id = dto.getId();
                            String rut = dto.getRutUsuario();
                            String nombre = dto.getNombre();
                            String apellidos = dto.getApellidos();
                            String contraseña = dto.getClave();
                    %>
                    <table>
                        <tr>
                            <td>Id: </td>
                            <td><input class="inputModulos" type="text" name="txt_idUsuario" readonly="readonly" value="<%=id%>"></td>
                        </tr>
                        <tr>
                            <td>Rut: </td>
                            <td><input class="inputModulos" type="text" name="txt_rutUsuario" value="<%=rut%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre: </td>
                            <td><input class="inputModulos" type="text" name="txt_nombreUsuario" value="<%=nombre%>"></td>
                        </tr>
                        <tr>
                            <td>Apellidos: </td>
                            <td><input class="inputModulos" type="text" name="txt_apellidosUsuario" value="<%=apellidos%>"></td>
                        </tr>
                        <tr>
                            <td>Cargo: </td>
                            <td>
                                <select name="opt_cargoUsuario">
                                    <option></option>
                                    <%               
                                        String codCargo = request.getParameter("codCargo");
                                        CargosDao cargDao = new CargosDao();
                                        for (CargosDto cargDto : cargDao.SeleccionarTodo()) {
                                            String nombreCargo = cargDto.getNombre_cargo();
                                            int idCargo = cargDto.getId_cargo();
                                    %>
                                    <option value="<%=idCargo%>"
                                            <%
                                            if(Integer.valueOf(codCargo)==idCargo){
                                                %>
                                                selected
                                                <%
                                            }
                                            %>
                                            ><%=nombreCargo%></option>
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
                                        String codPrivilegio = request.getParameter("codPriv");
                                        PrivilegiosDao privDao = new PrivilegiosDao();
                                        for (PrivilegiosDto privDto : privDao.SeleccionarTodo()) {
                                            String nombrePrivilegio = privDto.getNombre_privilegio();
                                            int idPrivilegio = privDto.getId();

                                    %>
                                    <option value="<%=idPrivilegio%>"
                                            <%
                                            if(Integer.valueOf(codPrivilegio)==idPrivilegio){
                                                %>
                                                selected
                                                <%
                                            }
                                            %>
                                            ><%=nombrePrivilegio%></option>
                                    <%
                                        }
                                    %>
                                </select> 
                            </td>
                        </tr>
                        <tr>
                            <td>Contraseña: </td>
                            <td><input class="inputModulos" type="password" name="txt_contraUsuario" value="<%=contraseña%>"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success rounded" name="btn_updateUsuario">Guardar Cambios</button>
                </div>
            </div>
            <% }%>
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
