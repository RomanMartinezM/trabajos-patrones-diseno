/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodirectiva;

/**
 *
 * @author Roman
 */
public class Operaciones {
    private double x;
    private double y;
    
     public Operaciones(){
         
     }
  
    public String elevarX_a_la_Y(double vx, double vy){
        double xy = 0.0;
        x = vx;
        y = vy;
        xy = Math.pow(x, y);
        return String.format("%4.2f elevado a la %4.2f es %4.2f",x,y,xy);
    }
    public String multiplicarX_por_Y(double vx, double vy){
        double resultado = 0.0;
        x = vx;
        y = vy;
        resultado = x*y;
        return String.format("%4.2f multiplicado por %4.2f es %4.2f",x,y,resultado);
    }
    public String raizCuadradaX_Y(double vx, double vy){
        double resultadoX = 0.0;
        double resultadoY = 0.0;
        
        x = vx;
        y = vy;
        resultadoX = Math.sqrt(x);
        resultadoY = Math.sqrt(y);
        
        return String.format("La raíz cuadrada de %4.2f es %4.2f y la raíz cuadrada de %4.2f es %4.2f",x,resultadoX,y,resultadoY);
    }
    
}
