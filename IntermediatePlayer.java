package question2;

import question1.*;
/**
 * purpose of class: give an improved tactic to winning games
 * compared to Basic player
 */
public class IntermediatePlayer extends BasicPlayer {

    Deck deck = new Deck();
    Hand hand = new Hand();
    final int bet = 10;
    public void decideBet() {
        while (!isBust()) {
            //if deck position is greater or equal to 7
            //or hand value 
            if (deck.getCard().get(0).getValue() >= 7 || 
                    hand.getHandValue() <= 17) {
                
                makeBet();
                
                //if deck position is lesser or equal to 6
            } else if (deck.getCard().get(0).getValue() <= 6 || 
                    hand.getHandValue() <= 12) {
                
                makeBet();
            }
        }
    }
}
