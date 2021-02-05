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
    private ArrayList<String> posiciones;
    private String palabra = "ABRACADABRA";    
    private String ida;
    /**
     * Creates a new instance of Ahorcado
     */
    public Ahorcado() {
        posiciones = new ArrayList();
        
        ida = new String("");
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
    }
    
    public void actualizar(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
        int pos = -1;
        String posicion = "";
        //posiciones.add(ida);
        
        for (int i = 0; i < palabra.length(); i++) {
            if ((pos = letras.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra
            //"pos = letras.indexOf(ka)" regresa la posición de la letra a la que se le dió click
                letras.set(pos, '_');
               // letras_descubiertas.set(pos,ka);
               posicion = ka.toString()+pos;
               posiciones.add(posicion);
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
    
    //EJERCICIO A HACER: MOSTRAR EL VALOR DE "metadato.index" en "juego.xhtml"
    
    //EJERCICIO 2: PONER EL NOMBRE DEL PARTICIPANTE, EL NUMERO DE INTENTOS TOTALES, LOS INTENTOS REALIZADOS Y LOS INTENTOS RESTANTES

    public ArrayList<String> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<String> posiciones) {
        this.posiciones = posiciones;
    }
    
 
    
}
