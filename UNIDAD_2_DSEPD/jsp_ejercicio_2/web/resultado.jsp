<%-- 
    Document   : resultado
    Created on : 8/11/2020, 10:17:39 PM
    Author     : Roman
--%>
<%@page import="java." %>
<%@page import="ejemplodirectiva.Operaciones"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Double x = Double.parseDouble(request.getParameter("vx"));
    Double y = Double.parseDouble(request.getParameter("vy"));
    Operaciones op = new Operaciones();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%-- expresiones con '<%= expresion %>' --%>
            <li>La fecha y hora actual es: <%= new java.util.Date()%></li>
            <li> <%= op.elevarX_a_la_Y(x,y) %></li>
            <li> <%= op.multiplicarX_por_Y(x,y) %></li>
            <li> <%= op.raizCuadradaX_Y(x,y) %></li>
            <%-- ejemplo de algo dinamico --%>
            <li>
                <% if(Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM) {%>
                             BUENOS DIAS 
                <% }else{ %>
                             BUENAS TARDES
                <% } %>
            </li>
            <%-- ejemplo de codigo java--%>
            <li>
                <%--
                <% ElevarX_a_Y x_y = new ElevarX_a_Y(2.0,8.0);
                    out.println(x_y.elevarX_a_la_Y());
                %> 
                --%>
            </li>
    </body>
</html>
