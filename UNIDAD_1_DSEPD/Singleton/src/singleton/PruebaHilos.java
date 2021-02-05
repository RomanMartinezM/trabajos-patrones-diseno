/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author lithium
 */
public class PruebaHilos {
    public static void main(String[] args) {
        SingletonHilos pro = new SingletonHilos();
        Thread h1 = new Thread(pro);
        Thread h2 = new Thread(pro);
        Thread h3 = new Thread(pro);
        Thread h4 = new Thread(pro);
        Thread h5 = new Thread(pro);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        
    }
}
