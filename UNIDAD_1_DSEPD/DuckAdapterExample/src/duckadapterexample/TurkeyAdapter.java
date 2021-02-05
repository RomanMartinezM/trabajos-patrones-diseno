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
public class TurkeyAdapter implements Duck{//Clase que toma el papel de "Adaptador"
    Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
    
}
