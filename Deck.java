package question1;

import java.util.ArrayList;
import question1.Card.Rank;
import question1.Card.Suit;
import java.util.Iterator;
import java.util.Random;
import java.io.Serializable;
import java.util.List;

/**
 * Purpose of the class is to initialize deck standard for card usage inside a
 * collection Generic used: List of type Card
 */
public final class Deck implements Serializable, Iterable<Card> {

    //Serialization id as implemented Serializable
    private static final long SerialVersionUID = 101;

    //initializes ArrayList Deck size, value can change
    private ArrayList<Card> cards = new ArrayList<>();
    public static final int DECK_SIZE = Card.Rank.values().length
            * Card.Suit.values().length;

    /**
     * Deck constructor uses arraylist and adds cards to list
     */
    public Deck() {
        final List<Card> shuffled = new ArrayList<>();

        //for all values a -> value2
        for (Rank rank : Rank.values()) {
            //for all values ace -> king
            for (Suit suit : Suit.values()) {
                //add all values of Rank and Suit to cards
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Method used to shuffle deck,
     *
     * @param cards ArrayList to be shuffled
     */
    public static void shuffle(ArrayList cards) {
        //Fisher-Yates shuffle
        ArrayList<Card> shuffled = new ArrayList<>();
        //add all shuffled cards
        cards.addAll(shuffled);
        //initialize random
        Random rand = new Random();

        for (int i = cards.size() - 1; i >= 0; --i) {
            int j = rand.nextInt(i + 1);

            Card card = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, card);
        }
    }

    /**
     * Simple method used to deal a single card from index 0
     *
     * @return card drawn
     */
    public Card deal() {
        final Card drawn = cards.get(0);
        cards.remove(0);
        return drawn;
    }

    /**
     * Size method to check the size of the array
     *
     * @return size of array - cards
     */
    public int size() {
        return cards.size();
    }
    
    /**
     * Returns cards inside the deck
     * @return Cards inside the deck, if any have been removed, this will be
     * appended
     */
    public ArrayList<Card> getCard() {
        return cards;
    }

    /**
     * Creates a new instance of deck
     * @return New created deck
     */
    public final Deck newDeck() {
        Deck newDeck = new Deck();
        return newDeck;
    }
    
    //Initialization of the iterable interface
    @Override
    public Iterator<Card> iterator() {
        return new OddEvenIterator();
        //return cards.iterator();
    }

    private class OddEvenIterator implements Iterator<Card> {

        private static final long SerialVersionUID = 101;
        private int index;

        public OddEvenIterator() {
            this.index = 0;
        }
        
        /**
         * Method to get the next value of the iteration in iterator
         * @return true if index can proceed
         */
        @Override
        public boolean hasNext() {
            if (index == cards.size() + 0) {
                index = 1;
                return true;
            } else if (this.index == cards.size() + 1) {
                return false;
            } else {
                return true;
            }
        }
        
        /**
         * Method to pass onto the next card
         * @return current card after iterated
         */
        @Override
        public Card next() {
            if (this.hasNext()) {
                Card currentCard = cards.get(index);
                index += 2;
                return currentCard;
            }
            return null;
        }
        
        //remove unnecesary for this task but included anyway
        @Override
        public void remove() {

        }

    }

}
