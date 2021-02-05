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
public class PruebaEnumerationIteratorAdapter {
    public static void main(String[] args) {
        MyIterator myIt = new MyIterator();
        MyEnumeration myEn = new MyEnumeration();
        Iterator iteratorAdapter = new EnumerationIterator(myEn);
        
        System.out.println("---------ADAPTADO-------------");
        System.out.println(myEn.hasMoreElements());
        System.out.println(myEn.nextElement());
        
        System.out.println("---------OBJETIVO-------------");
        pruebaIterator(myIt);
        
        System.out.println("---------ADAPTADOR-------------");
        pruebaIterator(iteratorAdapter);
    }
    static void pruebaIterator(Iterator iterator){
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
    }
}
