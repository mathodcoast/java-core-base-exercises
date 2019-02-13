package com.mathodcoast.behavioral;

public class MyTopicSubscriber implements Observer{
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public String update() {
        String message = (String) topic.getUpdate(this);
        if(message != null){
            System.out.println(name + ":: Consuming massage:: " + message);
            return (name + ":: Consuming massage:: " + message);
        } else {
            System.err.println(name + ":: No massage :: ");
            return (name + ":: No massage");
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }

    public String getName() {
        return name;
    }
}
