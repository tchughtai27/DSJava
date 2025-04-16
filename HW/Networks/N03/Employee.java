import java.io.*;

public class Employee {
    public static int lastIDUsed = 0;

    private int id;
    private double salary;
    private String firstName;
    private String lastName;

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.id = 0;
        this.salary = 0;
    }

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++lastIDUsed;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void displayInfo() {
        System.out.printf("%s, %s:%n", lastName, firstName);
        System.out.printf("  ID #   = %06d%n", id);
        System.out.printf("  Salary = $%,.2f%n", salary);
    }

    public void writeToStream(DataOutputStream out) throws IOException {
        out.writeInt(id);
        out.writeDouble(salary);
        out.writeUTF(firstName);
        out.writeUTF(lastName);
    }

    public static Employee readFromStream(DataInputStream in) throws IOException {
        int id = in.readInt();
        double salary = in.readDouble();
        String firstName = in.readUTF();
        String lastName = in.readUTF();
        return new Employee(firstName, lastName, id, salary);
    }

    // Extra constructor for reading (assigns exact ID)
    public Employee(String firstName, String lastName, int id, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
    }
}
