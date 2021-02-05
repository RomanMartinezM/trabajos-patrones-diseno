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
public class BotonAyudaDecorador extends VentanaDecorador{//toma el papel de DecoradorConcretoB

    public BotonAyudaDecorador(Ventana decoradorVentana) {
        super(decoradorVentana); 
    } 
 
    @Override
    public void dibujar() {
        dibujarBotonAyuda();
        decoradorVentana.dibujar();//decoradorVentana.dibujar();
    }
  
    @Override
    public String getDescripcion() {
        return decoradorVentana.getDescripcion() + ", con botón de ayuda";
    }
    
    public void dibujarBotonAyuda() {
        System.out.println("Se dibuja el botón de ayuda");
    }

}      