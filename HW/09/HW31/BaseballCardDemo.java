// Test to see if works as should
public class BaseballCardDemo {
    public static void main(String[] args) {

        BaseballCard card1 = new BaseballCard("Babe Ruth", 1933);
        BaseballCard card2 = new BaseballCard("Babe Ruth", 1933);
        BaseballCard card3 = new BaseballCard("Jackie Robinson", 1952);

        System.out.println("Card 1: " + card1.toString());
        System.out.println("Card 2: " + card2.toString());
        System.out.println("Card 3: " + card3.toString());

        System.out.println("Card 1 equals Card 2 is " + card1.equals(card2)); // true
        System.out.println("Card 1 equals Card 3 is " + card1.equals(card3)); // false
    }
}
