<%-- 
    Document   : acceso
    Created on : 16/11/2020, 21:25:55 pm
    Author     : Roman
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
        <h1>Acceder</h1>
        <h2>Bienvenido <%= request.getParameter("nombre")%> </h2>
        <%
            session=request.getSession();
            session.setAttribute("maxint",request.getParameter("nintento"));
        %>
        
        <h3> Quieres jugar?
            <a href="index.jsp">NO</a>
            <a href="Ahorcado">SI</a>
    </center>
    </body>
</html>
