//package com.example.demo3;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class ShapeController {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    @FXML
    void initialize() throws CloneNotSupportedException {
        gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
    }

    // This method draws on the canvas the shapes according to the requirements
    private void drawShapes(GraphicsContext gc) throws CloneNotSupportedException {

        ShapeList shapes = new ShapeList();
        ArrayList <MyShape> shapesList = shapes.getShapesList(); // The list of shapes with red fill
        ArrayList <MyShape> copyListShapes = shapes.duplicateListOfShapesWithChange(); //List the copy of the shapes with a green outline

        // Drawing the elements of the lists on the canvas
        for(int i = 0; i < shapesList.size(); i++) {
            shapesList.get(i).draw(gc);
            copyListShapes.get(i).draw(gc);
        }
    }
}