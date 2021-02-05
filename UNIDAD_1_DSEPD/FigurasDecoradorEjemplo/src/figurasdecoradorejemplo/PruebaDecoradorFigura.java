/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasdecoradorejemplo;

/** 
 *
 * @author Martínez Mendoza Román
 */
public class PruebaDecoradorFigura {
     public static void main(String[] args) {
        Figura circulo = new Circulo(); 
        Figura circuloRojo = new FiguraRojaDecorador(new Circulo());
        Figura rectanguloRojo = new FiguraRojaDecorador(new Rectangulo());
        //System.out.println("Círculo con borde normal");
        circulo.dibujar();
        //System.out.println("\nCírculo de borde rojo");
        System.out.println("\n"); 
        circuloRojo.dibujar();  
        //System.out.println("\nRectágulo de borde rojo");
        System.out.println("\n");
        rectanguloRojo.dibujar();
        
        
    }
}
