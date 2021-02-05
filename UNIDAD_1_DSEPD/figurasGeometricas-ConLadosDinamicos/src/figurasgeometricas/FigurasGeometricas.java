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

     protected double lados[];
     protected punto ubicacion;
     protected FormaCalArea calArea;
     protected FormaCalPerimetro calPerimetro;

     public FigurasGeometricas(double lados[], punto ubicacion){
        this.lados = lados;
        this.ubicacion = ubicacion; 
    } 
  
    public double[] getLados() {
        return lados;
    }
    public void setLados(double[] lados) {
        this.lados = lados;
    }
    
    public double CalculoArea(){  
        double Numlados[]=lados;
        return calArea.area(Numlados);
        
    }
    
    public double CalculoPerimetro(){
        double Numlados[]=lados;
        return calPerimetro.perimetro(Numlados);
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