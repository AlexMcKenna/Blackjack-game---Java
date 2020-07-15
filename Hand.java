package question1;

import java.io.Serializable;
import java.util.*;
import question1.Card.Rank;
import question1.Card.Suit;

/**
 * Purpose of the class: initalize the hand objects for use inside the BlackJack
 * game
 */
public final class Hand implements Serializable, Iterable<Card> {

    //Serializable id used for serializing
    private static final long SerialVersionUID = 102;

    //private variables
    /**
     * Array ranks and suits 2d array table
     */
    private final int[][] ranksAsuits;
    private int[] countRank;
    private int[] countSuit;

    //list hands and cards
    private List<Card> cards;
    private List<Card> hand;
    /**
     * Value of hand - int
     */
    private int valueHand;
    
    /**
     * Default constructor for hand
     * Holds values of histogram for ranks and suits
     */
    public Hand() {
        valueHand = 0;
        this.hand = new ArrayList<>();
        ranksAsuits = new int[Card.Rank.values().length][Card.Suit.values().length];
    }
    
    /**
     * Second initializer of hand constructor 
     * @param cards card array cards to add cards to array
     */
    public Hand(Card[] cards) {
        // Call the first constructor that 
        // initialises the list
        this();

        // Add the cards
        for (Card c : cards) {
            hand.add(c);
        }
    }
    
    /**
     * 3rd hand constructor - Adds cards to another hand
     * @param other other hand
     */
    public Hand(Hand other) {
        this();
        for (Card c : other) {
            cards.add(c);
        }
    }
    
    /**
     * add card method - values of rank and suit are changed on removal
     * @param card card to be added
     */
    public void addCard(Card card) {
        this.hand.add(card);

        int rankIndex = card.getRank().ordinal();
        int suitIndex = card.getSuit().ordinal();
        ++ranksAsuits[rankIndex][suitIndex];

        //update values
        valueHand += card.getRank().getValue();
    }
    public int getHandValue(){
        return valueHand;
    }
    /**
     * Add collection of cards 
     * @param cards collection of cards
     */
    public void addCollection(Collection<Card> cards) {
        cards.addAll(cards);
    }
    
    /**
     * Add a hand of cards
     * @param h initial given hand
     */
    public void addHand(Hand h) {
        for (Card c : h) {
            cards.add(c);
        }
    }
    
    /**
     * remove a single card
     * @param card  given card
     * @return  true if card is removed
     */
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }
    
    /**
     * Remove all given cards in a hand
     * @param hand  specified hand
     * @return      True if all cards are removed
     */
    public boolean removeAll(Hand hand) {
        for (int i = 0; i < cards.size(); ++i) {
            Card next = cards.get(i);
            if (hand.cards.contains(next)) {
                cards.remove(next);
            }
        }
        return true;
    }
    
    /**
     * remove a card at a given index
     * @param index index of given card
     * @return  card removed
     */
    public Card removeIndex(int index) {
        Card c = cards.remove(index);
        return c;
    }
    
    /**
     * Sort hand into ascending order using collections class
     */
    public void sortAscending() {
        Collections.sort(hand, null);
    }
    
    /**
     * Sort cards into descending order
     */
    public void sortDescending() {
        cards.sort(new Card.compareDescending());
    }
    
    /**
     * count the amount of suits in hand
     * @param suit  suits in hand
     * @return  the amount given in suit
     */
    public int countSuit(Suit suit) {
        return this.countSuit[suit.ordinal()];
    }
    
    /**
     * Count amount of ranks in hand
     * @param rank  Given ranks in hand
     * @return  total amount of rank in hand
     */
    public int countRank(Rank rank) {
        return this.countRank[rank.ordinal()];
    }
    
    /**
     * Tostring using stringbuilder for hands
     * @return tostring appended
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c).append(", ");
        }
        return sb.toString();

    }
    
    /**
     * Iterator implement method
     * @return iterator from deck class
     */
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

}
