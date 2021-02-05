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
  
   
   public Elipse(double r1, double r2, punto ubicacion){
        super(r1,r2,ubicacion); 
       
        super.calArea = new CalAreaElipse();
        super.calPerimetro = new CalPerimetroCirculo();
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
         System.out.println( "\nELIPSE \nSu radio menor es: " +super.getLado_1()+ " y su radio mayor es: " + super.getLado_2() + 
         "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")" );
    }
    

    
}
