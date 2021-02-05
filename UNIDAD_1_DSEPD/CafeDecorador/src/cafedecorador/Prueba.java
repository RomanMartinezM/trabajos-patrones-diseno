/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafedecorador;

/**
 *
 * @author Román Martínez Mendoza
 */
public class Prueba {
    public static void main(String[] args) { 
          
         Cafe cafe = new CafeSolo();
         System.out.println("bebida " + cafe.ingredientes()+ " $ " + cafe.costo());
         cafe = new Crema(cafe); 
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         cafe = new Canela(cafe);
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
  //       cafe = new Leche(cafe);
//         System.out.println("bebida "+ cafe.ingredientes() + " $ " + cafe.costo());
         
     /*
        Cafe cafe = new Canela(new Crema(new Leche(new CafeSolo())));
        System.out.println("Bebida " + cafe.ingredientes() + " $" + cafe.costo()); 
        cafe = new Crema(cafe);
        System.out.println("\nBebida " + cafe.ingredientes() + " $" + cafe.costo()); 
        CafeDecorador cafDecorador = new Canela(cafe);
        System.out.println("\nBebida " + cafe.ingredientes() + " $" + cafe.costo()); 
   */
    }
}
