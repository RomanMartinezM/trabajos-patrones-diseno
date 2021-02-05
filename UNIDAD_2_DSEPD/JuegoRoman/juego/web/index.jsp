<%-- 
    Document   : index
    Created on : 16/11/2020, 21:24:03 pm
    Author     : Roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <center>
        <h1>Inicio del juego</h1>
        <h2>Ahorcado</h2>
        <form action="acceso.jsp" method="post">
            Participante:
            <input type="text" name="nombre"/>
            Num. Intentos:
            <input type="number" name="nintento"/>
            <br/>
            <input type="submit" value="Continuar"/>
        </form>
        </center>
    </body>
</html>
