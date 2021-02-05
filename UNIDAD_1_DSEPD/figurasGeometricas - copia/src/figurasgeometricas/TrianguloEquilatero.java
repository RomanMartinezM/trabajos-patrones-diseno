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
public class TrianguloEquilatero extends FigurasGeometricas{
  
   private double base; 
   private double altura;
   private punto ubicacion;

   public TrianguloEquilatero(punto ubicacion, double base, double altura){
        super(ubicacion); 
        this.ubicacion = ubicacion;
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double area() {
      return (base * altura)/2;
    }

    @Override
    public double perimetro() { 
       return (base*3);
    }

    @Override
    public void girar(char direccion) {
        double aux_X = ubicacion.getX();
        if(direccion == 'I'){
            ubicacion.setX(ubicacion.getY());
            ubicacion.setY(aux_X);
            System.out.println( "El triángulo gira a la izquierda: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")");
        }  
        if(direccion == 'D'){
            ubicacion.setX(ubicacion.getY());
            ubicacion.setY(aux_X);
            System.out.println( "El triángulo gira a la derecha: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")");
        }
    } 

    @Override
    public void mostrar() {
         System.out.println( "La base del triángulo equilatero es: " +base+ " y su altura es: " + altura + 
         "\nEl área del triángulo equilatero es: " + area() + "\nSu perimetro es: " + perimetro() + 
         "\nLas coordenadas de uno de sus puntos son: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")"); 
    }
}
