<%-- 
    Document   : acceso
    Created on : 29/11/2020, 10:41:42 PM
    Author     : lithium
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controles.Controladora"%>
<%@page import="juego.AgregarUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     AgregarUsuario au = new AgregarUsuario();
     Controladora controlUsuario = au.crearControl();
     Usuario usu = (Usuario)controlUsuario.findModelo(Integer.parseInt(request.getParameter("id_usuario")));
     
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Acceder</h1>
            <h2>Bienvenido <%=usu.getNombre()%></h2>  
            <%
                session=request.getSession();
                session.setAttribute("idusuario",request.getParameter("id_usuario"));
                session.setAttribute("tipo_palabra",request.getParameter("tipopalabra"));
                session.setAttribute("nivel_juego",request.getParameter("nivel")); 
                session.setAttribute("maxint",request.getParameter("intentos_t"));
                //session.setAttribute("intentos_r",request.getParameter("intentos_r")); 
                //session.setAttribute("fechayhora",request.getParameter("fechayhora"));                            
            %>

            <h3> Quieres jugar?
                <a href="index.jsp">NO</a>
                <a href="Ahorcado">SI</a>
            </h3>
        </center>
    </body>
</html>
