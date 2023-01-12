import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.Optional;

public class HangManController {

    private HangManLogic hangMan;
    @FXML
    private Pane pane;
    @FXML
    private Circle head;
    @FXML
    private Line belly;
    @FXML
    private Line rightHand;
    @FXML
    private Line leftHand;
    @FXML
    private Line rightLeg;
    @FXML
    private Line leftLeg;
    @FXML
    private TextField text;
    @FXML
    private Text word;
    @FXML
    private Text guessHistory;
    private static int numberOfTrials = 0;

    @FXML
    private void initialize() {
        hangMan = new HangManLogic();
        word.setText(hangMan.printWord());
    }

    @FXML
    void getTextInput(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        String updateWord;
        if (hangMan.checkValidInput(text.getText())) {
            numberOfTrials++;
            updateWord = hangMan.showHiddenWord(hangMan.getGuessedWord(), text.getText().charAt(0));
            guessHistory.setText(String.valueOf(hangMan.getOldLettersGuessed()));
            word.setText(updateWord.replaceAll(",", " "));
            text.clear();

            for (Character ch : hangMan.getUpdateWordInArray()) {
                sb.append(ch);
            }
            String secretWord = sb.toString();

            if (hangMan.getFlag() == true)
                drawMan();

            if (secretWord.equals(hangMan.getGuessedWord()))
                win();

            if (hangMan.getLive() == 6)
                isGameOver();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid character");
            alert.showAndWait();
            text.clear();
        }
    }

    public void drawMan() {
        if (hangMan.getLive() == 1)
            head.setVisible(true);

        if (hangMan.getLive() == 2)
            rightHand.setVisible(true);

        if (hangMan.getLive() == 3)
            leftHand.setVisible(true);

        if (hangMan.getLive() == 4)
            belly.setVisible(true);

        if (hangMan.getLive() == 5)
            leftLeg.setVisible(true);

        if (hangMan.getLive() == 6)
            rightLeg.setVisible(true);

        if (hangMan.getLive() == 7)
            isGameOver();
    }

    public void isGameOver() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("The game is over :(  we believe in you that next time you will succeed!");
        alert.setContentText("Do you want to play again?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
            reset();

        else if (option.get() == null || option.get() == ButtonType.CANCEL)
            System.exit(0);
    }

    public void win() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("You won the game!!");
        alert.setContentText("Do you want to play again?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
            reset();

        else if (option.get() == null || option.get() == ButtonType.CANCEL)
            System.exit(0);
    }

    private void SetInvisibility() {
        int cnt = 1;

        if (cnt == 1) {
            head.setVisible(false);
            cnt++;
        }

        if (cnt == 2) {
            rightHand.setVisible(false);
            cnt++;
        }

        if (cnt == 3) {
            leftHand.setVisible(false);
            cnt++;
        }

        if (cnt == 4) {
            belly.setVisible(false);
            cnt++;
        }

        if (cnt == 5) {
            leftLeg.setVisible(false);
            cnt++;
        }

        if (cnt == 6) {
            rightLeg.setVisible(false);
            cnt++;
        }
    }
    public void reset() {
        hangMan.reset();
        SetInvisibility();
        word.setText(hangMan.getUpdateWord());
        text.clear();
        guessHistory.setText("");
        word.setText("");
        numberOfTrials = 0;
    }
}

