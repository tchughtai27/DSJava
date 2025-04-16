import java.io.*;
import java.util.*;

public class SerializationWrite {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter initial ID number (or press enter for 0): ");
        String input = in.nextLine();
        if (!input.isEmpty()) {
            try {
                Employee.lastIDUsed = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using 0.");
            }
        }

        while (true) {
            System.out.print("Type 'e' to add an employee or 'q' to quit: ");
            String choice = in.nextLine().toLowerCase();
            if (choice.equals("q"))
                break;
            if (!choice.equals("e"))
                continue;

            System.out.print("Enter first name: ");
            String firstName = in.nextLine();
            System.out.print("Enter last name: ");
            String lastName = in.nextLine();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(in.nextLine());

            Employee emp = new Employee(firstName, lastName, salary);
            employees.add(emp);
        }

        String filePath = "data.bin";
        try (FileOutputStream fos = new FileOutputStream(filePath);
                DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeInt(Employee.lastIDUsed);
            for (Employee e : employees) {
                e.writeToStream(dos);
            }

            System.out.println("Data written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
