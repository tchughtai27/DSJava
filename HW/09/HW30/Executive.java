public class Executive extends Manager {
    private double shares; // Number of shares the executive owns

    // Constructor
    public Executive(String name, double salary, double bonus, double shares) {
        // Call the parent class constructor (manager)
        super(name, salary, bonus);
        this.shares = shares;
    }

    // Shares
    public double getShares() {
        return shares;
    }

    // Shares
    public void setShares(double shares) {
        this.shares = shares;
    }

    // Override displayInfo to include the shares
    public void displayInfo() {
        // Call the parent class displayInfo method
        super.displayInfo();
        System.out.printf("  Shares = %,.2f%n", shares);
    }
}
