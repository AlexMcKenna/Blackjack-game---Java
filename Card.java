package question1;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Purpose of class: Create Card objects to be used throughout the program Ranks
 * and Suits will be combined to create card objects
 */
public class Card implements Serializable, Comparable<Card> {

    private static final long SerialVersionUID = 100;

    private final Rank name;
    private final Suit name2;

    /**
     * Default constructor for card object
     *
     * @param rank Ranks of cards to be displayed
     * @param suit Suits of cards to be displayed
     */
    public Card(Rank rank, Suit suit) {
        this.name = rank;
        this.name2 = suit;
        this.value = 0;
    }

    /**
     * Rank structure for Card object, follows a Variable(name,value) Standard
     */
    public enum Rank {
        ACE("ace", 11),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9),
        TEN("ten", 10),
        JACK("jack", 10),
        QUEEN("queen", 10),
        KING("king", 10);

        /**
         * Integer value of this card
         */
        private final int value;

        /**
         * String interpretation of the rank
         */
        private final String name;

        /**
         * Rank Constructor to hold values
         *
         * @param name name of given rank
         * @param value Value of rank in integer format
         */
        Rank(String name, int value) {
            this.name = name;
            this.value = value;
        };
        /**
         * Gets value of given value
         * @return value of given rank value
         */
        public int getValue() {
            return value;
        }

        /**
         * Returns the card value above this rank, can be used for top decking
         * @return ordinal of current index + 1
         */
        public Rank getNext() {
            //if rank is any, plus 1 to that value and return rank
            if (this.ordinal() == 12) {
                return Rank.values()[0];
            } else {
                return Rank.values()[this.ordinal() + 1];
            }
        }

        @Override
        public String toString() {
            return "Rank" + " " + "value = " + value + ", Name = " + name + " ";
        }

    }

    /**
     * Enum Structure for Suit
     * follows a Variable(name,value) Standard
     */
    public enum Suit {
        HEARTS("Hearts", 1),
        DIAMONDS("Diamonds", 2),
        CLUBS("Clubs", 3),
        SPADES("Spades", 4);
        
        /**
         * Value name of suit
         */
        private final int value2;
        /**
         * Name value of Suit
         */
        private final String name2;
        
        /**
         * Default constructor of suit enum
         * @param name2 Name of suit
         * @param value2 Value of suit
         */
        Suit(String name2, int value2) {
            this.name2 = name2;
            this.value2 = value2;
        }

        /**
         *Gets the value of suit and returns it
         * @return Value of suit
         */
        public int getSuit() {
            return this.value2;
        }

    };
    private final int value;

    /**
     *
     * @return Rank name
     */
    public Rank getRank() {
        return this.name;
    }

    public int getValue() {
        return value;
    }

    /**
     *
     * @return Suit name
     */
    public Suit getSuit() {
        return this.name2;
    }
    
    /**
     * Return the sum of the 2 Card values in addition e.g 8 + 2 = 10
     * @param rank  rank or card 1
     * @param rank2 rank of card 2
     * @return 
     */
    public int sum(Rank rank, Rank rank2) {
        return rank.value + rank2.value;
    }
    
    /**
     * Returns true if blackjack is achieved. E.g player yas reached max score
     * @param o card 1
     * @param k card 2
     * @return True if Blackjack is achieved, false otherwise
     */
    public boolean isBlackJack(Card o, Card k) {
        if (o.name.value <= k.name.value) {
            if (o.name == Rank.ACE || k.name == Rank.ACE) {
                return true;
            }
        }
        return false;
    }

    /**
     * CompareTo method used to compare scores of cards
     * @param o Card o to be used to compare
     * @return  comparison of card
     */
    @Override
    public int compareTo(Card o) {
        final int rankComp = name.compareTo(o.name);
        if (rankComp == 0) {
            return name2.compareTo(o.name2);
        }
        return rankComp;
    }

    @Override
    public String toString() {
        return "[" + getRank() + " of " + getSuit() + "]";
    }

    public static class compareDescending implements Comparator<Card> {

        /**
         *
         * @param card1 first card to be compared
         * @param card2 second card to be compared
         * @return comparison of the 2 cards
         */
        @Override
        public int compare(Card card1, Card card2) {
            //Negation done by adding - symbol to descend
            return //-card1.compareTo(card2);
                    -card1.getRank().compareTo(card2.getRank());
        }
    }

    /**
     * Comparator class comparing all suits
     */
    public static final class CompareSuit implements Comparator<Card> {

        @Override
        public final int compare(Card card1, Card card2) {
            return card1.getSuit().compareTo(card2.getSuit());
        }
    }

}
