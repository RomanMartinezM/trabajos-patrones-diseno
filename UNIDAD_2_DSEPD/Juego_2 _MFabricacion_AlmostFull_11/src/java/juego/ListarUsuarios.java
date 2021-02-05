/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controles.Controladora;
import controles.UsuarioJpaController;
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
import modelo.Usuario;
/**
 *
 * @author lithium
 */
@WebServlet(name = "ListarUsuarios", urlPatterns = {"/ListarUsuarios"})
public class ListarUsuarios extends ReglasNegocio {

    public ListarUsuarios(){
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
        controlUsu = crearControl();
        List<Usuario> listaUsuarios = controlUsu.findEntities();
        // List <Tipos>listaTipos = control.findEntities();
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table align='center' width='60%' border=1>");
            //encabezado de la tabla
           out.println("<tr>"
                    + "<td class='tipos'>ID Usuario</td>"
                    + "<td class='tipos'>Nombre</td>"
                    + "<td class='tipos'>Tipo de persona</td>"
                    + "<td class='tipos'>Fecha de registro</td>"
                    + "</tr>"
            );
           
           DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
           //DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            for (Usuario usu : listaUsuarios) {
                out.println("<tr>"
                            + "<td class='datos'>"+ usu.getIdUsuario()+"</td>"
                            + "<td class='datos'>"+ usu.getNombre() + "</td>"
                            + "<td class='datos'>"+ usu.getTpersona()+"</td>"
                            + "<td class='datos'>"+ formatoFecha.format(usu.getFechaRegistro()) + "</td>"
                            + "</tr>"
                );
            }
            out.println("</table>");
            out.println("<br/>");
            out.println("<a href=\"agregar_usuario.jsp\"> Seguir agregando </a>"); 
            out.println("<br/>");
            out.println("<a href=\"actualizar_usuario.jsp\"> Actualizar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"eliminar_usuario.jsp\"> Eliminar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"index.jsp\"> Regresar al inicio </a>"); 
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     public List<Usuario> listaU(){ 
       /*
        AgregarTipoPalabra atp = new AgregarTipoPalabra();
        control = atp.crearControl();
        List <Tipos>listaTipos = control.findEntities();
       */
       controlUsu = crearControl();
       List <Usuario>listaUsuarios = controlUsu.findEntities();
        
       return listaUsuarios;
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

    @Override
    public Controladora crearControl() {
        return new UsuarioJpaController(utx, emf);
    }

}
