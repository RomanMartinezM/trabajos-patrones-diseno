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
public class PalabrasJpaController extends Controladora implements Serializable {

    public PalabrasJpaController(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf, Palabras.class);
    }

    @Override
    public void create(Object object) throws RollbackFailureException, Exception {
        Palabras palabras = (Palabras)object;
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

    @Override
    public void edit(Object object) throws NonexistentEntityException, RollbackFailureException, Exception {
        Palabras palabras = (Palabras)object;
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
                if (findModelo(id) == null) {
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

}
