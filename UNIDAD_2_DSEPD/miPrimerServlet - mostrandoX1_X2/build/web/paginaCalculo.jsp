<%-- 
    Document   : paginaCalculo
    Created on : 10/11/2020, 12:33:51 PM
    Author     : lithium
--%>

<%@page import="clase_java.EcuacionCuadratica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionActual = request.getSession(true);
    double va= (Double)sesionActual.getAttribute("valorA");//Double.parseDouble(request.getParameter("coeficienteA"));  //aqui se obtiene el valor de "coeficienteA" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    double vb= (Double)sesionActual.getAttribute("valorB");//Double.parseDouble(request.getParameter("coeficienteB"));//aqui se obtiene el valor de "coeficienteB" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    double vc=(Double)sesionActual.getAttribute("valorC");//Double.parseDouble(request.getParameter("coeficienteC"));//aqui se obtiene el valor de "coeficienteC" que se captura en lel cuadro de texto de la paginaInvitado.jsp
    String ecua = String.format("%4.2f x^2+ %4.2f x + %4.2f",va,vb,vc);   
    String solucion = (String) sesionActual.getAttribute("solucion");
   /*
    EcuacionCuadratica ec=new EcuacionCuadratica();  
    ec.setCoeficientes(va, vb, vc);
    String sol = ec.getSolucion();
    */
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- se imprime la solucion de la ecuacion --%>
        <%-- <h1>la ecuacion es: <%=va%>X^2+<%=vb%>X+<%=vc%></h1>  --%>
        <h1>La ecuacion es: <%=ecua%></h1>
        <br>
        <h1>La solucion de la ecuacion es: <%=solucion%></h1>  <%-- se llama al metodo solucion de la clase "EcuacionCuadratica" --%>
    </body>
</html>
