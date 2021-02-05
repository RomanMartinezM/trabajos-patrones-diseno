/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_java;

import controles.JPA_Controller;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Roman
 */
public abstract class Reglas {

    public Reglas(){
        
    }
    public abstract JPA_Controller crearController(UserTransaction utx,EntityManagerFactory emf);
}