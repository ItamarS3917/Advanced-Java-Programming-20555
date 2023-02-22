# Trivia Game Application
This is a JavaFX application that provides a simple trivia game. The app reads trivia questions from a text file, randomizes them, and displays them one at a time to the user. The user must then select an answer from a set of possible answers, and their score is updated accordingly.

The app consists of four Java files:

- **Question.java:** This file defines a Question class with five fields that store the question and its four possible answers. The file provides methods to get and set the values of these fields.
- **TriviaGameApplication.java:** This file sets up and launches the JavaFX application.
- **TriviaGameController.java:** This file defines the controller for the JavaFX application. It contains methods to handle user input and update the display accordingly.
- **TriviaGameLogic.java:** This file provides the logic for the trivia game. It reads questions from a text file, randomizes them, and stores them in an ArrayList. It also provides methods to get the current question and its possible answers, check if an answer is correct, and shuffle the answers.
The trivia questions are stored in a text file, with each question on a separate line. Each line should contain the question followed by its four possible answers, separated by commas.

When the user selects an answer, their score is updated based on whether their answer is correct. If the user answers all the questions, the game ends and a dialog box is displayed with the final score. The user can then choose to start a new game or exit the application.




