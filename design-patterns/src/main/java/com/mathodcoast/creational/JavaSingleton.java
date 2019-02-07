package com.mathodcoast.creational;

public class JavaSingleton {
    private static JavaSingleton instance;

    private JavaSingleton() {
    }

    public static JavaSingleton getInstance() {
        if (instance == null){
            instance = new JavaSingleton();
        }
        return instance;
    }
}
