/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controles.Controladora;
import controles.PalabrasJpaController;
import fabricaIterador.Cola;
import fabricaIterador.FabricaIterador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
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
import modelo.Palabras;
import modelo.Tipos;

/**
 *
 * @author Roman
 */
@WebServlet(name = "ListarPalabras", urlPatterns = {"/ListarPalabras"})
public class ListarPalabras extends ReglasNegocio {
    
    public ListarPalabras(){
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
         controlPal = crearControl();
         List <Palabras>listaPalabras = controlPal.findEntities();
          LinkedList cola = new LinkedList();
        for (Palabras pal : listaPalabras) {
            cola.add(pal.getIdPalabra());
            cola.add(pal.getPalabra());
            cola.add(pal.getTipo().getDescripcion());//cola.add(pal.getTipo().getIdTipos());
            cola.add(pal.getNivel());
            
        }
        
        FabricaIterador iter = new Cola(cola);
        Iterator i = null;    
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarPalabras</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table align='center' width='60%' border=1>");
            //encabezado de la tabla
            /*
            out.println("<tr>"
                    + "<td class='datos'>ID</td>"
                    + "<td class='datos'>Palabra</td>"
                    + "<td class='datos'>Tipo</td>"
                    + "<td class='datos'>Nivel</td>"
                    + "</tr>"
            );
            */
            int tipoLista = Integer.parseInt(request.getParameter("tlistado"));
            if (tipoLista == 1) {
                out.println("<tr>"
                    + "<td class='datos'>ID</td>"
                    + "<td class='datos'>Palabra</td>"
                    + "<td class='datos'>Tipo</td>"
                    + "<td class='datos'>Nivel</td>"
                    + "</tr>"
                );
               i = iter.createIterador("adelante");
                while (i.hasNext() && i.hasNext() != false) {
                    //System.out.println(i.next());
                     out.println("<tr>"
                                + "<td class='datos'>"+ i.next()+"</td>"
                                + "<td class='datos'>"+ i.next()+"</td>"      
                                + "<td class='datos'>"+ i.next()+"</td>"
                                + "<td class='datos'>"+ i.next()+"</td>"              
                                + "</tr>"
                    );
                } 
            }
             if (tipoLista == 2) {
                 out.println("<tr>"
                    + "<td class='datos'>Nivel</td>"
                    + "<td class='datos'>Tipo</td>"
                    + "<td class='datos'>Palabra</td>"
                    + "<td class='datos'>ID</td>"
                    + "</tr>"
                 );
                 i = iter.createIterador("atras");
                 while (i.hasNext() && i.hasNext() != false) {
                      out.println("<tr>"
                                + "<td class='datos'>"+ i.next()+"</td>"
                                + "<td class='datos'>"+ i.next()+"</td>"      
                                + "<td class='datos'>"+ i.next()+"</td>"
                                + "<td class='datos'>"+ i.next()+"</td>"              
                                + "</tr>"
                    );
                 }
             }
            /*
            for (Palabras palabra : listaPalabras) {
                out.println("<tr>"
                            + "<td class='datos'>"+ palabra.getIdPalabra()+"</td>"
                            + "<td class='datos'>"+ palabra.getPalabra()+ "</td>"
                            + "<td class='datos'>"+ palabra.getTipo().getIdTipos() + "</td>"
                            + "<td class='datos'>"+ palabra.getNivel() + "</td>"   
                            + "</tr>"
                );
            }*/
            out.println("</table>");
            out.println("<br/>");
            out.println("<a href=\"agregar_palabra.jsp\"> Seguir agregando </a>"); 
            out.println("<br/>");
            out.println("<a href=\"actualizar_palabra.jsp\"> Actualizar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"eliminar_palabra.jsp\"> Eliminar </a>"); 
            out.println("<br/>");
            out.println("<a href=\"index.jsp\"> Regresar al inicio </a>"); 
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public List<Palabras> listaPal(){ 
       /*
        AgregarTipoPalabra atp = new AgregarTipoPalabra();
        control = atp.crearControl();
        List <Tipos>listaTipos = control.findEntities();
       */
       controlPal = crearControl();
       List <Palabras>listaPalabras = controlPal.findEntities();
        
       return listaPalabras;
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
        return new PalabrasJpaController(utx, emf);
    }
}
