/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import dao_salud.ActividadusuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo_salud.Actividadusuario;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class ActividadUsuario_ln {

    @EJB
    private ActividadusuarioFacade actividadusuarioFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void registrar(Actividadusuario actividadusuario){
        actividadusuarioFacade.create(actividadusuario);          
    }
    public List<Actividadusuario> listaActividadUsuario(){
        return actividadusuarioFacade.findAll();
    } 
    
}
