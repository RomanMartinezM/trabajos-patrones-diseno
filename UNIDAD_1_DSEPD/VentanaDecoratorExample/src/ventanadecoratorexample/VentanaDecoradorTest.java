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
public class VentanaDecoradorTest {
     public static void main(String[] args) {
         Ventana decoradorVentana = new BotonAyudaDecorador(new BordeDecorador(new VentanaConcreta()));
         System.out.println(decoradorVentana.getDescripcion());
         decoradorVentana.dibujar();
         
     }
}
