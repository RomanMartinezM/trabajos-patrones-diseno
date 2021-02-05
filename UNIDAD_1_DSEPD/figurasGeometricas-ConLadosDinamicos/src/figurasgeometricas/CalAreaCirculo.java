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
public class CalAreaCirculo implements FormaCalArea{
    private final double pi = 3.1416;

    @Override
    public double area(double[] lados) {
        return Math.pow((pi*lados[0]),2);
    }

   
}
