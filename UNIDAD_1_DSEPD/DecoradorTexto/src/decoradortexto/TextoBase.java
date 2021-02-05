/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class TextoBase extends Texto{//clase que toma el papel del "ComponenteConcreto"
    public TextoBase(){
        bufer = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void escribir(String[] s) {
        System.out.println("El texto es:     " + s[0]);
    }

    @Override
    public void leer(String[] s) {
        System.out.println("Introduce un texto:     ");
        try {
            s[0] = bufer.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
 