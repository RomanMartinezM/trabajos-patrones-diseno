/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

/**
 *
 * @author Edwin
 */
public class Ecuacion {
    int a,b,c;
    double dis,x1,x2;

   
    
    public String calcular(double a,double b,double c)
    {
       double r=(Math.pow(b, 2)-(4*a*c));
        dis=Math.sqrt(r);
        x1=((-1*b)-r)/(2*a);
        x2=((-1*b)+r)/(2*a);
        return String.format("La salucion de X1 es: %4.2f \n la solucion a X2 es: %4.2f",x1,x2);
        
        
    }
    
}
