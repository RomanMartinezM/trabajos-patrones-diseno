<%-- 
    Document   : actualizar_juegos_usuario
    Created on : 1/12/2020, 04:31:54 AM
    Author     : lithium
--%>

<%@page import="modelo.JuegosUsuario"%>
<%@page import="juego.ListarJuegosUsuario"%>
<%@page import="modelo.Palabras"%>
<%@page import="juego.ListarPalabras"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="juego.ListarUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListarUsuarios lu = new ListarUsuarios();
    List<Usuario> listaUsuarios = lu.listaU();
    
    ListarPalabras lp = new ListarPalabras();
    List<Palabras> listaPalabras = lp.listaPal();
    
    ListarJuegosUsuario lju = new ListarJuegosUsuario();
    List<JuegosUsuario> listaJU = lju.listaJuegos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h3>Actualización de juego de usuario</h3>
            <table width="50%">
                <form action="ActualizarJuegosUsuario" method="post">
                    <tr>
                        <td colspan="2">Datos del juego</td>
                    </tr>
                    <tr>
                        <td>ID Juegos Usuario: </td>
                        <td>
                            <select name="idjuegosusuario"> 
                                <% for (JuegosUsuario ju : listaJU) { %>
                                <option value="<%=ju.getIdJuegousu() %>"><%=ju.getIdJuegousu() %></option>
                                <% } %>                            
                            </select> 
                        </td>
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
                        <td>Intentos restantes: </td>
                        <td><input type="number" name="intentos_r"></td>
                    </tr>
                    <tr>
                        <td>Intentos totales: </td>
                        <td><input type="number" name="intentos_t"></td>
                    </tr>
                    <%--
                    <tr>
                        <td>Fecha hora: </td>
                        <td><input type="date" name="fechayhora"></td>
                    </tr> 
                    --%>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="actualizar" value="Actualizar" title="Actualizar" >
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
