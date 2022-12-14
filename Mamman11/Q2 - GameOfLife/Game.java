
/*The logic department of the game. This class is responsible for the functions we will use in the ProjectController class of the game*/

import java.util.Random;

public class Game {
    private static boolean [][] lifeMatrix;
    private static final int PERCENT_FOR_LIFE = 2;
    private static final int MATRIX_SIZE = 10;

    public Game(int matrixLifeSize) {
        lifeMatrix = new boolean[matrixLifeSize][matrixLifeSize];
    }

    public boolean[][] getMatrix() {
        return lifeMatrix;
    }

    /*This method fills the matrix with random values.*/
    void newMatrix(int matrixLifeSize) {
        Random rand = new Random();
        for (int i = 0; i < matrixLifeSize; i++) {
            for (int j = 0; j < matrixLifeSize; j++) {
                if (rand.nextInt() < PERCENT_FOR_LIFE)
                    lifeMatrix[i][j] = true;
                else
                    lifeMatrix[i][j] = false;
            }
        }
    }

    /*This method calculates the next generation - by checking the number of neighbors of a certain location,
      and updating the matrix to the new status.*/
    public void nextGeneration() {
        boolean[][] newLifeMatrix = new boolean[lifeMatrix.length][lifeMatrix[0].length];
        for (int i = 0; i < lifeMatrix.length; i++) {
            for (int j = 0; j < lifeMatrix[0].length; j++) {
                int NumOfAliveNeighbours = getNumOfAliveNeighbours(i, j, lifeMatrix);
                boolean updateStatus = lifeMatrix[i][j];
                if (lifeMatrix[i][j] && (NumOfAliveNeighbours < 2 || NumOfAliveNeighbours >= 4))
                    updateStatus = false;

                if (!lifeMatrix[i][j] && NumOfAliveNeighbours == 3)
                    updateStatus = true;

                newLifeMatrix[i][j] = updateStatus;
            }
        }
        lifeMatrix = newLifeMatrix;
    }

    /* This method checks the number of living neighbors in a certain location.*/
    private static int getNumOfAliveNeighbours(int i, int j, boolean[][] matrix) {

        int numOfAliveNeighbours = 0;

        if (getValidAliveNeighbour(i - 1, j - 1, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i - 1, j, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i - 1, j + 1, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i, j - 1, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i, j + 1, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i + 1, j - 1, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i + 1, j, matrix) == true)
            numOfAliveNeighbours++;

        if (getValidAliveNeighbour(i + 1, j + 1, matrix) == true)
            numOfAliveNeighbours++;

        return numOfAliveNeighbours;

    }

    /*An auxiliary method that verifies that the cell does not exceed the limits of the array, and that the cell is indeed "live".*/
    private static boolean getValidAliveNeighbour(int i, int j, boolean[][] matrix) {
        if (i < 0 || j < 0 || i > MATRIX_SIZE - 1 || j > MATRIX_SIZE - 1) {
            return false;
        } else if (matrix[i][j] == true)
            return true;

        return false;

    }
}
