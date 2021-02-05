<%-- 
    Document   : agregar_palabra
    Created on : 20/11/2020, 02:19:22 PM
    Author     : lithium
--%>

<%@page import="juego.ListarTipos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Tipos"%>
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
            <h3>Agregar Palabra</h3>
            <table width="50%">
                <form action="AgregarPalabra" method="post">
                    <tr>
                        <td colspan="2">Datos de la palabra</td>
                    </tr>
                    <tr>
                        <td>Palabra: </td>
                        <td><input type="text" name="palabra"></td>
                    </tr>
                    <tr>
                        <td>Tipo: </td>
                        <%-- <td><input type="number" name="tipopalabra"></td> --%>
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
                    <tr>
                        <td></td>
                        <td><input type="submit" name="aceptar" value="Äceptar" title="Aceptar"></td>
                    </tr>
                </form>
            </table>
        </center>
    </body>
</html>
