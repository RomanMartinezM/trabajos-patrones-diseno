<%-- 
    Document   : paginaInvitado
    Created on : 9/11/2020, 02:07:42 PM
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
        <form name="autenticacion" action="resultado.jsp" method="post">
             <table align="center" width="350" style="border-style:blue">
                 <thead>
                     <tr>
                         <th colspan="2">Calculo de las raices de una ecuacion cuadratica aX^2 +bX +c</th>
                     </tr>
                     <tr>
                          <th colspan="2">Lectura de los coeficientes (a,b,c)</th>
                     </tr>
                 </thead>   
                 <tbody>
                     <tr>
                         <th colspan="2">Acceso</th>
                     </tr>
                     <tr>
                        <td>
                            valor de a:
                        </td>
                           <%-- el usuario (comentario)--%>
                           <td><input type="number" name="coeficienteA" value=""/></td>
                     </tr>
                     <tr>
                        <td>
                            valor de b: </td>
                        <td><input  type="number" name="coeficienteB" value=""/></td>
                     </tr>
                                          <tr>
                        <td>
                            valor de c: </td>
                        <td><input  type="number" name="coeficienteC" value=""/></td>
                     </tr>
                     <tr>
                         <td><input type ="submit" value="Aceptar"/></td>
                     </tr>  
                 </tbody>
             </table>        
        </form>              
     </body>
</html>
