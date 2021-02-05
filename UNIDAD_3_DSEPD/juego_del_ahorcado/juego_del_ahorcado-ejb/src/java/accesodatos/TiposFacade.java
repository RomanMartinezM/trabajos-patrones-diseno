/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipos;

/**
 *
 * @author lithium
 */
@Stateless
public class TiposFacade extends AbstractFacade<Tipos> {

    @PersistenceContext(unitName = "juego_del_ahorcado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposFacade() {
        super(Tipos.class);
    }
    
}
