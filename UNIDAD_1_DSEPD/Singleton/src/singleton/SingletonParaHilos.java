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
public class SingletonParaHilos {
    private static volatile SingletonParaHilos instance = null;
    private static int ni=0;
    //private constructor
    private SingletonParaHilos(){
        ni++;
    }
    public static SingletonParaHilos getInstance(){
        if(instance == null){
            synchronized (SingletonParaHilos.class){
                //doble verificación
                if(instance == null){
                    instance = new SingletonParaHilos();
                    ni++;
                }
            }
            
        }
        return instance;
    }
    public static int nins(){
        return ni;
    }
}
