/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_java;

/**
 *
 * @author lithium
 */
public class EcuacionCuadratica {
    private String solucion;
    private double a,b,c;
   
    public EcuacionCuadratica(){ //puede llevar como parametros los valores d elos elementos
            
    }
    public void setCoeficientes(double ca,double cb,double cc){
        a = ca;
        b = cb;
        c = cc;
    }
     public String getSolucion(){
        double x1,x2;
        double discriminante=(Math.pow(b, 2)-(4*a*c));
        
         if (discriminante < 0) {
             double discriminante_1 = -b/(2*a);
             discriminante=Math.sqrt(discriminante*-1)/(2*a);
             return String.format("%5.2f + i %5.2f \n %5.2f  - i %5.2f ",discriminante_1,discriminante,discriminante_1,discriminante);
         }
        //discriminante=Math.sqrt(discriminante);
        x1=((-1*b)-discriminante)/(2*a);
        x2=((-1*b)+discriminante)/(2*a);
        solucion = String.format("X1 = %5.2f \n  X2 = %5.2f",x1,x2);
        return solucion;
    }
    /*
    public String solucion(double ca,double cb,double cc){
        double discriminante=(Math.pow(cb, 2)-(4*ca*cc));
        discriminante=Math.sqrt(discriminante);
        x1=((-1*cb)-discriminante)/(2*ca);
        x2=((-1*cb)+discriminante)/(2*ca);
        solucion = String.format("X1 vale: %4.2f \n  X2 vale: %4.2f",x1,x2);
        return solucion;
    }
   */
}
