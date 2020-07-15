package question2;

import java.util.ArrayList;
import java.util.Scanner;
import question1.*;

/**
 * Purpose of class: To implement the dealer interface given in dealer class
 */
public class BlackJackDealer implements Dealer {
    
    //global variables
    Deck deck;
    Hand hand;
    int totalBet;
    Hand dealerHand;

    //players = new Player[noPlayers];
    //Methods description given in dealer class
    
    @Override
    public void assignPlayers(ArrayList<Player> p) {

    }

    @Override
    public void takeBets() {

    }

    @Override
    public void dealFirstCards() {
        Deck deck = new Deck();
        //for amount of players in Game
        for (Player p : basicGame()) {
            //deal 2 cards
            deck.deal();
            deck.deal();
        }
    }

    @Override
    public int play(Player p) {
        Scanner scan = new Scanner(System.in);

        String line;

        while (scan.hasNextLine()) {
            //ensures scanner isnt case sensitive
            line = scan.nextLine().toLowerCase();
            if (line.equals("y")) {
                //if player requests card
                if (p.hit()) {
                    deck.deal();
                    //if players hand < 21
                } else if (p.isBust()) {
                    //end hand
                    settleBets();
                } else {
                    System.err.printf("Invalid input: \"%s\"%n", line);
                    break;
                }
            }
        }
        //return total of players hand
        return p.getHandTotal();
    }

    @Override
    public int playDealer() {
        int total = 0;
        if(total > 17){
        for (Card card : dealerHand) {
            total += card.getRank().getValue();
        }
        }
        return total;
    }

    @Override
    public int scoreHand(Hand h) {
        return 0;

    }

    @Override
    public void settleBets() {

    }

}
