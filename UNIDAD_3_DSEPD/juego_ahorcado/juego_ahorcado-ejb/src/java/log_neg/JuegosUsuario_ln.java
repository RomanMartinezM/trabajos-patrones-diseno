/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import accesodatos.JuegosUsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.JuegosUsuario;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class JuegosUsuario_ln {

    @EJB
    private JuegosUsuarioFacade juegosUsuarioFacade;
    
    public void agregar(JuegosUsuario juegosusuario){
        juegosUsuarioFacade.create(juegosusuario);
    }
    
    public List<JuegosUsuario> listaJuegosUsuario(){
        return juegosUsuarioFacade.findAll();
    }    
}
