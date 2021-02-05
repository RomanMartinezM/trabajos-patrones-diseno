/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaIterador;

import java.util.Iterator;

/**
 *
 * @author Ezequiel
 */
public class IColaAtras implements Iterator {

    Cola col;
    int i;

    public IColaAtras(Cola c) {
        this.col = c;
        i = c.cola.size() - 1;
    }

    @Override
    public boolean hasNext() {

        if (!col.cola.isEmpty() && i >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {

        return col.cola.get(i--);
    }

}
