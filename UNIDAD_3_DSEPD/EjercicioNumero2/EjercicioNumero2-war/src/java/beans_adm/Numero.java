/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author lithium
 */
@Named(value = "numero")
@SessionScoped
public class Numero implements Serializable {
    private int numeroa;
    private int numero;
    private int vMax;
    private int vMin;
    private String mensaje="";
    
    /**
     * Creates a new instance of Numero
     */
    public Numero() {
        vMax = 100;
        vMin = 1;
        Random na = new Random();
        numero = na.nextInt(vMax)+1;
    }
    public void amensaje(){
        if(numeroa > numero)
            mensaje = "Debe ser un valor menor";
        else if(numeroa < numero)
            mensaje = "Debe ser un valor mayor";
        else
            mensaje = "ACERTASTE";   
    }
    
    public int getNumeroa(){
        return numeroa;
    }
    public void setNumeroa(int numeroa){
        this.numeroa = numeroa;
    }
    public int getvMax(){
        return vMax;
    }
    public void setvMax(int vMax){
        this.vMax = vMax;
    }
    public int getvMin(){
        return vMin;
    }
    public void setvMin(int vMin){
        this.vMin = vMin;
    }
    public String getMensaje(){
        return mensaje;
    }
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
