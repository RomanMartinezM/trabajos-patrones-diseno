/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author Roman
 */
public class PruebaMenu {
     public static void main(String[] args) {
         ComponenteMenu menuCasa = new Menu("\n------Menu de la casa------", "desayuno");
         ComponenteMenu menuComida = new Menu("\n------Menu de la comida------", "Comida");
         ComponenteMenu menuCafe = new Menu("\n------Menu de cafe------", "cena");
         ComponenteMenu menuPostre = new Menu("\n-----Menu postre------", "postres");
         
         ComponenteMenu todosLosMenus = new Menu("TODOS LOS MENUS", "desayuno");
         
         ComponenteMenu m1 = new ElementoMenu ("\nEnsalada","Ensalada de verduras",true,35);
         ComponenteMenu m2 = new ElementoMenu ("\nBebida","Té Chai",true,15);
         
         ComponenteMenu m3 = new ElementoMenu ("\nHuevos","Huevos al gusto",false,15);
         ComponenteMenu m4 = new ElementoMenu ("\nBebida","Chocolate con leche",false,13);
        
         ComponenteMenu m5 = new ElementoMenu ("\nSandwich","sandwich integral",false,15);
         ComponenteMenu m6 = new ElementoMenu ("\nPastel","pastel de  tres leches",false,13);
         ComponenteMenu m7 = new ElementoMenu ("\nHelado","helado de nuez",false,14);
         ComponenteMenu m8 = new ElementoMenu ("\nGelationa","gelatina de limon",false,10);
         
         menuCasa.add(m1);
         menuCasa.add(m2);
         menuCasa.add(m3);
         
         menuComida.add(m3);
         menuComida.add(m4);
         
         menuCafe.add(m5); 
         
         menuPostre.add(m6);
         menuPostre.add(m7);
         menuPostre.add(m8);
         menuPostre.add(m8);
          
         todosLosMenus.add(menuCasa);
         todosLosMenus.add(menuComida);
       //  menuComida.add(menuPostre);
         todosLosMenus.add(menuCafe);
         todosLosMenus.add(menuPostre);
         todosLosMenus.add(menuPostre);
         todosLosMenus.print();
         
         
         System.out.println ("------------TOTAL ELEMENTOS---------");
         System.out.println ("El menu de casa tiene : " + menuCasa.getNumElementos() + " elementos ");
         System.out.println ("El menu de cafe tiene : " + menuCafe.getNumElementos() + " elementos ");
         System.out.println ("El menu de comida tiene : " + menuComida.getNumElementos() + " elementos ");
         System.out.println ("El menu de postre tiene : " + menuPostre.getNumElementos() + " elementos ");
                   
          

         
         System.out.println ("------------TOTAL---------");
         System.out.println ("El menu de casa cuesta : " + menuCasa.getPrecio() );
         System.out.println ("El menu de cafe cuesta : " +menuCafe.getPrecio());
         System.out.println ("El menu de comida cuesta : " +menuComida.getPrecio());
         System.out.println ("El menu de postre cuesta : " +menuPostre.getPrecio());
      
         //1ra modificacion  AGREGAR LOS ATRIBUTOS COMUNES
         //poner atriibutos comunes y eliminar los descendientes
           //2da modificaicion. CONTAR EL NUMERO DE ELEMENTOS DE CADA MENU, (MENU CENA O TODOS LOS MENUS TIENE TANTOS ELEMENTOS:DESAYUNO CUANTOS TIENE, CENA,E TC, TODOS)
          //escribir cuantos platillos tienen menu compuesto     , que escriba cuantos platillos tiene un menu  y tambien donde se definiria  y que tiene que incluir 
          
         //3ra modificacion  QUE NO ACEPTE MÁS DE UNA VEZ UN ELEMENTO O GRUPO DE MENU
         //Mesero mesero = new Mesero(menuComida);
         //4TA MODIFICACION. EL TOTAL DE LO QUE CUESTA CADA MENU          
     }
}
