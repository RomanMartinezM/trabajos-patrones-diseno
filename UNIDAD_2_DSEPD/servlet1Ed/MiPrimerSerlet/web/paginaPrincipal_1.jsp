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
        <form name="calculo" action="resultado.jsp" method="post">
        <table align="center" width="350" style="border-style:blue">
                 <thead>
                     <tr>
                         <th colspan="2">Calculo de las raices de una ecuacion cuadratica a+bX+cX^2</th>
                     </tr>
                 </thead>   
                 <tbody>
                     <tr>
                        <td>
                            Valor de A:
                        </td>
                           <%-- el usuario (comentario)--%>
                        <td><input type="text" name="A" value=""/></td>
                     </tr>
                     <tr>
                        <td>
                            Valor de B: </td>
                        <td><input  type="number" name="B" value=""/></td>
                     </tr>
                      <tr>
                        <td>
                            Valor de C: </td>
                        <td><input  type="number" name="C" value=""/></td>
                     </tr>
                     <tr>
                         <td><input type ="submit" value="Aceptar"/></td>
                     </tr>  
                 </tbody>
             </table>  
             </form>
    </body>
</html>
