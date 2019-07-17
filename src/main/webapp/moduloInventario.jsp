<%-- 
    Document   : moduloInventario
    Created on : 21-05-2019, 14:44:03
    Author     : PabloTnT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

        <title>Bodega/Inventario</title>

    </head>
    <body background="imagenes/fondo.png">
        <form action="Inventario_controller.do" method="post">
            <ul data-role="tabs" data-tabs-type="pills" data-expand="true">
                <li><a href="seleccionModulo.jsp"<i style="margin-left: 40px;margin-top: 10px;margin-right: 30px; cursor: pointer" class="fas fa-home"></i></a> </li>
                <li class="active"><a href="#abastecimiento">Abastecimiento</a></li>
                <li><a href="#trasladoMercaderia">Traslado de Mercaderia</a></li>
                <li><a href="#inventario">Inventario</a></li>
            </ul> 
            <div style="margin-top: 100px" id="abastecimiento">
                <div class="botonesInventario">
                    <button name="btn_oc" class="button primary large rounded" style="width: 400px">Generar Orden de Compra</button>
                </div>
                <div class="botonesInventario">
                    <button class="button primary large rounded" name="btn_ingresoBodega" style="width: 400px">Ingreso a Bodega</button>
                </div>
            </div>
            <div style="margin-top: 100px" id="trasladoMercaderia">
                <div class="botonesInventario">
                    <button class="button primary large rounded" name="btn_generarGuia" style="width: 400px">Tansferencia Entre Bodegas</button>
                </div>
                <div class="botonesInventario">
                    <button class="button primary large rounded" style="width: 400px">Ingresar Productos a Local</button>
                </div>
            </div>
            <div style="margin-top: 100px" id="inventario">
                <div class="botonesInventario">
                    <button class="button primary large rounded" name="btn_tomaInventario" style="width: 400px">Toma de Inventario</button>
                </div>
            </div>

        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
</body>
</html>
