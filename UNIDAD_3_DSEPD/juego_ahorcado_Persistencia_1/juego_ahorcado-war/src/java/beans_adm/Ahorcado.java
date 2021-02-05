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
    private ArrayList<Character> letras_aux;
    private ArrayList<String> posiciones;
    private ArrayList<Character> letrasabecedario;
    private ArrayList<Character> letras_descubiertas;
    private String palabra = "ABRACADABRA";    
    private String ida;
    private String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String guiones = "___________";
    private String usuario;
    private int intentos;
    private boolean hayintentos;
    private String mensaje;
    /**
     * Creates a new instance of Ahorcado
     */
    public Ahorcado() {
        mensaje="";
        hayintentos = false;
        usuario = "";
        intentos = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
        }
    }
    public void visualizar(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        posiciones.add(ida);       
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
                posicion = ka.toString()+pos;
                posiciones.add(posicion);
                //letras_descubiertas.set(pos,ka);
            }
        }
        
    }
    
    public void actualizar_letras(ActionEvent e){
        if (intentos > 0) {
                ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
                Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
                //int pos = -1;
               // for (int i = 0; i < palabra.length(); i++) {
                    if ((palabra.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra                
                        for (int j = 0; j < letras_aux.size(); j++) {
                            if (letras_aux.get(j).equals(ka)) {
                                 letras_descubiertas.set(j,ka);
                            }
                        }
                        letrasabecedario.remove(ka);
                    }else{
                        intentos--;
                    }
              //}
              
                    if (intentos == 0) {
                        hayintentos = true;
                        mensaje = "YA NO QUEDAN MÁS INTENTOS";
                    }
                    if (!letras_descubiertas.contains('_')) {
                         hayintentos = true;
                         mensaje = "¡JUEGO TERMINADO!";
                    }    
        }
    }
   
    public void reiniciar(){
        mensaje="";
        hayintentos = false;
        usuario = "";
        intentos = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
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

    public ArrayList<Character> getLetrasabecedario() {
        return letrasabecedario;
    }

    public void setLetrasabecedario(ArrayList<Character> letrasabecedario) {
        this.letrasabecedario = letrasabecedario;
    }

    public ArrayList<Character> getLetras_descubiertas() {
        return letras_descubiertas;
    }

    public void setLetras_descubiertas(ArrayList<Character> letras_descubiertas) {
        this.letras_descubiertas = letras_descubiertas;
    }

    public ArrayList<Character> getLetras_aux() {
        return letras_aux;
    }

    public void setLetras_aux(ArrayList<Character> letras_aux) {
        this.letras_aux = letras_aux;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean isHayintentos() {
        return hayintentos;
    }

    public void setHayintentos(boolean hayintentos) {
        this.hayintentos = hayintentos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
