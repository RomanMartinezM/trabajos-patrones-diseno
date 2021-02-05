/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import dao_salud.TipoactividadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo_salud.Tipoactividad;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class TipoActividad_ln {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @EJB
    private TipoactividadFacade tipoactividadFacade;

    public void registrar(Tipoactividad tipoactividad){
        tipoactividadFacade.create(tipoactividad);          
    }
    public List<Tipoactividad> listaTipoactividad(){
        return tipoactividadFacade.findAll();
    } 
}
