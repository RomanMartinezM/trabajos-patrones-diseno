<%-- 
    Document   : acceso
    Created on : 29/11/2020, 10:41:42 PM
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
            <h1>Acceder</h1>
            <h2>Bienvenido</h2>  
            <%
                session=request.getSession();
                session.setAttribute("maxint",request.getParameter("intentos_t"));
            %>

            <h3> Quieres jugar?
                <a href="index.jsp">NO</a>
                <a href="Ahorcado">SI</a>
            </h3>
        </center>
    </body>
</html>
