
//package com.example.demo3;
// This class is responsible for creating the lists of shapes
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class ShapeList {
    private ArrayList<MyShape> _shapesList;

    public ShapeList() {
        _shapesList = new ArrayList<MyShape>();
        Random r = new Random();
        int range = 200;

        // Adding red lines to the list
        _shapesList.add(new MyLine(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED));
        _shapesList.add(new MyLine(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED));

        // Adding red oval to the list
        _shapesList.add(new MyOval(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED, true));
        _shapesList.add(new MyOval(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED, true));

        // Adding red rectangle to the list
        _shapesList.add(new MyRectangle(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED, true));
        _shapesList.add(new MyRectangle(r.nextInt(range), r.nextInt(range), r.nextInt(range), r.nextInt(range), Color.RED, true));
    }

    // This method creates the duplicated list with the required changes
    public ArrayList<MyShape> duplicateListOfShapesWithChange() throws CloneNotSupportedException {
        ArrayList<MyShape> duplicateShapesList = new ArrayList<MyShape>();

        for (int i = 0; i < _shapesList.size(); i++) {
            MyShape temp = (MyShape)(_shapesList.get(i)).clone();
            temp.setX1(_shapesList.get(i).getX1() + 10);
            temp.setY1(_shapesList.get(i).getY1() + 10);
            temp.setColor(Color.GREEN);

            if (_shapesList.get(i) instanceof MyBoundedShape)
                ((MyBoundedShape) temp).setIsFill(false);

            duplicateShapesList.add(temp);
        }
        return duplicateShapesList;
    }

    public ArrayList<MyShape> getShapesList() {
        return _shapesList;
    }
}

