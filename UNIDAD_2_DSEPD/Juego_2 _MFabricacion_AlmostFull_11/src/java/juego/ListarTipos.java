/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controles.Controladora;
import controles.TiposJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import modelo.Tipos;

/**
 *
 * @author Roman
 */
@WebServlet(name = "ListarTipos", urlPatterns = {"/ListarTipos"})
public class ListarTipos extends ReglasNegocio {
 
    public ListarTipos(){
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
        control = crearControl();
        List <Tipos>listaTipos = control.findEntities();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarTipos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table align='center' width='60%' border=1>");
            //encabezado de la tabla
            
            out.println("<tr>"
                    + "<td class='tipos'>ID</td>"
                    + "<td class='tipos'>Descripcion del tipo</td>"
                    + "</tr>"
            );
            for (Tipos tipo : listaTipos) {
                out.println("<tr>"
                            + "<td class='datos'>"+ tipo.getIdTipos()+"</td>"
                            + "<td class='datos'>"+ tipo.getDescripcion() + "</td>"
                            + "</tr>"
                );
            }
            out.println("</table>");
            out.println("<br/>");
            out.println("<a href=\"agregar_tipo_palabra.jsp\"> Seguir agregando </a>"); 
            out.println("<br/>");
            out.println("<a href=\"actualizar_tipo_palabra.jsp\"> Actualizar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"eliminar_tipo_palabra.jsp\"> Eliminar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"index.jsp\"> Regresar al inicio </a>"); 
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public List<Tipos> listaT(){        
        control = crearControl();
        List <Tipos>listaTipos = control.findEntities();      
        return listaTipos;
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
         return new TiposJpaController(utx, emf);
    }
}
