package com.mathodcoast.model;

public class Triangle implements Shape {
    @Override
    public String draw(String fillColor) {
        return  "| " + fillColor + " Triangle ";
    }
}
