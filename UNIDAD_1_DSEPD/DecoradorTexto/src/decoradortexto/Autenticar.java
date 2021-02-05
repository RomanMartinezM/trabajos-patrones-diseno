/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class Autenticar extends Decorador{//clase que toma el papel del "DecoradorConcretoA"
    private String password="";
    private String p="";
    
    public Autenticar(Texto text) {
        super(text);
    }
    @Override
    public void leer(String[] s){
        System.out.println("Dar password:   ");
        try {
            p = bufer.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (p.equals(password)) 
            super.escribir(s);
        else
            System.out.println("PASSWORD INCORRECTO");
    }
    @Override
    public void escribir(String[] s){
        System.out.println("Escribir el password:    ");
        try {
            password = bufer.readLine();
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }
}
