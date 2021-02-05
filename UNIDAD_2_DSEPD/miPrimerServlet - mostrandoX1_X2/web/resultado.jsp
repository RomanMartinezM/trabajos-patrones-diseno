<%-- 
    Document   : resultado
    Created on : 10/11/2020, 01:26:39 PM
    Author     : lithium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clase_java.EcuacionCuadratica"%>
<%
   
    Double a=Double.parseDouble(request.getParameter("coeficienteA"));  //aqui se obtiene el valor de "coeficienteA" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    Double b=Double.parseDouble(request.getParameter("coeficienteB"));//aqui se obtiene el valor de "coeficienteB" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    Double c=Double.parseDouble(request.getParameter("coeficienteC"));//aqui se obtiene el valor de "coeficienteC" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    EcuacionCuadratica ec=new EcuacionCuadratica();  //se crea una instancia  de la clase  "EcuacionCuadratica"
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>la ecuacion es: <%=a%>X^2+<%=b%>X+<%=c%></h1> <%-- se imprime la solucion de la ecuacion --%>
        <br>
        <h1><%=ec.solucion(a,b,c)%></h1>  <%-- se llama al metodo solucion de la clase "EcuacionCuadratica" --%>

    </body>
</html>
