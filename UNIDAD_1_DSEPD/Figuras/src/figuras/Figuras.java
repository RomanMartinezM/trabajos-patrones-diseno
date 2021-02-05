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
public class Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Punto p=new Punto(3,1);
        Rectangulo r=new Rectangulo(5,5,p);
        System.out.println(r.mostrar());
        Triangulo t=new Triangulo(7,5,p);
        System.out.println(t.mostrar());
        Circulo c=new Circulo(5,0,p);
        System.out.println(c.mostrar());
    }   
}
