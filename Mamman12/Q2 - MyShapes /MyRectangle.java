//package com.example.demo3;

// This class inherits MyBoundedShape class and is responsible for a rectangle

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyBoundedShape {
    public MyRectangle(double x1, double y1, double x2, double y2, Color color, boolean isFill) {
        super(x1, y1, x2, y2, color, isFill);
    }

    // Draw the rectangle in the specified color
    public void draw(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeRect(getX1(), getY1(), getX2(), getY2());

        if (getIsFill() == true) {
            gc.setFill(getColor());
            gc.fillRect(getX1(), getY1(), getX2(), getY2());
        }
    }


    public boolean equals(Object other) {
        if (other instanceof MyRectangle)
            return this.getX2() == ((MyRectangle) other).getX2() && this.getY2() == ((MyRectangle) other).getY2();
        return false;
    }
}