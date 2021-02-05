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
 
         Cafe cafe= new CafeSolo();    
         System.out.println("bebida " + cafe.ingredientes()+ " $ " + cafe.costo());
       
         cafe = Crema.getInstancia(cafe);
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         
         cafe = Leche.getInstancia(cafe);
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         
         cafe = Canela.getInstancia(cafe);//Canela.getInstancia(cafe);//new Canela(cafe);  
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
          
         cafe = Canela.getInstancia(Crema.getInstancia(cafe));//Canela.getInstancia(cafe);//new Canela(cafe);  
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         
         cafe = Crema.getInstancia(cafe);
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         
         System.out.println("\n---------Con canela 2 veces--------------");
         cafe = Canela.getInstancia((Canela.getInstancia(Crema.getInstancia(Leche.getInstancia(new CafeSolo())))));
         System.out.println("Bebida " + cafe.ingredientes() + " $" + cafe.costo()); 
         
          
         System.out.println("\n---------Con canela y Con crema 2 veces--------------");
         cafe = Canela.getInstancia(Crema.getInstancia(Leche.getInstancia(Canela.getInstancia(Crema.getInstancia(new CafeSolo())))));
         System.out.println("Bebida " + cafe.ingredientes() + " $" + cafe.costo()); 
 
         /*
         cafe = Canela.getInstancia(cafe);//Canela.getInstancia(cafe);//new Canela(cafe);  
         System.out.println("bebida " + cafe.ingredientes() + " $ " + cafe.costo());
         */
         /* 
         System.out.println("\n-----------------------------------------");
         cafe = new Canela(new Crema(new Leche(new CafeSolo())));
         System.out.println("Bebida " + cafe.ingredientes() + " $" + cafe.costo()); 
         
         System.out.println("\n---------Con canela 2 veces--------------");
         cafe = new Canela(new Crema(new Leche(new Canela(new CafeSolo()))));
         System.out.println("Bebida " + cafe.ingredientes() + " $" + cafe.costo()); 
         
         System.out.println("-----------------------------------------");
          
          
         cafe = new Leche(cafe);
         System.out.println("bebida "+ cafe.ingredientes() + " $ " + cafe.costo());
         */
         
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
