/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman
 */
public class YoutubeChannel implements Observable{
    private List<Observer> channelSubscriber = new ArrayList<Observer>();;
    private String lastVideoPosted="";
    @Override
    public void attach(Observer observer) {
        channelSubscriber.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        channelSubscriber.remove(observer);
    }

    @Override
    public void notify_() {
        for(Observer observer: channelSubscriber){
            observer.update();
        }
    }
    public void addNewVideo(String title){
        this.lastVideoPosted = title;
        this.notify_();
        System.out.println("New youtube video added to channel");
    }
    public String getLastVideoTitle(){
        return this.lastVideoPosted;
    }


    
}
