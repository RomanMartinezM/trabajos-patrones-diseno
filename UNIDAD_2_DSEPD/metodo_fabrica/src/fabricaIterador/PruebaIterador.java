/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaIterador;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Ezequiel
 */
public class PruebaIterador {

    public static void main(String[] arg) {
        Stack pila = new Stack();
        pila.add("Ejemplo");
        pila.add("de");
        pila.add("Fabrica");
        pila.add("Iterador");
        FabricaIterador ite = new Pila(pila);
        Iterator i = null;
        LinkedList cola = new LinkedList();
        cola.add("Ejemplo");
        cola.add("de");
        cola.add("Fabrica");
        cola.add("Iterador");
        FabricaIterador iter = new Cola(cola);
        System.out.println("pila: "+ pila.toString());
        System.out.println("***listar pila hacia adelante***");
        i = ite.createIterador("adelante");
        while (i.hasNext()) {
            System.out.println(i.next());
        } 
        System.out.println("***listar hacia atras***");
        i = ite.createIterador("atras");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("cola: "+ cola.toString());
        System.out.println("***listar hacia adelante***");
        i = iter.createIterador("adelante");
        while (i.hasNext() && i.hasNext() != false) {
            System.out.println(i.next());
        }
        System.out.println("***listar cola hacia atras***");
        i = iter.createIterador("atras");
        while (i.hasNext() && i.hasNext() != false) {
            System.out.println(i.next());
        }

    }
}
