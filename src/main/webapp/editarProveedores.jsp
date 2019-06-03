<%-- 
Document   : admSistema
Created on : 26-05-2019, 17:29:55
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
        <form action="Proveedores_controller.do" method="post">
            <div align="center">
                <div style="margin-top: 100px" id="crearProveedor">
                    <%
                        if (request.getParameter("codigoProv") != null) {
                            ProveedorDao dao = new ProveedorDao();
                            ProveedorDto dto = dao.Select(request.getParameter("codigoProv"));
                            int codProveedor = dto.getId();
                            String rutProveedor = dto.getRut();
                            String razonSocial = dto.getRazon_social();
                            String direccion = dto.getDireccion();
                            String nombreContacto = dto.getNombre_contacto();
                            int telefonoContacto = dto.getTelefono();
                    %>
                    <table>
                        <tr>
                            <td>Cod. Proveedor: </td>
                            <td><input class="inputModulos" type="text" name="txt_codProveedor" readonly="readonly" value="<%=codProveedor%>"></td>
                        </tr>
                        <tr>
                            <td>RUT: </td>
                            <td><input class="inputModulos" type="text" name="txt_rutProveedor" value="<%=rutProveedor%>"></td>
                        </tr>
                        <tr>
                            <td>Razón Social: </td>
                            <td><input class="inputModulos" type="text" name="txt_razonSocial" value="<%=razonSocial%>"></td>
                        </tr>
                        <tr>
                            <td>Dirección: </td>
                            <td><input class="inputModulos" type="text" name="txt_direccionProveedor" value="<%=direccion%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre Contacto: </td>
                            <td><input class="inputModulos" type="text" name="txt_nombreContacto" value="<%=nombreContacto%>"></td>
                        </tr>
                        <tr>
                            <td>Teléfono Contacto: </td>
                            <td><input class="inputModulos" type="text" name="txt_telefonoContacto" value="<%=telefonoContacto%>"></td>
                        </tr>
                    </table>
                    <button align="center" name="btn_updateProveedor" style="margin-top: 70px; width: 200px" class="button success rounded">Guardar Cambios</button>
                    </form>
                </div>
            </div>
            <%                        }
            %>
            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
            <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
