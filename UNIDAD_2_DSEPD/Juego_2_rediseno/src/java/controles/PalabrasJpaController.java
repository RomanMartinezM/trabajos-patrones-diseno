/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import controles.exceptions.NonexistentEntityException;
import controles.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.transaction.UserTransaction;
import modelo.Palabras;
import modelo.Tipos;

/**
 *
 * @author Roman
 */
public class PalabrasJpaController extends JPA_Controller implements Serializable {

    
    public PalabrasJpaController(UserTransaction utx, EntityManagerFactory emf) {
        super(utx,emf);
    }

    public void create(Palabras palabras) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipos tipo = palabras.getTipo();
            if (tipo != null) {
                tipo = em.getReference(tipo.getClass(), tipo.getIdTipos());
                palabras.setTipo(tipo);
            }
            em.persist(palabras);
            if (tipo != null) {
                tipo.getPalabrasList().add(palabras);
                tipo = em.merge(tipo);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
  
    public void edit(Palabras palabras) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabras persistentPalabras = em.find(Palabras.class, palabras.getIdPalabra());
            Tipos tipoOld = persistentPalabras.getTipo();
            Tipos tipoNew = palabras.getTipo();
            if (tipoNew != null) {
                tipoNew = em.getReference(tipoNew.getClass(), tipoNew.getIdTipos());
                palabras.setTipo(tipoNew);
            }
            palabras = em.merge(palabras);
            if (tipoOld != null && !tipoOld.equals(tipoNew)) {
                tipoOld.getPalabrasList().remove(palabras);
                tipoOld = em.merge(tipoOld);
            }
            if (tipoNew != null && !tipoNew.equals(tipoOld)) {
                tipoNew.getPalabrasList().add(palabras);
                tipoNew = em.merge(tipoNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = palabras.getIdPalabra();
                if (findPalabras(id) == null) {
                    throw new NonexistentEntityException("The palabras with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabras palabras;
            try {
                palabras = em.getReference(Palabras.class, id);
                palabras.getIdPalabra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The palabras with id " + id + " no longer exists.", enfe);
            }
            Tipos tipo = palabras.getTipo();
            if (tipo != null) {
                tipo.getPalabrasList().remove(palabras);
                tipo = em.merge(tipo);
            }
            em.remove(palabras);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Palabras> findPalabrasEntities() {
        return findPalabrasEntities(true, -1, -1);
    }

    public List<Palabras> findPalabrasEntities(int maxResults, int firstResult) {
        return findPalabrasEntities(false, maxResults, firstResult);
    }

    private List<Palabras> findPalabrasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Palabras as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Palabras findPalabras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Palabras.class, id);
        } finally {
            em.close();
        }
    }

    public int getPalabrasCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Palabras as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
