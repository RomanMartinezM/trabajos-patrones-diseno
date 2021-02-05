<%-- 
    Document   : login
    Created on : 29/11/2020, 08:16:37 PM
    Author     : lithium
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="juego.ListarUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListarUsuarios lu = new ListarUsuarios();
    List<Usuario> listaUsuarios = lu.listaU();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h3>Login</h3>
            <table width="50%">
                <form action="datos_juego.jsp" method="post">
                    <tr>
                        <td>Usuario: </td>
                        <td>
                            <select name="idusuario">   
                                <% for (Usuario usu : listaUsuarios) { %>
                                <option value="<%=usu.getIdUsuario() %>"><%=usu.getNombre() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="ingresar" value="Ingresar" title="Ingresar"></td>
                    </tr>
                </form>
                <tr>
                    <a href="agregar_usuario.jsp">Registrarse</a>
                </tr>
            </table>
        </center>
    </body>
</html>
