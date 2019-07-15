<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
Author     : PabloTnT
--%>

<%@page import="modelo.dao.BodegasDao"%>
<%@page import="modelo.dto.BodegasDto"%>
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
        <form action="Bodegas_controller.do" method="post">
            <%
                if (request.getParameter("cambios") != null) {
            %>
            <script>
                opener.location.reload();
                window.close();
            </script>
            <%
                }
            %>
            <%
                if (request.getParameter("idBodega") != null) {
                    BodegasDao bodDao = new BodegasDao();
                    BodegasDto bodDto = bodDao.Select(request.getParameter("idBodega"));
                    int codBodega = bodDto.getId_bodega();
                    String nombre_bodega = bodDto.getNombre_bodega();
                    String comuna = bodDto.getComuna();
                    String direccion = bodDto.getDireccion();
                    String encargado = bodDto.getEncargado();
            %>
            <div style="margin-top: 100px" id="crearBodegas">   
                <div align="center">
                    <table>
                        <tr>
                            <td>ID:</td>
                            <td><input class="inputAdministracion" type="text" name="txt_idBodega" readonly="readonly" value="<%=codBodega%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre: </td>
                            <td><input class="inputAdministracion" type="text" name="txt_nombreBodega" value="<%=nombre_bodega%>"></td>
                        </tr>
                        <tr>
                            <td>Comuna: </td>
                            <td><input class="inputAdministracion" style="margin-left: 20px" value="<%=comuna%>" type="text" name="txt_comunaBodega"></td>
                        </tr>
                        <tr>
                            <td>Dirección: </td>
                            <td><input class="inputAdministracion" style="margin-left: 20px" value="<%=direccion%>" type="text" name="txt_direccionBodega"></td>
                        </tr>
                        <tr>
                            <td>Encargado: </td>
                            <td>
                                <%
                                    String idUsuario = request.getParameter("idEncargado");
                                %>
                                <select name="opt_encargadoBodega" value="<%=idUsuario%>" style="margin-left: 20px" >
                                    <option><i class="fas fa-angle-down"></i></option>
                                    <%
                                        UsuarioDao userDao = new UsuarioDao();
                                        for (UsuarioDto userDto : userDao.SeleccionarTodo()) {
                                            int codigoUsuario = userDto.getId();
                                            String nombreUsuario = userDto.getNombre() + " " + userDto.getApellidos();
                                    %>
                                    <option value="<%=codigoUsuario%>"
                                            <%
                                                if (Integer.valueOf(idUsuario) == codigoUsuario) {
                                            %>
                                            selected
                                            <%        
                                                }
                                            %>
                                            ><%=nombreUsuario%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 70px; width: 200px" class="button success rounded" name="btn_updateBodega">Guardar Cambios</button>
                    </form>
                </div>
            </div>

            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
            <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
