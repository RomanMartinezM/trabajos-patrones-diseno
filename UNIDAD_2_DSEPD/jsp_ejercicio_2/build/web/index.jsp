<%-- 
    Document   : index
    Created on : 8/11/2020, 09:00:01 PM
    Author     : Roman
--%>

<%--<%@page import="java.util.Calendar"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--<%@page import="ejemplodirectiva.ElevarX_a_Y"%>--%>
<jsp:declaration> double r=0; </jsp:declaration>
<%-- <% HttpSession sesionActual = request.getSession(true);
   sesionActual.setAttribute("x",0.0);
   sesionActual.setAttribute("y",0.0);
%>--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio_2</title>
    </head>
    <body>
        <h1>Cálculo de operaciones</h1>
        <h2>
            <form name="calculo" action="resultado.jsp" method="post">
                <table>
                    <thead> 
                        <tr>
                            <th colspan="2"> Acceder </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> valor de X ?: </td>
                            <td> <input type="number" name="vx" value="0"></td>
                        </tr>
                        <tr>
                            <td> valor de Y ?: </td>
                            <td> <input type="number" name="vy" value="0"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Aceptar"></td>
                        </tr>
                    </tbody>
                </table>
                <%--<%
                    Double vx = (Double) sesionActual.getAttribute("vx");
                    Double vy = (Double) sesionActual.getAttribute("vy");
                %>--%>
            </form>
        </h2>
    </body>
</html>
