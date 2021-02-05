/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanadecoratorexample;

/**
 *
 * @author Roman
 */
public abstract class VentanaDecorador implements Ventana{//toma el papel de Decorador
    protected Ventana decoradorVentana;
    
    public VentanaDecorador(Ventana decoraVentana){
        this.decoradorVentana = decoraVentana;
    } 
}
