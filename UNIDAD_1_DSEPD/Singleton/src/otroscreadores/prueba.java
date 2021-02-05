/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otroscreadores;

/**
 *
 * @author lithium
 */
public class prueba {
    public static void main(String[] args) {
        otroCreador otroC = new otroCreador();   
        System.out.println("instancia 1: " + otroC.numIns());
        
        otroCreador otroC1 = new otroCreador();   
        System.out.println("instancia 2: " + otroC1.numIns());
       
        otroCreador otroC2 = new otroCreador();   
        System.out.println("instancia 3: " + otroC2.numIns());
        
    }
}
