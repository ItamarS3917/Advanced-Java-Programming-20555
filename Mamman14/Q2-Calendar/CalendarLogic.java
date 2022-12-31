
import java.util.Calendar;

public class CalendarLogic {
    public int getFirstDayOfWeek(Calendar date) {
        date.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public void setMonthAndYear(int year, int month , Calendar date) {
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
    }
}
