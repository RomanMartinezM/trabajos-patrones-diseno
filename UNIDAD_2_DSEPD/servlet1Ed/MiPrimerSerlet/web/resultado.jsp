<%-- 
    Document   : resultado
    Created on : 10/11/2020, 12:33:31 PM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Java.Ecuacion"%>
<%
    HttpSession sesionActual = request.getSession();
    
   /* String a = (String) sesionActual.getAttribute("A");
    String b= (String) sesionActual.getAttribute("B");
    String c = (String) sesionActual.getAttribute("C");*/
    Double a=Double.parseDouble(request.getParameter("A"));
    Double b=Double.parseDouble(request.getParameter("B"));
    Double c=Double.parseDouble(request.getParameter("C"));
    Ecuacion e=new Ecuacion();
   /* String b=request.getParameter("B");
    String c=request.getParameter("C");
    String a=request.getParameter("A");*/
   
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>la ecuacion es: <%=a%>+<%=b%>X+<%=c%>X^2</h1>
        <br>
        <h1><%=e.calcular(a,b,c)%></h1>

    </body>
</html>
