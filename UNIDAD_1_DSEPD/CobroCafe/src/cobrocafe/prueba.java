/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrocafe;

/**
 *
 * @author Anselmo Lorenzo Olivera
 */
public class prueba {
     public static void main(String[] args) { 
         Cafe cafe = new CafeSolo();
         System.out.println("bebida simple: " + cafe.ingredientes());
         cafe = new Crema(cafe);
         System.out.println("bebida con un ingrediente" + cafe.ingredientes() + " $ " + cafe.costo());
         cafe = new Canela(cafe);
         System.out.println("bebida " + cafe.ingredientes() + cafe.costo());
         Leche leche = new Leche(cafe);
          System.out.println("bebida "+ leche.ingredientes() + " $ " + leche.costo());
    }
}
