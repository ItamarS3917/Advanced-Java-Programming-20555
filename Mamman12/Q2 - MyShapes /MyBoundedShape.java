//package com.example.demo3;

// The abstract class that defines what shapes have in common with area
import javafx.scene.paint.Color;

public abstract class MyBoundedShape extends MyShape {
    private boolean _isFill;

    public MyBoundedShape(double x1, double y1, double x2, double y2, Color color, boolean isFill) {
        super(x1, y1, x2, y2, color);
        _isFill = isFill;
    }

    public boolean getIsFill() {
        return _isFill;
    }

    public void setIsFill(boolean isFill) {
        _isFill = isFill;
    }
}
