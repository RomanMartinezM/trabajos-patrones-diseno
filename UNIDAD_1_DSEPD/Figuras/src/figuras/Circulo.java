/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author Edwin
 */
public class Circulo extends FigurasGeometricas {

    public Circulo(double lado1, double lado2, Punto ubicacion) {
        super(lado1, lado2, ubicacion);
    }
    public double Area()
    {
        double areaf;
        areaf=Math.pow((3.1416*lado1),2);
        return areaf;
    }
    public double Perimetro()
    {
        double peri;
        peri=3.1416*(lado1*lado1);
        return peri;
    }
    public String mostrar()
    {
        return super.mostrar();
        //return "El area es: "+Area();
    }
    
}
