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
public class MyIterator implements Iterator{
    private int cnt = 0;
    private boolean mas = true;
    
    @Override
    public boolean hasNext() {
         return(mas); 
    }

    @Override
    public Object next() {
        cnt++;
        if(cnt > 4)
            mas = false;
        return(new Integer(cnt));
    }

    @Override
    public void remove() {
        System.out.println("Quita elemento");
    }
    
}
