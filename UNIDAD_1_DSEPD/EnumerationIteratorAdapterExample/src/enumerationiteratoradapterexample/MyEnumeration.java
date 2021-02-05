/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerationiteratoradapterexample;

/**
 *
 * @author lithium
 */
public class MyEnumeration implements Enumeration{
    private boolean mas = true;
    private int cnt = 0;
    
    @Override
    public boolean hasMoreElements() {
        return mas;
    }

    @Override
    public Object nextElement() {
        cnt++;
        if( cnt > 4 )
            mas = false;
        return( new Integer( cnt ) );
    }
}
