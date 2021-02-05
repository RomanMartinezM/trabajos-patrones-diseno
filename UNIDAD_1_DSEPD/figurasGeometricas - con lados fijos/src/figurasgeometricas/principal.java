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
public class principal {
     public static void main(String[] args) {
        
        System.out.println("----------------------------------------------------------------");
        punto p = new punto(3, 4); 
        FigurasGeometricas fg = new rectangulo(4,6,p);
        fg.mostrar(); 
        fg.girar('I');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p, 2, 2);
        fg.escalar(3);
        
        System.out.println("----------------------------------------------------------------");
        punto p0 = new punto(3, 3); 
        fg = new Cuadrado(4,4,p0);
        fg.mostrar();
        fg.girar('I'); 
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p0, 2, 2);
        fg.escalar(3);
        
        System.out.println("----------------------------------------------------------------");
        punto p1 = new punto(3, 6); 
        fg = new Paralelogramo(2,5,p1);
        fg.mostrar();
        fg.girar('I');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p1, 2, 2);
        fg.escalar(2);

        
        System.out.println("----------------------------------------------------------------");
        punto p2 = new punto(2, 5);
        fg = new TrianguloEquilatero(3,3,p2);
        fg.mostrar();
        fg.girar('D');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p2, 2, 2); 
        fg.escalar(3);
        
        System.out.println("----------------------------------------------------------------");
        punto p3 = new punto(2, 5);
        fg = new TrianguloRectangulo(2,4,p3);
        fg.mostrar();
        fg.girar('D');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p3, 2, 2); 
        fg.escalar(3);
        
        System.out.println("----------------------------------------------------------------");
        punto p4 = new punto(6, 7);
        fg = new circulo(3,3,p4);
        fg.mostrar();
        fg.girar('D');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p4, 3, 3);
        fg.escalar(2);
        
        System.out.println("----------------------------------------------------------------");
        punto p5 = new punto(6, 7);
        fg = new Elipse(4,4,p5);
        fg.mostrar(); 
        fg.girar('D');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p5, 3, 3);
        fg.escalar(2);
        
        System.out.println("----------------------------------------------------------------");
        punto p6 = new punto(4, 6);
        fg = new RomboRegular(4,4,p6);
        fg.mostrar();
        fg.girar('D');
        System.out.println("area: " + fg.area());
        System.out.println("perimetro: " + fg.perimetro());
        fg.trasladar(p6, 3, 3); 
        fg.escalar(2);
     }
     
}
