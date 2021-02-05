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
public class IPilaAtras implements Iterator{

    Pila pil;
    int i=1;
    public IPilaAtras(Pila p) {
        this.pil = p;
        
    }

    @Override
    public boolean hasNext() {
        
        if (!pil.pila.empty()&& i<=pil.pila.size()-1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return pil.pila.get(i++);
    }
    
}
