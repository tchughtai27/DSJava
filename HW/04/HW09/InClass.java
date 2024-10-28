import java.util.Scanner; 
public class InClass {
    public static void main(String[] args) {
        
        double total_dollars = 0;
        double dollars = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter a positive dollar amount or negative to quit: ");
            dollars = in.nextDouble();
            
            if (dollars >= 0) {
                total_dollars = total_dollars + dollars;
                System.out.println("Total:" + total_dollars);
            }
        } 
        while (dollars >= 0);
        System.out.println("Total: " + total_dollars);
    }
}