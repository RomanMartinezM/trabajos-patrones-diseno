<%-- 
    Document   : resultado
    Created on : 6/11/2020, 12:46:06 PM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.Calendar"%>
<%@page  import="Calcular.CalcularXY"%>
<%
    Double x=Double.parseDouble(request.getParameter("vx"));
    Double y=Double.parseDouble(request.getParameter("vy"));
    CalcularXY xy=new CalcularXY();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <li>La fecha y hora actual es:<%=new java.util.Date()%></li>
    <li><%= xy.elevar(x,y) %></li>
    <li></li>
    <li></li>
    </body>
</html>
