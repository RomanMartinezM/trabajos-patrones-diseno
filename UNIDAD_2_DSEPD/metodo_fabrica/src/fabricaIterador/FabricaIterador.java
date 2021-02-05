package fabricaIterador;

import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ezequiel
 */
public abstract class FabricaIterador {
    abstract Iterator createIterador(String tipo);
 
   
}
