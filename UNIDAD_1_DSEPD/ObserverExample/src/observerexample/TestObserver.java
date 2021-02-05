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
public class TestObserver {
    public static void main(String[] args) {
        YoutubeChannel yc = new YoutubeChannel();
        Subscriber sub1 = new Subscriber(yc);
        Subscriber sub2 = new Subscriber(yc);
        
        yc.attach(sub1);
        yc.attach(sub2);
        
        yc.addNewVideo("observer pattern");
    }
}
