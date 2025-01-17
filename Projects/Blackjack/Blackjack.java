/*
 * Talha Chughtai
 * ATCS
 * Blackjack Project
 */
import java.util.*;

//start of the class
public class Blackjack {
    //defining 
    private List<Card> deck;
    private List<List<Card>> playersHands;
    private List<Card> dealerHand;
    private int[] playerBalances;
    private int[] playerBets;


//final balance
    private static final int STARTING_BALANCE = 100;


    public Blackjack(int numPlayers) {
        initializeDeck();
        playersHands = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            playersHands.add(new ArrayList<>());
        }
        dealerHand = new ArrayList<>();
        playerBalances = new int[numPlayers];
        playerBets = new int[numPlayers];
        Arrays.fill(playerBalances, STARTING_BALANCE); // Initialize balances
    }

    // Initialize and shuffle the deck
    private void initializeDeck() {
        deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
    }

    // Deal a card from the deck
    private Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("The deck is empty! Reshuffling.");
            initializeDeck();
        }
        return deck.remove(0);
    }

    // Calculate the value of a hand
    private int calculateHandValue(List<Card> hand) {
        int value = 0;
        int aces = 0;

        for (Card card : hand) {
            switch (card.getRank()) {
                case TWO -> value += 2; // converted this normal switch to a rule switch, VS code did it by itself.
                case THREE -> value += 3;
                case FOUR -> value += 4;
                case FIVE -> value += 5;
                case SIX -> value += 6;
                case SEVEN -> value += 7;
                case EIGHT -> value += 8;
                case NINE -> value += 9;
                case TEN, JACK, QUEEN, KING -> value += 10;
                case ACE -> {
                    value += 11;
                    aces++;
                }
            }
        }

        // This part adjusts for Ace if the hand value is over 21
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    // Display hand
    private void displayHand(String name, List<Card> hand) {
        System.out.print(name + "'s hand: ");
        for (Card card : hand) {
            System.out.print(card.getFace() + " ");
        }
        System.out.println(" (Value: " + calculateHandValue(hand) + ")");
    }

    // Game logic part
    public void play() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\nStarting a new round...");
            // Clears hand for new round
            for (int i = 0; i < playersHands.size(); i++) {
                playersHands.get(i).clear();
            }
            dealerHand.clear();

            // Placing the bets
            for (int i = 0; i < playersHands.size(); i++) {
                if (playerBalances[i] <= 0) {
                    System.out.println("Player " + (i + 1) + " is out of money!");
                    continue;
                }
                System.out.println("Player " + (i + 1) + ", your current balance: $" + playerBalances[i]);
                System.out.print("Enter your bet: ");
                int bet = in.nextInt();
                while (bet <= 0 || bet > playerBalances[i]) {
                    System.out.print("Invalid bet. Enter a valid amount: ");
                    bet = in.nextInt();
                }
                playerBets[i] = bet;
            }

            // Initials deal
            for (List<Card> playerHand : playersHands) {
                playerHand.add(dealCard());
                playerHand.add(dealCard());
            }
            dealerHand.add(dealCard());
            dealerHand.add(dealCard());

            // Player turns
            for (int i = 0; i < playersHands.size(); i++) {
                if (playerBalances[i] <= 0)
                    continue;
                System.out.println("\nPlayer " + (i + 1) + "'s turn:");
                List<Card> hand = playersHands.get(i);
                boolean playerBust = false;

                OUTER: while (true) { //learned how to do outer loop in my AP book!
                    displayHand("Player " + (i + 1), hand);
                    if (calculateHandValue(hand) > 21) {
                        System.out.println("Player " + (i + 1) + " busted!");
                        playerBust = true;
                        break;
                    }
                    System.out.println("Do you want to (H)it or (S)tand?");
                    char choice = in.next().toUpperCase().charAt(0);
                    switch (choice) { // I had this differently, but VS code suggested to change.
                        case 'H' -> hand.add(dealCard());
                        case 'S' -> {
                            break OUTER;
                        }
                        default -> System.out.println("Invalid choice. Please enter 'H' or 'S'.");
                    }
                }

                if (playerBust) {
                    playerBalances[i] -= playerBets[i];
                    System.out.println("Player " + (i + 1) + " loses $" + playerBets[i] + ".");
                }
            }

            // Dealer's turn
            System.out.println("\nDealer's turn:");
            displayHand("Dealer", dealerHand);
            while (calculateHandValue(dealerHand) < 17) {
                dealerHand.add(dealCard());
                displayHand("Dealer", dealerHand);
            }
            int dealerValue = calculateHandValue(dealerHand);
            if (dealerValue > 21) {
                System.out.println("Dealer busted!");
            }

            // Determine winners
            for (int i = 0; i < playersHands.size(); i++) {
                if (playerBalances[i] <= 0)
                    continue;
                int playerValue = calculateHandValue(playersHands.get(i));
                if (playerValue > 21) {
                    
                } else if (dealerValue > 21 || playerValue > dealerValue) {
                    System.out.println("Player " + (i + 1) + " wins $" + playerBets[i] + "!");
                    playerBalances[i] += playerBets[i];
                } else if (playerValue < dealerValue) {
                    System.out.println("Player " + (i + 1) + " loses $" + playerBets[i] + ".");
                    playerBalances[i] -= playerBets[i];
                } else {
                    System.out.println("Player " + (i + 1) + " pushes (ties). No money lost.");
                }
            }

            // Check if want to play again
            System.out.print("\nDo you want to play another round? (Y/N): ");
            char again = in.next().toUpperCase().charAt(0);
            if (again != 'Y') {
                System.out.println("Thanks for playing!");
                break;
            }
        }
//close scanner
        in.close();
    }

    // Main method to run 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = in.nextInt();
        while (numPlayers <= 0) {
            System.out.print("Invalid number. Enter a valid number of players: ");
            numPlayers = in.nextInt();
        }

        Blackjack game = new Blackjack(numPlayers);
        game.play();

        in.close();
    }
}