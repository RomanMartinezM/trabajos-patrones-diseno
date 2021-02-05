/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lithium
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {
    private String usuarios[]={"administrador","invitado"};
    private String claves[]={"admi","invi"};
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse respuesta)
            throws ServletException, IOException {
        
        String nombreUsuario = request.getParameter("nombreUsuario");//"nombreUsuario" viene de 'index.jsp', de la etiqueta <input name="nombreUsuario">
        String clave = request.getParameter("clave");//"clave" viene de 'index.jsp', de la etiqueta <input name="clave">
    //Se crea una variable de tipo 'session' para guardar el nombre de usuario
        HttpSession sesionActual = request.getSession(true);
        //se almacena el nombre de usuario en la variable de  sesion
        sesionActual.setAttribute("nomUsuario",nombreUsuario);
        if (nombreUsuario.equals(usuarios[0]) && clave.equals(claves[0])){
                //se direcciona hacia 'paginaPrincipal.jsp'
                respuesta.sendRedirect("paginaPrincipal.jsp");
                //todo este codigo ya no se ejecuta porque se redirecciona a 'paginaPrincipal.jsp'. Así que, se puede eliminar
                respuesta.setContentType("text/html;charset=UTF-8");
        }else if (nombreUsuario.equals(usuarios[1]) && clave.equals(claves[1])){
                //se direcciona hacia 'paginaPrincipal.jsp'
                respuesta.sendRedirect("paginaInvitado.jsp");
                //todo este codigo ya no se ejecuta porque se redirecciona a 'paginaPrincipal.jsp'. Así que, se puede eliminar
                respuesta.setContentType("text/html;charset=UTF-8");
        }else{
               respuesta.sendRedirect("index.jsp");
          }
        try (PrintWriter out = respuesta.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Control at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
