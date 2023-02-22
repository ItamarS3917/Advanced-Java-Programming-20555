# Calendar

This is a calendar application built using Java and JavaFX. It allows the user to select a month and year, and displays a calendar for that month. The user can also enter text for a specific date and save it, so that the text can be retrieved when the same month and year are selected.

## Requirements

- Java Development Kit (JDK) 8 or later
- JavaFX 8 or later 

## Usage
When the application is launched, a calendar for the current month and year is displayed. The user can use the two combo boxes at the top of the screen to select a different month and year, and the calendar will update accordingly.

The user can click on any day of the calendar to select it, and a text area at the bottom of the screen will display any text associated with that day. The user can also enter text into the text area and click the "Save" button to save the text associated with the currently selected day.

## Code Structure
The application consists of three classes:

- `CalendarApplication:` This class extends the Application class and is responsible for setting up the user interface.

- `CalendarController:` This class manages user interaction with the calendar, including updating the calendar when the user selects a different month or year, and saving and displaying text associated with a specific day.

- `CalendarLogic:` This class contains the logic for the calendar, including determining the first day of the month and setting the month and year
