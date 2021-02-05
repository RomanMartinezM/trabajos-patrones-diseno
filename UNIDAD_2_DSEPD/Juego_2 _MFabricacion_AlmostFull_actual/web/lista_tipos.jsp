<%-- 
    Document   : lista_tipos
    Created on : 1/12/2020, 01:42:34 PM
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
            <h3>Listar Tipo de palabras</h3>
            <table width="50%">
                <form action="ListarTipos" method="post">
                    <tr>
                        <td colspan="2">Selecciona como listar</td>
                    </tr>
                    
                   
                    <tr>
                        <td>Tipo de listado: </td>
                        <td>
                            <select name="tlistado"> 
                                <option value="1">Adelante</option>
                                <option value="2">Inversa</option>
                                <option value="3">Saltos</option>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="aceptar" value="Äceptar" title="Aceptar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
