/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import dao_salud.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo_salud.Usuario;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class Usuarios_ln {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private UsuarioFacade usuarioFacade;

    public void registrar(Usuario usuario){
        usuarioFacade.create(usuario);          
    }
    public List<Usuario> listaUsuarios(){
        return usuarioFacade.findAll();
    } 
}
