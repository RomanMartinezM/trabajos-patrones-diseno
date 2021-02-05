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
public class RomboRegular extends FigurasGeometricas{

    public RomboRegular(double diametroMenor , double diametroMayor, punto ubicacion){
        super(diametroMenor,diametroMayor,ubicacion);
      
        super.calArea = new CalAreaTriangulo();
        super.calPerimetro = new CalPerimetroParaCuaRec();
    }
    
    @Override
    public void girar(char direccion) {
        double aux_X = super.ubicacion.getX();
        if(direccion == 'I'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El rombo regular gira a la izquierda: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        } 
        if(direccion == 'D'){
            super.ubicacion.setX(super.ubicacion.getY());
            super.ubicacion.setY(aux_X);
            System.out.println( "El rombo regular gira a la derecha: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")");
        
        }
    }

    @Override
    public void mostrar() {
          System.out.println( "\nROMBO REGULAR \nSu diametro menor es: " +super.getLado_1()+ " y su diametro mayor es: " + super.getLado_2() + 
         "\nLas coordenadas de su ubicacion son: " + "(" + super.ubicacion.getX() + ", " + super.ubicacion.getY() + ")" ); 
    }
    
}
