/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import dao_salud.AntropometricosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo_salud.Antropometricos;


/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class Antropometricos_ln {

    @EJB
    private AntropometricosFacade antropometricosFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void registrar(Antropometricos antropometricos){
        antropometricosFacade.create(antropometricos);          
    }
    public List<Antropometricos> listaAntropometricos(){
        return antropometricosFacade.findAll();
    }
}
