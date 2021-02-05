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
public class rectangulo extends FigurasGeometricas{
  
   public rectangulo(double base, double altura, punto ubicacion){
        super(base,altura,ubicacion);
        
        super.calArea = new CalAreaParaCuaRec();
        super.calPerimetro = new CalPerimetroParaCuaRec();
    }
   
    @Override
    public void girar(char direccion) {
        double aux_X = super.ubicacion.getX();
        if(direccion == 'I'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El rectangulo gira a la izquierda: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        } 
        if(direccion == 'D'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El rectangulo gira a la derecha: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        
        }
    }

    @Override
    public void mostrar() {
         System.out.println( "\nRECTÁNGULO \nSu base es: " +super.getLado_1()+ " y su altura es: " + super.getLado_2() + 
         "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")"); 
    }
    
}
 