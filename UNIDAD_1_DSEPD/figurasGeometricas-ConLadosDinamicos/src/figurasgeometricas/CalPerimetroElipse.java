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
public class CalPerimetroElipse implements FormaCalPerimetro{
    private final double pi = 3.1416;
  
    @Override
    public double perimetro(double[] lados) {
          return  2*pi*Math.pow(((Math.pow(lados[0],2) + Math.pow(lados[1],2))/2),1/2);
    }
}
