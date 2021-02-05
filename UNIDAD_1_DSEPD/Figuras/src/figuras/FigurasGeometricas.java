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
public abstract class FigurasGeometricas {
    public double lado1;
    public double lado2;
    public double perimetro;
    public double area;
    public Punto ubicacion;
public FigurasGeometricas(double lado1, double lado2, Punto ubicacion) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.ubicacion = ubicacion;
    }
public double Perimetro()
{
    
    perimetro=lado1+lado2;
    return perimetro;
}    
public double Area()
{
    
    area=lado1*lado2;
    return area;
}
//tipos de entorno de desarrollo,plataformas de desarrollo web,fremwords lado cliente, desarrollo
public void Mover()
{
    double ladox;
    double ladoy;
    
    
}
public String mostrar()
{
    return "El area de la figura es: "+Area()+" ,su perimetro es: "+Perimetro()+
            " Punto de ubicacio X: "+ubicacion.getX()+" Punto de ubicacio Y: "+ubicacion.getY();
}

}
