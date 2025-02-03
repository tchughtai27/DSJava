public class Customer {
    private String companyName;
    private double totalSales;
    private int numberSales;
    private int regionCode;
    private int serialNumber;

    public static int lastSerialUsed = 0;

    public Customer(String name, int regionCode) {
        companyName = name;
        totalSales = 0;
        numberSales = 0;
        this.regionCode = regionCode;
        lastSerialUsed++;
        serialNumber = lastSerialUsed;
    }

    public Customer(String name) {
        this(name, 0);
    }

    public String getName() {
        return companyName;
    }

    public void setName(String new_name) {
        companyName = new_name;
    }

    public void setRegion(int new_region) {
        regionCode = new_region;
    }

    public int getRegion() {
        return regionCode;
    }

    public void addSale(double amount) {
        totalSales += amount;
        numberSales++;
    }

    public double getSales() {
        return totalSales;
    }

    public int getNumber() {
        return numberSales;
    }

    public double getAverage() {
        if (numberSales == 0) {
            return 0;
        }
        return totalSales / numberSales;
    }

    public static double getTaxRate(int regionCode) {
        switch (regionCode) {
            case 1:
                return 0.0000;
            case 2:
                return 0.0550;
            case 3:
                return 0.0600;
            case 4:
                return 0.0625;
            default:
                return 0.0000;
        }
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Sal's Deli", 2);
        Customer c2 = new Customer("Joe's Bakery", 3);

        c1.addSale(100);
        c1.addSale(150);
        c2.addSale(200);

        System.out.println("Customer: " + c1.getName() + ", Serial Number: " + c1.getSerialNumber() + ", Total Sales: "
                + c1.getSales());
        System.out.println("Customer: " + c2.getName() + ", Serial Number: " + c2.getSerialNumber() + ", Total Sales: "
                + c2.getSales());
        System.out.println("Tax rate for Region 2: " + Customer.getTaxRate(2));
        System.out.println("Tax rate for Region 3: " + Customer.getTaxRate(3));
        System.out.println("Average Sale for " + c1.getName() + ": " + c1.getAverage());
        System.out.println("Average Sale for " + c2.getName() + ": " + c2.getAverage());
    }
}
