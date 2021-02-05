<%-- 
    Document   : agregar_usuario
    Created on : 28/11/2020, 10:00:51 PM
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
            <h3>Registro de usuario</h3>
            <table width="50%">
                <form action="AgregarUsuario" method="post">
                    <tr>
                        <td colspan="2">Datos del usuario</td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>Tipo de persona: </td>
                        <td>
                            <select name="tipopersona"> 
                                <option value="0">Seleccione</option>
                                <option value="n">Niño</option>
                                <option value="a">Adulto</option>
                                <option value="v">Anciano</option>                
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Fecha de registro: </td>
                        <td><input type="date" name="fecharegistro"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="registrar" value="Registrar" title="Registrar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
