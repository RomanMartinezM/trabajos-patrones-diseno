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
import modelo.Tipos;

/**
 *
 * @author Roman
 */
@WebServlet(name = "AgregarTipoPalabra", urlPatterns = {"/AgregarTipoPalabra"})
public class AgregarTipoPalabra extends ReglasNegocio {
   
    public AgregarTipoPalabra(){
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
        boolean existe = false;
        String descripcion = request.getParameter("tipo");
        
        ListarTipos lt = new ListarTipos();
        List<Tipos> listaTipos = lt.listaT();        
        for (Tipos t : listaTipos) {
            if (t.getDescripcion().equals(descripcion)) {
                existe = true;
                break;
            }
        }
       
        try {
             if (existe == false) {//si el tipo no existe
                 control = crearControl();
                 Tipos tipos = new Tipos();
                 tipos.setDescripcion((String)descripcion);
                 control.create(tipos);
                 response.sendRedirect("ListarTipos");
             }else{//si el tipo ya existe
                 response.sendRedirect("agregar_tipo_palabra.jsp");
             }           
         } catch (Exception ex) {
             Logger.getLogger(AgregarTipoPalabra.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public Controladora crearControl() {
        return new TiposJpaController(utx, emf);
    }
}
