/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.NonexistentEntityException;
import controles.exceptions.RollbackFailureException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Roman
 */
public abstract class JPA_Controller {
    protected UserTransaction utx = null;
    protected EntityManagerFactory emf = null;
    
    public JPA_Controller(UserTransaction utx, EntityManagerFactory emf){
        this.utx = utx;
        this.emf = emf;
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public abstract void destroy(Integer id)throws NonexistentEntityException, RollbackFailureException, Exception ;
}
