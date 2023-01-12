//package com.example.demo3;

// This class inherits MyBoundedShape class and is responsible for a oval
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyBoundedShape{

    public MyOval(double x1, double y1, double x2, double y2, Color color ,  boolean isFill) {
        super(x1, y1, x2, y2, color , isFill);
    }

    // Draw the oval in the specified color
    public void draw(GraphicsContext gc)
    {
        gc.setStroke(getColor());
        gc.strokeOval(getX1() , getY1() , getX2() , getY2());

        if(getIsFill() == true) {
            gc.setFill(getColor());
            gc.fillOval(getX1(), getY1(), getX2(), getY2());
        }
    }

    public boolean equals(Object other)
    {
        if(other instanceof MyOval)
            return this.getX2() == ((MyOval)other).getX2() && this.getY2() == ((MyOval)other).getY2();
        return false;
    }
}