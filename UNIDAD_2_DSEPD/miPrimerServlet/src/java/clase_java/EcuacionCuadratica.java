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
    private double x1,x2;
    public EcuacionCuadratica(){ //puede llevar como parametros los valores d elos elementos
            
    }
    public void setCoeficiente(double ca,double cb,double cc){
        a = ca;
        b = cb;
        c = cc;
    }
    public String solucion(double ca,double cb,double cc){
        double discriminante=(Math.pow(cb, 2)-(4*ca*cc));
        discriminante=Math.sqrt(discriminante);
        x1=((-1*cb)-discriminante)/(2*ca);
        x2=((-1*cb)+discriminante)/(2*ca);
        solucion = String.format("X1 vale: %4.2f \n  X2 vale: %4.2f",x1,x2);
        return solucion;
    }
   
}
