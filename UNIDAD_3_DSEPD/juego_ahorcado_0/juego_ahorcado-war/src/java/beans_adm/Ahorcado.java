/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author lithium
 */
@Named(value = "ahorcado")
@ApplicationScoped
public class Ahorcado implements Serializable{
    private ArrayList<Character> letras;
    private ArrayList<Character> letras_descubiertas;
    
    private ArrayList<String> posiciones;
             
    private ArrayList<Character> letrasabecedario;
    private ArrayList<Character> guiones_letras;
    
    private String palabra = "ABRACADABRA";
 
    
    private String ida;
    private String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String guiones = "_-_-_-_-_-_-_-_-_-_-_";
    private String vacio = "___________";
    private String vacio_pos = "           ";
    /**
     * Creates a new instance of Ahorcado
     */
    public Ahorcado() {
        posiciones = new ArrayList();
       
        
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < vacio.length(); i++) {
            letras_descubiertas.add(vacio.charAt(i));
        }
        
        ida = new String("");
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        }
        
         
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        /*
        guiones_letras = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            guiones_letras.add(guiones.charAt(i));
        }
        */
        
    }
    
    public void actualizar(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
        int pos = -1;
        posiciones.add(ida);
        
        for (int i = 0; i < palabra.length(); i++) {
            if ((pos = letras.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra
            //"pos = letras.indexOf(ka)" regresa la posición de la letra a la que se le dió click
                letras.set(pos, '_');
                letras_descubiertas.set(pos,ka);
                
                //EJERICICIO: MOSTRAR EL VALOR DE "ida" en la pantalla cada vez que se de click en una letra y además, mostrar las letras que van siendo sustituidas por un "_"
            }
        }
        
       
    }
    public void actualizar_letras(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
        int pos = -1;
        int posAux = 0;
        for (int i = 0; i < letrasabecedario.size(); i++) {
            if ((pos = palabra.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra
                letrasabecedario.remove(ka);
                //letras.set(pos, '_');
                /*
                if (pos == 0) {
                    guiones_letras.set(pos, ka);
                }else{
                    posAux = pos + pos;
                    guiones_letras.set(posAux, ka);
                }*/
            }
        }

    }
    

    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }

    public ArrayList<Character> getLetras_descubiertas() {
        return letras_descubiertas;
    }

    public void setLetras_descubiertas(ArrayList<Character> letras_descubiertas) {
        this.letras_descubiertas = letras_descubiertas;
    }
    
    

    public ArrayList<Character> getLetrasabecedario() {
        return letrasabecedario;
    }

    public void setLetrasabecedario(ArrayList<Character> letrasabecedario) {
        this.letrasabecedario = letrasabecedario;
    }
    
    
    
    //EJERCICIO A HACER: MOSTRAR EL VALOR DE "metadato.index" en "juego.xhtml"
    
    //EJERCICIO 2: PONER EL NOMBRE DEL PARTICIPANTE, EL NUMERO DE INTENTOS TOTALES, LOS INTENTOS REALIZADOS Y LOS INTENTOS RESTANTES

   
    public ArrayList<Character> getLineas() {
        return guiones_letras;
    }

    public void setLineas(ArrayList<Character> guiones_letras) {
        this.guiones_letras = guiones_letras;
    }

    public ArrayList<String> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<String> posiciones) {
        this.posiciones = posiciones;
    }
    
 
    
}
