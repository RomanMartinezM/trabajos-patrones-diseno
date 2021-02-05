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
public class Rectangulo extends FigurasGeometricas {

    public Rectangulo(double lado1, double lado2, Punto ubicacion) {
        super(lado1, lado2, ubicacion);
    }
    @Override
    public double Area()
    {
        return super.Area();
    }
    public double Perimetro()
    {
        double peri;
        peri=(super.Perimetro()+lado1+lado2);
        return peri;
    }
    public String mostrar()
    {
        return super.mostrar();
    }
    
}
