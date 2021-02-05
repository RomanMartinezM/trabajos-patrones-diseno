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
   
    public circulo(double r1, double r2,punto ubicacion){
        super(r1,r2,ubicacion);
        
        super.calArea = new CalAreaCirculo();
        super.calPerimetro = new CalPerimetroCirculo();
        
    }
 
    @Override
    public void girar(char direccion) {
       System.out.println( "El círculo no gira a ningún lado");
     }
 
    @Override
    public void mostrar() {
         System.out.println( "\nCÍRCULO \nSu radio es: " +super.getLado_1()+ 
         "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")" );
    }
    
}
