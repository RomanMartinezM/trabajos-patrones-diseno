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
public class SingletonClasico {
    protected static SingletonClasico instancia;
    private static int numIns=0;
    
    protected SingletonClasico(){
        //Existe solo para evitar qeue se cree con "new" fuera de aquí
        System.out.println("\nSe creo una instancia");
        numIns++;
    }
    public static SingletonClasico getInstancia(){
        if(instancia == null){
            instancia = new SingletonClasico();
        }
        return instancia;
    }
    public static int numIns(){
        return numIns;
    }
}
