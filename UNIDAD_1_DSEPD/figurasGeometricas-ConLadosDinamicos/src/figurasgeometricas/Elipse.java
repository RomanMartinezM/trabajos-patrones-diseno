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
public class Elipse extends FigurasGeometricas{

   public Elipse(double lados[],punto ubicacion){
        super(lados,ubicacion);
        super.calArea = new CalAreaElipse();
        super.calPerimetro = new CalPerimetroElipse();
        
    }
           
    @Override
    public void girar(char direccion) { 
        double aux_X = super.ubicacion.getX();
        if(direccion == 'I'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "La elipse gira a la izquierda: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        } 
        if(direccion == 'D'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "La elipse gira a la derecha: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        
        }
    }

    @Override
    public void mostrar() {
         System.out.println( "\nELIPSE \nSu radio menor es: " +super.lados[0]+ " y su radio mayor es: " + super.lados[1] + 
         "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
    }
    
}
