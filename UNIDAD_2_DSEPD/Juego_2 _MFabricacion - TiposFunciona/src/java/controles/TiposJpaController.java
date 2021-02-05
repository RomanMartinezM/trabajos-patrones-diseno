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
import javax.transaction.UserTransaction;
import modelo.Tipos;

/**
 *
 * @author lithium
 */
public class TiposJpaController extends Controladora implements Serializable {   
   
    public TiposJpaController(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf,Tipos.class);
    }

    @Override
    public void create(Tipos tipos) throws RollbackFailureException, Exception {
        if (tipos.getPalabrasList() == null) {
            tipos.setPalabrasList(new ArrayList<Palabras>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Palabras> attachedPalabrasList = new ArrayList<Palabras>();
            for (Palabras palabrasListPalabrasToAttach : tipos.getPalabrasList()) {
                palabrasListPalabrasToAttach = em.getReference(palabrasListPalabrasToAttach.getClass(), palabrasListPalabrasToAttach.getIdPalabra());
                attachedPalabrasList.add(palabrasListPalabrasToAttach);
            }
            tipos.setPalabrasList(attachedPalabrasList);
            em.persist(tipos);
            for (Palabras palabrasListPalabras : tipos.getPalabrasList()) {
                Tipos oldTipoOfPalabrasListPalabras = palabrasListPalabras.getTipo();
                palabrasListPalabras.setTipo(tipos);
                palabrasListPalabras = em.merge(palabrasListPalabras);
                if (oldTipoOfPalabrasListPalabras != null) {
                    oldTipoOfPalabrasListPalabras.getPalabrasList().remove(palabrasListPalabras);
                    oldTipoOfPalabrasListPalabras = em.merge(oldTipoOfPalabrasListPalabras);
                }
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
    public void edit(Tipos tipos) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Tipos persistentTipos = em.find(Tipos.class, tipos.getIdTipos());
            List<Palabras> palabrasListOld = persistentTipos.getPalabrasList();
            List<Palabras> palabrasListNew = tipos.getPalabrasList();
            List<Palabras> attachedPalabrasListNew = new ArrayList<Palabras>();
            for (Palabras palabrasListNewPalabrasToAttach : palabrasListNew) {
                palabrasListNewPalabrasToAttach = em.getReference(palabrasListNewPalabrasToAttach.getClass(), palabrasListNewPalabrasToAttach.getIdPalabra());
                attachedPalabrasListNew.add(palabrasListNewPalabrasToAttach);
            }
            palabrasListNew = attachedPalabrasListNew;
            tipos.setPalabrasList(palabrasListNew);
            tipos = em.merge(tipos);
            for (Palabras palabrasListOldPalabras : palabrasListOld) {
                if (!palabrasListNew.contains(palabrasListOldPalabras)) {
                    palabrasListOldPalabras.setTipo(null);
                    palabrasListOldPalabras = em.merge(palabrasListOldPalabras);
                }
            }
            for (Palabras palabrasListNewPalabras : palabrasListNew) {
                if (!palabrasListOld.contains(palabrasListNewPalabras)) {
                    Tipos oldTipoOfPalabrasListNewPalabras = palabrasListNewPalabras.getTipo();
                    palabrasListNewPalabras.setTipo(tipos);
                    palabrasListNewPalabras = em.merge(palabrasListNewPalabras);
                    if (oldTipoOfPalabrasListNewPalabras != null && !oldTipoOfPalabrasListNewPalabras.equals(tipos)) {
                        oldTipoOfPalabrasListNewPalabras.getPalabrasList().remove(palabrasListNewPalabras);
                        oldTipoOfPalabrasListNewPalabras = em.merge(oldTipoOfPalabrasListNewPalabras);
                    }
                }
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
                Integer id = tipos.getIdTipos();
                if (findModelo(id) == null) {
                    throw new NonexistentEntityException("The tipos with id " + id + " no longer exists.");
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
            Tipos tipos;
            try {
                tipos = em.getReference(Tipos.class, id);
                tipos.getIdTipos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipos with id " + id + " no longer exists.", enfe);
            }
            List<Palabras> palabrasList = tipos.getPalabrasList();
            for (Palabras palabrasListPalabras : palabrasList) {
                palabrasListPalabras.setTipo(null);
                palabrasListPalabras = em.merge(palabrasListPalabras);
            }
            em.remove(tipos);
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
