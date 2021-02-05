/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_java;

import controles.JPA_Controller;
import controles.PalabrasJpaController;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Roman
 */
public class Palabras extends Reglas{

    @Override
    public JPA_Controller crearController(UserTransaction utx, EntityManagerFactory emf) {
        return new PalabrasJpaController(utx, emf);
    }
   
}
