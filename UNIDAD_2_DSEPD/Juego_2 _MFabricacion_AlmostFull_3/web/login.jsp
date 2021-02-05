<%-- 
    Document   : login
    Created on : 29/11/2020, 08:16:37 PM
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
            <h3>Login</h3>
            <table width="50%">
                <form action="LoginU" method="post">
                    <tr>
                        <td>ID Usuario: </td>
                        <td><input type="number" name="idusu"></td>
                    </tr>
                    <tr>
                        <td>Nombre de usuario: </td>
                        <td><input type="text" name="nombreusu"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="ingresar" value="Ingresar" title="Ingresar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
