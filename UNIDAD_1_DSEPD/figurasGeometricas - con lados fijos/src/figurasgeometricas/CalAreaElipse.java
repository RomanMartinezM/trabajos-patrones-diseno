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
public class CalAreaElipse implements FormaCalArea{
    private final double pi = 3.1416;
    @Override
    public double area(double r1, double r2) {
        return (pi*r1*r2);
    }
}
