/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodatos;

/**
 *
 * @author Roman Martinez Mendoza
 */
public class Procesos { 
    public static void main(String[] args) {
        ProcesoDatos pd = new ProcesoDatos();
        Thread h1 = new Thread(pd);
        Thread h2 = new Thread(pd);
        Thread h3 = new Thread(pd);
        
        
        h1.start();
        h2.start();
        h3.start();
        
        
    }
}
