<%-- 
    Document   : index
    Created on : 9/11/2020, 12:36:39 PM
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
        <form name="autenticacion" action="Control" method="post">
             <table align="center" width="350" style="border-style:blue">
                 <thead>
                     <tr>
                         <th colspan="2">Acceso</th>
                     </tr>
                 </thead>   
                 <tbody>
                     <tr>
                        <td>
                            Usuario:
                        </td>
                           <%-- el usuario (comentario)--%>
                        <td><input type="text" name="nombreUsuario" value=""/></td>
                     </tr>
                     <tr>
                        <td>
                            Clave: </td>
                        <td><input  type="password" name="clave" value=""/></td>
                     </tr>
                     <tr>
                         <td><input type ="submit" value="Aceptar"/></td>
                     </tr>  
                 </tbody>
             </table>        
        </form>              
     </body>
</html>
