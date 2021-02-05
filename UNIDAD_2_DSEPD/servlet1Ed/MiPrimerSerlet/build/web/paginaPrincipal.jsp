<%-- 
    Document   : paginaPrincipal
    Created on : 9/11/2020, 02:06:19 PM
    Author     : lithium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionActual = request.getSession();
    String usuario = (String) sesionActual.getAttribute("nomUsuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido <%= usuario %> </title>
    </head>
    <body>
        <h4>Bienvenido: <%= usuario %></h4>
        <div id="menu">
            <ul>
                <li><a href="#">Mantenimiento</a></li>
                <li><a href="#">Consultas</a></li>
                <li><a href="#">Informes</a></li>
                <li><a href="#">Acerca de...</a></li>
            </ul>
        </div>
    </body>
</html>
