<%-- 
    Document   : index
    Created on : 6/11/2020, 12:43:24 PM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculo de x funcion</h1>
        <h2>
            <form name="calculo" action="resultado.jsp" method="post">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">Acceder</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>valor de x:</td>
                            <td><input type="number" name="vx" value=" "/></td>
                        </tr>
                        <tr>
                            <td>valor de y:</td>
                            <td><input type="number" name="vy" value=" "/></td>
                        </tr>
                        <tr>
                            
                            <td><input type="submit" value="Aceptar"/></td>
                        </tr>
                    </tbody>
            </form>
        </h2>
    </body>
</html>
