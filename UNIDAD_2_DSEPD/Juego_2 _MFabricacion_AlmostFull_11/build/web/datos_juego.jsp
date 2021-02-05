<%-- 
    Document   : datos_juego
    Created on : 30/11/2020, 07:39:20 PM
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
            <h1>Inicio del juego</h1>
            <h2>Ahorcado</h2>
            <table width="50%">
                <form action="acceso.jsp" method="post">
                    <tr>
                        <td><input type="hidden" name="id_usuario" value="<%=request.getParameter("idusuario")%>"></td>
                    </tr>
                    <tr>
                        <td>Tipo de palabra: </td>
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
                        <td>Intentos totales: </td>
                        <td><input type="number" name="intentos_t"></td>
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
