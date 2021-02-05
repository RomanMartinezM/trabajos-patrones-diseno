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
public class CalPerimetroTriangulo implements FormaCalPerimetro{

    @Override 
    public double perimetro(double[] lados) {
        return (lados[0]+lados[1]+lados[2]);
    }
    
}
