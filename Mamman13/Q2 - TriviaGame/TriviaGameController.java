package com.example.triviagame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.Optional;

public class TriviaGameController {
    @FXML
    private ToggleGroup choice;

    @FXML
    private RadioButton firstAnswer;

    @FXML
    private RadioButton secondAnswer;

    @FXML
    private RadioButton thirdAnswer;

    @FXML
    private RadioButton fourAnswer;
    @FXML
    private Text question;

    @FXML
    private Label firstAns;

    @FXML
    private Label secondAns;

    @FXML
    private Label fourAns;

    @FXML
    private Label thirdAns;

    @FXML
    private Label score;
    private static TriviaGameLogic triviaGame;
    private int scoringResults;

    @FXML
    void initialize() {
        triviaGame = new TriviaGameLogic();
        triviaGame.readFromFile();
        question.setText(triviaGame.randomQuestion());
        triviaGame.currentAnswers();
        triviaGame.shuffleTheAnswers();
        setText();
    }

    @FXML
    void answerSelected(ActionEvent event) {
        if (firstAnswer.isSelected()) {
            String ans = triviaGame.getShuffleAns()[0];
            if (triviaGame.correctAns(ans)) {
                scoringResults += 10;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            } else {
                scoringResults -= 5;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            }
        }
        if (secondAnswer.isSelected()) {
            String ans = triviaGame.getShuffleAns()[1];
            if (triviaGame.correctAns(ans)) {
                scoringResults += 10;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();

            } else {
                scoringResults -= 5;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            }
        } else if (thirdAnswer.isSelected()) {
            String ans = triviaGame.getShuffleAns()[2];
            if (triviaGame.correctAns(ans)) {
                scoringResults += 10;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            } else {
                scoringResults -= 5;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            }
        } else if (fourAnswer.isSelected()) {
            String ans = triviaGame.getShuffleAns()[3];
            if (triviaGame.correctAns(ans)) {
                scoringResults += 10;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            } else {
                scoringResults -= 5;
                score.setText(String.valueOf(scoringResults));
                getNextQuestion();
            }
        }
    }

    @FXML
    void endGame(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("GAME OVER");
        alert.setHeaderText("The game is over - " + "Your score is:  " + scoringResults);
        alert.setContentText("Press OK to start a new game");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
            setNewGame();

        else if (option.get() == null || option.get() == ButtonType.CANCEL)
            System.exit(0);
    }

    public void gameOver() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("GAME OVER");
        alert.setHeaderText("The game is over - " + "Your score is:  " + scoringResults);
        alert.setContentText("Press OK to start a new game");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
            setNewGame();

        else if (option.get() == null || option.get() == ButtonType.CANCEL)
            System.exit(0);
    }

    public void getNextQuestion() {
        triviaGame.remove();
        if (triviaGame.getQuestionsAndAnswers().size() == 0)
            gameOver();
        triviaGame.setShuffleAns();
        question.setText(triviaGame.randomQuestion());
        triviaGame.currentAnswers();
        triviaGame.shuffleTheAnswers();
        setText();
        setSelected();
    }

    public void setText() {
        firstAns.setText(triviaGame.getShuffleAns()[0]);
        secondAns.setText(triviaGame.getShuffleAns()[1]);
        thirdAns.setText(triviaGame.getShuffleAns()[2]);
        fourAns.setText(triviaGame.getShuffleAns()[3]);
    }

    public void setSelected() {
        firstAnswer.setSelected(false);
        secondAnswer.setSelected(false);
        thirdAnswer.setSelected(false);
        fourAnswer.setSelected(false);
    }

    public void setNewGame() {
        triviaGame.reset();
        triviaGame.readFromFile();
        question.setText(triviaGame.randomQuestion());
        triviaGame.currentAnswers();
        triviaGame.shuffleTheAnswers();
        setText();
        scoringResults = 0;
        score.setText("");
    }
}
