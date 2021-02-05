/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import accesodatos.PalabrasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Palabras;

/**
 *
 * @author lithium
 */
@Stateless
@LocalBean
public class palabras_ln {

    @EJB
    private PalabrasFacade palabrasFacade;
    
    public void guardar(Palabras palabras){
        palabrasFacade.create(palabras);
    }
    public List<Palabras> listaPalabras(){
        return palabrasFacade.findAll();
    }
}
