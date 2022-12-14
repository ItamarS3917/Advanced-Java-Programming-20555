//package com.example.demo3;

// This class inherits the MyShape class and is responsible for a line
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {
    public MyLine(double x1, double y1, double x2, double y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    // Draw the line in the specified color
    public void draw(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getY1(), getY1(), getX2(), getY2());
    }

    // This method calculates the distance between two points
    private double distanceBetweenTwoPoints() {
        return Math.sqrt(Math.pow((getX1() - getX2()), getY1() - getY2()));
    }

    public boolean equals(MyLine other) {
        return this.distanceBetweenTwoPoints() == other.distanceBetweenTwoPoints();
    }
}
