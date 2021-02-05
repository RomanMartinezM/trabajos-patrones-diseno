/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_salud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo_salud.Actividadusuario;

/**
 *
 * @author lithium
 */
@Stateless
public class ActividadusuarioFacade extends AbstractFacade<Actividadusuario> {

    @PersistenceContext(unitName = "salud-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadusuarioFacade() {
        super(Actividadusuario.class);
    }
    
}
