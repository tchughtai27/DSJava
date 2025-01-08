/*
 * Talha Chughtai
 * ATCS
 * HW AT08
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class PartA {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Display the results
        System.out.println("Today's date is " + currentDate);
        System.out.println("The time is " + currentTime);
    }
}
