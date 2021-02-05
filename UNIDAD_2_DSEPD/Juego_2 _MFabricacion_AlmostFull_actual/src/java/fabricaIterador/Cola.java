/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaIterador;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author lithium
 */
public class Cola extends FabricaIterador {

    LinkedList cola = new LinkedList();

    public Cola(LinkedList c) {
        this.cola = c;
    }

    @Override
    public Iterator createIterador(String tipo) {
        if (tipo.equalsIgnoreCase("adelante")) {
            return new IColaAdelante(this);
        } else if (tipo.equalsIgnoreCase("atras")) {
            return new IColaAtras(this);
        } else if (tipo.equalsIgnoreCase("saltos")) {
            return new IColaSaltos(this);
        } else 
            return null;
        
    }

}
