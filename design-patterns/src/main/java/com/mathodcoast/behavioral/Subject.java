package com.mathodcoast.behavioral;

import java.util.Objects;

public interface Subject {

     void register(Observer obj);
     void unregister(Observer obj);

     void notifyObservers();

     Object getUpdate(Observer obj);
}
