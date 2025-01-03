import java.util.Random;

public class Card {
    // Enumerated types for Suit and Rank
    public enum Suit {
        SPADE, HEART, CLUB, DIAMOND
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }


    // Private member variables for suit and rank
    private Suit suit;
    private Rank rank;

    // Unicode symbols for suits 
    
    //SUITS SHOW AS QUESTION MARKS
    //You know the story here Mr. Eng, replaced with letters instead. 
    
    private static final char SPADE_SYMBOL = '\u2660';    // ♠ \u2660
    private static final char HEART_SYMBOL = '\u2661';    // ♡ \u2661
    private static final char CLUB_SYMBOL = '\u2662';     // ♣ \u2662
    private static final char DIAMOND_SYMBOL = '\u2663';  // ♢ \u2663

   

    // Assigns random suit and rank
    public Card() {
        Random random = new Random();
        this.suit = Suit.values()[random.nextInt(Suit.values().length)]; // From what I understood about this. is this.suit is specifying that the variable suit belongs to the current instance of the class.  
        this.rank = Rank.values()[random.nextInt(Rank.values().length)]; // The part in [] says that it chooses a random number from 0 to the #of elements in each enum, and chooses the corresponding value in the enum.
    }

    // Accepts suit and rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Gets suit
    public Suit getSuit() {
        return suit;
    }

    // Gets rank
    public Rank getRank() {
        return rank;
    }

    // Return face value of card as a string
    public String getFace() {
        // Get suit symbol
        char suitSymbol;
        switch (suit) { //based on the value of suit, the switch statement selects a suitSymbol. 
            case SPADE -> suitSymbol = SPADE_SYMBOL; //searched how to use ->, its easier than returning every time for each case. 
            case HEART -> suitSymbol = HEART_SYMBOL;
            case CLUB -> suitSymbol = CLUB_SYMBOL;
            case DIAMOND -> suitSymbol = DIAMOND_SYMBOL;
            default -> throw new IllegalStateException("Unexpected value: " + suit); //throws an exception if none of the cases
        }

        // Get rank character
        String rankStr;
        switch (rank) { //same logic as other switch statement
            case TWO -> rankStr = "2"; 
            case THREE -> rankStr = "3";
            case FOUR -> rankStr = "4";
            case FIVE -> rankStr = "5";
            case SIX -> rankStr = "6";
            case SEVEN -> rankStr = "7";
            case EIGHT -> rankStr = "8";
            case NINE -> rankStr = "9";
            case TEN -> rankStr = "T";
            case JACK -> rankStr = "J";
            case QUEEN -> rankStr = "Q";
            case KING -> rankStr = "K";
            case ACE -> rankStr = "A";
            default -> throw new IllegalStateException("Unexpected value: " + rank); //thorwing an exception if none of the cases are satisfied
        }
        
        return suitSymbol + rankStr; //returns the symbol and string
        //It returns like this because of the unicode issue. 
    }

    // Main method for Card class
    public static void main(String[] args) {
        
        // Create a specific card (Q of Hearts) and print value
        Card queenOfHearts = new Card(Suit.HEART, Rank.QUEEN); //defines queenOfHearts
        System.out.println("The following card should be the queen of hearts:");
        System.out.println("  " + queenOfHearts.getFace()); //queen of hearts printed

        // Generate and print 10 random cards
        System.out.println("10 random cards...");
        for (int i = 0; i < 10; i++) { //for loop for 10 cards
            Card randomCard = new Card();
            System.out.println("  " + randomCard.getFace());
        }
    }
}
