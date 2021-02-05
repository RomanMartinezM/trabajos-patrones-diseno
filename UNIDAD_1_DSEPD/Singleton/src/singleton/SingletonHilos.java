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
public class SingletonHilos implements Runnable{
    //proceso donde se trata de crear instancias
    //Ejemplo de un proceso donde se trabaja con instancias
    private static SingletonParaHilos osc;

    @Override
    public void run() {
        osc = SingletonParaHilos.getInstance();
        System.out.println("instancia= " + SingletonParaHilos.nins());
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException ex) {}
    }
} 
