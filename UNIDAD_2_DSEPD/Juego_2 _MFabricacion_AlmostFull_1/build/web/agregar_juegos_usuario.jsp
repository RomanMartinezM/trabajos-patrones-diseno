<%-- 
    Document   : agregar_juegos_usuario
    Created on : 29/11/2020, 09:13:13 AM
    Author     : lithium
--%>

<%@page import="modelo.Palabras"%>
<%@page import="juego.ListarPalabras"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@page import="juego.ListarUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%
    ListarUsuarios lu = new ListarUsuarios();
    List<Usuario> listaUsuarios = lu.listaU();
    
    ListarPalabras lp = new ListarPalabras();
    List<Palabras> listaPalabras = lp.listaPal();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h3>Registro de juego de usuario</h3>
            <table width="50%">
                <form action="acceso.jsp" method="post">
                    <tr>
                        <td colspan="2">Datos del juego</td>
                    </tr>
                    <tr>
                        <td>ID Usuario: </td>
                        <td>
                            <select name="idusuario"> 
                                <% for (Usuario usu : listaUsuarios) { %>
                                <option value="<%=usu.getIdUsuario() %>"><%=usu.getNombre() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>ID Palabra: </td>
                        <td>
                            <select name="idpalabra"> 
                                <% for (Palabras palabra : listaPalabras) { %>
                                <option value="<%=palabra.getIdPalabra() %>"><%=palabra.getPalabra() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Intentos R: </td>
                        <td><input type="number" name="intentos_r"></td>
                    </tr>
                    <tr>
                        <td>Intentos T: </td>
                        <td><input type="number" name="intentos_t"></td>
                    </tr>
                    <tr>
                        <td>Fecha hora: </td>
                        <td><input type="date" name="fechayhora"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="guardar" value="Guardar" title="Guardar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
