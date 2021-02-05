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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.JuegosUsuario;
import modelo.Palabras;
import modelo.Usuario;

/**
 *
 * @author lithium
 */
@WebServlet(name = "AgregarJuegosUsuario", urlPatterns = {"/AgregarJuegosUsuario"})
public class AgregarJuegosUsuario extends ReglasNegocio {

    public AgregarJuegosUsuario(){
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
        AgregarUsuario au = new AgregarUsuario();
        controlUsu = au.crearControl();
        Usuario usu = (Usuario)controlUsu.findModelo(Integer.parseInt(request.getParameter("idusuario")));
        
        AgregarPalabra ap = new AgregarPalabra();
        controlPal = ap.crearControl();
        Palabras pal = (Palabras)controlPal.findModelo(Integer.parseInt(request.getParameter("idpalabra")));
        
        
        JuegosUsuario ju = new JuegosUsuario();
        ju.setIdusuario(usu);
        ju.setIdpalabra(pal);
        ju.setIntentosr(Integer.parseInt(request.getParameter("intentos_r")));
        ju.setIntentost(Integer.parseInt(request.getParameter("intentos_t")));
        
        Calendar calendario = Calendar.getInstance();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaR="";
        Date fechaRegistro = null;
        try { 
            //fechaRegistro = formatoFecha.parse(request.getParameter("fechayhora"));
             fechaR = formatoFecha.format(calendario.getTime());
             fechaRegistro = formatoFecha.parse(fechaR);
             ju.setFechaHora(fechaRegistro);
        } catch (ParseException ex) {
            Logger.getLogger(AgregarJuegosUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            controlJuego.create(ju);
            response.sendRedirect("ListarJuegosUsuario");
        } catch (Exception ex) {
            Logger.getLogger(AgregarJuegosUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
        return new JuegosUsuarioJpaController(utx, emf);
    }

}
