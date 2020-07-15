package question1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * Purpose of the class is to test program for question 1 of 2 Uses iterators to
 * iterate through program and print out cards.
 */
public class CardTest {

    public static void main(String[] args) {

        Deck deck = new Deck();
        // check cards on the deck
        System.out.println(deck.size());

        //iterate cards on the deck
        for (Card card : deck.getCard()) {
            System.out.println(card.toString());
        }

        //second iterator
        Iterator<Card> ite = deck.iterator();
        System.out.println("\n odd even iter testing ");
        while (ite.hasNext()) {
//            i++;
            Card card = ite.next();
            System.out.println(card.toString());
        }

        //dealing all cards to a number of hands
        ArrayList<Hand> hands = new ArrayList<Hand>();
        //creation of hand objects
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        Hand hand3 = new Hand();
        Hand hand4 = new Hand();
        //add hands to array
        hands.add(hand);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);

        for (int i = 0; i <= hands.size(); i++) {
            //while cards exist in deck
            while (ite.hasNext()) {
                //deal all cards out continuously
                hand.addCard(deck.deal());
                hand2.addCard(deck.deal());
                hand3.addCard(deck.deal());
                hand4.addCard(deck.deal());
            }
        }

        System.out.println("\n Testing hand 1");
        //Testing if any aces exist in hand1
        System.out.println(hand.countRank(Card.Rank.ACE));

        /*
            Serialization of the class to save objects to byte code
            so the objects can be used as a copy for another object
         */
        System.out.println("\nSerialization of Cards in odd even order");
        String filename = "CardSave.ser";
        Deck d = new Deck();
        for (Card card : d) {
            System.out.println(card);
        }
        try {
            //creating file output stream for file
            FileOutputStream fos = new FileOutputStream(filename);
            //create an  object from the file output stream
            ObjectOutputStream out = new ObjectOutputStream(fos);
            //write file object
            out.writeObject(d);
            //close object stream to prevent loss data
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("\nDeserialize CardSave.ser");
        try {
            //open file input stream to open file
            FileInputStream fis = new FileInputStream(filename);
            //create accepting file input stream to accept file
            ObjectInputStream in = new ObjectInputStream(fis);
            //read in the deck
            d = (Deck) in.readObject();
            //close input stream
            in.close();
            //print out all cards
            for (Card card : d) {
                System.out.println(card);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //sending cards from 1 hand to second hand
        //add contents of hand to hand 2
        hand2.addHand(hand);
        //remove contents of hand 1
        hand.removeAll(hand);
        //print out information from hand 1 to prove cards are removed
        for (Card card : hand) {
            System.out.println(card);

        }

        //print out hand in ascending order
        System.out.println("Sort hand in ascending order");
        hand2.sortAscending();

        Iterator<Card> iter = hand2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
