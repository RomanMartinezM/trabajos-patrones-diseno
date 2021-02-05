/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaIterador;

import java.util.Iterator;

/**
 *
 * @author lithium
 */
public abstract class FabricaIterador {
    public abstract Iterator createIterador(String tipo);
 
   
}
