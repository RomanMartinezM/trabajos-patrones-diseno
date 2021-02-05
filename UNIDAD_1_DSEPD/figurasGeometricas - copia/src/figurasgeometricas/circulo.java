/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

/**
 *
 * @author lithium
 */
public class circulo extends FigurasGeometricas {
   private final double pi = 3.1416;
   private double radio;
   private punto ubicacion;
   
    public circulo(punto ubicacion, double radio){
        super(ubicacion);
        this.ubicacion = ubicacion;
        this.radio= radio;
    }
       
    @Override
    public double area() {
        return Math.pow((pi*radio),2);
    }

    @Override
    public double perimetro() {
        return pi*(radio*radio);
    }

    @Override
    public void girar(char direccion) {
       System.out.println( "El círculo no gira a ningún lado");
     }
 
    @Override
    public void mostrar() {
         System.out.println( "El radio del círculo es: " + radio + 
         "\nEl área del círculo es: " + area() + "\nSu perimetro es: " + perimetro() + 
         "\nLas coordenadas de uno de sus puntos son: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")"); 
    }
    
}
