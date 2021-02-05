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
public class IColaAdelante implements Iterator {

    Cola col;
    int i=0;
    public IColaAdelante(Cola c) {
        this.col = c;
    }

    @Override
    public boolean hasNext() {

        if (!col.cola.isEmpty()&& i<=col.cola.size()-1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        
        return col.cola.get(i++);
        
    }

}
