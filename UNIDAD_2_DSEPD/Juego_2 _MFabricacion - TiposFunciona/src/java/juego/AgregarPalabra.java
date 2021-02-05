/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controles.Controladora;
import controles.PalabrasJpaController;
import controles.TiposJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import modelo.Palabras;
import modelo.Tipos;

/**
 *
 * @author lithium
 */
@WebServlet(name = "AgregarPalabra", urlPatterns = {"/AgregarPalabra"})
public class AgregarPalabra extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    /*
    public AgregarPalabra(){
        super();
    }
    */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        //////////////////////controlPal = crearControl();
        //response.setContentType("text/html;charset=UTF-8");
        emf = Persistence.createEntityManagerFactory("Juego_2PU");
        PalabrasJpaController controlPalabra;
        controlPalabra = new PalabrasJpaController(utx, emf);
        Palabras palabras = new Palabras(); 
        /*
        //controlTipo = new TiposJpaController(utx, emf);
        //Tipos tipos = controlTipo.findTipos(Integer.parseInt(request.getParameter("tipopalabra")));
        */
        
        TiposJpaController controlTipo; 
        controlTipo = new TiposJpaController(utx, emf);
        /*
        List<Tipos> listaTipos = new ArrayList<Tipos>();
        listaTipos = controlTipo.findEntities();
        request.setAttribute("listaTipos", listaTipos);
        request.getRequestDispatcher("agregar_palabra.jsp").forward(request, response);
        */
        
        Tipos tipos = (Tipos)controlTipo.findModelo(Integer.parseInt(request.getParameter("tipopalabra")));
        /*
        AgregarTipoPalabra atp = new AgregarTipoPalabra(); 
        control = atp.crearControl();
        Tipos tipos = (Tipos)control.findModelo(Integer.parseInt(request.getParameter("tipopalabra")));
        */
        palabras.setTipo(tipos);
        
        palabras.setPalabra(request.getParameter("palabra"));
        
        int nivelD = Integer.parseInt(request.getParameter("nivel"));
        palabras.setNivel(nivelD);
         

        
        
        try {
           
             controlPalabra.create(palabras);
            ///// controlPal.create(palabras);
             response.sendRedirect("ListarPalabras");
         } catch (Exception ex) {
             Logger.getLogger(AgregarTipoPalabra.class.getName()).log(Level.SEVERE, null, ex);
         }

        
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        /*  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarPalabra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarPalabra at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
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
/*
    @Override
    public Controladora crearControl() {
        return new PalabrasJpaController(utx, emf);
    }
*/
}
