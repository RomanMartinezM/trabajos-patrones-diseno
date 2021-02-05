/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controles.Controladora;
import controles.JuegosUsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.JuegosUsuario;
/**
 *
 * @author lithium
 */
@WebServlet(name = "ListarJuegosUsuario", urlPatterns = {"/ListarJuegosUsuario"})
public class ListarJuegosUsuario extends ReglasNegocio {

    public ListarJuegosUsuario(){
        super();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        controlJuego = crearControl();
        List<JuegosUsuario> listaJuegosUsuario = controlJuego.findEntities();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarJuegosUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table align='center' width='60%' border=1>");
            //encabezado de la tabla
            
            out.println("<tr>"
                    + "<td class='datos'>ID Juegos Usuario</td>"
                    + "<td class='datos'>ID Usuario</td>"
                    + "<td class='datos'>ID Palabra</td>"
                    + "<td class='datos'>Intentos R</td>"
                    + "<td class='datos'>Intentos T</td>"
                    + "<td class='datos'>Fecha y hora</td>"
                    + "</tr>"
            );
            
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            for (JuegosUsuario ju : listaJuegosUsuario) {
                out.println("<tr>"
                            + "<td class='datos'>"+ ju.getIdJuegousu()+"</td>"
                            + "<td class='datos'>"+ ju.getIdusuario().getIdUsuario()+ "</td>"
                            + "<td class='datos'>"+ ju.getIdpalabra().getIdPalabra() + "</td>"
                            + "<td class='datos'>"+ ju.getIntentosr() + "</td>"  
                            + "<td class='datos'>"+ ju.getIntentost() + "</td>"  
                            + "<td class='datos'>"+ formatoFecha.format(ju.getFechaHora()) + "</td>"                             
                            + "</tr>"
                );
            }
            out.println("</table>");
            out.println("<br/>");
            out.println("<a href=\"agregar_juegos_usuario.jsp\"> Seguir agregando </a>"); 
            out.println("<br/>");
            out.println("<a href=\"actualizar_juegos_usuario.jsp\"> Actualizar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"eliminar_juegos_usuario.jsp\"> Eliminar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"index.jsp\"> Regresar al inicio </a>"); 
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
     public List<JuegosUsuario> listaJuegos(){ 
        controlJuego = crearControl();
        List<JuegosUsuario> listaJuegosUsuario = controlJuego.findEntities();
        return listaJuegosUsuario;
     }
       /*
        
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

    @Override
    public Controladora crearControl() {
        return new JuegosUsuarioJpaController(utx, emf);
    }
}
