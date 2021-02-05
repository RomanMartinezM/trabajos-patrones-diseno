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
   private double base;
   private double altura;
   private punto ubicacion;
   
   public rectangulo(punto ubicacion, double base, double altura){
        super(ubicacion);
        this.ubicacion = ubicacion;
        this.base = base;
        this.altura = altura;
    }
   /* 
   public rectangulo(double lado_1, double lado_2, double x, double y){
        super(lado_1, lado_2, x, y);
        base = lado_1;
        altura = lado_2;
    }
    */
    @Override
    public double area() {
        return  base * altura;
    }

    @Override
    public double perimetro() {
        return ((base*2) + (altura*2));
    }

    @Override
    public void girar(char direccion) {
        double aux_X = ubicacion.getX();
        if(direccion == 'I'){
            ubicacion.setX(ubicacion.getY());
            ubicacion.setY(aux_X);
            System.out.println( "El rectangulo gira a la izquierda: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")");
        } 
        if(direccion == 'D'){
            ubicacion.setX(ubicacion.getY());
            ubicacion.setY(aux_X);
            System.out.println( "El rectangulo gira a la derecha: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")");
        
        }
    }

    @Override
    public void mostrar() {
         System.out.println( "La base del rectángulo es: " +base+ " y su altura es: " + altura + 
         "\nEl área del rectángulo es: " + area() + "\nSu perimetro es: " + perimetro() + 
         "\nLas coordenadas de uno de sus puntos son: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")"); 
    }
    
}
