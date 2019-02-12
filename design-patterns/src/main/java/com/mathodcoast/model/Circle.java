package com.mathodcoast.model;

public class Circle implements Shape {
    @Override
    public String draw(String fillColor) {
        return "| " + fillColor + " Circle ";
    }
}
