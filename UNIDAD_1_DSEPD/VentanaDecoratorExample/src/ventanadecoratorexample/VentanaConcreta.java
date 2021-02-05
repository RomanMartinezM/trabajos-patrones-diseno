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
public class VentanaConcreta implements Ventana{//toma el papel de ComponenteConcreto

    @Override
    public void dibujar() {
        System.out.println("Se dibuja ventana simple");
    }

    @Override
    public String getDescripcion() {
        return "Ventana simple";
    }
    
}
