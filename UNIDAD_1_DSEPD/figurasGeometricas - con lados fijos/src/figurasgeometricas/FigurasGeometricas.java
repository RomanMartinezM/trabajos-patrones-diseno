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
public abstract class FigurasGeometricas {
     protected double lado_1;
     protected double lado_2;
     protected double lado_3;
     protected punto ubicacion;
     protected FormaCalArea calArea;
     protected FormaCalPerimetro calPerimetro;

     public FigurasGeometricas(double lado_1, double lado_2, punto ubicacion){
        this.lado_1 = lado_1;
        this.lado_2 = lado_2;
        this.ubicacion = ubicacion; 
    } 
      public FigurasGeometricas(double lado_1, double lado_2,double lado_3, punto ubicacion){
        this.lado_1 = lado_1;
        this.lado_2 = lado_2;
        this.lado_3 = lado_3;
        this.ubicacion = ubicacion; 
    } 

    public double getLado_1() {
        return lado_1;
    }

    public double getLado_2() {
        return lado_2;
    }

    
    public void setLado_1(double lado_1) {
        this.lado_1 = lado_1;
    }

    public void setLado_2(double lado_2) {
        this.lado_2 = lado_2;
    }
    
    public double area(){  
        double l1=lado_1;
        double l2=lado_2;
        return calArea.area(l1, l2);
    }
    public double perimetro(){
        double l1=lado_1;
        double l2=lado_2;
        return calPerimetro.perimetro(l1, l2);
    }
    public abstract void girar(char direccion);
    public abstract void mostrar(); 
     
    public void trasladar(punto p,double posX, double posY){
       p.setX(p.getX()+posX); 
       p.setY(p.getY()+posY);
       System.out.println("traslacion: " + "(" + p.getX() + ", " + p.getY() + ")" );
       
    }
    public void escalar(double proporcion){
        ubicacion.setX(ubicacion.getX()*proporcion);
        ubicacion.setY(ubicacion.getY()*proporcion);
        System.out.println("escala: " + "(" + ubicacion.getX() + ", " + ubicacion.getY() + ")" ); 
    } 
} 