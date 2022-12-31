

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.util.Calendar;
import java.util.HashMap;

public class CalendarController extends AnchorPane {

    @FXML
    private ComboBox<String> monthC;

    @FXML
    private ComboBox<String> yearC;

    @FXML
    private TextArea textArea;
    @FXML
    private GridPane grid;
    private Button[] buttons;
    private final int ROW = 6, COLUMN = 7;
    private HashMap<Calendar, String> hashMapCalendar;
    private Calendar calendar;
    private CalendarLogic calendarLogic;

    @FXML
    void initialize() {
        calendar = Calendar.getInstance();
        calendarLogic = new CalendarLogic();
        initComboBox();
        drawCalendar();
    }

    @FXML
    void setMonth(ActionEvent event) {
        grid.getChildren().clear();
        calendarLogic.setMonthAndYear(Integer.parseInt(yearC.getValue()), Integer.parseInt(monthC.getValue()) - 1, calendar);
        drawCalendar();
    }

    @FXML
    void setYear(ActionEvent event) {
        grid.getChildren().clear();
        calendarLogic.setMonthAndYear(Integer.parseInt(yearC.getValue()), Integer.parseInt(monthC.getValue()) - 1, calendar);
        drawCalendar();
    }

    public void drawCalendar() {
        final int sizeofCalendar = 42;
        int maximumDaysPerMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int numberOfDay = 0;
        buttons = new Button[sizeofCalendar];
        for (int i = calendarLogic.getFirstDayOfWeek(calendar) - 1; i < maximumDaysPerMonth + calendarLogic.getFirstDayOfWeek(calendar) - 1; i++) {
            buttons[i] = new Button("" + (numberOfDay + 1));
            numberOfDay++;
            buttons[i].setPrefSize(grid.getPrefWidth() / ROW, grid.getPrefHeight() / ROW);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    handleButton(e);
                }
            });
            grid.add(buttons[i], i % COLUMN, i / COLUMN);
        }
    }

    private void handleButton(ActionEvent e) {
        int day = Integer.parseInt(((Button) e.getSource()).getText());
        calendar.set(Calendar.DAY_OF_MONTH, day);
        textArea.setText(hashMapCalendar.get(calendar));
    }

    @FXML
    void savePressed(ActionEvent event) {
        hashMapCalendar.put(calendar, textArea.getText());
        textArea.clear();
    }

    private void initComboBox() {
        final int MONTHS = 12, START_YEAR = 2020, END_YEAR = 2022;
        hashMapCalendar = new HashMap<Calendar, String>();
        for (int i = 1; i <= MONTHS; i++)
            monthC.getItems().add(String.valueOf(i));
        monthC.setValue("1");

        for (int i = START_YEAR; i <= END_YEAR; i++)
            yearC.getItems().add(String.valueOf(i));
        yearC.setValue("2020");

        calendarLogic.setMonthAndYear(Integer.parseInt(yearC.getValue()), Integer.parseInt(monthC.getValue()) - 1, calendar);
    }
}