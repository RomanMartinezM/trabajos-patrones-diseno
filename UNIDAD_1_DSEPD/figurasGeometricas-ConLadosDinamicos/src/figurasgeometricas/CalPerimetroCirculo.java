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
public class CalPerimetroCirculo implements FormaCalPerimetro{
    private final double pi = 3.1416;
   
    @Override
    public double perimetro(double[] lados) {
        return (2*pi*lados[0]);
    }
    
}