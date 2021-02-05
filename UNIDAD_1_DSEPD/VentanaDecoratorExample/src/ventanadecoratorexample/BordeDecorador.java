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
public class BordeDecorador extends VentanaDecorador{//toma el papel de DecoradorConcretoA

    public BordeDecorador(Ventana decoradorVentana) {
        super(decoradorVentana);
    }

    @Override
    public void dibujar() {
        dibujarBorde();
        decoradorVentana.dibujar();
    }

    @Override
    public String getDescripcion() {
        return decoradorVentana.getDescripcion() + ", con borde";
    }
    
    public void dibujarBorde(){
        System.out.println("Se dibuja el borde de la ventana");
    }
        
}
