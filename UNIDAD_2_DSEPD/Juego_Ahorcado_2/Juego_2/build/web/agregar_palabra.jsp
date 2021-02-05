<%-- 
    Document   : agregar_palabra
    Created on : 20/11/2020, 08:55:03 AM
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
            <h3>Agregar Palabra</h3>
            <table width="50%">
                <form action="AgregarPalabra" method="post">
                    <tr>
                        <td colspan="2">Datos de la palabra</td>
                    </tr>
                    <tr>
                        <td>Palabra: </td>
                        <td><input type="text" name="palabra"></td>
                    </tr>
                    <tr>
                        <td>Tipo: </td>
                        <td><input type="number" name="tipopalabra"></td>
                    </tr>
                    <tr>
                        <td>Nivel: </td>
                        <td>
                            <select name="nivel"> 
                                <option value="1">Básico</option>
                                <option value="2">Intermedio</option>
                                <option value="3">Alto</option>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="aceptar" title="Aceptar"></td>
                    </tr>
                </form>
        </center>
    </body>
</html>
