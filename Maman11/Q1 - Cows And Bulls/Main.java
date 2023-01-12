
/*//The main class of the game in which the program runs, performs input and output operations - interaction with the user*/
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        int randNumber = game.getNum();
        startPlay(randNumber, game);
    }

    /*This method checks if the number guessed by the user is indeed equal to the random number, if so we will return that the user won*/
    public static boolean userHasWon(int randNum, int numInput) {
        return (randNum == numInput);
    }

    /*This method keeps the number of bulls and the cows of a guessed number*/
    public static String guessHistory(int numInput, int randNumber, GameLogic game) {
        String str = numInput + " - " + game.bullsAndCows(numInput, randNumber) + "\n";
        return str;
    }

    /*This method starts the game run, prints and receives the input from the user, and uses the game logic class to check for correctness.*/
    public static void startPlay(int randNum, GameLogic game) {
        String numInput, playAgain, guessHistory = "";
        int numInputInt = 0, numberOfGuesses = 0;
        boolean continuePlay = true;
        do {

            numInput = JOptionPane.showInputDialog("Hi, please enter the number you want to guess: " +"\n"+ guessHistory);
            numberOfGuesses++;
            if (game.checkInput(numInput) == false) {
                JOptionPane.showMessageDialog(null, "The number you entered is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                continuePlay = true;
            } else {
                numInputInt = Integer.parseInt(numInput);
                if (userHasWon(randNum, numInputInt) == true) {
                    JOptionPane.showMessageDialog(null, "Well done! you have won the game - Your number of guesses is: " + numberOfGuesses,
                            "Game over ", JOptionPane.PLAIN_MESSAGE);
                    playAgain = JOptionPane.showInputDialog("Would you like to play again? enter yes/no");
                    if (playAgain.equals("yes")) { //If the user succeeded in guessing and wants to play again, the data and features will be reset.
                        continuePlay = true;
                        guessHistory = "";
                        numberOfGuesses = 0;
                        game.reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thank you for playing ", "Game over ", JOptionPane.PLAIN_MESSAGE);
                        continuePlay = false;
                    }
                } else {
                    guessHistory += guessHistory(numInputInt, randNum, game);
                    continuePlay = true;
                }
            }

        }

        while (continuePlay);
    }
}

