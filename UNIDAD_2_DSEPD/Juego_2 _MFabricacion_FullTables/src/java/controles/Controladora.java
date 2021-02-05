/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.NonexistentEntityException;
import controles.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import modelo.Palabras;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import modelo.Tipos;

/**
 *
 * @author Roman
 * @param <T>
 */
public abstract class Controladora<T> implements Serializable {
    protected UserTransaction utx = null;
    protected EntityManagerFactory emf = null;
    private Class<T> modelo; //Clase que se comporta como un objeto
    
     public Controladora(UserTransaction utx, EntityManagerFactory emf,Class <T> model) {
        this.utx = utx;
        this.emf = emf;
        modelo = model;
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public abstract void create(Object object) throws RollbackFailureException, Exception;

    public abstract void edit(Object object) throws NonexistentEntityException, RollbackFailureException, Exception;

    public abstract void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<T> findEntities() {
        return findEntities(true, -1, -1);
    }

    public List<T> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<T> findEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from " + modelo.getName() + " as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public T findModelo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(modelo, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from " + modelo.getName() +" as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
