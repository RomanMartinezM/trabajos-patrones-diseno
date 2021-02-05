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
public class PruebaSingletonClasico {
     public static void main(String[] args) {
       SingletonClasico instancia1 = SingletonClasico.getInstancia();
       System.out.println("Número de instancia creada después de instancia1: " + instancia1.numIns());
      
       SingletonClasico instancia2 = SingletonClasico.getInstancia();
       System.out.println("Número de instancia creada después de instancia2: " + instancia2.numIns());
        
       SingletonClasico instancia3 = SingletonClasico.getInstancia();
       System.out.println("Número de instancia creada después de instancia3: " + instancia3.numIns());
   }
}
