/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_salud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo_salud.Antropometricos;

/**
 *
 * @author lithium
 */
@Stateless
public class AntropometricosFacade extends AbstractFacade<Antropometricos> {

    @PersistenceContext(unitName = "salud-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntropometricosFacade() {
        super(Antropometricos.class);
    }
    
}
