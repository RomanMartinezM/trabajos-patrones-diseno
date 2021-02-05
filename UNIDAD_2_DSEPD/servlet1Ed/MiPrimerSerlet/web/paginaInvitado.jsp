<%-- 
    Document   : paginaInvitado
    Created on : 9/11/2020, 02:07:42 PM
    Author     : lithium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionActual = request.getSession(true);
    String usuario = (String) sesionActual.getAttribute("nomUsuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
    }
%>
<%//@page import="clase_java.EcuacionLineal" %>
<%
    double va = Double.parseDouble((String)sesionActual.getAttribute("va"));
    double vb = Double.parseDouble((String)sesionActual.getAttribute("vb"));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EcuacionLineal</title>
    </head>
    <body>
        <h2>Ecuación lineal</h2>
        <h3>
            Ecuacion Lineal de la forma y= a + bx
            <br>
            Dar los valores de los coeficientes
            
                
            </form>
        </h3>
    </body>
</html>
