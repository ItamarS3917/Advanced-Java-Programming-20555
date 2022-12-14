
/*This class is responsible for starting the game.*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class GameController {
    @FXML
    private Canvas canvas;
    @FXML
    private Button nextGenButton;
    private Game lifeMatrix;
    private GraphicsContext gc;
    private final int MATRIX_SIZE = 10;

    @FXML
    private void initialize() {
        lifeMatrix = new Game(MATRIX_SIZE); //Creates a new matrix.
        lifeMatrix.newMatrix(MATRIX_SIZE);//Initialize the matrix with random boolean values.
        drawLifeMatrix();
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.setLineWidth(0.2); //Make the strokes less visible.

    }

    /*This method transfers the matrix of life to the next generation and then paints it on the canvas.*/
    @FXML
    private void nextGen(ActionEvent event) {
        lifeMatrix.nextGeneration();
        drawLifeMatrix();
    }

    /*This method draws the given life matrix on the canvas.*/
    private void drawLifeMatrix() {
        boolean[][] mat = lifeMatrix.getMatrix();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        double firstCoordinate, secondCoordinate, thirdCoordinate, fourthCoordinate;
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                firstCoordinate = i / (double) MATRIX_SIZE * canvasWidth;
                secondCoordinate = j / (double) MATRIX_SIZE * canvasHeight;
                thirdCoordinate = canvasWidth / MATRIX_SIZE;
                fourthCoordinate = canvasHeight / MATRIX_SIZE;
                if (mat[i][j]) {
                    gc.fillRect(firstCoordinate, secondCoordinate, thirdCoordinate, fourthCoordinate);
                }
                gc.strokeRect(firstCoordinate, secondCoordinate, thirdCoordinate, fourthCoordinate);
            }
        }
    }
}





