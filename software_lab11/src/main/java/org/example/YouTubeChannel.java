package org.example;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private final List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void uploadVideo(String title) {
        System.out.println("{"+ channelName + "} uploaded a new video: " + title);
        notifyObservers(title);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
