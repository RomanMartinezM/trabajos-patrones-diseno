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
public class IPilaAdelante implements Iterator {

    Pila pil;
    int i;

    public IPilaAdelante(Pila p) {
        this.pil = p;
        i=p.pila.size()-1;
    }

    @Override
    public boolean hasNext() {
        if (!pil.pila.empty() && i>=0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return pil.pila.get(i--);
    }

}
