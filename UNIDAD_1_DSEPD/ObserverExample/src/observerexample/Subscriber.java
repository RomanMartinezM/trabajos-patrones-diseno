/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerexample;

/**
 *
 * @author Roman
 */
public class Subscriber implements Observer{
    private Observable observable;
    public Subscriber(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update() {
        System.out.println("New video posted!!");
       // System.out.println(this.observable.);
        
    }
    
}
