package question2;

import java.util.ArrayList;
import java.util.Scanner;
import question1.Card;
import question1.Hand;

/**
 * Purposed:to implement the player interface to expand on methods for use
 * 
 */
public class BasicPlayer implements Player {
    
    //global variables
    private int balance;
    private int bet;
    private Hand hand;
    //private String PlayerName;

    /**
     * default constructor for basicPlayer
     */
    public BasicPlayer() {
        this.balance = 200;
        this.bet = 10;
    }
    
    //Method descriptions in player class
    @Override
    public Hand newHand() {
        Hand oldHand = this.hand;
        this.hand = new Hand();
        return oldHand;
    }

    @Override
    public int makeBet() {
        //scan bets from user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a bet between 1-500.");
        //scan the next int for bet
        bet = scan.nextInt();
        //error checking
        if (scan.nextInt() > 1 && scan.nextInt() < 500) {
            System.out.println("Error:Bet not in range, please enter number between 1-500");
            bet = scan.nextInt();
        }
        return bet;
    }

    @Override
    public int getBet() {
        return bet;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean hit() {
        if (hit() == true) {
            System.out.println("Card is required");
            return true;
        }
        return false;
    }

    @Override
    public void takeCard(Card c) {
        if (hit()) {
            hand.addCard(c);
        }
    }

    @Override
    public boolean settleBet(int p) {
        p = 0;
        if(isBust()){
            --p;
            return false;
        } else
            p++;
        return true;
    }

    @Override
    public int getHandTotal() {
        int total = 0;
        for (Card card : hand) {
            total += card.getRank().getValue();
        }
        return total;
    }

    @Override
    public boolean blackjack() {
        for (Card card : hand) {
            //switch case for gotBlackjack - Ace / Ten
            switch (card.getRank()) {
                case ACE:
                case TEN:
                    continue;
                default:
                    return false;
            }
        }
        //returns true if blackjack
        return true;
    }

    @Override
    public boolean isBust() {
        //return true if total hand is above 21
        return getHandTotal() > 21;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public void viewDealerCard(Card c) {
        
    }

    @Override
    public void viewCards(ArrayList<Card> cards) {
        System.out.println(cards.toString());
    }

    @Override
    public void newDeck() {
        System.out.println("A new deck has been reshuffled...");
    }

}
