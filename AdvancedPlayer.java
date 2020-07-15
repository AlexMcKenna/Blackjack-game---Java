package question2;

import question1.*;
/**
 * purpose of class: give an improved tactic to winning games
 * compared to Basic player and Intermediate player. 
 * aim is to use counting cards to determine betting value
 */
public class AdvancedPlayer extends BasicPlayer {

    Deck deck = new Deck();
    Hand hand = new Hand();
    int bet = 0;
//follows same skeleton as intermediate
    public void decideBet() {
        while (!isBust()) {
            //if deck position is greater or equal to 7
            //or hand value 
            if (deck.getCard().get(0).getValue() >= 7
                    || hand.getHandValue() <= 17) {

                makeBet();

                //if deck position is lesser or equal to 6
            } else if (deck.getCard().get(0).getValue() <= 6
                    || hand.getHandValue() <= 12) {

                makeBet();
            }
        }
    }
    
}
