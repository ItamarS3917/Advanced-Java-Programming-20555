//package com.example.demo3;

// An abstract class that defines what is common to all the shapes

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape implements Cloneable {

    private double _x1; // x - coordinate of first point
    private double _y1; // y - coordinate of first point
    private double _x2; // x - coordinate of second point
    private double _y2; // y - coordinate of second point
    private Color _color; // The color of the shape


    public MyShape(double x1, double y1, double x2, double y2, Color color) {

        // Checking that entered values are not negative
        if (x1 >= 0)
            _x1 = x1;

        if (y1 >= 0)
            _y1 = y1;

        if (x2 >= 0)
            _x2 = x2;

        if (y2 >= 0)
            _y2 = y2;

        if (color != null)
            _color = color;
    }

    public double getX1() {
        return _x1;
    }

    public double getY1() {
        return _y1;
    }

    public double getX2() {
        return _x2;
    }

    public double getY2() {
        return _y2;
    }

    public Color getColor() {
        return _color;
    }

    public void setX1(double x1) {
        if (x1 >= 0)
            _x1 = x1;
    }

    public void setY1(double y1) {
        if (y1 >= 0)
            _y1 = y1;
    }

    public void setX2(double x2) {
        if (x2 >= 0)
            _x2 = x2;
    }

    public void setY2(double y2) {
        if (y2 >= 0)
            _y2 = y2;
    }

    public void setColor(Color color) {
        if (color != null)
            _color = color;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void draw(GraphicsContext gc);
}
