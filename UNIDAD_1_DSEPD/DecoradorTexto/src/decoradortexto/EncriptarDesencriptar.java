/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import static decoradortexto.Texto.bufer;
import java.io.IOException;
import java.util.Base64;

/**
 *
 * @author Roman
 */
public class EncriptarDesencriptar extends Decorador{//clase que toma el papel del "DecoradorConcretoB"
    private String password="";
    private String p="";
    
    public EncriptarDesencriptar(Texto text) {
        super(text);
    }
     @Override
    public void leer(String[] s){
        System.out.println("Dar password:   ");
        try {
           // p = bufer.readLine();
            byte[] encodedBytes4 = Base64.getEncoder().encode(bufer.readLine().getBytes());
            p = new String(encodedBytes4);
             System.out.println("password encriptado es:  " + p );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       byte[] encodedBytes2 = Base64.getEncoder().encode(s[0].getBytes());
 
        if (p.equals(password)){
            String des[] = new String[1];    
            System.out.println("TEXTO DESENCRIPTADO\n");    
            byte[] decodedBytes2 = Base64.getDecoder().decode(encodedBytes2);
            des[0] = new String(decodedBytes2);
            super.escribir(des);
              
        }else{
             System.out.println("PASSWORD INCORRECTO");
             System.out.println("TEXTO ENCRIPTADO\n");
                String enc[] = new String[1];
                enc[0]=new String(encodedBytes2);
                super.escribir(enc);
        }
    }
    @Override
    public void escribir(String[] s){
        System.out.println("Escribir el password:    ");
        try {
            //password = bufer.readLine();
            
            
            byte[] encodedBytes3 = Base64.getEncoder().encode(bufer.readLine().getBytes());
            password = new String(encodedBytes3);
            System.out.println("password encriptado es:  " + password );
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }
    
}
