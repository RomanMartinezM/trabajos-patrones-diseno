<%-- 
    Document   : eliminar_palabra
    Created on : 1/12/2020, 04:15:19 AM
    Author     : lithium
--%>

<%@page import="modelo.Palabras"%>
<%@page import="java.util.List"%>
<%@page import="juego.ListarPalabras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   // ListarTipos lt = new ListarTipos();
   // List<Tipos> listaTipos = lt.listaT();
    
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
            <h3>Eliminar Palabra</h3>
            <table width="50%">
                <form action="EliminarPalabra" method="post">
                    <tr>
                        <td colspan="2">Datos de la palabra</td>
                    </tr>
                    <tr>
                        <td>Palabra: </td>
                        <td>
                            <select name="idpalabra"> 
                                <% for (Palabras palabra : listaPalabras) { %>
                                <option value="<%=palabra.getIdPalabra() %>"><%=palabra.getPalabra() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <%--
                    <tr>
                        <td>Palabra: </td>
                        <td><input type="text" name="palabra"></td>
                    </tr>                  
                    <tr>
                        <td>Tipo: </td>
                        <td>
                            <select name="tipopalabra"> 
                                <option value="0">Seleccione</option>
                                <% for (Tipos tipo : listaTipos) { %>
                                <option value="<%= tipo.getIdTipos() %>"><%= tipo.getDescripcion() %></option>
                                <% } %>                            
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Nivel: </td>
                        <td>
                            <select name="nivel"> 
                                <option value="1">Básico</option>
                                <option value="2">Intermedio</option>
                                <option value="3">Alto</option>
                            </select> 
                        </td>
                    </tr>
                    --%>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="eliminar" value="Eliminar" title="Eliminar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
