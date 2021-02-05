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
public class TrianguloRectangulo extends FigurasGeometricas{
   public TrianguloRectangulo(double lados[], punto ubicacion){
        super(lados,ubicacion);
        super.calArea = new CalAreaTriangulo();
        super.calPerimetro = new CalPerimetroTriangulo();
    }
           
    @Override
    public void girar(char direccion) {
        double aux_X = super.ubicacion.getX();
        if(direccion == 'I'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El triángulo rectángulo gira a la izquierda: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        }  
        if(direccion == 'D'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El triángulo rectángulo gira a la derecha: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        }
    } 

    @Override
    public void mostrar() {
         System.out.println( "\nTRIÁNGULO RECTÁNGULO \nSu lado 1 es: " +super.lados[0]+ ", su lado 2 es: " + super.lados[1] + 
         " y su lado 3 es: " + super.lados[2] + "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + 
         super.ubicacion.getY() + ")");
    }
    
    
}
