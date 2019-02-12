package com.mathodcoast.structural;

import com.mathodcoast.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class DrawingComposite implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    @Override
    public String draw(String fillColor) {
        StringBuilder shapesString = new StringBuilder();
        for (Shape shape : shapes) {
           shapesString.append(shape.draw(fillColor));
        }
        return shapesString.toString();
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    //removing shape from drawing
    public void remove(Shape s) {
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear() {
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }

}
