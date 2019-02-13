package com.mathodcoast.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyTopic implements Subject{

    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();
    private List<String> observersMassages;

    public MyTopic() {
        this.observers = new ArrayList<>();
        this.observersMassages = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
       Objects.requireNonNull(obj,"Null Observer");
       synchronized (MUTEX){
           if (!observers.contains(obj)){
               observers.add(obj);
           }
       }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal;

        synchronized (MUTEX){
            if (!changed) return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer observer : observersLocal){
            String observerUpdate = observer.update();
            observersMassages.add(observerUpdate);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public String postMassage(String message){
        System.out.println("Massage Posted to Topic: " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
        return ("Massage Posted to Topic: " + message);
    }

    public List<String> getObserversMassages() {
        return observersMassages;
    }
}
