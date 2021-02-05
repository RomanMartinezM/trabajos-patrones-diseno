/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdecorador;

/**
 *
 * @author lithium
 */
public class pruebaReloj {
     public static void main(String[] args) { 

         System.out.println("----------------Reloj CONCRETO");
         Reloj reloj = new RelojC();
         reloj.fijarHora(2, 10);
         reloj.mostrar();
         reloj.mostrarDia();
         reloj.activar();
         reloj.mostrar();
         reloj.mostrarDia();
         
         System.out.println("----------------Reloj DESPERTADOR");
         reloj = new Despertador(reloj);
         reloj.fijarHora(25, 59);
         reloj.mostrar();
         reloj.mostrarDia();
         reloj.activar();
         reloj.mostrar();
         reloj.mostrarDia();
         
     }
}
