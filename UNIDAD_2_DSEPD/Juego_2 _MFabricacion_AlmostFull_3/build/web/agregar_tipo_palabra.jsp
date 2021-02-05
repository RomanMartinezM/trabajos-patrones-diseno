<%-- 
    Document   : agregar_tipo_palabra
    Created on : 20/11/2020, 02:18:48 PM
    Author     : lithium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h3>AGREGAR TIPO DE PALABRA</h3>
            <form action="AgregarTipoPalabra" method="post">
                 <output  name="ttipo" > Descripción: </output>
                 <input  name="tipo" type ="text" maxlength="30" minlength="4">    
                 <input type="submit" name="aceptar" value="Äceptar" title="Guardar palabra" >
            </form>
         </center>
    </body>
</html>
