/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckadapterexample;

/**
 *
 * @author lithium
 */
public class DuckTestDrive {//Clase que toma el papel de "Cliente"
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck(); //let's create a Duck
        WildTurkey turkey = new WildTurkey();//let's create a Turkey
        Duck turkeyAdapter = new TurkeyAdapter(turkey); //and then wrap the turkey in a "TurkeyAdapter", wich makes it looke like a "Duck"
        
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();
        
        System.out.println("\nThe Duck says...");
        testDuck(duck);
        
        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}

