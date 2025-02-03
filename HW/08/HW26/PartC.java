public class Customer {
    static int lastSerialUsed;
    private String name;
    private int sales;

    public Customer(String name) {
        this.name = name;
        this.sales = 0;
    }

    public void addSale(int amount) {
        sales += amount;
    }

    public int getSales() {
        return sales;
    }
}

public class CustomerDemo {
    public static void main(String[] args) {
        Customer.lastSerialUsed = 100;
        Customer c1 = new Customer("Sal's Deli");
        c1.addSale(100);
        Customer c2 = c1;
        c2.addSale(50);
        System.out.println(c1.getSales());
        System.out.println(c2.getSales());
    }
}
