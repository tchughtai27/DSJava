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

}