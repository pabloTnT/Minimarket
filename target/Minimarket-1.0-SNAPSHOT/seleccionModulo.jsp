<%-- 
    Document   : seleccionModulo
    Created on : 18-05-2019, 23:50:56
    Author     : PabloTnT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        
        <title>JSP Page</title>
    </head>
    <body background="imagenes/fondo.png">
        <form action="Seleccion_modulo.do" method="post">
            
            <div style="margin-left: 250px;margin-top: 40px">
                <div data-size="medium" data-role="tile"><img class="menu-principal" src="imagenes/admin.jpg" class="icon"><a><button style="margin-left: 200px;width: 600px" name="btn_administracion" class="button primary large">Administración de Sistema</button></a></div>
                <div data-size="medium" data-role="tile"><img class="menu-principal" src="imagenes/inventario.jpg" class="icon"><a><button style="margin-left: 200px;width: 600px" name="btn_inventario" class="button primary large">Movimiento de Bodegas / Inventario</button></a></div>
                <div data-size="medium" data-role="tile"><img class="menu-principal" src="imagenes/reportes.jpg" class="icon"><a><button style="margin-left: 200px;width: 600px" name="btn_reportes" class="button primary large">Reportes</button></a></div>
            </div>
        </form>
    </body>
</html>
