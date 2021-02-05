/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import accesodatos.TiposFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipos;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class Tipo_p {

    @EJB
    private TiposFacade tiposFacade;
    
    public List<Tipos> lista_t(){
        return tiposFacade.findAll();
    }
}
