import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class TextBasedCalendar {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Month month = today.getMonth();
        LocalDate firstOfMonth = today.withDayOfMonth(1); // Get the first day of the current month

        System.out.printf("        %s        %n", month); // Center the month name
        System.out.println("MON TUE WED THU FRI SAT SUN");

        DayOfWeek startDay = firstOfMonth.getDayOfWeek();
        int dayOfWeekValue = startDay.getValue(); // 1 = MON, ..., 7 = SUN

        // Adjust dayOfWeekValue to make Sunday = 0 for easier calculations
        if (dayOfWeekValue == 7) {
            dayOfWeekValue = 0;
        }

        // Print leading spaces for the first row
        for (int i = 0; i < dayOfWeekValue; i++) {
            System.out.print("    "); // 4 spaces for each empty day
        }

        int daysInMonth = month.length(firstOfMonth.isLeapYear());
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate currentDate = firstOfMonth.plusDays(day - 1);
            String output = String.format(" %2d ", day);

            if (currentDate.equals(today)) {
                output += "*"; // Add an asterisk for today
            }

            System.out.print(output);

            if ((day + dayOfWeekValue) % 7 == 0) {
                System.out.println(); // New line after Sunday
            }
        }

        // If the month does not end on a Sunday, print a newline
        if (daysInMonth % 7 != 0) {
            System.out.println();
        }
    }
}
