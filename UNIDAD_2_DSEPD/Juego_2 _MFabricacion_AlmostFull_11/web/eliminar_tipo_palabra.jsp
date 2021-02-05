<%-- 
    Document   : eliminar_tipo_palabra
    Created on : 1/12/2020, 03:31:06 AM
    Author     : lithium
--%>

<%@page import="modelo.Tipos"%>
<%@page import="java.util.List"%>
<%@page import="juego.ListarTipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ListarTipos lt = new ListarTipos();
    List<Tipos> listaTipos = lt.listaT();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h3>Eliminar tipo de palabra</h3>
            <form action="EliminarTipoPalabra" method="post">
                    <tr>
                        <td>Tipo: </td>
                        <td>
                            <select name="idtipo"> 
                                <option value="0">Seleccione</option>
                                <% for (Tipos tipo : listaTipos) { %>
                                <option value="<%= tipo.getIdTipos() %>"><%= tipo.getDescripcion() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <%--
                    <tr>
                        <td>Descripción: </td>
                        <td><input type="text" name="descripcion"></td>
                    </tr>
                    --%>
                 <input type="submit" name="eliminar" value="Eliminar" title="Eliminar"></td>
            </form>
         </center>
    </body>
</html>
