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
        
        rectangulo r=new rectangulo(p,3,7);
        r.mostrar();
        r.girar('I');
        r.trasladar(p, 2, 2);
        r.escalar(3);
        
        punto p1 = new punto(2, 5);
        TrianguloEquilatero t=new TrianguloEquilatero(p1,2,3);
        t.mostrar();
        t.girar('D');
        t.trasladar(p1, 2, 2); 
        t.escalar(3);
        
        punto p2 = new punto(6, 7);
        circulo c=new circulo(p2,3);
        c.mostrar();
        c.girar('D');
        c.trasladar(p2, 3, 3);
        c.escalar(2);
     }
     
}
