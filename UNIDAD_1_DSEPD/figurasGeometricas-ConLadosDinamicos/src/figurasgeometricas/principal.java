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
         
        punto p = new punto(3, 4); 
        double ladosR[] = {4,6};
        FigurasGeometricas fg = new rectangulo(ladosR,p);
        fg.mostrar();
        System.out.println("Área rectángulo: " + fg.CalculoArea());
        System.out.println("Perimetro rectángulo: " + fg.CalculoPerimetro());
        fg.girar('I');
        fg.trasladar(p, 2, 2);
        fg.escalar(3);
        
        
        punto p0 = new punto(3, 3); 
        double ladosCu[] = {4,4};
        fg = new Cuadrado(ladosCu,p0);
        fg.mostrar();
        System.out.println("Área cuadrado: " + fg.CalculoArea());
        System.out.println("Perimetro cuadrado: " + fg.CalculoPerimetro());
        fg.girar('I');
        fg.trasladar(p0, 2, 2);
        fg.escalar(3);
        
        punto p1 = new punto(3, 6); 
        double ladosP[] = {3,7};
        fg = new Paralelogramo(ladosP,p1);
        fg.mostrar();
        System.out.println("Área paralelogramo: " + fg.CalculoArea());
        System.out.println("Perimetro paralelogramo: " + fg.CalculoPerimetro());
        fg.girar('I');
        fg.trasladar(p1, 2, 2);
        fg.escalar(2);

        
        punto p2 = new punto(2, 5);
        double ladosTE[] = {3,3,3};
        fg = new TrianguloEquilatero(ladosTE,p2);
        fg.mostrar();
        System.out.println("Área triángulo equilatero: " + fg.CalculoArea());
        System.out.println("Perimetro triángulo equilatero: " + fg.CalculoPerimetro());
        fg.girar('D');
        fg.trasladar(p2, 2, 2); 
        fg.escalar(3);
        
        punto p3 = new punto(2, 5); 
        double ladosTR[] = {2,5,7};
        fg = new TrianguloRectangulo(ladosTR,p3);
        fg.mostrar();
        System.out.println("Área triángulo rectángulo: " + fg.CalculoArea());
        System.out.println("Perimetro triángulo rectángulo: " + fg.CalculoPerimetro());
        fg.girar('D');
        fg.trasladar(p3, 2, 2); 
        fg.escalar(3);
        
        
        punto p4 = new punto(6, 7);
        double ladosCi[] = {4};       
        fg = new circulo(ladosCi,p4);
        fg.mostrar();
        System.out.println("Área círculo: " + fg.CalculoArea());
        System.out.println("Perimetro círculo: " + fg.CalculoPerimetro());
        fg.girar('D');
        fg.trasladar(p4, 3, 3);
        fg.escalar(2);
        
        punto p5 = new punto(6, 7);
        double ladosEli[] = {3,6};
        fg = new Elipse(ladosEli,p5);
        fg.mostrar();
        System.out.println("Área elipse: " + fg.CalculoArea()); 
        System.out.println("Perimetro elipse: " + fg.CalculoPerimetro());
        fg.girar('D'); 
        fg.trasladar(p5, 3, 3);
        fg.escalar(2);

        
        punto p6 = new punto(6, 7);
        double ladosRom[] = {3,6};
        fg = new RomboRegular(ladosRom,p6);
        fg.mostrar();
        System.out.println("Área rombo: " + fg.CalculoArea()); 
        System.out.println("Perimetro rombo: " + fg.CalculoPerimetro());
        fg.girar('D'); 
        fg.trasladar(p6, 3, 3);
        fg.escalar(2);
        
     }
     
}
