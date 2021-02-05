<%-- 
    Document   : actualizar_usuario
    Created on : 1/12/2020, 12:08:02 AM
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
            <h3>Actualización de usuario</h3>
            <table width="50%">
                <form action="ActualizarUsuario" method="post">
                    <tr>
                        <td colspan="2">Datos del usuario</td>
                    </tr>
                    <tr>
                        <td>Usuario: </td>
                        <td>
                            <select name="idusu"> 
                                <% for (Usuario usu : listaUsuarios) { %>  
                                <option value="<%=usu.getIdUsuario() %>"><%=usu.getNombre() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>Tipo de persona: </td>
                        <td>
                            <select name="tipopersona">                          
                                <option value="0">Seleccione</option>
                                <option value="n">Niño</option>
                                <option value="a">Adulto</option>
                                <option value="v">Anciano</option>             
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Fecha de registro: </td>
                        <td><input type="date" name="fecharegistro"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="actualizar" value="Actualizar" title="Actualizar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
