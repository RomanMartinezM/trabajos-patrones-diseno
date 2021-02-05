/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoradortexto;

/**
 *
 * @author Roman
 */ 
public class PruebaDecorador {
    public static void main(String[] args) {
        String linea[] = {new String()};
        Texto tb = new TextoBase();
        tb.leer(linea);
        
        
        Texto autenticar = new Autenticar(tb);
        autenticar.escribir(linea);
        autenticar.leer(linea);
        
        System.out.println("--------------------\n");
        Texto encDesenc = new EncriptarDesencriptar(tb);
        encDesenc.escribir(linea);
        encDesenc.leer(linea);
        
        System.out.println("--------------------\n");
        Texto reemplazar = new Reemplazar(tb);
        reemplazar.escribir(linea);
        reemplazar.leer(linea);
        
        Texto archivar = new Archivar(tb);
        archivar.escribir(linea);
        archivar.leer(linea);
    }
}
