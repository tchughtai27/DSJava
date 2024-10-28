/*
 * Talha Chughtai AT05 PartB
 * 10/25
 */



import java.util.Scanner;

public class PartB {
    private class DimmableLight {
        boolean lightIsOn;
        int brightness;

        public DimmableLight() {
            lightIsOn = false; 
            brightness = 1;
        }

        public void turnOn() {
            lightIsOn = true;
            System.out.println("The light is on.");
        }

        public void turnOff() {
            lightIsOn = false;
            System.out.println("The light is off.");
        }

        public void increaseBrightness() {
            if (brightness < 10) {
                brightness++;
                System.out.println("Brightness increased to " + brightness + ".");
            } else {
                System.out.println("Brightness is at maximum!");
            }
        }

        public void decreaseBrightness() {
            if (brightness > 1) {
                brightness--;
                System.out.println("Brightness decreased to " + brightness + ".");
            } else {
                System.out.println("Brightness is at minimum!");
            }
        }

        public void viewLight() {
            String state = lightIsOn ? "ON" : "OFF";
            System.out.println("The light is " + state + " with a brightness of " + brightness + ".");
        }

        
    }public static void main(String[] args) {
        PartB program = new PartB();
        DimmableLight light = program.new DimmableLight();
        Scanner in = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Dimmable Light!");
        System.out.println("Enter 'on', 'off', 'view', 'up', 'down', or 'q' to quit.");

        while (true) {
            command = in.nextLine();

            switch (command) { //had to search on StackOverflow how to use this switch 
                case "on": //case is much easier than if/else statements
                    light.turnOn();
                    break;
                case "off":
                    light.turnOff();
                    break;
                case "view":
                    light.viewLight();
                    break;
                case "up":
                    light.increaseBrightness();
                    break;
                case "down":
                    light.decreaseBrightness();
                    break;
                case "q":
                    System.out.println("Exiting");
                    in.close(); // Close the scanner to prevent resource leaks
                    return;
                default: //if none of the cases are true, then it goes here and prints the following
                    System.out.println("Invalid command. Please enter 'on', 'off', 'view', 'up', 'down', or 'q'.");
            }
        }
    }
}
