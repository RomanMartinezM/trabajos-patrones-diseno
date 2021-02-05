/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import static decoradortexto.Texto.bufer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class Reemplazar extends Decorador{//clase que toma el papel del "DecoradorConcretoC"
    private String password="";
    private String p="";
    private String nuevoTexto="";
    
    public Reemplazar(Texto text) {
        super(text);
    }
     @Override
    public void leer(String[] s){
        System.out.println("Dar password:   ");
        try {
            p = bufer.readLine();
            //s[0]  = p;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (p.equals(password)){ 
            
            System.out.println("INTRODUZCA EL NUEVO TEXTO");
     
            super.leer(s);
            //s[0] = nuevoTexto;
            System.out.println("NUEVO TEXTO");
            super.escribir(s);
            
            
        }else{
            System.out.println("PASSWORD INCORRECTO");
            System.out.println("NO SE PUEDE CAMBIAR EL TEXTO");
            super.escribir(s);
        }
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
