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
    private static final char SPADE_SYMBOL = '\u2660'; // ♠
    private static final char HEART_SYMBOL = '\u2661'; // ♡
    private static final char CLUB_SYMBOL = '\u2662'; // ♣
    private static final char DIAMOND_SYMBOL = '\u2663'; // ♢

    // Assigns random suit and rank
    public Card() {
        Random random = new Random();
        this.suit = Suit.values()[random.nextInt(Suit.values().length)]; // Select a random suit
        this.rank = Rank.values()[random.nextInt(Rank.values().length)]; // Select a random rank
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
        switch (suit) {
            case SPADE -> suitSymbol = SPADE_SYMBOL;
            case HEART -> suitSymbol = HEART_SYMBOL;
            case CLUB -> suitSymbol = CLUB_SYMBOL;
            case DIAMOND -> suitSymbol = DIAMOND_SYMBOL;
            default -> throw new IllegalStateException("Unexpected value: " + suit);
        }

        // Get rank character
        String rankStr;
        switch (rank) {
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
            default -> throw new IllegalStateException("Unexpected value: " + rank);
        }

        return suitSymbol + rankStr; // Return symbol and rank
    }

    // Main method for Card class
    public static void main(String[] args) {
        // Create a specific card (Q of Hearts) and print value
        Card queenOfHearts = new Card(Suit.HEART, Rank.QUEEN);
        System.out.println("The following card should be the queen of hearts:");
        System.out.println("  " + queenOfHearts.getFace());

        // Generate and print 10 random cards
        System.out.println("10 random cards...");
        for (int i = 0; i < 10; i++) {
            Card randomCard = new Card();
            System.out.println("  " + randomCard.getFace());
        }
    }
}
