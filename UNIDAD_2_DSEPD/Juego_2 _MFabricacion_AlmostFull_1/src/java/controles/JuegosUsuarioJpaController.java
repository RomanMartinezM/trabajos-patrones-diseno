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
import modelo.JuegosUsuario;
import modelo.Palabras;
import modelo.Usuario;

/**
 *
 * @author lithium
 */
public class JuegosUsuarioJpaController extends Controladora implements Serializable {

    public JuegosUsuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf, JuegosUsuario.class);
    }
   
    @Override
    public void create(Object object) throws RollbackFailureException, Exception {
        JuegosUsuario juegosUsuario = (JuegosUsuario)object;
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Palabras idpalabra = juegosUsuario.getIdpalabra();
            if (idpalabra != null) {
                idpalabra = em.getReference(idpalabra.getClass(), idpalabra.getIdPalabra());
                juegosUsuario.setIdpalabra(idpalabra);
            }
            Usuario idusuario = juegosUsuario.getIdusuario();
            if (idusuario != null) {
                idusuario = em.getReference(idusuario.getClass(), idusuario.getIdUsuario());
                juegosUsuario.setIdusuario(idusuario);
            }
            em.persist(juegosUsuario);
            if (idpalabra != null) {
                idpalabra.getJuegosUsuarioList().add(juegosUsuario);
                idpalabra = em.merge(idpalabra);
            }
            if (idusuario != null) {
                idusuario.getJuegosUsuarioList().add(juegosUsuario);
                idusuario = em.merge(idusuario);
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
        JuegosUsuario juegosUsuario = (JuegosUsuario)object;
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            JuegosUsuario persistentJuegosUsuario = em.find(JuegosUsuario.class, juegosUsuario.getIdJuegousu());
            Palabras idpalabraOld = persistentJuegosUsuario.getIdpalabra();
            Palabras idpalabraNew = juegosUsuario.getIdpalabra();
            Usuario idusuarioOld = persistentJuegosUsuario.getIdusuario();
            Usuario idusuarioNew = juegosUsuario.getIdusuario();
            if (idpalabraNew != null) {
                idpalabraNew = em.getReference(idpalabraNew.getClass(), idpalabraNew.getIdPalabra());
                juegosUsuario.setIdpalabra(idpalabraNew);
            }
            if (idusuarioNew != null) {
                idusuarioNew = em.getReference(idusuarioNew.getClass(), idusuarioNew.getIdUsuario());
                juegosUsuario.setIdusuario(idusuarioNew);
            }
            juegosUsuario = em.merge(juegosUsuario);
            if (idpalabraOld != null && !idpalabraOld.equals(idpalabraNew)) {
                idpalabraOld.getJuegosUsuarioList().remove(juegosUsuario);
                idpalabraOld = em.merge(idpalabraOld);
            }
            if (idpalabraNew != null && !idpalabraNew.equals(idpalabraOld)) {
                idpalabraNew.getJuegosUsuarioList().add(juegosUsuario);
                idpalabraNew = em.merge(idpalabraNew);
            }
            if (idusuarioOld != null && !idusuarioOld.equals(idusuarioNew)) {
                idusuarioOld.getJuegosUsuarioList().remove(juegosUsuario);
                idusuarioOld = em.merge(idusuarioOld);
            }
            if (idusuarioNew != null && !idusuarioNew.equals(idusuarioOld)) {
                idusuarioNew.getJuegosUsuarioList().add(juegosUsuario);
                idusuarioNew = em.merge(idusuarioNew);
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
                Integer id = juegosUsuario.getIdJuegousu();
                if (findModelo(id) == null) {
                    throw new NonexistentEntityException("The juegosUsuario with id " + id + " no longer exists.");
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
            JuegosUsuario juegosUsuario;
            try {
                juegosUsuario = em.getReference(JuegosUsuario.class, id);
                juegosUsuario.getIdJuegousu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The juegosUsuario with id " + id + " no longer exists.", enfe);
            }
            Palabras idpalabra = juegosUsuario.getIdpalabra();
            if (idpalabra != null) {
                idpalabra.getJuegosUsuarioList().remove(juegosUsuario);
                idpalabra = em.merge(idpalabra);
            }
            Usuario idusuario = juegosUsuario.getIdusuario();
            if (idusuario != null) {
                idusuario.getJuegosUsuarioList().remove(juegosUsuario);
                idusuario = em.merge(idusuario);
            }
            em.remove(juegosUsuario);
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
