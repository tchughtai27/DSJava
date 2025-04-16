import java.io.*;
import java.util.*;

public class SerializationRead {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "data.bin";
        ArrayList<Employee> employees = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
                DataInputStream dis = new DataInputStream(fis)) {

            Employee.lastIDUsed = dis.readInt();
            System.out.println("Last ID used: " + Employee.lastIDUsed);

            while (dis.available() > 0) {
                Employee e = Employee.readFromStream(dis);
                employees.add(e);
            }

            System.out.println("\n--- Employee Data ---");
            for (Employee e : employees) {
                e.displayInfo();
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Error reading from file.");
            e.printStackTrace();
        }
    }
}
