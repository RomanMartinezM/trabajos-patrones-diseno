/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaIterador;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author lithium
 */
public class Pila extends FabricaIterador {

    Stack pila = new Stack();

    public Pila(Stack p) {
        this.pila = p;
    }

    @Override
    public Iterator createIterador(String tipo) {
        if (tipo.equalsIgnoreCase("adelante")) {
            return new IPilaAdelante(this);
        } else if (tipo.equalsIgnoreCase("atras")) {
            return new IPilaAtras(this);
        } else {
            return null;
        }
    }

}
