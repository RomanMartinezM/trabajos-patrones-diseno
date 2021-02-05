/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerationiteratoradapterexample;

/**
 * 
 * @author Roman Martinez Mendoza
 */
public class EnumerationIterator implements Iterator{//Clase que toma el papel de "Adaptador"
    Enumeration enume;
    
    public EnumerationIterator(Enumeration enume){
        this.enume = enume;
    }
    @Override
    public boolean hasNext() {
        return enume.hasMoreElements();
    }

    @Override
    public Object next() {
        return enume.nextElement();
    }

    @Override
    public void remove() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
