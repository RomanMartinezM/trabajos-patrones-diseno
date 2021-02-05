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
public interface Observable {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notify_();
}
