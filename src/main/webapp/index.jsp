<%-- 
    Document   : index
    Created on : 20-05-2019, 14:01:05
    Author     : PabloTnT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">

    </head>
    <body background="imagenes/fondo.png" >
        <form action="Inicio_sesion.do" method="post">
            <div style="margin-left: 500px; margin-right: 500px">
                <div align="center" style="margin-top: 50px">
                    <img src="imagenes/icono-iniciar-sesion-png.png" width="250px" height="250px"/>
                </div>
                <div class="form-group">
                    <label>Usuario: </label>
                    <input type="text" placeholder="Ingrese su usuario" name="txt_usuario"/>
                    <small class="text-muted">Sus datos de usuario siempre seran privados.</small>
                </div>
                <div class="form-group"> 
                    <label>Contraseña:</label>
                    <input type="password" placeholder="Ingrese contraseña" name="txt_clave"/>
                </div>
                <div class="form-group">
                    <button class="button success" name="btn_enviar">Iniciar Sesion</button>
                </div>
            </div>
        </form>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>
