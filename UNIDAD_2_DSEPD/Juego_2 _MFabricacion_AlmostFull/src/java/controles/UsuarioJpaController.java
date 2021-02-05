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
import modelo.JuegosUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import modelo.Usuario;

/**
 *
 * @author lithium
 */
public class UsuarioJpaController extends Controladora implements Serializable {

    public UsuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
       super(utx, emf, Usuario.class);
    }
   
    @Override
    public void create(Object object) throws RollbackFailureException, Exception {
        Usuario usuario = (Usuario)object;
        if (usuario.getJuegosUsuarioList() == null) {
            usuario.setJuegosUsuarioList(new ArrayList<JuegosUsuario>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<JuegosUsuario> attachedJuegosUsuarioList = new ArrayList<JuegosUsuario>();
            for (JuegosUsuario juegosUsuarioListJuegosUsuarioToAttach : usuario.getJuegosUsuarioList()) {
                juegosUsuarioListJuegosUsuarioToAttach = em.getReference(juegosUsuarioListJuegosUsuarioToAttach.getClass(), juegosUsuarioListJuegosUsuarioToAttach.getIdJuegousu());
                attachedJuegosUsuarioList.add(juegosUsuarioListJuegosUsuarioToAttach);
            }
            usuario.setJuegosUsuarioList(attachedJuegosUsuarioList);
            em.persist(usuario);
            for (JuegosUsuario juegosUsuarioListJuegosUsuario : usuario.getJuegosUsuarioList()) {
                Usuario oldIdusuarioOfJuegosUsuarioListJuegosUsuario = juegosUsuarioListJuegosUsuario.getIdusuario();
                juegosUsuarioListJuegosUsuario.setIdusuario(usuario);
                juegosUsuarioListJuegosUsuario = em.merge(juegosUsuarioListJuegosUsuario);
                if (oldIdusuarioOfJuegosUsuarioListJuegosUsuario != null) {
                    oldIdusuarioOfJuegosUsuarioListJuegosUsuario.getJuegosUsuarioList().remove(juegosUsuarioListJuegosUsuario);
                    oldIdusuarioOfJuegosUsuarioListJuegosUsuario = em.merge(oldIdusuarioOfJuegosUsuarioListJuegosUsuario);
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
    public void edit(Object object) throws NonexistentEntityException, RollbackFailureException, Exception {
        Usuario usuario = (Usuario)object;
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            List<JuegosUsuario> juegosUsuarioListOld = persistentUsuario.getJuegosUsuarioList();
            List<JuegosUsuario> juegosUsuarioListNew = usuario.getJuegosUsuarioList();
            List<JuegosUsuario> attachedJuegosUsuarioListNew = new ArrayList<JuegosUsuario>();
            for (JuegosUsuario juegosUsuarioListNewJuegosUsuarioToAttach : juegosUsuarioListNew) {
                juegosUsuarioListNewJuegosUsuarioToAttach = em.getReference(juegosUsuarioListNewJuegosUsuarioToAttach.getClass(), juegosUsuarioListNewJuegosUsuarioToAttach.getIdJuegousu());
                attachedJuegosUsuarioListNew.add(juegosUsuarioListNewJuegosUsuarioToAttach);
            }
            juegosUsuarioListNew = attachedJuegosUsuarioListNew;
            usuario.setJuegosUsuarioList(juegosUsuarioListNew);
            usuario = em.merge(usuario);
            for (JuegosUsuario juegosUsuarioListOldJuegosUsuario : juegosUsuarioListOld) {
                if (!juegosUsuarioListNew.contains(juegosUsuarioListOldJuegosUsuario)) {
                    juegosUsuarioListOldJuegosUsuario.setIdusuario(null);
                    juegosUsuarioListOldJuegosUsuario = em.merge(juegosUsuarioListOldJuegosUsuario);
                }
            }
            for (JuegosUsuario juegosUsuarioListNewJuegosUsuario : juegosUsuarioListNew) {
                if (!juegosUsuarioListOld.contains(juegosUsuarioListNewJuegosUsuario)) {
                    Usuario oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario = juegosUsuarioListNewJuegosUsuario.getIdusuario();
                    juegosUsuarioListNewJuegosUsuario.setIdusuario(usuario);
                    juegosUsuarioListNewJuegosUsuario = em.merge(juegosUsuarioListNewJuegosUsuario);
                    if (oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario != null && !oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario.equals(usuario)) {
                        oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario.getJuegosUsuarioList().remove(juegosUsuarioListNewJuegosUsuario);
                        oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario = em.merge(oldIdusuarioOfJuegosUsuarioListNewJuegosUsuario);
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
                Integer id = usuario.getIdUsuario();
                if (findModelo(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<JuegosUsuario> juegosUsuarioList = usuario.getJuegosUsuarioList();
            for (JuegosUsuario juegosUsuarioListJuegosUsuario : juegosUsuarioList) {
                juegosUsuarioListJuegosUsuario.setIdusuario(null);
                juegosUsuarioListJuegosUsuario = em.merge(juegosUsuarioListJuegosUsuario);
            }
            em.remove(usuario);
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
